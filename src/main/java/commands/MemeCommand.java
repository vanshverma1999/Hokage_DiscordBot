package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import types.ServerCommand;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MemeCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        JSONParser parser = new JSONParser();
        String postLink ="";
        String title ="";
        String url ="";

        if(arguments[0].equalsIgnoreCase("!meme")){
            try {
                URL memeURL = new URL("https://meme-api.herokuapp.com/gimme");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));
                String lines;
                while ((lines= bufferedReader.readLine()) != null){
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));
                    for (Object o : array) {
                        JSONObject jsonObject = (JSONObject)o;
                        postLink = (String)jsonObject.get("postLink");
                        title =(String)jsonObject.get("title");
                        url = (String)jsonObject.get("url");
                    }
                }
                bufferedReader.close();

                EmbedBuilder builder = new EmbedBuilder()
                        .setTitle(title,postLink)
                        .setImage(url)
                        .setColor(Color.ORANGE);
                textChannel.sendMessage(builder.build()).queue();
            }catch (Exception e ){
                textChannel.sendMessage(":no entry: **Hey, Something went Wrong. Please try again later**").queue();
                e.printStackTrace();
            }
        }
    }
}

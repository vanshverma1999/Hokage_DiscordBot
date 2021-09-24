package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MemeCommand extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        JSONParser parser = new JSONParser();
        String postLink ="";
        String title ="";
        String url ="";
        if(args[0].equalsIgnoreCase("!meme")){
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
                event.getMessage().delete().queue();
                EmbedBuilder builder = new EmbedBuilder()
                        .setTitle(title,postLink)
                        .setImage(url)
                        .setColor(Color.ORANGE);
                event.getChannel().sendMessage(builder.build()).queue();
            }catch (Exception e ){
                event.getChannel().sendMessage(":no entry: **Hey, Something went Wrong. Please try again later**").queue();
                e.printStackTrace();
            }
        }
    }
}

package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import types.ServerCommand;

import java.util.Random;

public class EightBallCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length <2){
            textChannel.sendMessage("Please mention the question as well!").queue();
        }
        else if(arguments[0].equalsIgnoreCase("!8ball")){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Your Horoscope");

            embedBuilder.setColor(0x2ecc71);
            embedBuilder.setThumbnail("https://cafeastrology.com/wp-content/plugins/magic-answers/images/ball.png");
            embedBuilder.setDescription(randomString());
            embedBuilder.setFooter("Hope this prediction will help you :)");
            textChannel.sendMessage(embedBuilder.build()).queue();
        }
    }

    public static String randomString(){
        Random r = new Random();

        int choice = 1 + r.nextInt(15);
        String response = "";

        if ( choice == 1 )
            response = "It is certain";
        else if ( choice == 2 )
            response = "It is decidedly so";
        else if ( choice == 3 )
            response = "Without a doubt";
        else if ( choice == 4 )
            response = "Yes - definitely";
        else if ( choice == 5 )
            response = "You may rely on it";
        else if ( choice == 6 )
            response = "As I see it, yes";
        else if ( choice == 7 )
            response = "Most likely";
        else if ( choice == 8 )
            response = "Outlook good";
        else if ( choice == 9 )
            response = "Signs point to yes";
        else if ( choice == 10 )
            response = "Yes";
        else if ( choice == 11 )
            response = "Reply hazy, try again";
        else if ( choice == 12 )
            response = "Ask again later";
        else if ( choice == 13 )
            response = "Better not tell you now";
        else if ( choice == 14 )
            response = "Cannot predict now";
        else if ( choice == 15 )
            response = "Concentrate and ask again";
        else
            response = "8-BALL ERROR!";

        return  "MAGIC 8-BALL SAYS: " + response;
    }


}

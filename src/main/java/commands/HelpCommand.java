package commands;

import types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0xC4E538);
        embedBuilder.setTitle("Some Helpful Commands");
        embedBuilder.setDescription("**-----------------------------------------------------------------------------------------------------**\n" +
                "\n**!help** - *To display all the usefull commands available*\n" +
                "\n**!userinfo <user mentioned>** - *To display a detailed overview of a user*\n" +
                "\n**!clear <Amount>** - *To delete the specified amount of messages from a text channel*\n" +
                "\n**!kick <user> <reason>** - *To remove a user from the server \n(You must have the admin role to use this!)*\n" +
                "\n**!ban <user> <reason>** - *To Ban a user from the server and they cant join until you unban them \n(You must have the admin role to use this!)*\n" +
                "\n**!unban <userID>** - *To Unban a user from the server so they can join back \n(You must have the admin role to use this!)*\n" +
                "\n**!meme** - *To display a funny meme from reddit*\n" +
                "\n**!dog** - *To display a cute dog picture from reddit*\n" +
                "\n**!cooldown** - *To give a 30 second cooldown to the user*\n" +
                "\n**!8ball <Question>** - *To get the future prediction about the question asked*\n" +
                "\n**!play <link/name>** - *To play the specified song/video in your connected voice channel \n(You must be present in the voice channel to let the bot know about your presence)*\n" +
                "\n**-----------------------------------------------------------------------------------------------------**");
        textChannel.sendMessage(embedBuilder.build()).queue();
    }
}

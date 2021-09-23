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

        embedBuilder.setColor(0x2ecc71);
        embedBuilder.setTitle("Some Helpful Commands");
        embedBuilder.setDescription("\n**!help** - *To check which commands are available*\n\n**!clear <Integer>** - *clears some messages*\n" +
                "                \n**!ban <user> <reason>** - *Banish the mentioned user from the server*\n" +
                "                \n**!unban <userID>** - *Un-Banish the mentioned user from the server*\n" +
                "                \n**!cooldown** - *Lets you wait 30 seconds before you can use the command again*\n" +
                "                \n**!kick <user> <reason>** - *Kicks the mentioned user from the server*");
        textChannel.sendMessage(embedBuilder.build()).queue();
    }
}

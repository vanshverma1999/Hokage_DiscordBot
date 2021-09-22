package commands.commands;

import commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0x95a5a6);
        embedBuilder.setTitle("Useful Commands");
        embedBuilder.setDescription("**!help** - *print this embed*\n**!clear <Integer>** - *clears some messages* ");
        textChannel.sendMessage(embedBuilder.build()).queue();
    }
}

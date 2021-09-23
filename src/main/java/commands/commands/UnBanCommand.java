package commands.commands;

import commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnBanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        /* !unban <userID> */
        if(arguments.length == 2){
            Member target = message.getMentionedMembers().get(0);
            String id = arguments[1];
            if(id!=null){
                guild.unban(id).queue();
            }
        }else{
            textChannel.sendMessage("Sorry! This is not the right usage\nPlease use - *!unban <user>*").queue();

        }
    }
}

package commands;

import types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KickCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        /* !kick <user> <reason> */
        if(arguments.length == 3){
            Member target = message.getMentionedMembers().get(0);
            if(target !=null){
                String reason = arguments[2];
                if(reason != null){
                    if(member.hasPermission(Permission.KICK_MEMBERS)){
                        textChannel.sendMessage("The user : "+target.getUser().getName()+ " was kicked for "+reason).queue();
                        target.kick(reason).queue();
                    }
                    else{
                        textChannel.sendMessage("You don't have permissions for this command.").queue();
                    }
                }
            }
        }else{
            textChannel.sendMessage("Sorry! This is not the right usage\nPlease use - *!kick <user> <reason>*").queue();
        }
    }
}

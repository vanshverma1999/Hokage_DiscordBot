package commands;

import types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class BanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        /* !ban <user> <reason> */
        if(arguments.length == 3) {
            Member target = message.getMentionedMembers().get(0);
            if(target != null){
                String reason = arguments[2];
                if(reason != null){
                    if(member.hasPermission(Permission.BAN_MEMBERS)){
                        textChannel.sendMessage("You have successfully banned "+target.getUser().getName()+ " from the server for "+reason).queue();
                        target.ban(0,reason).queue();
                    }
                    else{
                        textChannel.sendMessage("You don't have permissions for this command.").queue();
                    }
                }
            }
        }else if(arguments.length < 3 || arguments.length >3){
            textChannel.sendMessage("Sorry! This is not the right usage\nPlease use - *!ban <user> <reason>*").queue();
        }
    }
}

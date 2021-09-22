package commands.commands;

import commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

import java.util.List;

public class ClearCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        /* Clear <count> */
        if(arguments.length < 2){   //not working check
            textChannel.sendMessage("Sorry! This is not the right usage\nPlease use - *!clear <amount>*").queue();
        }
        else{
            try{
                try{
                    message.delete().queue();
                }catch (InsufficientPermissionException exception){
                    textChannel.sendMessage("Sorry but i don't have permissions to delete the messages!").queue();
                }
                message.delete().queue();
                List<Message> messageList = textChannel.getHistory().retrievePast(Integer.parseInt(arguments[1])).complete();
                textChannel.deleteMessages((messageList)).queue();

                textChannel.sendMessage("**Successfully clear "+arguments[1]+" message(s) in "+textChannel.getAsMention()).queue();

            }
            /* Cant delete more than 100 messages and messages dated more than 2 weeks from present */
            catch(IllegalArgumentException exception){
                if(exception.toString().startsWith("java.lang.IllegalArguementException: Message retrieval")){
                    textChannel.sendMessage("Sorry but you cant delete more than 100 messages at once").queue();
                }
                else{
                    textChannel.sendMessage("Sorry but you cant delete messages that are older than 2 weeks").queue();
                }
            }
        }
    }
}

package commands.commands;

import commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.HashMap;

public class CooldownCommand implements ServerCommand {
    /*Key is the member */
    public HashMap<Member,Long> cooldown = new HashMap<>();
    /* 30 sec timer */
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(cooldown.containsKey(member) && cooldown.get(member) > System.currentTimeMillis()){
            long longRemaining = cooldown.get(member) - System.currentTimeMillis();
            int intremaining = (int)(longRemaining/1000);  // 1 seconds = 1000 ticks
            textChannel.sendMessage("You must wait " + intremaining + " second(s), before executing the command again").queue();
        }else{
            textChannel.sendMessage("Successfully executed the command, you have to for 30 seconds!").queue();
            cooldown.put(member,System.currentTimeMillis()+(30*1000));
        }
    }
}

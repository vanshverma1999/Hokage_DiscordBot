package commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter {

    public final HelpCommand helpCommand;
    public final ClearCommand clearCommand;
    public final KickCommand kickCommand;
    public final BanCommand banCommand;
    public final UnBanCommand unBanCommand;
    public final CooldownCommand cooldownCommand;
    public CommandManager(){
        this.helpCommand = new HelpCommand();
        this.clearCommand = new ClearCommand();
        this.kickCommand = new KickCommand();
        this.banCommand = new BanCommand();
        this.unBanCommand = new UnBanCommand();
        this.cooldownCommand = new CooldownCommand();
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        if(!event.getMember().getUser().isBot()){
            String[] arguements = event.getMessage().getContentRaw().split(" ");

            Guild guild = event.getGuild();
            Member member = event.getMember();
            TextChannel textChannel = event.getChannel();
            Message message = event.getMessage();

            switch(arguements[0]){
                case "!help" :
                    helpCommand.performCommand(arguements, guild,member, textChannel, message);
                    break;
                case "!clear" :
                    clearCommand.performCommand(arguements, guild, member, textChannel, message);
                    break;
                case "!kick" :
                    kickCommand.performCommand(arguements, guild, member,textChannel,message);
                    break;
                case "!ban" :
                    banCommand.performCommand(arguements, guild, member,textChannel,message);
                    break;
                case "!unban" :
                    unBanCommand.performCommand(arguements, guild, member,textChannel,message);
                    break;
                case "!cooldown" :
                    cooldownCommand.performCommand(arguements, guild, member,textChannel,message);
            }
        }
    }
}
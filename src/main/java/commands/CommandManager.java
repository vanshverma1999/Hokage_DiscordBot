//!play https://www.youtube.com/watch?v=i-VQl94tw2s
//only url working
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
    public final MemeCommand memeCommand;
    public final DogCommand dogCommand;
    public final PlayCommand playCommand;
    public final EightBallCommand eightBallCommand;
    public final UserInfoCommand userInfoCommand;

    public CommandManager(){
        this.helpCommand = new HelpCommand();
        this.clearCommand = new ClearCommand();
        this.kickCommand = new KickCommand();
        this.banCommand = new BanCommand();
        this.unBanCommand = new UnBanCommand();
        this.cooldownCommand = new CooldownCommand();
        this.memeCommand = new MemeCommand();
        this.dogCommand = new DogCommand();
        this.playCommand = new PlayCommand();
        this.eightBallCommand = new EightBallCommand();
        this.userInfoCommand = new UserInfoCommand();
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        if(!event.getMember().getUser().isBot()){
            String[] arguments = event.getMessage().getContentRaw().split(" ");

            Guild guild = event.getGuild();
            Member member = event.getMember();
            TextChannel textChannel = event.getChannel();
            Message message = event.getMessage();

            switch(arguments[0]){
                case "!help" :
                    helpCommand.performCommand(arguments, guild,member, textChannel, message);
                    break;
                case "!clear" :
                    clearCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!kick" :
                    kickCommand.performCommand(arguments, guild, member,textChannel,message);
                    break;
                case "!ban" :
                    banCommand.performCommand(arguments, guild, member,textChannel,message);
                    break;
                case "!unban" :
                    unBanCommand.performCommand(arguments, guild, member,textChannel,message);
                    break;
                case "!cooldown" :
                    cooldownCommand.performCommand(arguments, guild, member,textChannel,message);
                    break;
                case "!hello" :
                    textChannel.sendMessage("Hello, Greetings for the day! Type !help for available commands. " + member.getAsMention()).queue();
                    break;
                case "!mention" :
                    member = event.getMessage().getMentionedMembers().get(0);
                    //message.delete().queue(); To delete the message sent then mentioning
                    if (!member.getUser().isBot()) {
                        event.getChannel().sendMessage(("You have been mentioned through me : " + member.getUser().getAsMention())).queue();
                    } else {
                        event.getChannel().sendMessage("Sorry! I can't mention the bots!").queue();
                    }
                    break;
                case "!meme" :
                    memeCommand.performCommand(arguments, guild, member,textChannel,message);
                    break;
                case "!dog" :
                    dogCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!play" :
                    playCommand.performCommand(arguments,guild,member,textChannel,message);
                    break;
                case "!8ball" :
                    eightBallCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!userinfo" :
                    userInfoCommand.performCommand(arguments,guild, member, textChannel, message);
                    break;
            }
        }
    }
}

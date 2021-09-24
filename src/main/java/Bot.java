import commands.CommandManager;
import commands.MemeCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {

    public static JDA jda;
    public static JDABuilder jdaBuilder;

    public static void main(String[] args) throws LoginException {

        /* Building Discord bot and token is used to connect back-end to front-end(BOT) */
         jda = JDABuilder.createDefault("ODgzNjc4MDM1MTkzMjUzOTE5.YTNbTQ.05YtcaMOdrBrCiRycEDeIZGAWXI").build();

        /* Status of BOT ( Online, idle , offline, Invisible) */
        jda.getPresence().setStatus(OnlineStatus.IDLE);

        /* Specifying what activity is bot doing right now : watching playing etc */
        jda.getPresence().setActivity(Activity.watching("The server"));

        /* Event Listener is responsible of handling events */
        jda.addEventListener(new Moderation());
        jda.addEventListener(new WelcomeMessage());
        jda.addEventListener(new MemeCommand());

        //Bot.jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerCommands();
    }

    public static void registerCommands(){
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);
    }
}
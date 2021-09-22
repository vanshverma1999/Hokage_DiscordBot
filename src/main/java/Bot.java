import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;
import java.util.HashSet;

public class Bot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        /* Building Discord bot and token is used to connect back-end to front-end(BOT) */
        JDA jda = JDABuilder.createDefault("ODgzNjc4MDM1MTkzMjUzOTE5.YTNbTQ.05YtcaMOdrBrCiRycEDeIZGAWXI").build();

        /* Status of BOT ( Online, idle , offline, Invisible) */
        jda.getPresence().setStatus(OnlineStatus.IDLE);

        /* Specifying what activity is bot doing right now : watching playing etc */
        jda.getPresence().setActivity(Activity.watching("The server"));

        /* Event Listener is responsible of handling events */
        jda.addEventListener(new Command());
    }
}
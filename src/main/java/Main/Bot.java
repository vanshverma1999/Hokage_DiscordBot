package Main;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import commands.AudioManager;
import commands.CommandManager;

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
    public static AudioPlayerManager audioPlayerManager;
    private static commands.AudioManager audioManager;
    public static void main(String[] args) throws LoginException {

        /* Building Discord bot and token is used to connect back-end to front-end(BOT) */
         jda = JDABuilder.createDefault("ODgzNjc4MDM1MTkzMjUzOTE5.YTNbTQ.wz5u1fVcNFq3nGEk1VroJkBXB64").build();

        /* Status of BOT ( Online, idle , offline, Invisible) */
        jda.getPresence().setStatus(OnlineStatus.IDLE);

        /* Specifying what activity is bot doing right now : watching playing etc */
        jda.getPresence().setActivity(Activity.watching("The server"));

        /* Event Listener is responsible of handling events */
        jda.addEventListener(new Moderation());
        jda.addEventListener(new WelcomeMessage());

        
        audioPlayerManager = new DefaultAudioPlayerManager();
        audioManager = new AudioManager();

        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        //jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerCommands();
    }

    public static void registerCommands(){
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);
    }
    public static JDA getJda(){
        if(jda!=null){
            return jda;
        }
        return null;
    }
    public static AudioPlayerManager getAudioPlayerManager(){
        if(audioPlayerManager != null){
            return audioPlayerManager;
        }
        return null;
    }
    public static AudioManager getAudioManager(){
        if (audioManager != null)
            return audioManager;
        return null;
    }
}

package commands;

import Main.Bot;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.Guild;
public class MusicController {
    private Guild guild;
    private AudioPlayer audioPlayer;

    public MusicController(Guild guild){
        this.guild = guild;
        this.audioPlayer = Bot.getAudioPlayerManager().createPlayer();
        this.guild.getAudioManager().setSendingHandler(new MusicCommand(audioPlayer));
        this.audioPlayer.setVolume(15);
    }
    public Guild getGuild(){
        if (this.guild != null)
            return guild;
        return null;
    }
    public AudioPlayer getAudioPlayer(){
        if(this.audioPlayer != null)
            return  audioPlayer;
        return null;
    }
}

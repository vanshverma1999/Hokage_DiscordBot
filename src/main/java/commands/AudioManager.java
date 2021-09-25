package commands;

import Main.Bot;

import java.util.HashMap;

public class AudioManager {
    public HashMap<Long, MusicController> controllerHashMap;

    public AudioManager(){
        this.controllerHashMap = new HashMap<>();
    }

    public MusicController getMusicController(long guild){
        MusicController musicController = null;
        if (this.controllerHashMap.containsKey(guild)){
            musicController = this.controllerHashMap.get(guild);
        }else{
            musicController = new MusicController(Bot.getJda().getGuildById(guild));
            this.controllerHashMap.put(guild, musicController);
        }
        return musicController;
    }
}

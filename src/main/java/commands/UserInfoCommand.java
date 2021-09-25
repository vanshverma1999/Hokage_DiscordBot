package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import types.ServerCommand;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfoCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if (arguments.length==2){
            Member target =message.getMentionedMembers().get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(target!=null){
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(Color.ORANGE);
                embedBuilder.setTitle("User - "+target.getUser().getName());
                embedBuilder.setThumbnail(target.getUser().getAvatarUrl());
                embedBuilder.addField("Time Joined ",target.getTimeJoined().format(formatter),true);
                embedBuilder.addField("Time Created ",target.getTimeCreated().format(formatter),true);
                embedBuilder.addField("Discord Bot" ,   String.valueOf(checkForBot(target)),true);
                embedBuilder.addField("User Roles", getRoles(target.getRoles()),true);
                textChannel.sendMessage(embedBuilder.build()).queue();
            }
        }
    }
    private boolean checkForBot(Member member){
        if (member.getUser().isBot()){
            return true;
        }
        return false;
    }

    public String getRoles(List rolesList){
        String roles = null;
        if(!rolesList.isEmpty()){
            Role tempRole = (Role) rolesList.get(0);
            roles = tempRole.getName();
            for (int i = 1; i < rolesList.size(); i++) {
                tempRole = (Role)rolesList.get(i);
                roles = roles+", "+tempRole.getName();
            }
        }else{
            roles = "No Roles";
        }
        return roles;
    }
}

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/* Not working */
public class WelcomeMessage extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event){
        if(!event.getMember().getUser().isBot()){
            TextChannel textChannel = event.getGuild().getSystemChannel();
            if(textChannel !=null){
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(0xecf0f1);
                embedBuilder.setTitle("A new member has joined!!!");
                embedBuilder.setDescription(event.getMember().getUser().getAsMention()+" just Joined the server!");
                embedBuilder.setThumbnail(event.getMember().getUser().getAvatarUrl());

                textChannel.sendMessage(embedBuilder.build()).queue();
                textChannel.sendMessage("New bird has arrived").queue();
            }
        }
    }
}

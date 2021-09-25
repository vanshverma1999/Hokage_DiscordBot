package Main;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.HashSet;

public class Moderation extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        /* Main.Moderation Strings */
        HashSet<String> set = new HashSet<>();
        set.add("bad");
        set.add("abusive");
        set.add("looser");

        String receivedMessage = event.getMessage().toString();
        /* Getting each message for various checks */
        String[] message = event.getMessage().getContentRaw().split(" ");

        Member member;
        /* Main.Moderation */
        for (String bad: set) {
            if (receivedMessage.contains(bad.toLowerCase())) {
                member = event.getMember();
                event.getChannel().sendMessage(member.getAsMention() + "Please do not use bad words. We do not tolerate such behaviour!!!").queue();
                event.getChannel().sendMessage("Moderators please look into this matter").queue();
                break;
            }
        }
    }
}
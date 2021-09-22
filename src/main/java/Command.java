import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.HashSet;
public class Command extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        /* Moderation Strings */
        HashSet<String> set = new HashSet<>();
        set.add("bad");
        set.add("abusive");
        set.add("looser");

        String receivedMessage = event.getMessage().toString();
        /* Getting each message for various checks */
        String[] message = event.getMessage().getContentRaw().split(" ");

        Member member;
        /* Moderation */
        for (String bad: set) {
            if (receivedMessage.contains(bad)) {
                member = event.getMember();
                event.getChannel().sendMessage(member.getAsMention() + "Please do not use bad words. We do not tolerate such behaviour!!!").queue();
                event.getChannel().sendMessage("Moderators please look into this matter").queue();
                break;
            }
        }
        /* Greeting members */
        if (message[0].equals("!hello")) {
            member = event.getMember();
            event.getChannel().sendMessage("Hello, Greetings for the day!" + member.getAsMention()).queue();
        }
        /* Mentions */
        if (message[0].equals("!mention")) {
            member = event.getMessage().getMentionedMembers().get(0);
            if (!member.getUser().isBot()) {
                event.getChannel().sendMessage(("You've successfully mentioned the user : " + member.getUser().getAsMention())).queue();
            } else {
                event.getChannel().sendMessage("Sorry! I can't mention the bots!").queue();
            }
        }
    }
}

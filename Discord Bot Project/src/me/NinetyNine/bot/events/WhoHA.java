package me.NinetyNine.bot.events;

import java.util.List;

import me.NinetyNine.bot.util.Info;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class WhoHA extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		TextChannel channel = event.getChannel();

		if (args[0].equalsIgnoreCase(Info.getPrefix() + "whoIsHA")) {
			if (args.length == 1) {
				if (!event.getMember().getUser().isBot()) {
					List<Member> user = event.getGuild().getMembersByName("Pika", true);
					for (Member us : user)
						channel.sendMessage("GuildCraft Networks' Bedwars Head Admin is " + us.getEffectiveName() + "!")
								.complete();
					return;
				}
			} else
				channel.sendMessage(event.getMember().getAsMention() + "no u").complete();
		}
	}
}
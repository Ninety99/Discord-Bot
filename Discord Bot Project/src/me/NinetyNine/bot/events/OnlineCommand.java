package me.NinetyNine.bot.events;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class OnlineCommand extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		TextChannel channel = e.getChannel();

		int online = 0;
		int members = e.getGuild().getMembers().size();

		for (int i = 0; i < members; i++)
			if (e.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE
					|| e.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB)
				online++;

		channel.sendMessage("There are " + online + " memebrs online! There are " + members + " on "
				+ e.getGuild().getName() + "'s server").complete();
		online = 0;
	}
}

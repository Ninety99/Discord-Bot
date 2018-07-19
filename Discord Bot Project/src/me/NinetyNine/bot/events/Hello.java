package me.NinetyNine.bot.events;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		TextChannel channel = e.getChannel();

		if (args[0].equalsIgnoreCase("Hello")) {
			if (args.length != 1)
				return;
			else if (args.length == 1) {
				channel.sendMessage("Hey there, " + e.getMember().getAsMention() + "!").complete();
				return;
			}
		}
	}
}

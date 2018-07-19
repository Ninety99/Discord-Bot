package me.NinetyNine.bot.events;

import java.awt.Color;

import me.NinetyNine.bot.util.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed.Field;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SetPrefix extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String[] args = e.getMessage().getContentRaw().split(" ");
		TextChannel channel = e.getChannel();

		if (args[0].equalsIgnoreCase(Info.getPrefix() + "setPrefix")) {
			if (args.length != 2) {
				channel.sendMessage(e.getMember().getAsMention() + " no u").complete();
				return;
			} else if (args.length == 2 && args.length > 1) {
				Info.setPrefix(args[1]);
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("PREFIX");
				embed.addField(new Field("Prefix: ", Info.getPrefix(), true));
				embed.setColor(Color.CYAN);
				channel.sendMessage(embed.build()).complete();
				return;
			}
		}

		if (args[0].equalsIgnoreCase(Info.getPrefix() + "resetPrefix")) {
			if (args.length != 1)
				return;
			else {
				if (Info.isDefault(Info.getPrefix())) {
					channel.sendMessage("The prefix is still the default one!").complete();
					return;
				}
				
				Info.reset();
				channel.sendMessage("Prefix has reset! `" + Info.getPrefix() + "`").complete();
				return;
			}
		}
	}
}

package me.NinetyNine.bot;

import javax.security.auth.login.LoginException;

import lombok.Getter;
import me.NinetyNine.bot.events.Hello;
import me.NinetyNine.bot.events.OnlineCommand;
import me.NinetyNine.bot.events.SetPrefix;
import me.NinetyNine.bot.events.WhoHA;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class BotMain {

	@Getter
	public static JDA jda;

	public static void main(String[] args) {
		try {
			jda = new JDABuilder(AccountType.BOT)
					.setToken("NDUxMjIxMTEwOTE5Mzk3Mzgy.DjDEGA.BLesKUGfqqNVG1rTUK6zOmt2smk").buildBlocking();
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WhoHA wh = new WhoHA();
		Hello h = new Hello();
		SetPrefix sp = new SetPrefix();
		OnlineCommand cm = new OnlineCommand();
		
		jda.addEventListener(wh);
		jda.addEventListener(h);
		jda.addEventListener(sp);
		jda.addEventListener(cm);
	}
}
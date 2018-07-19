package me.NinetyNine.bot.util;

public class Info {

	private static String PREFIX = "-";

	public static void setPrefix(String prefix) {
		PREFIX = prefix;
	}

	public static void reset() {
		setPrefix("-");
	}

	public static boolean isDefault(String prefix) {
		return prefix == "-";
	}

	public static String getPrefix() {
		return PREFIX;
	}
}

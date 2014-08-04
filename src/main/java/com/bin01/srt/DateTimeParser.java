package com.bin01.srt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeParser
{
	private static final Pattern REGEX = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2}),(\\d{3})");

	private DateTimeParser()
	{
	}

	public static final DateTime parse(String s)
	{
		Matcher matcher = REGEX.matcher(s);
		if (matcher.find())
		{
			int hours = Integer.parseInt(matcher.group(1));
			int minutes = Integer.parseInt(matcher.group(2));
			int seconds = Integer.parseInt(matcher.group(3));
			int millis = Integer.parseInt(matcher.group(4));
			return new DateTime(hours, minutes, seconds, millis);
		}
		throw new IllegalArgumentException("Invalid DateTime Format " + s);
	}
}

package com.bin01.srt;

public class DateTime
{
	private final int hours;
	private final int minutes;
	private final int seconds;
	private final int millis;

	public DateTime(int hours, int minutes, int seconds, int millis)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.millis = millis;
	}

	public int getHours()
	{
		return hours;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public int getSeconds()
	{
		return seconds;
	}

	public int getMillis()
	{
		return millis;
	}
}

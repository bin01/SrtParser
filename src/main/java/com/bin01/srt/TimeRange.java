package com.bin01.srt;

public class TimeRange
{
	private final DateTime start;
	private final DateTime end;
	
	public TimeRange(DateTime start, DateTime end)
  {
	  this.start = start;
	  this.end = end;
  }

	public DateTime getStart()
	{
		return start;
	}

	public DateTime getEnd()
	{
		return end;
	}
}

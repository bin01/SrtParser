package com.bin01.srt;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class Block
{
	private final int id;
	private final TimeRange timeRange;
	private final List<String> lines;

	public Block(int id, TimeRange timeRange, List<String> lines)
	{
		this.id = id;
		this.timeRange = timeRange;
		this.lines = ImmutableList.<String> copyOf(lines);
	}

	public int getId()
	{
		return id;
	}

	public TimeRange getTimeRange()
	{
		return timeRange;
	}

	public List<String> getLines()
	{
		return lines;
	}
}

package com.bin01.srt;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class SubRip
{
	private final List<Block> blocks;

	public SubRip(List<Block> blocks)
	{
		this.blocks = ImmutableList.<Block> copyOf(blocks);
	}

	public List<Block> getBlocks()
	{
		return blocks;
	}
}

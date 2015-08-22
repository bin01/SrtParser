package com.bin01.srt;

import java.util.List;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class SubRip {

  public static SubRip newSubRip(List<Block> blocks) {
    return new AutoValue_SubRip(ImmutableList.<Block>copyOf(blocks));
  }

  public abstract List<Block> getBlocks();
}

package com.bin01.srt;

import java.util.List;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class Block {

  public abstract int getId();

  public abstract TimeRange getTimeRange();

  public abstract List<String> getLines();

  public static Block newBlock(int id, TimeRange timeRange, List<String> lines) {
    return new AutoValue_Block(id, timeRange, ImmutableList.<String>copyOf(lines));
  }

}

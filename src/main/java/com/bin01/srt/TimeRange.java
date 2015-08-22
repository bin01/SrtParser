package com.bin01.srt;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TimeRange {

  public static TimeRange newTimeRange(DateTime start, DateTime end) {
    return new AutoValue_TimeRange(start, end);
  }

  public abstract DateTime getStart();

  public abstract DateTime getEnd();
}

package com.bin01.srt;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DateTime {

  public static DateTime newDateTime(int hours, int minutes, int seconds, int millis) {
    return new AutoValue_DateTime(hours, minutes, seconds, millis);
  }

  public abstract int getHours();

  public abstract int getMinutes();

  public abstract int getSeconds();

  public abstract int getMillis();
  
}

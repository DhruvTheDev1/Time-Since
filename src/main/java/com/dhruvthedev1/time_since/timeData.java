package com.dhruvthedev1.time_since;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

public class TimeData {
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull(message = "Cannot be empty")
  private LocalDateTime localDateTime;
  private DurationFormat durationFormat;

  public TimeData() {
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  public DurationFormat getDurationFormat() {
    return durationFormat;
  }

  public void setDurationFormat(DurationFormat durationFormat) {
    this.durationFormat = durationFormat;
  }

  
}





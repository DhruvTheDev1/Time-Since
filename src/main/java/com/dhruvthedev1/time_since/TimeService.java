package com.dhruvthedev1.time_since;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Service;

// will calculate difference between current time and user's selected time
// accepts duration format too
@Service
public class TimeService {
  public String calculateTimeSince(LocalDateTime selectedInput, String durationFormat) {
    // retrieves curr date/time
    LocalDateTime currTime = LocalDateTime.now();
    // period between selected and current day
    Period period = Period.between(selectedInput.toLocalDate(), currTime.toLocalDate());

    // calculates hours, mins seconds
    Duration duration = Duration.between(selectedInput, currTime);

    // calculates the remaning hours, minutes and seconds
    // e.g. 58 hours, 130 seconds, 4500 seconds
    long days = period.getDays(); // gives full days (2)
    long hours = duration.toHours() % 24; // gives remaning hours after full day (58 % 24 = 10)
    long minutes = duration.toMinutes() % 60; // gives remaining minutes (130 % 60 = 10)
    long seconds = duration.toSeconds() % 60; // gives remaning seconds (4500 % 60 = 0)

    // calculating duration based on different formats
    if (durationFormat.equals("Years")) {
      return formatYears(period, days, hours);
    } else if (durationFormat.equals("Months")) {
      return formatMonths(period, days, hours, minutes);
    } else if (durationFormat.equals("Weeks")) {
      return formatWeeks(days, hours, minutes);
    } else if (durationFormat.equals("Days")) {
      // returns a readable format 2 days, 10 hours, 10 minutes, 0 seconds
      return String.format("%d days %d hours %d minutes %d seconds", days, hours, minutes, seconds);
    } else if (durationFormat.equals("Hours")) {
      return formatHours(duration, minutes, seconds);
    }

    return "Invalid format";

  }

  private String formatYears(Period period, long days, long hours) {
    long years = period.getYears();
    long months = period.getMonths();
    return String.format("%d years %d months %d days %d hours", years, months, days, hours);
  }

  private String formatMonths(Period period, long days, long hours, long minutes) {
    long months = period.getMonths();
    return String.format("%d months %d days %d hours %d minutes", months, days, hours, minutes);
  }

  private String formatWeeks(long days, long hours, long minutes) {
    long weeks = days / 7;
    long remainingDays = days % 7;
    return String.format("%d weeks %d days %d hours %d minutes", weeks, remainingDays, hours, minutes);
  }

  private String formatHours(Duration duration, long minutes, long seconds) {
    long totalHours = duration.toHours();
    return String.format("%d hours %d minutes %d seconds", totalHours, minutes, seconds);
  }

  // testing
  public static void main(String[] args) {
    TimeService timeService = new TimeService();
    LocalDateTime selectedInput = LocalDateTime.of(2026, 01, 07, 14, 0);
    String durationFormat = "Months";
    String calculateTime = timeService.calculateTimeSince(selectedInput, durationFormat);

    System.out.println(calculateTime);
  }

}

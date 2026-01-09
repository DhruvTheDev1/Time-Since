package com.dhruvthedev1.time_since;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

// will calculate difference between current time and user's selected time
// accepts duration format too
@Service
public class TimeService {
  public String calculateTimeSince(LocalDateTime selectedInput, String durationFormat) {
    // retrieves curr date/time
    LocalDateTime currTime = LocalDateTime.now();
    // years, months, days difference
    Period period = Period.between(selectedInput.toLocalDate(), currTime.toLocalDate());
    // hours, minutes, seconds difference
    Duration duration = Duration.between(selectedInput, currTime);

    long totalDays = ChronoUnit.DAYS.between(selectedInput, currTime);
    long totalHours = duration.toHours();
    // calculates hours, mins, seconds
    long remainingHours = duration.toHoursPart();
    long remainingMinutes = duration.toMinutesPart();
    long remainingSeconds = duration.toSecondsPart();

    // calculating duration based on different formats
    if (durationFormat.equals("Years")) {
      return formatYears(period, remainingHours);
    } else if (durationFormat.equals("Months")) {
      return formatMonths(period, remainingHours, remainingMinutes);
    } else if (durationFormat.equals("Weeks")) {
      return formatWeeks(totalDays, remainingHours, remainingMinutes);
    } else if (durationFormat.equals("Days")) {
      return String.format("%d days %d hours %d minutes %d seconds", totalDays, remainingHours, remainingMinutes, remainingSeconds);
    } else if (durationFormat.equals("Hours")) {
      return formatHours(totalHours, remainingMinutes, remainingSeconds);
    }

    return "Invalid format";

  }

  private String formatYears(Period period, long hours) {
    return String.format("%d years %d months %d days %d hours", period.getYears(), period.getMonths(), period.getDays(), hours);
  }

  private String formatMonths(Period period, long hours, long minutes) {
long totalMonths = (period.getYears() * 12L) + period.getMonths();    
return String.format("%d months %d days %d hours %d minutes", totalMonths, period.getDays(), hours, minutes);
  }

  private String formatWeeks(long totalDays, long hours, long minutes) {
    long weeks = totalDays / 7;
    long remainingDays = totalDays % 7;
    return String.format("%d weeks %d days %d hours %d minutes", weeks, remainingDays, hours, minutes);
  }

  private String formatHours(long totalHours, long minutes, long seconds) {
    return String.format("%d hours %d minutes %d seconds", totalHours, minutes, seconds);
  }

  // testing
  public static void main(String[] args) {
    TimeService timeService = new TimeService();
    LocalDateTime selectedInput = LocalDateTime.of(2026, 01, 9, 14, 20); 
    String durationFormat = "Days";
    String calculateTime = timeService.calculateTimeSince(selectedInput, durationFormat);

    System.out.println(calculateTime);
  }

}

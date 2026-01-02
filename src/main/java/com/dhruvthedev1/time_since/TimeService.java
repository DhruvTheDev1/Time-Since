package com.dhruvthedev1.time_since;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Service;

// will calculate difference between current time and user's selected time
@Service
public class TimeService {

  public String calculateTimeSince(LocalDateTime selectedInput) {
    LocalDateTime currTime = LocalDateTime.now(); // retrieves curr date/time
    Period period = Period.between(selectedInput.toLocalDate(), currTime.toLocalDate()); // period of years, months,
                                                                                         // days between the two days

    Duration duration = Duration.between(selectedInput, currTime); // calculates hours, mins, seconds

    long days = period.getDays();
    long hours = duration.toHours() % 24;
    long minutes = duration.toMinutes() % 60;
    long seconds = duration.toSeconds() % 60;

    return String.format("%d days %d hours %d minutes %d seconds", days, hours, minutes, seconds);

  }

}

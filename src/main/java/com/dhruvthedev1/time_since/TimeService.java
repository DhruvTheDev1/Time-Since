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

    // calculates the remaning hours, minutes and seconds
    // e.g. 58 hours, 130 seconds, 4500 seconds
    long days = period.getDays(); // gives full days (2)
    long hours = duration.toHours() % 24; // gives remaning hours after full day (58 % 24 = 10)
    long minutes = duration.toMinutes() % 60; // gives remaining minutes (130 % 60 = 10)
    long seconds = duration.toSeconds() % 60; // gives remaning seconds (4500 % 60 = 0)
    
    // returns a readable format 2 days, 10 hours, 10 minutes, 0 seconds
    return String.format("%d days %d hours %d minutes %d seconds", days, hours, minutes, seconds);
  }

  // testing
  public static void main(String[] args) {
    TimeService timeService = new TimeService();    
    LocalDateTime selectedInput = LocalDateTime.of(2026, 01, 02, 16, 05, 0);
    String result = timeService.calculateTimeSince(selectedInput);
    
    System.out.println(result); 
  }


}

package com.dhruvthedev1.time_since;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimeController {

  @Autowired
  private TimeService timeService;

  // displays form
  @GetMapping("/Time-Since")
  public String form() {
    return "form";
  }

  // POST method that handles when user inputs a date and calculates time difference
  // based on duration format selected by user
  @PostMapping("/Time-Since")
  @ResponseBody
  public Map<String, String> calculateTimeSinceDate(@ModelAttribute TimeData input) {
    String result = timeService.calculateTimeSince(input.getLocalDateTime(), input.getDurationFormat());
    return Collections.singletonMap("result", result);
  }
}
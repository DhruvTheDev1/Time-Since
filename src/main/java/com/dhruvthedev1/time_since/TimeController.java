package com.dhruvthedev1.time_since;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
  @PostMapping("/Time-Since")
  public String calculateTimeSinceDate(@ModelAttribute TimeData input, Model model) {
    String result = timeService.calculateTimeSince(input.getLocalDateTime());
    model.addAttribute("result", result);
    return "form";
  }
  
}

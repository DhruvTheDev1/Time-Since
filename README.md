# Time-Since App
A time Since web application that displays the exact time passed since any given date and time. Built with SpringBoot for the backend and a dynmaic frontend that provides real time, second by second updates.
The user can display the time passed in a variety of formats.

## Features
- Date/Time Selection: Users can pick any date and time.
- Multiple Duration Formats: Users can select the format they'd like to see the results in, whether that's years, months, weeks, days or hours.
- Real-Time Updates: The results updates dynamically every second using AJAX.
- Dynamic UI: The results updates dynamically as you change the duration formats.
- Precise calendar logic: Uses java.time which is extremely precise and automatically handles leap years and other calendar rules.

## How It Works
- User selects a date/time using the datetime picker and choosing a preferred duration format (days by default)
- The backend calculates the time difference between the selected date/time and current moment and returns it as a JSON.
- The result is updated dynamically in real-time using AJAX without needed to reload the page and users can even change the duration format which automatically updates.

## Tech Stack
- SpringBoot
- Thymeleaf
- JavaScript/JQuery
- Maven

## App Examples
<img width="466" height="368" alt="image" src="https://github.com/user-attachments/assets/2c10bd61-bd43-4179-8b14-dd4018744f65" />

<img width="465" height="327" alt="image" src="https://github.com/user-attachments/assets/df9374b2-dd34-413e-a242-49067f8eff3c" />

## Further Work
- Adding CSS to make the front-end more user-friendly and appealing.
- Currently the application uses 1 second AJAX polling which is inefficient for a real world application hence transitioning to WebSockets can reduce server load and be more efficient.

// updates the results dynamically
let updateInterval;

$(document).ready(function () {
  $('#timeForm').submit(function (event) {
    event.preventDefault();
    // gets the date and durationFormat
    const selectedDate = $('#selectedDate').val();
    const durationFormat = $('#durationFormat').val();

    // stops previous polling when form is resubmitted for example
    if (updateInterval) {
      clearInterval(updateInterval);
    }

    updateTime(selectedDate, durationFormat);
    // polls every 1 second
    updateInterval = setInterval(function () {
      updateTime(selectedDate, durationFormat);
    }, 1000);
  });

  // stops polling if user leaves page
  $(window).on('beforeunload', function () {
    if (updateInterval) {
      clearInterval(updateInterval);
    }
  });
});

function updateTime(selectedDate, durationFormat) {
  $.ajax({
    url: '/Time-Since',
    method: 'POST',
    data: {
      localDateTime: selectedDate,
      durationFormat: durationFormat
    },
    // updates results
    success: function (response) {
      $('#resultDisplay').text(response.result);
    },
    error: function() {
      console.error("error"); // debugging
    }
  });
}

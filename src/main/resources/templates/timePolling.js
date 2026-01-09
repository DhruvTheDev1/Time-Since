// JQuery to update the results dynamically
let updateInterval;

$(document).ready(function () {
  $('#timeForm').submit(function (event) {
    event.preventDefault();
    // gets the date and durationFormat
    const selectedDate = $('#selectedDate').val();
    const durationFormat = $('#durationFormat').val();

    // stops prev polling when form is resubmitted for example
    if (updateInterval) {
      clearInterval(updateInterval);
    }

    updateTime(selectedDate, durationFormat);

    updateInterval = setInterval(function () {
      updateTime(selectedDate, durationFormat);
    }, 1000);  // polls every 1 second
  });
});

function updateTime(selectedDate, durationFormat) {
  $.ajax({
    url: '/Time-Since',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify({
      localDateTime: selectedDate,
      durationFormat: durationFormat
    }),
    success: function (data) {
      // update the time
      $('#resultDisplay').text(data.result);
    }
  });
}

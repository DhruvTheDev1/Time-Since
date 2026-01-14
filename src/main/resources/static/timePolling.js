// updates the results dynamically
let updateInterval;

$(document).ready(function () {
  $('#timeForm').submit(function (event) {
    event.preventDefault();
    // gets the date and durationFormat
    const selectedDate = $('#selectedDate').val();
    const durationFormat = $('#durationFormat').val();

    // stops prev polling
    if (updateInterval) {
      clearInterval(updateInterval);
    }

   const performUpdate = () => updateTime(selectedDate, durationFormat);
   performUpdate();
   updateInterval = setInterval(performUpdate, 1000);
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
      success: (response) =>  $('#resultDisplay').text(response.result)
  });
}
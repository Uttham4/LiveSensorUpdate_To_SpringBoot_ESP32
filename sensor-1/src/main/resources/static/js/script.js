/**
 * 
 */

// auto-reload.js

function fetchData() {
    fetch('/sensor-1/getLastData')
    .then(response => response.json()) // Parse the response as JSON
    .then(data => {
        console.log(data); // Check the retrieved data
        document.getElementById('dataContainer').innerText = JSON.stringify(data);
    })
    .catch(error => console.error('Error fetching data:', error));
}

// Fetch data initially
fetchData();

// Fetch data every 5 seconds (adjust the interval as needed)
//setInterval(fetchData, 2000); // 5000 milliseconds = 5 seconds
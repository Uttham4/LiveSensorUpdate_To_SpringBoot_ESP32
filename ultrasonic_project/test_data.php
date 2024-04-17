<?php

$hostname = "localhost"; 
$username = "root"; 
$password = ""; 
$database = "sensors_db";

$conn = mysqli_connect($hostname, $username, $password, $database);

if (!$conn) { 
	die("Connection failed: " . mysqli_connect_error()); 
} 

echo "Database connection is OK<br>"; 

if(isset($_POST["distance_in_inch"]) && isset($_POST["distance_in_cm"])) {

	$t = $_POST["distance_in_inch"];
	$h = $_POST["distance_in_cm"];

	$sql = "INSERT INTO ultrasonic (distance_in_inch, distance_in_cm) VALUES (".$t.", ".$h.")"; 

	if (mysqli_query($conn, $sql)) { 
		echo "\nNew record created successfully"; 
	} else { 
		echo "Error: " . $sql . "<br>" . mysqli_error($conn); 
	}
}

?>
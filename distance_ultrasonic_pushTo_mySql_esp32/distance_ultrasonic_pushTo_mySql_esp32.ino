#include <WiFi.h>
#include <HTTPClient.h>



String URL = "http://192.168.227.59/ultrasonic_project/test_data.php";

const char* ssid = "vivo V21e 5G"; 
const char* password = "12345678"; 
const int pingPin = 15;

//int iter=0;

void setup() {
  Serial.begin(9600);
  
  connectWiFi();
}

void loop() {
  int duration, inches, cm;
  
  if(WiFi.status() != WL_CONNECTED) {
    connectWiFi();
  }

  pinMode(pingPin, OUTPUT);
  digitalWrite(pingPin, LOW);
  delayMicroseconds(2);
  digitalWrite(pingPin, HIGH);
  delayMicroseconds(5);
  digitalWrite(pingPin, LOW);

  pinMode(pingPin, INPUT);
  duration = pulseIn(pingPin, HIGH);

  // convert the time into a distance
  inches = microsecondsToInches(duration);
  cm = microsecondsToCentimeters(duration);

  String postData = "distance_in_inch=" + String(inches) + "&distance_in_cm=" + String(cm);
  
  HTTPClient http;
  http.begin(URL);
  http.addHeader("Content-Type", "application/x-www-form-urlencoded");
  
  int httpCode = http.POST(postData);
  String payload = http.getString();

  Serial.print("URL : "); Serial.println(URL); 
  Serial.print("Data: "); Serial.println(postData);
  Serial.print("httpCode: "); Serial.println(httpCode);
  Serial.print("payload : "); Serial.println(payload);
  Serial.print("Distance in inch : " + String(inches) + "\n");
  Serial.print("Distance in cm : " + String(cm));
  Serial.println("--------------------------------------------------");
  // iter++;
  // if(iter>10)
  //   return;
  delay(2000);
}


void connectWiFi() {
  WiFi.mode(WIFI_OFF);
  delay(1000);
  //This line hides the viewing of ESP as wifi hotspot
  WiFi.mode(WIFI_STA);
  
  WiFi.begin(ssid, password);
  Serial.println("Connecting to WiFi");
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
    
  Serial.print("connected to : "); Serial.println(ssid);
  Serial.print("IP address: "); Serial.println(WiFi.localIP());
}

int microsecondsToInches(int microseconds) {

  return microseconds / 74 / 2;
}

int microsecondsToCentimeters(int microseconds) {
  return microseconds / 29 / 2;
}

#include <Servo.h>
Servo servo; 
Servo servo2;
const int s0 = A0;  
const int s1 = A1;  
const int s2 = A2;  
const int s3 = A3;  
const int out = 13;   
// LED pins connected to Arduino
int redLed = 2;  
int greenLed = 10;  
int blueLed = 4;
// Variables  
int red = 0;  
int green = 0;  
int blue = 0; 

int trigPin = A5;
int echoPin = A4;
long distance;
long duration;


//Variables declaradas
//&&


#define ENA 5
#define ENB 6
#define IN1 7
#define IN2 8
#define IN3 9
#define IN4 11

//&&velocidad
//&&dealy

void setup() {
servo.attach(3); 
servo.write(180); 
delay(1000); 
servo.write(0);
delay(1000);
servo.write(90);
delay(1000);

servo2.attach(10); 
delay(1000);

Serial.begin(9600); 
  pinMode(s0, OUTPUT);  
  pinMode(s1, OUTPUT);  
  pinMode(s2, OUTPUT);  
  pinMode(s3, OUTPUT);  
  pinMode(out, INPUT);  
  pinMode(redLed, OUTPUT);  
  //pinMode(greenLed, OUTPUT);  
  pinMode(blueLed, OUTPUT);  
  digitalWrite(s0, HIGH);  
  digitalWrite(s1, HIGH);

    pinMode(IN1,OUTPUT);
  pinMode(IN2,OUTPUT);
  pinMode(IN3,OUTPUT);
  pinMode(IN4,OUTPUT);
  pinMode(ENA,OUTPUT);
  pinMode(ENB,OUTPUT);
   digitalWrite(ENA, HIGH);//Enable left motor     
}

//&&loop
void loop() {
  

  color(); 
  Serial.print("R Intensity:");  
  Serial.print(red, DEC);  
  Serial.print(" G Intensity: ");  
  Serial.print(green, DEC);  
  Serial.print(" B Intensity : ");  
  Serial.print(blue, DEC);  
  //Serial.println();  


    
  if (red < blue && red < green && red < 20)
  {  
    servo2.write(160); 
  delay(80); 
   
   Serial.println(" - (Red Color)");  
   digitalWrite(redLed, HIGH); // Turn RED LED ON 
   digitalWrite(greenLed, LOW);  
   digitalWrite(blueLed, LOW);  

    //&&red
          color();
  }  

  else if (blue < red && blue < green)   
  {  
    servo2.write(0);
    Serial.println(" - (Blue Color)");  
    digitalWrite(redLed, LOW);  
    digitalWrite(greenLed, LOW);  
    digitalWrite(blueLed, HIGH);

    //&&blue
      color();
    delay(20);// Turn BLUE LED ON  
  }  

  else if (green < red )  
  {  
   Serial.println(" - (Green Color)");  
   digitalWrite(redLed, LOW);  
   digitalWrite(greenLed, HIGH); // Turn GREEN LED ON 
   digitalWrite(blueLed, LOW); 
    
    //&&green

    delay(20);// Turn GREEN LED ON 
  }

      else if (red > 40 && green >53 && blue >30 )   
  {  
    Serial.println(" - (Black Color)");   

    //&&black
   color();

} 
  else{
  Serial.println();  
  }
    
  delay(300);   
  digitalWrite(redLed, LOW);  
  digitalWrite(greenLed, LOW);  
  digitalWrite(blueLed, LOW);  
   color();
}
//&&loop

void color()  
{    
  digitalWrite(s2, LOW);  
  digitalWrite(s3, LOW);  
  //count OUT, pRed, RED  
  red = pulseIn(out, digitalRead(out) == HIGH ? LOW : HIGH);  
  digitalWrite(s3, HIGH);  
  //count OUT, pBLUE, BLUE  
  blue = pulseIn(out, digitalRead(out) == HIGH ? LOW : HIGH);  
  digitalWrite(s2, HIGH); 
  //count OUT, pGreen, GREEN  
  green = pulseIn(out, digitalRead(out) == HIGH ? LOW : HIGH);  
}

void retorno() 
{

 pinMode(IN1, OUTPUT);   //set IO pin mode OUTPUT
  pinMode(IN2, OUTPUT);
  pinMode(ENA, OUTPUT);
  digitalWrite(ENA, HIGH);//Enable left motor  

digitalWrite(IN1, HIGH);      
  digitalWrite(IN2, LOW); //Right wheel turning forwards
   delay(1200); //TIEMPO QUE VA DURAR LA VUELTA  
}

void avanzar(){
     digitalWrite(IN1,HIGH);
  digitalWrite(IN2,LOW);
  digitalWrite(IN3,LOW);
  digitalWrite(IN4,HIGH);
  analogWrite(ENB,velocidad);
  analogWrite(ENA,velocidad); 

}
void detener(){ 
  digitalWrite(IN1, LOW);      
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);      
  digitalWrite(IN4, LOW);
  
  digitalWrite(ENB,LOW); //Motor is off 
  digitalWrite(ENA,LOW);  
   
 
}


  void giroDe() 
{

  pinMode(IN3, OUTPUT); //set IO pin mode OUTPUT
  pinMode(IN4, OUTPUT);
  pinMode(ENB, OUTPUT);
  digitalWrite(ENB, HIGH);

 digitalWrite(IN3, LOW);      
  digitalWrite(IN4, HIGH);//Right wheel turning forwards
  delay(600);          
}

  void giroIz() 
{

 pinMode(IN1, OUTPUT);   //set IO pin mode OUTPUT
  pinMode(IN2, OUTPUT);
  pinMode(ENA, OUTPUT);
  digitalWrite(ENA, HIGH);//Enable left motor  

digitalWrite(IN1, HIGH);      
  digitalWrite(IN2, LOW); //Right wheel turning forwards
   delay(600); //TIEMPO QUE VA DURAR LA VUELTA  
}

void obstaculo(){
   digitalWrite(redLed, HIGH); // Turn RED LED ON 
   detener();
   delay(1000); 
   giroIz();
   detener();
   delay(1000);
   giroDe();
      detener();
   delay(1000);
   
   analogWrite(ENB,100);
    analogWrite(ENA,100);
      detener();
   delay(1000);
     
   
    giroDe();
       detener();
   delay(1000);
   
    giroIz(); 
       detener();
}   

void checar (){ 
 ultra();

  if(distance < 15){

   obstaculo(); 

  }
 else {
   digitalWrite(redLed, LOW); // Turn RED LED ON 
  }

}

void ultra(){
  digitalWrite(trigPin, LOW);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = duration/59;  //escalamos el tiempo a una distancia en cm
  
  Serial.print("Distancia: ");
  Serial.print(duration);      //Enviamos serialmente el valor de la distancia
  Serial.print("cm");
  Serial.println();
  }

  void camaraArriba() {

servo2.write(10); 
delay(1000);
  
  }

  
  void camaraAbajo() {
 
servo2.write(150); 
delay(1000);
  
  }
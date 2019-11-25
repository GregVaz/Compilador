#include <Servo.h>
Servo servo; 
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


#define ENA 5
#define ENB 6
#define IN1 7
#define IN2 8
#define IN3 9
#define IN4 11



void setup() {
servo.attach(3); 
servo.write(0); 
delay(2000);

Serial.begin(9600); 
  pinMode(s0, OUTPUT);  
  pinMode(s1, OUTPUT);  
  pinMode(s2, OUTPUT);  
  pinMode(s3, OUTPUT);  
  pinMode(out, INPUT);  
  pinMode(redLed, OUTPUT);  
  pinMode(greenLed, OUTPUT);  
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
    servo.write(160); 
  delay(80); 
   
   Serial.println(" - (Red Color)");  
   digitalWrite(redLed, HIGH); // Turn RED LED ON 
   digitalWrite(greenLed, LOW);  
   digitalWrite(blueLed, LOW);  
 
 detener(); 
  delay(2000);
avanzar();
  

       
  }  

  else if (blue < red && blue < green)   
  {  
    servo.write(0);
   Serial.println(" - (Blue Color)");  
   digitalWrite(redLed, LOW);  
   digitalWrite(greenLed, LOW);  
   digitalWrite(blueLed, HIGH);
  avanzar(); 
    delay(20);// Turn BLUE LED ON  
  }  

  else if (green < red )  
  {  
   Serial.println(" - (Green Color)");  
   digitalWrite(redLed, LOW);  
   digitalWrite(greenLed, HIGH); // Turn GREEN LED ON 
   digitalWrite(blueLed, LOW); 

     detener(); 
  delay(800);
  giro(); 
    detener(); 
  }

      else if (red > 40 && green >53 && blue >30 )   
  {  
    servo.write(90);
  delay(80);
   Serial.println(" - (black)");  
} 
  else{
  Serial.println();  
  }
  delay(300);   
  digitalWrite(redLed, LOW);  
  digitalWrite(greenLed, LOW);  
  digitalWrite(blueLed, LOW);  
}

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
void giro() 
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
analogWrite(ENB,100);
    analogWrite(ENA,100); 

}
void detener(){ 
       digitalWrite(IN1, LOW);      
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);      
  digitalWrite(IN4, LOW);
  
   digitalWrite(ENB,LOW); //Motor is off 
  digitalWrite(ENA,LOW);  
   
 
}

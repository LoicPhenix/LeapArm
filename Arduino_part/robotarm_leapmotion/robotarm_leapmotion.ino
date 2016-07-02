#include "MeOrion.h"
#include <SoftwareSerial.h>

//pince [-150,150]
MeDCMotor motor1_pince(PORT_1);
//bras [-200,250]
MeDCMotor motor2_bras(PORT_2); //+ monté / - descendre (correctif negatif +50)
//Chenilles [-255,255]
MeDCMotor motor3_gauche(M1);
MeDCMotor motor4_droit(M2);
//Bluetooth
MeBluetooth bluetooth(PORT_5);

void setup() {
  Serial.begin(115200); // Activation port Serie
  bluetooth.begin(115200); // Activation Bluetooth
  Serial.println("Hello Arduino, Bluetooth Start!");  
}

void loop() {
  
}

// ---- Méthode serialEvent() ----
void serialEvent(){
  
  char table[10] = {};
  char pin = {};
  char angle[4] = {};
  
  int angle_int, pin_int;
  int readdata = 0,i = 0,count = 0;

  if (bluetooth.available())
  {
    //Reception Trame
    while((readdata = bluetooth.read()) != (int)-1)
    {
      char inChar = (char)readdata;
      if (inChar == '\n') {
          break;
      }     
      
      table[count] = inChar;
      count++;
      
      delay(1);
    }
    
    //Return Message
    Serial.print(table);    
    
    //Récupération de Pin
    pin_int = atoi(&table[0]);
    
    //Récupération de Angle
    count =0;
    for(i = 2;i<6;i++)
    {
      angle[count] = table[i];
      count++;
    }
    angle_int = atoi(angle); //angle en int
  
    //Gestion Pince (pin = 1) (moteur_1)
    if(pin_int == 1) {
      if (angle_int == 0) {
        motor1_pince.stop();
      } else {
        motor1_pince.run(angle_int);
      }
    }
  
    //Gestion Bras (pin = 2) (moteur_2)
    if(pin_int == 2) {
      if (angle_int == 0) {
        motor2_bras.stop();
      } else {
        motor2_bras.run(angle_int);
      }
    }
  
    //Gestion moteur 3 (pin = 3)
    if(pin_int == 3) {
      if (angle_int == 0) {
        motor3_gauche.stop();
      } else {
        // correction de rotation
        // moteur gauche + faible (correctif : - 15)
        if(angle_int < 0)
          motor3_gauche.run(angle_int-15); 
        else
          motor3_gauche.run(angle_int);
      }
    }

    //Gestion moteur 4 (pin = 4)
    if(pin_int == 4) {
      if (angle_int == 0) {
        motor4_droit.stop();
      } else {
         motor4_droit.run(-angle_int);
      }
    }
    
    Serial.flush();
    
  } 
}

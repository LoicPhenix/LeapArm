#include "MeOrion.h"

MeDCMotor motor1_pince(PORT_1);

MeDCMotor motor2_bras(PORT_2);

MeDCMotor motor3_gauche(M1);

MeDCMotor motor4_droit(M2);

uint8_t motorSpeed_pince = 150;
uint8_t motorSpeed_bras = 250;
uint8_t motorSpeed = 100;

void setup()
{
  motor1_pince.run(50);
  delay(2000);
  motor1_pince.stop();
}

void loop()
{
  /* value: between -255 and 255.   
  
  //pince [-150,150]
  motor1_pince.run(motorSpeed_pince); //+ ouvert / - fermé
  
  //bras [-200,250]
  motor2_bras.run(motorSpeed_bras); //+ monté / - descendre (correctif negatif +50)

  //Chenilles [-255,255]
  motor3_gauche.run(-motorSpeed); //+ arriere / - avant
  motor4_droit.run(motorSpeed); //- arriere / + avant
  
  delay(2000);
  motor1_pince.stop();
  motor2_bras.stop();
  motor3_gauche.stop();
  motor4_droit.stop();
  delay(100);
  motor1_pince.run(-motorSpeed_pince);
  motor2_bras.run(-motorSpeed_bras+50); // correctif negatif 50
  motor3_gauche.run(motorSpeed);
  motor4_droit.run(-motorSpeed);
  delay(2000);
  motor1_pince.stop();
  motor2_bras.stop();
  motor3_gauche.stop();
  motor4_droit.stop();
  delay(2000);*/
}


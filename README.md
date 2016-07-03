# Projet LeapArm
## Par Loïc MONOT / Pierre-Antoine CHARPENTIER

Projet de commande d'un bras robotisé sur chenille à l'aide de LeapMotion via Bluetooth.

### Ressources & Documents :
	
- Dans le dossier "Ressources" se trouve le ZIP de la librairie "Makeblock".
- La librairie LeapMotion étant trop lourde pour GitHub celle-ci fut retirée.

 Merci de télecharger sur leapMotion.com la librairie : Leap_Motion_SDK_Windows_2.3.1

- Le dossier "documents" contient :
	- Vidéo de présentation d'utilisation de LeapArm
	- Un diaporama de soutenance et présentation de LeapArm
	- Une Doc du projet
	- Le manuel du robot makeblock

### Installation du Projet :

JAVA :
- Chargez le projet LeapArm a l'aide d'Eclipse
- installez les librairies utiles (LeapArm/lib):
	- LeapMotion : (ATTENTION) merci de récupérer la librairie LeapMotion SDK sur leapMotion.com
	- RXTX 2.2 : déjà inclu dans leapArm/lib
	- Makeblock : déjà inclu dans leapArm/lib

ARDUINO :
- Installez L'IDE Arduino
- ouvrez LeapArm/Arduino-part/robotarm_leapmotion
- televersez le .ino sur la carte arduino (orion) 

### Démarrage de LeapArm :

- Débranchez le bluetooth du robot. (carte LED bleu)
- Téleversez robotarm_leapmotion.ino sur le robot makeblock. (via USB)
- Rebranchez le bluetooth du robot et allumez le.
- Connectez le robot au PC via bluetooth (LED bleu ne clignote plus)
- Branchez votre LeapMotion au PC
- ouvrez votre projet LeapArm
- Modifiez le port RS232 : "COM4" par votre port BL du robot (dans : LeapArm/src/LeapArm.java)

- Lancez LeapArm via l'IDE

### Utilisation :

- !! Merci de regarder la vidéo pour les gestes d'utilisation du robot (LeapArm/documents/..)

- des informations de Mouvements/Trames son retournées sur la console Eclipse

### GL ... ;)
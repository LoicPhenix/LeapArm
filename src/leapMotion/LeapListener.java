/*Classe LeapListener [THREAD]
 * Desc : Gestion d'evenement Threadé du LeapMotion
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package leapMotion;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Vector;

import makeBlock.Servo;

public class LeapListener extends Listener {
	Servo arm_pince_1 = new Servo("1");
	Servo arm_bras_2 = new Servo("2");
	Servo arm_drive_3 = new Servo("3");
	Servo arm_drive_4 = new Servo("4");

	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}
	public void onConnect(Controller controller) {
		System.out.println("Connected");
	}
	public void onDisconnect(Controller controller) {
		System.out.println("Disconnected");
	}
	public void onExit(Controller controller) {
		System.out.println("Exited");
	}
	
	// Reception des mouvements LeapMotion (Boucle)
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();
		if (!frame.hands().isEmpty()) {
			
			
			Hand handRight = frame.hands().rightmost();
			Hand handLeft = frame.hands().leftmost();
			// Vecteur des Mains et Direction
			Vector handR = handRight.palmNormal();
			Vector handL = handLeft.palmNormal();
			
			// Debug
			System.out.println("\n\nHand Right, diametre: " + handRight.sphereRadius()+
			", X : " + handRight.palmPosition().getX()+
			", Y : "+handRight.palmPosition().getY()+
			", Z : " + handRight.palmPosition().getZ()+
			", Yaw : " + Math.toDegrees(handR.yaw()));
			System.out.println("Hand Left, diametre: " + handLeft.sphereRadius()+
			", X : " + handLeft.palmPosition().getX()+
			", Y : "+handLeft.palmPosition().getY()+
			", Z : " + handLeft.palmPosition().getZ()+
			", Yaw : " + Math.toDegrees(handL.yaw()));
			
			// Transcription des mouvements en action du robot 
			// Main Gauche
			if (handLeft.isLeft() == true){
				arm_pince_1.arm_pince(handLeft.sphereRadius(), Math.toDegrees(handL.yaw()));
				arm_bras_2.arm_bras(handLeft.palmPosition().getY(), handLeft.sphereRadius());
			}
			// Main droite
			if (handRight.isRight() == true){
				arm_drive_3.arm_chenilleG(handRight.palmPosition().getZ(),handRight.palmPosition().getX(), handRight.sphereRadius());
				arm_drive_4.arm_chenilleD(handRight.palmPosition().getZ(),handRight.palmPosition().getX(), handRight.sphereRadius());
			}
			
			try {
				//attente de 10 ms
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
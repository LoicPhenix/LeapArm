/*Classe ArmRun
 * Desc : Gestion du bras makeBlock
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package makeBlock;
import com.leapmotion.leap.Vector;

import CommRS232.CommPortSender;

public class Servo {
	public String pin_str;
	
	public Servo(String pin) {
		pin_str =pin;
	}
	
	public void arm_chenilleD(float z_axis, float x_axis, float hand_radius) {
		int angle_Z = (int)Math.round(z_axis * 1.5);
		int angle_X = (int)Math.round(x_axis);
		int valeur = 0;
		int coef = 0;
		
		if (hand_radius > 50){		
			if(z_axis<=(-20) && z_axis>=(-160) && angle_Z>=(-250)) {
				if(angle_X <= 100 && angle_X >= 0){			
					valeur = angle_Z - 50;
				} else if (angle_X >= 200){				
					valeur = angle_Z + 50;
				} else {				
					valeur = angle_Z;
				}	
				//Debug
				System.out.print("\nAvant: " + valeur);
				setMsg(valeur);
	
			} else if (z_axis>=20 && z_axis<=250 && angle_Z<=250){
				
				//Debug
				System.out.print("\nArriere: " + angle_Z);				
				setMsg(angle_Z);	
			}else {			
				setMsg(0);
			}
		} else {
			
			setMsg(0);
		}
	}
	
	public void arm_chenilleG(float z_axis, float x_axis, float hand_radius) {
		int angle_Z = (int)Math.round(z_axis * 1.5);
		int angle_X = (int)Math.round(x_axis);
		int valeur = 0;
		
		if (hand_radius > 50){		
			if(z_axis<=(-20) && z_axis>=(-160) && angle_Z>=(-250)) {
				
				if(angle_X <= 100 && angle_X >= 0){			
					valeur = angle_Z + 50;
				} else if (angle_X >= 200){				
					valeur = angle_Z - 50;
				} else {				
					valeur = angle_Z;
				}	
				//Debug
				System.out.print("\nAvant: " + valeur);
				setMsg(valeur);	
	
			} else if (z_axis>=20 && z_axis<=250 && angle_Z<=250){
				
				//Debug
				System.out.print("\nArriere: " + angle_Z);				
				setMsg(angle_Z);	
			}else {			
				setMsg(0);
			}
		} else {
			
			setMsg(0);
		}
	}
	
	public void arm_bras(float y_axis, float sphere_radius) {
		int diametre = (int)Math.round(sphere_radius);
		int valeurY = (int)Math.round(y_axis);
		
		//if(diametre > 50) {
			if(y_axis >= 350 && y_axis <= 450){
				//Debug
				System.out.print("bras_monte: 200");
				setMsg(200);
				
			} else if (y_axis >= 100  && y_axis <= 200) {
				//Debug
				System.out.print("bras_descend: -200");
				setMsg(-200);
			}else {			
				setMsg(0);
			}
			
		//} else {
			//setMsg(0);
		//}
	}
	
	public void arm_pince(float sphere_radius, double rotation_z) {
		int diametre = (int)Math.round(sphere_radius);
		int rotZ = (int)Math.round(rotation_z);
		
		if(diametre > 50) {
			if(rotZ >= 20 && rotZ <= 100){
				//Debug
				System.out.print("Pince_ouverte: 150");
				setMsg(150);
				
			} else if (rotZ <= 20) {
				//Debug
				System.out.print("Pince_fermee: -150");
				setMsg(-150);
			}
			
		} else {
			setMsg(0);
		}
	}
	
	public void setMsg(int angle) {
		String tmp = Integer.toString(angle);
		
		if(Integer.toString(angle).length() == 3) {
			if(angle < 0)
				tmp = "-0" + Integer.toString(-angle);
			else 
				tmp = "0" + Integer.toString(angle);
		}
		
		if(Integer.toString(angle).length() == 2) {
			if(angle < 0)
				tmp = "-00" + Integer.toString(-angle);
			else 
				tmp = "00" + Integer.toString(angle);
		}
		
		if(Integer.toString(angle).length() == 1)
			tmp = "000" + Integer.toString(angle);
		
		/*if(pin_str.length() == 1) 
			pin_str = "0" + pin_str;
		*/
		tmp = pin_str + "," + tmp + "\n";
		CommPortSender.send(new ProtocolServo().getMessage(tmp));
	}
}

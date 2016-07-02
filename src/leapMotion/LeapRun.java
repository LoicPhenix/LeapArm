/*Classe LeapRun
 * Desc : Gestion du LeapMotion
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package leapMotion;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class LeapRun {
	
	private Controller controller;
	private LeapListener listener;
	
	public LeapRun () {
		// Create a sample listener and controller
		listener = new LeapListener();
        controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(listener);
        
        System.out.println(controller.frame().hands());

	}
	
	public void HauteurBras (){
		
		System.out.println(controller.frame().hands());
		
	}
	
	// Destructeur
	public void finalize()
    {
        // Remove the sample listener when done
        controller.removeListener(listener);
        
        System.out.println("LeapRun Class destruct");   
    }
}

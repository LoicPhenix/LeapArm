/*Classe Protocol [INTERFACE]
 * Desc : INTERFACE de comm Protocol pour ProtocolServo
 * By : Lo�c MONOT
 * Date : 08/05/2016
 * Group : Lo�c MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package makeBlock;
public interface Protocol {  
	// traite chaque octet re�u
    void onReceive(byte b);    
        
    // g�re le flux quand close
    void onStreamClosed();   
}  
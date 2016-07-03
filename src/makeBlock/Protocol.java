/*Classe Protocol [INTERFACE]
 * Desc : INTERFACE de comm Protocol pour ProtocolServo
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package makeBlock;
public interface Protocol {  
	// traite chaque octet reçu
    void onReceive(byte b);    
        
    // gère le flux quand close
    void onStreamClosed();   
}  
/*Classe ProtocolServo
 * Desc : Protocol de communication (Trame) du robot
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package makeBlock;
import java.io.IOException;

public class ProtocolServo implements Protocol{  
	
    byte[] buffer = new byte[1024];    
    int tail = 0;    
        
    public void onReceive(byte b) {    
        // simple protocol: each message ends with new line    
        if (b=='\n') {    
            onMessage();    
        } else {    
            buffer[tail] = b;    
            tail++;    
        }    
    }    
     
    public void onStreamClosed() {    
        onMessage();    
    }    
         
    private void onMessage() {    
        if (tail!=0) {    
            // constructing message    
            String message = getMessage(buffer, tail);
            System.out.println("\nRECEIVED MESSAGE: " + message);    
            tail = 0;    
        }    
    }    
        
    // helper methods     
    public byte[] getMessage(String message) {    
        return message.getBytes();    
    }    
        
    public String getMessage(byte[] buffer, int len) {
			return new String(buffer, 0, tail);

    }  
}  
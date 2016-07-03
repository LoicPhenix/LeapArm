/*Classe CommPortReceiver [THREAD]
 * Desc : Classe de reception de trame du port serie
 * By : Lo�c MONOT
 * Date : 08/05/2016
 * Group : Lo�c MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package CommRS232;
import java.io.IOException;
import java.io.InputStream;

import makeBlock.Protocol;
import makeBlock.ProtocolServo;
  
public class CommPortReceiver extends Thread{  
	
    InputStream in;    
    Protocol protocol = new ProtocolServo();    
     
    public CommPortReceiver(InputStream in) {    
        this.in = in;
    }    
        
    public void run() {    
        try {    
            int b;    
            while(true) {    
                    
                // si le flux est pas li� in.read () renvoie -1
                while((b = in.read()) != -1) {    
                    protocol.onReceive((byte) b);    
                }    
                protocol.onStreamClosed();    
                    
                // attendre 10ms Lorsque le flux est coup� et v�rifier � nouveau 
                sleep(1);    
            }    
        } catch (IOException e) {    
            e.printStackTrace();    
        } catch (InterruptedException e) {    
            e.printStackTrace();    
        }     
    }  
}
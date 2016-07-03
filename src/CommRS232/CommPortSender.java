/*Classe CommPortSender
 * Desc : Classe d'envoi de trame au port serie
 * By : Lo�c MONOT
 * Date : 08/05/2016
 * Group : Lo�c MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package CommRS232;
import java.io.IOException;
import java.io.OutputStream;
  
public class CommPortSender {  
	
    static OutputStream out;    
      
    public static void setWriterStream(OutputStream out) {    
        CommPortSender.out = out;    
    }    
        
    public static void send(byte[] bytes) {    
        try {    
        	//debug
            System.out.print("\nSENDING --> length : " + bytes.length + ", trame : " + new String(bytes, 0, bytes.length));
                
            // Envoi par le port s�rie de la trame
            out.write(bytes);    
            out.flush();
            
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
    }      
}  
/*Classe ConnectRS232 
 * Desc : Classe de connection et configuration du port serie
 * By : Loïc MONOT
 * Date : 08/05/2016
 * Group : Loïc MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

package CommRS232;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
 
public class ConnectRS232 {  
	public void connect(String portName) throws Exception {    
		
		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);    
     
        if (portIdentifier.isCurrentlyOwned()) {    
            System.out.println("Port in use!");    
        } else {    
            // instanciation du port serie   
            SerialPort serialPort = (SerialPort) portIdentifier.open("RS232Example", 2000);    
                
            // Connection au port série   
            serialPort.setSerialPortParams(    
            		115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);    
            //115200 Bauds (bluetooth)
            //Trame 8 bits -1 (stop bit)
            
            // ouverture du port   
            CommPortSender.setWriterStream(serialPort.getOutputStream());    
                
            // ouverture en écoute du port série (thread)  
            new CommPortReceiver(serialPort.getInputStream()).start();    
        }    
    }     
}
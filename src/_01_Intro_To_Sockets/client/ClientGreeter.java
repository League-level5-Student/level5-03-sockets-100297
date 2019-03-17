package _01_Intro_To_Sockets.client;

import java.net.*;
import java.io.*;

public class ClientGreeter {

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
      String ipn = "192.168.1.176";
      //2. Create an integer for the server's port number
      int portn = 8080;
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.

    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
      	try {
			Socket sock = new Socket(ipn, portn);
			DataOutputStream a = (DataOutputStream) sock.getOutputStream();
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
       a.writeUTF("This is a special message");  
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         DataInputStream inp = (DataInputStream) sock.getInputStream();
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
          System.out.println(inp.readUTF());
         //9. Close the client's server object
          sock.close();
      	}
     catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}

import java.io.*;
import java.net.*;
import java.util.*;
class TCPClient {
  public static void main(String argv[]) throws Exception  {
    String sentence;
    String answer;
    Scanner sc=new Scanner(System.in);
    String data=sc.next();
    
    BufferedReader inFromUser = new BufferedReader( new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
    Socket clientSocket = new Socket("localhost", 8999);
    
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
    sentence = inFromUser.readLine();
    outToServer.writeBytes(sentence + '\n');
    
    answer = inFromServer.readLine();
    System.out.println("Answer is: " + answer);
    clientSocket.close();
  }
}
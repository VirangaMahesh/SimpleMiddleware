import java.io.*; 
import java.net.*;

class TCPServer1 {    
  public static void main(String argv[]) throws Exception       {
    String method;
    ServerSocket welcomeSocket = new ServerSocket(8124);
    while(true){ 
      int ans=0;
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient =                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      method = inFromClient.readLine();
      
      
      System.out.println("Received: " + method);
      String request[]=method.split("[,()]");
      if(request[0].equalsIgnoreCase("multy")){
        ans=multy(Integer.parseInt(request[1]),Integer.parseInt(request[2]));
      }else if(request[0].equalsIgnoreCase("mod")){
        ans=mod(Integer.parseInt(request[1]),Integer.parseInt(request[2]));;
      }
      
      String Answer=ans+"";
      
      outToClient.writeBytes(Answer+'\n');
      System.out.println("Answer: " + Answer);
    }
  }
  public static int multy(int x,int y){
    int ans=x*y;
    return ans;
  } 
  public static int mod(int x,int y){
    int ans=x%y;
    return ans;
  }
} 
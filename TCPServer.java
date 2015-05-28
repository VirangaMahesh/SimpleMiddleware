import java.io.*; 
import java.net.*;
class TCPServer {    
  public static void main(String argv[]) throws Exception       {
    String method;
    ServerSocket welcomeSocket = new ServerSocket(8123);
    while(true){ 
      
      int ans=0;
      
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient =                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      method = inFromClient.readLine();
      
      
      System.out.println("Received: " + method);
      
      String request[]=method.split("[,()]");
      
      if(request[0].equalsIgnoreCase("add")){
        ans=add(Integer.parseInt(request[1]),Integer.parseInt(request[2]));
      }else if(request[0].equalsIgnoreCase("sub")){
        ans=sub(Integer.parseInt(request[1]),Integer.parseInt(request[2]));;
      }
      String Answer=ans+"";
      
      outToClient.writeBytes(Answer+'\n');
      System.out.println("Answer: " + Answer);
    }
  }
  
  public static int add(int x,int y){
    int ans=x+y;
    return ans;
  }
  public static int sub(int x,int y){
    int ans=x-y;
    return ans;
  }
} 

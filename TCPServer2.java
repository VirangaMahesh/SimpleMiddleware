import java.io.*; 
import java.net.*;


class TCPServer2 {    
  public static void main(String argv[]) throws Exception       {
    String method;
    ServerSocket welcomeSocket = new ServerSocket(8125);
    while(true){ 
      int ans=0;
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient =                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      method = inFromClient.readLine();
      
      
      System.out.println("Received: " + method);
      String request[]=method.split("[,()]");
      if(request[0].equalsIgnoreCase("divide")){
        ans=divide(Integer.parseInt(request[1]),Integer.parseInt(request[2]));
      }
      String Answer=ans+"";
      
      outToClient.writeBytes(Answer+'\n');
      System.out.println("Answer: " + Answer);
    }
  }
  public static int divide(int x,int y){
    if(!(y==0)){
    int ans=x/y;
    return ans;
    }else{
      return 0;
  }
  }
 
} 
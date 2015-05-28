import java.io.*; 
import java.util.*;
import java.net.*;
class Middleware {    
  public static void main(String argv[]) throws Exception       {
    String clientSentence;
    String capitalizedSentence;
    ServerSocket socket = new ServerSocket(8999);
   // ServerSocket socket1 = new ServerSocket(8998);
   // ServerSocket socket2 = new ServerSocket(8997);
    while(true)          { 
     
      
      Socket connectionSocket = socket.accept();
      //Socket connectionSocket1 = socket1.accept();
      //Socket connectionSocket2 = socket2.accept();
      BufferedReader inFromClient =     new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      clientSentence = inFromClient.readLine();
      System.out.println(clientSentence);
      
      String request[]=clientSentence.split("[(,)]");
      
     // System.out.println("Received: " + clientSentence);
     // capitalizedSentence = clientSentence.toUpperCase() + '\n';
     // outToClient.writeBytes(capitalizedSentence);
      
      int portNumber=0;
    
        Mid m=new Mid();
      portNumber=m.checkServer(request[0]);
     
      
      if (portNumber>0){
        int answer=m.midClient(portNumber,clientSentence);
        System.out.println(portNumber+"");
        outToClient.writeBytes((Integer.toString(answer))+'\n');
      }
    }
    
    
  }
}
class Mid{
  public  int checkServer(String method){
    int portNumber=0;
    String[][] datalist=new String[3][];
    // The name of the file to open.
    String fileName = "checkserver.txt";
    
    // This will reference one line at a time
    String line = null;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = 
        new FileReader(fileName);
      
      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = 
        new BufferedReader(fileReader);
      int i=0;
      while((line = bufferedReader.readLine()) != null) {
        
        String string = line;
        datalist[i]=string.split(",");
        i++;
        //System.out.println(line);
      }    
      
      // Always close files.
      bufferedReader.close();
      
      for(int j=0;j<datalist.length;j++){
        for(int k=2;k<datalist[j].length;k++){
          if(method.equalsIgnoreCase(datalist[j][k])){
            portNumber=Integer.parseInt(datalist[j][1]);
            
          }
          
        }
      }
      return portNumber;
    }
    catch(FileNotFoundException ex) {
      System.out.println(
                         "Unable to open file '" + 
                         fileName + "'");
      return 0;
    }
    catch(IOException ex) {
      System.out.println(
                         "Error reading file '" 
                           + fileName + "'"); 
      return 0;
      // Or we could just do this: 
      // ex.printStackTrace();
    }
    
  }
  
  public int midClient(int portNumber,String data) throws Exception  {
    String sentence;
    String modifiedSentence;
    int answer=0;
    BufferedReader inFromUser = new BufferedReader( new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
    Socket clientSocket = new Socket("localhost", portNumber);
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
    sentence = inFromUser.readLine();
    System.out.println("ans: " + 1);
    outToServer.writeBytes(sentence + '\n');
    System.out.println("ans: " + 2);
    modifiedSentence = inFromServer.readLine();
    System.out.println("ans: " + 3);
    answer=Integer.parseInt(modifiedSentence);
    System.out.println("FROM SERVER: " + modifiedSentence);
    //System.out.println("ans: " + answer);
    clientSocket.close();
    System.out.println("FROM SERVER: " + modifiedSentence);
    return answer;
    
  }
} 
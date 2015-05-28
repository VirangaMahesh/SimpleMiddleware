# SimpleMiddleware
this is simple middleware for get an idea for beginners,
 there is thre servers for deferent task and middleware for select server for paticular client paticular request.
 TCPClient in the client for the Middleware and it send request for middleware.
 There is an CheckServer  text file find out which server has which method.
 data pass through network as an bite string,

How to run programe:-
using commandline(make sure you had all compiled java files)
  first run three servers 
    java TCPServer
    java TCPServer1
    java TCPServer2
    
  then run Middleware
    java Middleware
    
  then run client
    java TCPClient
    
clent get inputs:
  add(int x,int y)
  multy(int x,int y)
  divide(int x,int y)
  mod(int x,int y)
  sub(int x,int y)
(x and y shoyd be integer except zreo)
  
this is sample file only you can edit and costamize all the things. 

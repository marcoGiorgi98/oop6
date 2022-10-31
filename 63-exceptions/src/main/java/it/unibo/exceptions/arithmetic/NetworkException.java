package it.unibo.exceptions.arithmetic;

import java.io.IOException;

public class NetworkException extends IOException{
    
    Exception e;
    public NetworkException(){
        this.e=new Exception("Network error: no response");
    }

    public NetworkException(String message){
this.e=new Exception("Network error while sending message: "+message);
    }
}

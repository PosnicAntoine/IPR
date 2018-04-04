package tp.rmi.common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReceiveCallback extends Remote, Serializable{

    public void newMessage(String message) throws RemoteException;

}
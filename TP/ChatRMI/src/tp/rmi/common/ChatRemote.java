package tp.rmi.common;

import java.awt.List;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatRemote extends Remote, Serializable {
	ArrayList<ReceiveCallback> listCallback = new ArrayList<ReceiveCallback>();
	
	public void registerCallback(ReceiveCallback callback) throws RemoteException;

    public void send(String name, String message) throws RemoteException;
    
    public String echo(String name, String message);

}
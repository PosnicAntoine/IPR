package tp.rmi.serveur;

import java.rmi.RemoteException;

import tp.rmi.common.ChatRemote;
import tp.rmi.common.ReceiveCallback;

public class ChatRemoteImpl implements ChatRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String echo(String name, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerCallback(ReceiveCallback callback)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(String name, String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}

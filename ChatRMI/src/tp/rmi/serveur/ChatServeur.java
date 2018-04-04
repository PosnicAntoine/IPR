package tp.rmi.serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatServeur {
	private static String ADDRESS = "localhost";
	private static int REGISTRY_PORT = 1099;
	
	public static void main(String[] args) throws RemoteException,
			MalformedURLException {
		ChatRemoteImpl objetDistant = new ChatRemoteImpl();
		Naming.rebind("//"+ ADDRESS +"/chat", objetDistant);
	}
}

package tp.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import tp.rmi.serveur.ChatRemoteImpl;

public class ChatClient {
	private static String ADDRESS = "localhost";
	private static int REGISTRY_PORT = 1099;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		ChatRemoteImpl object = (ChatRemoteImpl) Naming.lookup("//"+ ADDRESS +"/chat");
		System.out.println("Object gathered: "+ object);
	}
}

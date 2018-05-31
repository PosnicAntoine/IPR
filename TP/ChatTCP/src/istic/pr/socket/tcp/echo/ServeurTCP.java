//...

package istic.pr.socket.tcp.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {

    public static void main(String[] args) throws IOException {
    	int portEcoute = 9999;
        //Attente des connexions sur le port 9999
    	ServerSocket socketServeur = new ServerSocket(portEcoute);
    	
		try {
			//Dans une boucle, pour chaque socket clientes, appeler traiterSocketCliente
			while(true){
				System.out.println("Attends les clients");
				traiterSocketCliente(socketServeur.accept());
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			System.out.println("end");
			socketServeur.close();
		}
		//Traitement des exceptions
		

    }

    public static void traiterSocketCliente(Socket socketVersUnClient){
    	try{
		    //Créer printer et reader
			BufferedReader br = creerReader(socketVersUnClient);
			PrintWriter pw = creerPrinter(socketVersUnClient);
			
			String curr;
			while((curr = recevoirMessage(br)) != null){
		    	//Tant qu’il y’a un message à lire via recevoirMessage
				System.out.println(curr);
				envoyerMessage(pw, curr);
				//Envoyer message au client via envoyerMessage
			
			}
			socketVersUnClient.close();
			
			//Si plus de ligne à lire fermer socket cliente
    	}catch(IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
    	}
    }

    public static BufferedReader creerReader(Socket socketVersUnClient)
    throws IOException {
    	return new BufferedReader(new InputStreamReader(socketVersUnClient.getInputStream()));
        //créé un BufferedReader associé à la Socket
    }

    public static PrintWriter creerPrinter(Socket socketVersUnClient) throws
    IOException {
		return new PrintWriter(socketVersUnClient.getOutputStream());
        //créé un PrintWriter associé à la Socket
    }

    public static String recevoirMessage(BufferedReader reader) throws
    IOException {
    	return reader.readLine();
    	//Récupérer une ligne
        //Retourner la ligne lue ou null si aucune ligne à lire.
    }
    

    public static void envoyerMessage(PrintWriter printer, String message)
    throws IOException {
    	printer.println(message);
    	printer.flush();
        //Envoyer le message vers le client
    }

}
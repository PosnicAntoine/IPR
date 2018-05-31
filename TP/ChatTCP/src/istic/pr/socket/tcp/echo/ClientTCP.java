package istic.pr.socket.tcp.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {

    public static void main(String[] args) {
    	int portDuServeur = 9999;
    	String adresseDuServeur = "localhost";
    	Socket socketVersLeServeur;
    	try {
    		//créer une socket client
			socketVersLeServeur = new Socket(adresseDuServeur, portDuServeur);
			
	        //créer reader et writer associés
			BufferedReader br = creerReader(socketVersLeServeur);
			PrintWriter pw = creerPrinter(socketVersLeServeur);
			String curr = lireMessageAuClavier();
			
			//Tant que le mot «fin» n’est pas lu sur le clavier,
			while(!curr.equals("fin")){
				//envoyer le message au serveur
				envoyerMessage(pw, curr);
				//recevoir et afficher la réponse du serveur
				System.out.println("Message Reçu:\n"+recevoirMessage(br));
				//Lire un message au clavier
				curr = lireMessageAuClavier();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String lireMessageAuClavier() throws IOException {
    	System.out.println("Entrez votre message:");
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		return in.readLine();
    	//lit un message au clavier en utilisant par exemple un BufferedReader
        //sur System.in
    }

    public static BufferedReader creerReader(Socket socketVersUnClient) throws 
    IOException {
    	return new BufferedReader(new InputStreamReader(socketVersUnClient.getInputStream()));
    	//créé un BufferedReader associé à la Socket
    }

    public static PrintWriter creerPrinter(Socket socketVersUnClient) throws
    IOException {
    	return new PrintWriter(socketVersUnClient.getOutputStream());
        //créé un PrintWriter associé à la Socket
        //identique serveur
    }

    public static String recevoirMessage(BufferedReader reader) throws
    IOException {
    	return reader.readLine();
        //identique serveur
    }

    public static void envoyerMessage(PrintWriter printer, String message) throws
    IOException {
    	printer.println(message);
    	printer.flush();
        //identique serveur
    }

}
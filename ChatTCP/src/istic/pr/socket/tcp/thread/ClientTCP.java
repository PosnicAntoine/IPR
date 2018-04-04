package istic.pr.socket.tcp.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {

    public static void main(String[] args) {
    	int portDuServeur = 9999;
    	String adresseDuServeur = "localhost";
    	String nameServeur = "Serveur";
    	String charset = "UTF-8";
    	Socket socketVersLeServeur;
    	
    	if(args.length>1){
    		nameServeur = args[0];
    		charset = args[1];
    	}
    	
    	try {
    		//créer une socket client
			socketVersLeServeur = new Socket(adresseDuServeur, portDuServeur);
			
	        //créer reader et writer associés
			BufferedReader br = creerReader(socketVersLeServeur, charset);
			PrintWriter pw = creerPrinter(socketVersLeServeur, charset);
			
			envoyerNom(pw, nameServeur);
			System.out.println(recevoirMessage(br));
			
			String curr = lireMessageAuClavier();
			
			//Tant que le mot «fin» n’est pas lu sur le clavier,
			while(!curr.equals("fin")){
				//envoyer le message au serveur
				envoyerMessage(pw, curr);
				//recevoir et afficher la réponse du serveur
				System.out.println(recevoirMessage(br));
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
    	System.out.print("user> ");
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		return in.readLine();
    	//lit un message au clavier en utilisant par exemple un BufferedReader
        //sur System.in
    }

    public static BufferedReader creerReader(Socket socketVersUnClient, String charset) throws 
    IOException {
    	return new BufferedReader(new InputStreamReader(socketVersUnClient.getInputStream(), charset));
    	//créé un BufferedReader associé à la Socket
    }

    public static PrintWriter creerPrinter(Socket socketVersUnClient, String charset) throws
    IOException {
    	return new PrintWriter(new OutputStreamWriter(socketVersUnClient.getOutputStream(), charset));
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
    
    public static void envoyerNom(PrintWriter printer, String nom) throws
    IOException {
    	printer.println(nom);
    	printer.flush();
        //envoi « NAME: nom » au serveur
    }

}
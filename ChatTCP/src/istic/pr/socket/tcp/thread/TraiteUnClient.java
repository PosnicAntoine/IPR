package istic.pr.socket.tcp.thread;

import java.net.Socket;

class TraiteUnClient implements Runnable{
	private Socket socketVersUnClient;
	
	protected TraiteUnClient(Socket socketVersUnClient) {
		this.socketVersUnClient = socketVersUnClient;
	}
	@Override
	public void run() {
		ServeurTCP.traiterSocketCliente(this.socketVersUnClient);
	}
	
}

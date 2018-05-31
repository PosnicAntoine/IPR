package istic.pr.socket.address;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;



public class AfficheInterfaces {

	public static void main(String[] args) {
		Enumeration<NetworkInterface> ni = null;
		Enumeration<InetAddress> ia = null; 
		try {
			ni = NetworkInterface.getNetworkInterfaces();
			while (ni.hasMoreElements()){
				NetworkInterface currni = ni.nextElement();
				System.out.println(currni);
				ia = currni.getInetAddresses();
				while (ia.hasMoreElements()){
					System.out.println(ia.nextElement());
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}

}

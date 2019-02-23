package utility.observer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BusStop {
	public static void main(String args[]) {
		Bus bus = new Bus();
		System.out.println("Bus ID: " + bus.getInfo());
		System.out.println();
		BusPassenger[] passengers = new BusPassenger[4];
		passengers[0] = new BusPassenger("Allan");
		passengers[1] = new BusPassenger("Britt");
		passengers[2] = new BusPassenger("Carl");
		passengers[3] = new BusPassenger("Dee");
		for (int i = 0; i < passengers.length; i++) {
			System.out.println(passengers[i] + " is getting in");
			try {
				passengers[i].getIn(bus);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(passengers[2] + " is getting out");
		try {
			passengers[2].getOut();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(bus);
	}
}
/*
 * OUTPUT: (note Buss id could be different) Bus ID: eXpress 22 Allan is getting
 * in Britt is getting in Allan: Hello Britt Carl is getting in Allan: Hello
 * Carl Britt: Hello Carl Dee is getting in Allan: Hello Dee Britt: Hello Dee
 * Carl: Hello Dee Carl is getting out Allan: Bye Bye Carl Britt: Bye Bye Carl
 * Dee: Bye Bye Carl eXpress 22: Allan Britt Dee
 */
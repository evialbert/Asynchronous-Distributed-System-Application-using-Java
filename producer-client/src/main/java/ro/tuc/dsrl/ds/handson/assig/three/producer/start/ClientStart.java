package ro.tuc.dsrl.ds.handson.assig.three.producer.start;

import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

import java.io.IOException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 *	Starting point for the Producer Client application. This
 *	application will send several messages to be inserted
 *  in the queue server (i.e. to be sent via email by a consumer).
 */
public class ClientStart {
	private static final String HOST = "localhost";
	private static final int PORT = 8888;

	private ClientStart() {
	}

	public static void main(String[] args) {
		QueueServerConnection queue = new QueueServerConnection(HOST, PORT);
		DVD dvd1 = new DVD("1", 1997, 12);
		DVD dvd2 = new DVD("2", 1998, 2);


		try {
			queue.writeMessage(dvd1.toString());
			queue.writeMessage(dvd2.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

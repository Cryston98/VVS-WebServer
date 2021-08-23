package test;

import static org.junit.Assert.*;

import java.net.ServerSocket;

import org.junit.Test;

import main.myServer;

public class listenForClient {
	
	myServer server = new myServer();
	
	@Test
	public void testListen() {
	
		
		server.setPort(8444);
		server.acceptServerPort();
		int myVar=server.conectionClient;
		assertEquals(0,myVar);
	
	}

}

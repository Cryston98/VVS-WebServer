package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.Socket;

import org.junit.jupiter.api.Test;

import main.myServer;
import main.uiClass;




class stateServer {

	myServer emp =new myServer();
	
	@Test
	void test_set_getStatus() {
		emp.setStateServer(1);
		assertEquals(1,emp.getStateServer());

	}
	
	@Test
	void test_set_getSocketClient() {
		Socket sock = new Socket();
		emp.setClientSocket(sock);
		assertEquals(sock,emp.getClientSocket());
	}
	
	
	
	

}
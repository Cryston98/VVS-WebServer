package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.myServer;

public class portTest {
	 myServer server;
	 
	@Before
	public void setup() {
		 server=new myServer();
	}
	
	
	@Test
	public void testPortUnderZero() {
		assertEquals(false,server.setPort(-1));
	}
	
	@Test
	public void testPortAboveMax() {
		assertEquals(false,server.setPort(66000));
	}
	
	
	@Test
	public void testSetPort1() {
		int port=0;
		server.setPort(port);
		assertEquals(false,server.acceptServerPort());
	}
	


	
	@Test
	public void test_acceptServerPort()
	{
		server.setPort(10005);
		assertEquals(true,server.acceptServerPort());
	}
	
	@Test
	public void test_Exception1_acceptServerPort()
	{
		server.setPort(100000);
		assertEquals(false,server.acceptServerPort());
	}
	
	@Test
	public void test_Exception2_acceptServerPort()
	{
		server.setPort(-10);
		assertEquals(false,server.acceptServerPort());
	}

	@Test
	public void test_Exception3_acceptServerPort()
	{
		server.setPort(1024);
		assertEquals(false,server.acceptServerPort());
	}
	

	@Test
	public void test_Exception4_acceptServerPort()
	{
		server.setPort(65000);
		assertEquals(false,server.acceptServerPort());
	}
	
}



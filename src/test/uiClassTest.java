package test;

import main.myServer;
import main.uiClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Runner;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class uiClassTest {

	@Mock
	private uiClass uiClassMock;

	@Mock
	private myServer myServerMock;

	@Test
	public void testVerifComand1() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServerMock=mock(myServer.class);
		myServer myS=  new myServer();
		String data = "7889";
		uiClass.setSrv(myS);
		//InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8"));
		//System.setIn(testInput);
		//uiClass.setPortInterface();


		uiClassMock.verifCommand("srv_pause");
		assertEquals(myS.getStateServer(),2);
	}

	@Test
	public void testVerifComand2() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		uiClassMock.verifCommand("srv_stop");
		assertEquals(myS.getStateServer(),3);
	}


	@Test
	public void testVerifComand3() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		uiClassMock.verifCommand("srv_start");
		assertEquals(myS.getStateServer(),1);

	}

	@Test
	public void testVerifComand4() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		uiClassMock.verifCommand("CEVA");
		assertEquals("WAITING",uiClass.getStatusServer());

	}
	@Test
	public void testVerifComand5() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		uiClassMock.verifCommand("status");
	}
	@Test
	public void testVerifComand6() throws IOException {
		uiClassMock=mock(uiClass.class);
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		uiClassMock.verifCommand("systeminfo");
	}


	@Test
	public void testSetPortInterface1() throws IOException {
		uiClass uiC= Mockito.mock(uiClass.class);
		String data = "7989";
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8"));
		System.setIn(testInput);
		uiC.setPortInterface();
		assertEquals(true,uiClass.getConnectionOk());
	}

	@Test
	public void testSetPortInterface2() throws UnsupportedEncodingException {
		uiClass uiC= Mockito.mock(uiClass.class);
		String data = "abs";
		myServer myS=  new myServer();
		uiClass.setSrv(myS);
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8"));
		System.setIn(testInput);
		uiC.setPortInterface();
	}


}

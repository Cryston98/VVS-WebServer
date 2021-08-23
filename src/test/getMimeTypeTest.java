package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import main.myServer;

public class getMimeTypeTest {

	File root= new  File("www");
	File fileHTML= new File(root,"typefile.html");
	File fileCSS= new File(root,"typefile.css");
	File fileJPG= new File(root,"typefile.jpg");
	File fileJPEG= new File(root,"typefile.jpeg");
	File fileJS= new File(root,"typefile.js");
	File fileN1= new File(root,"typefile.js..d");
	File fileTTF= new File(root,"typefile.ttf");
	File fileEOT= new File(root,"typefile.eot");
	File filePNG= new File(root,"typefile.png");
	File fileNone= new File(root,"typefile");

	myServer  server;
	
	@Before
	public void setup() {
		 server=new myServer();
	}
	
	@Test
	public void testHTML() {
		assertEquals("text/html",server.getExtFile(fileHTML));
	}

	@Test
	public void testNone() {
		assertEquals("none",server.getExtFile(fileNone));
	}
	
	@Test
	public void testCSS() {
		assertEquals("text/css",server.getExtFile(fileCSS));
	}

	@Test
	public void testJS() {
		assertEquals("text/js",server.getExtFile(fileJS));
	}
	
	@Test
	public void testBadFile() {
		assertEquals("text/html",server.getExtFile(fileN1));
	}

	@Test
	public void testJPEG() {
		assertEquals("image/jpeg",server.getExtFile(fileJPEG));
	}
	@Test
	public void testJPG() {
		assertEquals("image/jpg",server.getExtFile(fileJPG));
	}
	@Test
	public void testPNG() {
		assertEquals("image/png",server.getExtFile(filePNG));
	}
	@Test
	public void testEOT() {
		assertEquals("font/eot",server.getExtFile(fileEOT));
	}

	@Test
	public void testTTF() {
		assertEquals("font/ttf",server.getExtFile(fileTTF));
	}
	
}

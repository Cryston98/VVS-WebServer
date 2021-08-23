package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Test;



import main.myServer;

public class readFileTest {

	@Test
	public void test() throws IOException  {
		myServer srv=new myServer();
		
		File root= new  File("www");
		File fileHTML= new File(root,"maintenance.html");
		int fileLength =(int)fileHTML.length();

		byte[] binarFileR = new byte[fileLength];
		binarFileR = srv.readFileData(fileHTML, fileLength);


			final int BLOCK_SIZE = fileLength;
			InputStream aStream = new FileInputStream(fileHTML);

			byte[] aBuffer = new byte[fileLength];
			aStream.read(aBuffer, 0, BLOCK_SIZE);
			assertArrayEquals(aBuffer, binarFileR);

	}

}

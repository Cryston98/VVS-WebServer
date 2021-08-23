package test;

import main.myServer;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public  class foundFileTest {

    @Test
    public void testFound() throws IOException {
        myServer srv=new myServer();

        File root= new  File("www");
        File fileHTML= new File(root,"maintenance.html");
        int fileLength =(int)fileHTML.length();

        PrintWriter out=null;
        OutputStream dataOut=null;
        String fileRequested="maintenance.html";

        srv.fileNotFound(out,dataOut,fileRequested);


    }
}
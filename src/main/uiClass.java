package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;



public class uiClass implements Runnable{
	
	static boolean runServer=true;

	public static String getStatusServer() {
		return statusServer;
	}

	static String  statusServer;
	static int port;
	static int stepSetPort=0;

	public static boolean getConnectionOk() {
		return connectionOk;
	}

	public static void setConnectionOk(boolean connectionOk) {
		uiClass.connectionOk = connectionOk;
	}

	static boolean connectionOk=false;

	public static myServer getSrv() {
		return srv;
	}

	public static void setSrv(myServer srv) {
		uiClass.srv = srv;
	}

	static myServer srv;
	static int programRun=1;


	
	public static void main(String[] args)
	{
		//Initializare server
		srv = new myServer();
		while (!connectionOk) {
			setPortInterface();
		}
		
		Thread interfaceThread = new Thread(new uiClass());
		interfaceThread.start();

		try {
			readComands();
		} catch (IOException e) {
			System.out.println("\n Invalid command !");
		}
	}

	@Override
	public void run() {
		while(runServer) {
			srv.listenForClients();
		}
	}

	public static void readComands() throws IOException {
		while(true)
			{
				System.out.print("+ Enter command :");
				BufferedReader readerCommand =  new BufferedReader(new InputStreamReader(System.in)); 
				String comandaLinie = readerCommand.readLine(); 
				verifCommand(comandaLinie);
			}
	}
	
	public static void verifCommand(String cmd) throws IOException {
		if (cmd.equals("status")) {
	    	   System.out.println("Status WebServer is :"+statusServer);
		}else if (cmd.equals("systeminfo")) {
	    	   System.out.println("Status server : "+statusServer);
	    	   System.out.println("Port : "+port);
	    	   InetAddress IP = InetAddress.getLocalHost();
	    	   System.out.println("Host : "+IP.getHostAddress());
		}else if (cmd.equals("srv_pause")){
				srv.setStateServer(2);
			 	statusServer="MAINTENANCE";
	    	    System.out.println("Server is now in maintenance mode!");
		}else if (cmd.equals("srv_start")) {
			   srv.setStateServer(1);
			   statusServer="RUNNING";
	    	   System.out.println("Server start with initial port : "+port);
		}else if (cmd.equals("srv_stop")){
			   srv.setStateServer(3);
			   statusServer="STOP";
	    	   System.out.println("Server is stop!");
		}else{
			 statusServer="WAITING";
			 System.out.println("This command is not defined!");
		}
	}

	public static void setPortInterface() {
		    System.out.print("Enter Server Port : ");
			BufferedReader readerCommand =  new BufferedReader(new InputStreamReader(System.in)); 
			try {
				port = Integer.parseInt(readerCommand.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid port 1");
				port=-1;
			}
			if(srv.setPort(port))
			{
				if(srv.acceptServerPort())
				{
					System.out.println("Port : "+port+" was accepted! Enter 'srv_start' command in order to start server l\n");
					connectionOk=true;
					statusServer="STOP";
				}
			}
	}
	
}

package test;

import org.junit.Test;
import org.junit.Assert;



public class webResponsTest {


	private String sendStrig, recString, expected;
	private webConnection wbcon;

	@Test
	public void testResponseOK() {
		wbcon=new webConnection();

		int code=wbcon.responseCode();
		System.out.println(code);
		Assert.assertEquals(200,code);
	}

	/*
	*
	* ATENTIE NUMAR PORT.CLASA  webConnection,webResponsTest  si clasa uiTest sa se utilizez acelasi port
	*
	* */

	@Test
	public void maintenancetest() {
		try {
			wbcon=new webConnection();
			expected=new String("<html>\n" +
					"<head>\n" +
					"<title>Mentenaince</title>\n" +
					"<link rel=\"stylesheet\" href=\"style.css\">\n" +
					"</head>\n" +
					"<body>\n" +
					"  <h2>Mentenanta Server!</h2>\n" +
					"</body>\n" +
					"</html>\n");
			recString=wbcon.httpUrlConnection("http://localhost:7877/");
			Assert.assertEquals(expected,recString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

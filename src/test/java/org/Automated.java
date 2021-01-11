package org;

import java.io.IOException;
import java.util.Date;

import org.cts.Base;
import org.cts.LogIn;
import org.tcs.Access;
import org.tcs.CreateAccount;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Automated extends Base {
	@BeforeClass
	private void beforeClass() {
		getChromeDrive();
		loadUrl("https://octoperf.com/actions/catalog.action");
	}

	@BeforeMethod
	private void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	private void mainMethod1() {
		CreateAccount account = new CreateAccount();
		btn(account.getStart());
	}

	@Parameters({ "email", "password" })
	@Test
	private void mainMethod2(String s1, String s2) {
		LogIn in = new LogIn();
		windowHandling();
		enterType(in.getLogId(), s1);
		enterType(in.getPassWord(), s2);
		btn(in.getLogInBtn());
	}

	@Parameters({ "name", "description", "tagname" })
	@Test
	private void mainMethod3(String s3, String s4, String s5) throws InterruptedException {
		Access access = new Access();
		Thread.sleep(3000);
		btn(access.getAddProject());
		enterType(access.getName(), s3);
		enterType(access.getDescription(), s4);
		enterType(access.getTag(), s5);
		btn(access.getSave());
	}

	@AfterMethod
	private void afterMethod() throws IOException {
		Date date = new Date();
		System.out.println(date);
		screenShot("C:\\Users\\ELCOT\\Desktop\\Daily Tasks\\screenshot\\octperf");
	}

	@AfterClass
	private void afterClass() {
		shutDown();

	}
}

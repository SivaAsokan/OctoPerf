package org;

import org.cts.Base;
import org.cts.LogIn;
import org.tcs.Access;
import org.tcs.CreateAccount;

public class Demo extends Base {
	public static void main(String[] args) throws InterruptedException {
		getChromeDrive();
		loadUrl("https://octoperf.com/actions/catalog.action");
		CreateAccount account = new CreateAccount();
		btn(account.getStart());
		LogIn in = new LogIn();
		windowHandling();
		enterType(in.getLogId(), "shivaabe19@gmail.com");
		enterType(in.getPassWord(), "siva2118@#$");
		btn(in.getLogInBtn());
		Access access = new Access();
		Thread.sleep(3000);
		btn(access.getAddProject());
		enterType(access.getName(), "OctPerf");
		enterType(access.getDescription(), "This is a project to add with browser");
		enterType(access.getTag(), "Automted");
		btn(access.getSave());
		shutDown();
	}

}

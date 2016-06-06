package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.*;
import TestData.DriverSetup;

public class ShopByDept extends DriverSetup{

	@Test
	public static void testCase1() throws Exception
	{
		LoginPage login = DriverSetup.SelectBrowser();
		CredentialsPage cp = login.loginWithCreds();
		HomePage hp = cp.signIn();
		AllDepartments ad = hp.navigateToAllDepartments();
		AmazonVideos av = ad.navigateToAllVideos();
		SearchResult sr = av.searchBarVideo();
	}
}

package testng;

import org.testng.annotations.Test;

public class TestngPractice {
		@Test(invocationCount = 10)
		 void modifyUser()
		{
			System.out.println("ModifyUser");
		}
		@Test(priority = 1)
		private void createUser()
		{
			System.out.println("User created");
		}
		
		
}

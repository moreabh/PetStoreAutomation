package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1, dataProvider= "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fName, String lName, String usermail, String pwd, String phno) {
		
		User userPayload = new User();
		

		System.out.println(userID + " " + userName);
		
//		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(usermail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phno);
		userPayload.setId(Integer.parseInt(userID));
		
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public  void testDeleteUserByName(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
//		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}

import org.testng.Assert;

import Files.AddJson;
import io.restassured.path.json.JsonPath;

public class ExtractCourcesData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AddJson aj = new AddJson();
		String jsddata=AddJson.cources();
		JsonPath js = new JsonPath(jsddata);
		int pAmount =js.getInt("dashboard.purchaseAmount");
		System.out.println(js.getInt("courses.size()"));
		int price=0;
		int sum=0;
		for(int i=0;i<js.getInt("courses.size()");i++) {
			System.out.println(js.getString("courses["+i+"].title")+"   :  "+js.getString("courses["+i+"].price"));
			price =price+js.getInt("courses["+i+"].price");
		}
		System.out.println("Total Price of all the cources to purchase is : "+ price);
		Assert.assertEquals(price, 135);
		
		for(int i=0;i<js.getInt("courses.size()");i++) {
			int copies= js.getInt("courses["+i+"].copies");
			int prices= js.getInt("courses["+i+"].price");
			sum =sum+copies*prices;
		}
		Assert.assertEquals(sum, pAmount);
		if(sum==pAmount) {
			System.out.println("Matched....");
		}
		else {
			System.out.println("Not Matched???/?");
		}
		
		

	}

}

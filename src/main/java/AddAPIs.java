import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import Files.AddJson;
public class AddAPIs {
	public static void main(String[] args) {
		RequestSpecification rs = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").build();
		ResponseSpecification rs1 = new ResponseSpecBuilder().expectStatusCode(200).build();
		String resposnse = given().spec((RequestSpecification) rs).body(AddJson.addJson()).log().all().when()
				.post("/maps/api/place/add/json").then().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		System.out.println(resposnse);
		String placeid = ReusableJPath.rawToJson(resposnse, "place_id");
		System.out.println("Place Id of the address : " + placeid);
		String add = "Sri Anjaneyam Street , IND";
		String resposnse2 = given().spec(rs)
				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"" + add + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().log().all().assertThat().spec(rs1).extract()
				.response().asString();
		System.out.println(resposnse2);
		JsonPath js1 = new JsonPath(resposnse2);
		System.out.println("The successfull message is : " + js1.getString("msg"));

		String response3 = given().spec(rs).queryParam("place_id", placeid).when()
				.get("/maps/api/place/get/json").then().log().all().spec(rs1).extract().response().asString();
		JsonPath js2 = new JsonPath(response3);
		System.out.println("the addr is: " + js2.getString("address"));
		Assert.assertEquals(add, js2.getString("address"));
	}
}
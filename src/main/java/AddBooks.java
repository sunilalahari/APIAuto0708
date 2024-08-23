import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.AddJson;

public class AddBooks {
@Test(dataProvider = "Books")
	public static void AddBook(String s1, String s2) throws IOException{
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://216.10.245.166";
		given().body(new String(Files.readAllBytes(Paths.get(null))));
		String res = given().body(AddJson.BooksJson(s1,s2)).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);		
	}

@DataProvider(name="Books")
public Object[][] getData() {
	 Object[][] on= {{"SFjjT","434"},{"SHGG77FT","4JJ34"},{"SHH9JFT","4JJ34"}};
	 return on;
}

}

import java.util.ArrayList;
import java.util.List;

import POJOs.Api;
import POJOs.Courses;
import POJOs.WebAutomation;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
public class OAuthClientCredentials {
	public static void main(String[] args) {	
		List<String> lString = new ArrayList<String>();
		String res= RestAssured.given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").when().post(" https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.asString();
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		String AT = js.getString("access_token");
		System.out.println("The Access Token is : "+AT);
		String res1 =RestAssured.given().queryParam("access_token", AT)
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.asString();
		System.out.println(res1);
		//System.out.println(j.getString("courses.api.courseTitle"));
		Courses courses =RestAssured.given().queryParam("access_token", AT)
				.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.as(Courses.class);
		List<WebAutomation> lwa= courses.getCourses().getWebAutomation();
		List<Api> apis= courses.getCourses().getApi();
		//lwa.stream().forEach(a->a.getCourseTitle());
		for(WebAutomation w: lwa) {
			System.out.println(w.getCourseTitle()+" : "+w.getPrice());
		}
		for(Api a: apis) {	
			System.out.println(a.getCourseTitle()+" : "+a.getPrice());
		}
	}

}

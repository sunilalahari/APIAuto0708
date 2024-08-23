import io.restassured.path.json.JsonPath;

public class ReusableJPath {
public static JsonPath js;
	public static String rawToJson(String response, String JsonPath) {
		js= new JsonPath(response);
		return js.getString(JsonPath);
	}
}

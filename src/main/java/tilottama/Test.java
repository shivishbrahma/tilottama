/**
 * 
 */
package tilottama;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		Type mapType = new TypeToken<Map<String, String>>() {
		}.getType();
		String jsonText = "{}";
		Map mapJson = gson.fromJson(jsonText, mapType);
	}
}

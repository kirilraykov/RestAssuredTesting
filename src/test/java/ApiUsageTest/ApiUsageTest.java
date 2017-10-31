package ApiUsageTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.xerces.dom3.as.ASObjectList;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.jsoup.select.Evaluator.ContainsData;
import org.jsoup.select.Evaluator.ContainsText;
import org.junit.Ignore;
import org.junit.Test; 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.hasItem;

public class ApiUsageTest {

	/* First test case is for asserting the status code for this laptop and
	 * then asserting that is has the certain body.
	 * It first asserts that the response will be in JSON format (given().accept).*/
	@Test
    public void canGetY700(){
    	RestAssured.given().accept(ContentType.JSON).
    	when().get("/laptops/Y700").
        then().assertThat().statusCode(200).log().status()
        .and().assertThat().body("model", IsEqual.equalTo("Y700"));

    }
    
    

	/*If we want to capture the status code or any other info
	 * we can use thenReturn
	 *If we want to validate certain information we can use then
	 *followed by assertThat()*/
    @Test
    public void canGet¿24(){
    	String body = RestAssured.given().accept(ContentType.JSON).
    	get("/laptops/A24").thenReturn().body().asString();
    	System.out.println(body);
                       
    }
   
    /*Validating all attributes on a laptop in one test*/
   @Test
    public void canGetFull24() {
    	RestAssured.get("/laptops/A24").then().
    	assertThat().statusCode(200).and().
    	assertThat().body("brand", IsEqual.equalTo("Dell"), "model", IsEqual.equalTo("A24"), "price", IsEqual.equalTo(1100));
    }
    
    
    /*Validating the nested object*/
   @Test
    public void canGetObjectFromLaptop() {
    	RestAssured.get("/laptops/A24").then().
    	assertThat().statusCode(200).and().
        body("feature", Matchers.hasEntry("hdd", "750GB")).and().
        body("feature", Matchers.hasEntry("ram", 8));
    }
    
    /*printing all the laptops as a string and logging all resources from the endpoint*/
    @Test
    public void printAllLaptops() {
    	//printing it in raw string
    	String json = RestAssured.get("/laptops").asString();
    	System.out.println(json);
    	
    	//log all resources from the JUnit test
    	RestAssured.get("http://localhost:8080/laptops").then().log().all();
    }
    
    
    
    
    
   

}
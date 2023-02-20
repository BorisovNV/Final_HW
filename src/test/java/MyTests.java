import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.containsString;

public class MyTests extends AbstractTest {
    @Test
    public void get_Data_Test() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("username110", "0918b94410").headers("X-Auth-Token", "6a6255fc67cf5ecad836e00f2be275d1");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);

    }
    @Test
    void get_First_Test(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "6a6255fc67cf5ecad836e00f2be275d1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void get_Second_Test(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "6a6255fc67cf5ecad836e00f2be275d1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?order=DESC&page=2")

                .then()
                .log().all()
                .assertThat()

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test
    void get_Third_Test(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "6a6255fc67cf5ecad836e00f2be275d1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test
    void get_Fourth_Test(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "6a6255fc67cf5ecad836e00f2be275d1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void Incorrect_Data_Test(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "6a6255fc67cf5axcd836e00f2be275d1")
                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()

                .statusCode(401)
                .statusLine("HTTP/1.1 401 Unauthorized")
                .statusLine(containsString("HTTP/1.1 401 Unauthorized"));

    }
}

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.containsString;

public class MyTests extends AbstractTest  {
    @Test
    public void getDataTest() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("username125", "0918b94410").headers("X-Auth-Token", "7f0c87f55946869603c39d30dac10dba");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);

    }
    @Test
    void getOneTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "7f0c87f55946869603c39d30dac10dba")

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
    void getTwoTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "7f0c87f55946869603c39d30dac10dba")

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
    void getThreeTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "7f0c87f55946869603c39d30dac10dba")

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
    void getFourTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "7f0c87f55946869603c39d30dac10dba")

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
    void IncorrectCredentialsTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "7f0c87f55946869603c39d30dac1d0dba")
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

package helpers;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    String login = config.login();
    String password = config.pass();


    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic("qaguru3", "PDQAwqS6GqzeNLqsj92r")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}

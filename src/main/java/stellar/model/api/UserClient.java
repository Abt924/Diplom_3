package stellar.model.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import stellar.model.pojo.*;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    public static String REGISTER_PATH = "api/auth/register";
    public static String LOGIN_PATH = "api/auth/login";
    public static String LOGOUT_PATH = "api/auth/logout";
    public static String REFRESH_TOKEN_PATH = "api/auth/token";
    public static String USER_PATH = "api/auth/user";


    @Step("api create User {user} ")
    public ValidatableResponse create(User user) {
        return given()
                .spec(spec)
                .body(user)
                .when()
                .post(REGISTER_PATH)
                .then();
    }

    @Step("api login credentials {credentials} ")
    public ValidatableResponse login(Credentials credentials) {
        return given()
                .spec(spec)
                .body(credentials)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    @Step("api logout ")
    public ValidatableResponse logout(String refreshToken) {
        String json = String.format("{ \"token\" : \"%s\" }", refreshToken);
        return given()
                .spec(spec)
                .body(json)
                .when()
                .post(LOGOUT_PATH)
                .then();
    }

    @Step("refresh token with credentials {credentials} ")
    public ValidatableResponse refreshToken(Credentials credentials) {
        return given()
                .spec(spec)
                .body(credentials)
                .when()
                .post(REFRESH_TOKEN_PATH)
                .then();
    }

    @Step("api get user by token {userCreated} ")
    public ValidatableResponse getUser(UserCreated userCreated) {
        return given()
                .spec(spec)
                .header("Authorization", userCreated.getAccessToken())
                .when()
                .get(USER_PATH)
                .then();
    }

    @Step("apo Update user {userCreated} nue {emailName}")
    public ValidatableResponse updateUser(UserCreated userCreated, EmailName emailName) {

        return given()
                .spec(spec)
                .header("Authorization", userCreated.getAccessToken())
                .body(emailName)
                .when()
                .patch(USER_PATH)
                .then();
    }


    @Step("api delete user {authorized} ")
    public ValidatableResponse delete(Authorized authorized) {
        return given()
                .spec(spec)
                .header("Authorization", authorized.getAccessToken())
                .when()
                .delete(USER_PATH)
                .then();
    }

    public UserCreated createUser(User user){
        return create(user)
                .extract()
                .body()
                .as(UserCreated.class);
    }

    public Authorized loginUser(User user) {
        return login(user.getCredentials())
                .extract()
                .body()
                .as(Authorized.class);
    }

    public SuccessMessage deleteAuthorizedUser(Authorized authorized){
        return delete(authorized)
                .extract()
                .body()
                .as(SuccessMessage.class);
    }
}

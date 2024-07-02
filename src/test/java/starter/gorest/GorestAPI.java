package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestAPI {
    public static String LIST_USERS = Constants.BASE_URL+"/public/v2/users/";
    public static String CREATE_USER = Constants.BASE_URL+"/public/v2/users";
    public static String USER_WITH_ID = Constants.BASE_URL+"/public/v2/users/{id}";
    public static String SINGLE_USER = Constants.BASE_URL+"/public/v2/users/{id}";


    @Step("Get list users")
    public void getlistUsers(){
        SerenityRest.given()
                .when()
                .get(GorestAPI.LIST_USERS);

    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single user resources")
    public void  getSingleUserResources(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update_user")
    public void putUdpateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer " + Constants.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
//    @Step("Update_user_patch")
//    public void patchUpdateUser(int id, File json){
//        SerenityRest.given()
//                .pathParam("id", id)
//                .contentType(ContentType.JSON)
//                .body(json);
//    }

    @Step("Delete a user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer " + Constants.TOKEN);
    }
}
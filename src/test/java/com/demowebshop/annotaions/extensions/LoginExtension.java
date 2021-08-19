package com.demowebshop.annotaions.extensions;

import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {

    private UserRepository userRepository = new UserRepositoryImpl();
    private Authorization authorization = new Authorization();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        User user = userRepository.getUser();
        Response response = authorization.loginViaApi(user);
        Map<String, String> cookies = response.getCookies();


/*        Map<String, String> cookies = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", user.getEmail())
                .formParam("Password",  user.getPassword())
                .when()
                .post("http://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .log().body()
                .extract().cookies();*/

        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");
        getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", cookies.get("NOPCOMMERCE.AUTH")));
    }
}

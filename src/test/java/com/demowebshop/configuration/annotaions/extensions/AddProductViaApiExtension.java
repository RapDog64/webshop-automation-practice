package com.demowebshop.configuration.annotaions.extensions;

import com.codeborne.selenide.WebDriverRunner;
import com.demowebshop.service.ProductService;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class AddProductViaApiExtension implements BeforeEachCallback {

    private ProductService productService = new ProductService();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Map<String, String> cookies = productService.addProductViaApi(1).cookies();
        open("/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");
        cookies.forEach((key, value) -> WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(key, value)));
    }
}

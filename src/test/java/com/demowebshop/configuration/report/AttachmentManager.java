package com.demowebshop.configuration.report;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.demowebshop.configuration.env.ApplicationConfigImpl.config;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AttachmentManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(AttachmentManager.class);

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static void addVideo(String sessionId) {
        final int timeToAddVideoToCI = 10;
        URL videoUrl = getVideoUrl(sessionId).orElseThrow(IllegalArgumentException::new);

        InputStream videoInputStream = null;
        sleep(1000);

        for (int i = 0; i < timeToAddVideoToCI; i++) {
            try {
                videoInputStream = videoUrl.openStream();
                break;
            } catch (FileNotFoundException e) {
                sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
    }

    private static Optional<URL> getVideoUrl(String sessionId) {
        final String videoUrl = config.videoStorage() + sessionId + ".mp4";

        try {
            return Optional.of(new URL(videoUrl));
        } catch (MalformedURLException e) {
            LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Wrong test video url, {}", videoUrl);
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

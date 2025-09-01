package com.example.project.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskUiTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:" + port + "/tasks.html");
    }

    @Test
    public void testAddTaskUiScenario() {
        WebElement taskInput = driver.findElement(By.id("taskInput"));
        WebElement addButton = driver.findElement(By.id("addButton"));

        taskInput.sendKeys("Buy groceries");
        addButton.click();

        // 🟢 Add an explicit wait here
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("taskList"), "Buy groceries"));

        WebElement taskList = driver.findElement(By.id("taskList"));
        assertTrue(taskList.getText().contains("Buy groceries"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
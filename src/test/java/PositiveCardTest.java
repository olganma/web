import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Idea Projects\\web\\driver\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestHappyPath() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=\"name\"] .input__control")).sendKeys("Маевская Ольга");
        driver.findElement(By.cssSelector("[data-test-id=\"phone\"] .input__control")).sendKeys("+79261111111");
        driver.findElement(By.cssSelector("[data-test-id=\"agreement\"]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals(expected, actual.trim());
    }

}

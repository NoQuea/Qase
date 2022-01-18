import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test
    public void login(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//input[@id='inputPassword']"))
                .setValue(password)
                .submit();
        $(By.xpath("//a[@id='createButton']")).shouldBe(Condition.visible);
    }

    @Test
    public void login2(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//input[@id='inputPassword']"))
                .setValue(password)
                .submit();
        $(By.xpath("//a[@id='createButton']")).shouldBe(Condition.visible);
    }

}

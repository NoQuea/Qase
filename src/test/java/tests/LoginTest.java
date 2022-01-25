package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login(){

        open("/login");
        $("#inputEmail").setValue(email);
        $(By.xpath("//input[@id='inputPassword']"))
                .setValue(password)
                .submit();
        $(By.xpath("//a[@id='createButton']")).shouldBe(Condition.visible);
    }

    @Test
    public void enterToShareLaneProject() {
        login();
        open("/projects");
        $(By.xpath("//a[normalize-space()='ShareLane']")).click();
        $(By.xpath("//h1[@class='style_title-319J6']")).shouldHave(Condition.text("SL repository"));
    }

    @Test
    public void addFilterTagInShareLaneProject() {
        enterToShareLaneProject();
        $(By.xpath("//button[@class='add-filter-button']")).click();
        $(By.xpath("//button[normalize-space()='Tags']")).click();
        $(By.xpath("//span[normalize-space()='Not set']")).click();
        $(By.xpath("//div[contains(@class, 'style_empty')]")).shouldBe(Condition.visible);
    }
    @Test
    public void enterInTheFieldSearchForCases(){
        enterToShareLaneProject();
        $(By.xpath("//input[@placeholder='Search for cases']")).setValue("Ввод пустого поля имени");
        $(By.xpath("//span[contains(text(),'Ввод пустого поля имени')]")).shouldHave(Condition.visible);
    }

}

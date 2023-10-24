package steps;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StarHealthHomePage {
	
	public static WebDriver driver;
	
	@Given("User open the chrome browser and starhealth application")
	public void user_open_the_chrome_browser_and_starhealth_application() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in//");
		
	}
	@Test
	@Then("validates the Star Health home page title using a JUnit assertion")
	public void validates_the_star_health_home_page_title_using_a_j_unit_assertion() {
	    
		String expected = driver.getTitle();
		String actual = "Star Health Insurance: Medical, Accident and Travel insurance policies";
		Assertions.assertEquals(expected, actual,"The title is different");
	}

	@Then("clicks on the Buy Now button")
	public void clicks_on_the_buy_now_button() {

		driver.findElement(By.xpath("((//div[@class='primaryButton_primary__lQkYH '])[1])/descendant::span")).click();
	}

	@Then("User enters following details")
	public void user_enters_following_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> userList = dataTable.asLists(String.class);
		
		for(List<String> e : userList)
		{
			driver.findElement(By.xpath("//input[@id='name']")).clear();
			driver.findElement(By.xpath("//input[@id='name']"))
			.sendKeys(e.get(0));
			driver.findElement(By.xpath("//input[@id='contact_no']")).clear();
			driver.findElement(By.xpath("//input[@id='contact_no']"))
			.sendKeys(e.get(1));
			driver.findElement(By.xpath("//input[@id='pinCode']")).clear();
			driver.findElement(By.xpath("//input[@id='pinCode']"))
			.sendKeys(e.get(2));
		
		}
	}

	@Then("User clicks on the Star Health logo")
	public void user_clicks_on_the_star_health_logo() {
		driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-regular MuiToolbar-gutters']/descendant::a")).click();
	}

	@Then("Close all the browsers")
	public void close_all_the_browsers() {
	    driver.close();
	}

}

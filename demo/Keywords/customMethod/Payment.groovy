package customMethod

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.lowagie.text.ListItem

import internal.GlobalVariable
import java.text.SimpleDateFormat
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByXPath
import org.testng.Assert

public class Payment {
	private WebDriver driver
	@Keyword
	def payment() {
		driver = DriverFactory.getWebDriver()
		int index = 2

		String name = driver.findElement(By.xpath(objNameProduct(index))).getText()

		//click nút checkboxx
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div["+index+"]//input[@type='checkbox']")).click()

		//nút xác nhận giỏ hàng
		driver.findElement(By.xpath("//button[contains(text(),'XÁC NHẬN GIỎ HÀNG')]")).click()

		//set info
		WebUI.setText(findTestObject('Object Repository/Object_Store/Payment/input_address'), "cao đẳng công thương tphcm")
		WebUI.setText(findTestObject('Object Repository/Object_Store/Payment/input_city'), "tphcm")
		WebUI.setText(findTestObject('Object Repository/Object_Store/Payment/input_country'), "vietname")
		WebUI.setText(findTestObject('Object Repository/Object_Store/Payment/input_phone'), "0123456789")


		//lấy thời gian hiện tại
		String currentTime = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(new Date())
		System.out.println("currenttime" + currentTime)
		driver.findElement(By.xpath("//button[normalize-space()='THANH TOÁN']")).click()


		List<WebElement> listItem = driver.findElements(By.xpath("//table//tr"))
		//		Sytem.out.print(listItem.size())
		System.out.println(listItem.size())
		Assert.assertTrue(checkValueItem(listItem, driver, currentTime), "chưa thanh toán")


	}
	public Boolean checkValueItem(List<WebElement> listItem, WebDriver driver, String currentTime) {
		for(int i = 2; i <= listItem.size(); i++) {
			String time = driver.findElement(By.xpath("//table//tr["+i+"]//td[2]")).getText() //tr là hàng, td là cột (cột thứ 2)
			System.out.println("item" + i + " " + time)
			if(time == currentTime) { //nếu thời gian = nhau -> đã order
				return true
			}
		}
		return false
	}

	public String objNameProduct(int i) {
		return "//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div["+i+"]//h2"
	}
}

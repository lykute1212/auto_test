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

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByXPath
import org.testng.Assert

import internal.GlobalVariable

public class Search_Store {
	@Keyword
	def searchProduct() {
		WebDriver driver
		driver = DriverFactory.getWebDriver()

		List<WebElement> listItem = driver.findElements(By.xpath("//div[@class='product--control']//div[@class='row']/div"))// tất cả element lưu vào list

		listItem.size()// trả về số item của list
		System.out.println(listItem.size())
		System.out.println(listItem)

		for(int i = 1; i <= listItem.size(); i++) {
			String textitem = driver.findElement(By.xpath("//div[@class='product--control']//div[@class='row']/div["+i+"]")).getText()// lấy giá trị text của Element tương ứng
			System.out.println(textitem)

			Assert.assertTrue(textitem.contains("Quần"))
		}
	}
}

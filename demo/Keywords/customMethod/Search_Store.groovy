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

import internal.GlobalVariable

public class Search_Store {
	@Keyword
	def searchProduct() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebDriver>lisItem = driver.findElements(By.xpath("//(//a[contains(text(),'Quần')])"))

		listItem.size()

		System.out.println(listItem.size())
		System.out.println(listItem)

		for(int i=0; i<listItem.size(); i++)
			String textTittle = driver.findElement(By.xpath("////div[@class='header__search--find']//li[+i+]")).getText()

		System.out.println(textTittle)

		//div[@class='header__search--find']//li[1]
	}
}

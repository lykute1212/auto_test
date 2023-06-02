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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords



import internal.GlobalVariable

public class Sign_Store {
	@Keyword
	def Sign_in(String username, String password, String email) {
		WebUI.maximizeWindow()

		WebUI.navigateToUrl('http://localhost:3000/account/register')
		WebUI.setText(findTestObject('Object Repository/Object_Store/Sign_Store/input_Usename'), username)
		WebUI.setText(findTestObject('Object Repository/Object_Store/Sign_Store/input_Email'), email)
		WebUI.setText(findTestObject('Object Repository/Object_Store/Sign_Store/input_Password'), password)
		WebUI.click(findTestObject('Object Repository/Object_Store/Sign_Store/btn_Sign'))
		WebUI.verifyElementText(findTestObject('Object Repository/Object_Store/Sign_Store/toat_notify'), 'Đăng nhập thành công!')
		
	}
}

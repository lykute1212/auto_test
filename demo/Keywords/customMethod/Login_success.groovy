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

import internal.GlobalVariable

public class Login_success {

	@Keyword
	def login_success(String email, String password) {
		WebUI.navigateToUrl('http://localhost:3000/account/login')
		WebUI.setText(findTestObject('Object Repository/Object_Store/Login_Store/input_Email'), email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Object_Store/Login_Store/input_Pass'), password)
		WebUI.click(findTestObject('Object Repository/Object_Store/Login_Store/btn_Login'))
		WebUI.verifyElementText(findTestObject('Object_Store/Login_Store/toast_login_success'), 'Đăng nhập thành công!')
		WebUI.verifyEqual('Đăng nhập thành công!', 'Đăng nhập thành công!')
	}
}

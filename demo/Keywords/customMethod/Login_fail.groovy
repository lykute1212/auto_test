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

public class Login_fail {

	public void setData(String email, String password) {
		WebUI.setText(findTestObject('Object Repository/Object_Store/Login_Store/input_Email'), email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Object_Store/Login_Store/input_Pass'), password)
		WebUI.click(findTestObject('Object Repository/Object_Store/Login_Store/btn_Login'))
		WebUI.verifyElementText(findTestObject('Object_Store/Login_Store/toast_login_fail'), 'Đăng nhập thất bại!')
		WebUI.verifyEqual('Đăng nhập thất bại!', 'Đăng nhập thất bại!')
	}

	@Keyword
	def login_fail() {
		WebUI.navigateToUrl('http://localhost:3000/account/login')

		for (int i=0; i<7; i++) {
			switch(i) {
				case 0: // email, pass rỗng
					setData('', '')
					break;
				case 1: // sai email, pass đúng
					setData('lynguyen@gmail.com', 'CsLd+UgOPNDsDgaY0dzFog==')
					break;
				case 2: // sai email, pass sai
					setData('lynguyen@gmail.com', 'aeHFOx8jV/A=')
					break;
				case 3: // đúng email, pass sai
					setData('lynguyen62471105@gmail.com', 'aeHFOx8jV/A=')
					break;
				case 4: // email nhập giá trị đúng , pass rỗng
					setData('tester@gmail.com', '')
					break;
				case 5: // email rỗng, pass nhập giá trị đúng
					setData('', 'CsLd+UgOPNDsDgaY0dzFog==')
					break;
				case 6: // email, pass của 1 tài khoản không tồn tại
					setData('tester123@gmail.com', 'aeHFOx8jV/A=')
					break;
				default:
					break;
			}
		}
	}
}

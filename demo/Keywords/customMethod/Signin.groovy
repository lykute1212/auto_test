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

public class Signin {
	public void setData(String username, String email, String password) {
		WebUI.setText(findTestObject('Object_Store/Sign_Store/input_Username'), username)
		WebUI.setText(findTestObject('Object_Store/Sign_Store/input_Email'), email)
		WebUI.setEncryptedText(findTestObject('Object_Store/Sign_Store/input_Password'), password)
		WebUI.click(findTestObject('Object_Store/Sign_Store/btn_Sign'))
		WebUI.verifyElementText(findTestObject('Object_Store/Sign_Store/toast'), 'error')
		WebUI.verifyEqual('error', 'error')
		//WebUI.verifyTextPresent('Đăng nhập thành công!', false)
		//		WebUI.verifyEqual('error', 'error')
	}
	@Keyword
	def sign_fail() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('http://localhost:3000/account/register')

		for (int i=0; i<6; i++) {
			switch(i) {

				case 0: // username, email, pass rỗng
					setData('', '','')
					break;
				case 1: // username rỗng, email không đúng định dạng, pass có 1 ký tự  (1)
					setData('tester123', 'lynguyen', 'HeCM15nHKBI=')
					break;
				case 2: // username nhập giá trị, email không đúng định dạng, pass nhập đủ ký tự (>5) 12345678
					setData('tester123', 'lynguyengmail.com', 'RigbBhfdqODKcAsiUrg+1Q==')
					break;
				case 3: // username nhập giá trị, email nhập giá trị đúng, pass có chữ cái a123456
					setData('tester123','lynguyen62471105@gmail.com', 'ZUgKSRs8gNk=')
					break;
				case 4: // username nhập giá trị vô hạn, email nhập giá trị đúng , pass rỗng
					setData('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','testergmail.com', '')
					break;
				case 5: // email, pass của 1 tài khoản đã tồn tại
					setData('tester123','lynguyen62471105@gmail.com', 'CsLd+UgOPNDsDgaY0dzFog==')
					break;

				default:
					break;
			}
		}
	}
}

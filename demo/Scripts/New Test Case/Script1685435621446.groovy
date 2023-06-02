import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:3000/account/login')

WebUI.setText(findTestObject('Object Repository/New Folder/Page_Fashion Store/input_Email_email'), 'tester@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/New Folder/Page_Fashion Store/input_Mt khu_password'), 'nwr9I1qT+J0GbQ++JlYjHw==')

WebUI.click(findTestObject('Object Repository/New Folder/Page_Fashion Store/button_ng nhp'))

WebUI.verifyElementText(findTestObject('New Folder/Page_Fashion Store/a_Thng tin ti khon'), 'tester')

WebUI.getText(findTestObject('New Folder/Page_Fashion Store/a_Thng tin ti khon', [('variable') : 'a']))

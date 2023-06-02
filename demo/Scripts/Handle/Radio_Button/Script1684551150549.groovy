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

WebUI.navigateToUrl('http://demo.seleniumeasy.com/basic-radiobutton-demo.html')

WebUI.click(findTestObject('Object Repository/Object handle/Radio buttons/input_Male_optradio'))

WebUI.verifyElementChecked(findTestObject('Object handle/Radio buttons/input_Male_optradio'), 
    0)

WebUI.verifyElementNotChecked(findTestObject('Object handle/Radio buttons/input_Radio Female'), 
    5)

WebUI.click(findTestObject('Object Repository/Object handle/Radio buttons/button_Get Checked value'))

WebUI.verifyElementText(findTestObject('Object Repository/Object handle/Radio buttons/p_Radio button Female is checked'), 
    'Radio button \'Male\' is checked')

WebUI.scrollToElement(findTestObject('Object handle/Radio buttons/button_getvalue'), 
    10)

WebUI.delay(2)

WebUI.closeBrowser()


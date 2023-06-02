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

WebUI.navigateToUrl('https://qavbox.github.io/demo/alerts/')

WebUI.verifyElementText(findTestObject('Object handle/Page_Alerts/p_You pressed Cancel'), '')

WebUI.click(findTestObject('Object Repository/Object handle/Page_Alerts/input_Different Types of ALERTS_confirm'))

WebUI.acceptAlert()

WebUI.verifyElementText(findTestObject('Object handle/Page_Alerts/p_You pressed Cancel'), 'You pressed OK!')

WebUI.delay(2)

WebUI.click(findTestObject('Object handle/Page_Alerts/input_Different Types of ALERTS_confirm'))

WebUI.dismissAlert()

WebUI.verifyElementText(findTestObject('Object handle/Page_Alerts/p_You pressed Cancel'), 'You pressed Cancel!')

WebUI.delay(1)

WebUI.click(findTestObject('Object handle/Page_Alerts/button_PromptMe'))

WebUI.delay(1)

WebUI.setAlertText('Demo')

WebUI.delay(1)

WebUI.acceptAlert()

WebUI.verifyElementText(findTestObject('Object handle/Page_Alerts/p_You pressed Cancel'), 'Hello Demo! How are you today?')

WebUI.closeBrowser()


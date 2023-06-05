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

WebUI.navigateToUrl('https://rise.fairsketch.com/signin')

WebUI.click(findTestObject('Object Repository/Cilent/div_Admin            admindemo.com         _52fc9c'))

WebUI.click(findTestObject('Object Repository/Cilent/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Cilent/a_Clients'))

WebUI.click(findTestObject('Object Repository/Cilent/a_Add client'))

WebUI.setText(findTestObject('Object Repository/Cilent/input_Company name_company_name'), 'ptz')

WebUI.click(findTestObject('Cilent/dropdown_addclient'))

WebUI.setText(findTestObject('Object Repository/Cilent/textarea_Address_address'), dripstion)

WebUI.setText(findTestObject('Object Repository/Cilent/input_City_city'), 'hanoi')

WebUI.setText(findTestObject('Object Repository/Cilent/input_State_state'), 'binhdinh')

WebUI.setText(findTestObject('Object Repository/Cilent/input_Zip_zip'), '77')

WebUI.setText(findTestObject('Object Repository/Cilent/input_Country_country'), 'vietnam')

WebUI.setText(findTestObject('Object Repository/Cilent/input_Phone_phone'), '022723848484')

WebUI.setText(findTestObject('Object Repository/Cilent/input_Website_website'), 'a')

WebUI.setText(findTestObject('Object Repository/Cilent/input_VAT Number_vat_number'), '0292')

WebUI.setText(findTestObject('Object Repository/Cilent/input_GST Number_gst_number'), '12')

WebUI.click(findTestObject('Object Repository/Cilent/input_Client groups_s2id_autogen2'))

WebUI.click(findTestObject('Object Repository/Cilent/div_Gold'))

WebUI.click(findTestObject('Object Repository/Cilent/div_ARS   Currency'))

WebUI.setText(findTestObject('Object Repository/Cilent/input_Currency Symbol_currency_symbol'), 'a')

WebUI.click(findTestObject('Object Repository/Cilent/button_Save'))


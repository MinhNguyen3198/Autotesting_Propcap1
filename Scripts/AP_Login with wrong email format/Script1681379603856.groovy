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

WebUI.navigateToUrl('https://admin-portal-dev.propcaptechnologieshk.com/login')

WebUI.setText(findTestObject('Page_PropCap/input_Login_login_email_inAP'), email)

WebUI.verifyElementText(findTestObject('Page_PropCap/div_Please provide valid email_inAP'), 'Please provide valid email')

// Verify Color of 'Please correct the email format' text
ColorOfText = WebUI.getCSSValue(findTestObject('Page_PropCap/div_Please provide valid email_inAP'), 'color')

println(ColorOfText)

ExpectedColorOfText = 'rgba(255, 77, 79, 1)'

WebUI.verifyEqual(ColorOfText, ExpectedColorOfText)

//Verify color of Email Textbox's border
ColorOfBorder = WebUI.getCSSValue(findTestObject('Object Repository/Page_PropCap/span_TextboxEmail_inAP'), 
    'border-color')

println(ColorOfBorder)

ExpectedColorOfBorder = 'rgb(255, 120, 117)'

WebUI.verifyEqual(ColorOfBorder, ExpectedColorOfBorder)

WebUI.setText(findTestObject('Page_PropCap/input_Login_login_password_inAP'), password)

WebUI.click(findTestObject('Object Repository/Page_PropCap/button_Login'))

WebUI.delay(5)

ActualUrl = 'https://admin-portal-dev.propcaptechnologieshk.com/login'

ExpectedUrl = WebUI.getUrl()

WebUI.verifyEqual(ActualUrl, ExpectedUrl)

WebUI.closeBrowser()


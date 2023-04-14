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

WebUI.setText(findTestObject('Object Repository/Page_PropCap/input_Login_login_email_inAP'), 'minh.nguyen2@bnksolution.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PropCap/input_Login_login_password_inAP'), 'C/Qzn8ORT1P96Z4jkVNA+g==')

WebUI.click(findTestObject('Object Repository/Page_PropCap/span_Login_inAP'))

WebUI.executeJavaScript('window.open();', [])

currentWindow = WebUI.getWindowIndex()

//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)

WebUI.navigateToUrl('https://outlook.office.com/')

WebUI.setText(findTestObject('Object Repository/Page_Sign in to your Microsoft account/input_Sign in_loginfmt'), 'minh.nguyen2@bnksolution.com')

WebUI.click(findTestObject('Object Repository/Page_Sign in to your Microsoft account/input_Create one_idSIButton9'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign in to Outlook/input_Enter password_passwd'), 'QSYkr2ffJu+rozihREsVxQ==')

WebUI.click(findTestObject('Object Repository/Page_Sign in to Outlook/input_Forgot my password_idSIButton9'))

WebUI.click(findTestObject('Page_Sign in to Outlook/input_concat(Don, , t show this again)_idSIButton9'))

WebUI.click(findTestObject('Page_Mail - Minh Nguyn (BU6.TEST) - Outlook/OTPmail'))

OTP = WebUI.getText(findTestObject('Page_Mail - Minh Nguyn (BU6.TEST) - Outlook/b_PHAZUI7E'))

WebUI.switchToWindowTitle('PropCap')

WebUI.setText(findTestObject('Object Repository/Page_PropCap/input_OTP Expires in Minutes_otp_inAP'), OTP)

WebUI.click(findTestObject('Object Repository/Page_PropCap/span_Submit_inAP'))

WebUI.delay(5)

ActualUrl = 'https://admin-portal-dev.propcaptechnologieshk.com/'

ExpectedUrl = WebUI.getUrl()

WebUI.verifyEqual(ActualUrl, ExpectedUrl)

ColorOfDashboardsection = WebUI.getCSSValue(findTestObject('Page_PropCap/li_Dashboard_inAP'), 'background-color')

ExpectedColorOfDashboardsection='rgba(16, 98, 173, 1)'

WebUI.verifyEqual(ColorOfDashboardsection, ExpectedColorOfDashboardsection)

ColorOfDashboardtext = WebUI.getCSSValue(findTestObject('Object Repository/Page_PropCap/span_Dashboard_AP'), 'color')

ExpectedColorOfDashboardtext= 'rgba(255, 255, 255, 1)'

WebUI.verifyEqual(ColorOfDashboardsection, ExpectedColorOfDashboardsection)

WebUI.closeBrowser()


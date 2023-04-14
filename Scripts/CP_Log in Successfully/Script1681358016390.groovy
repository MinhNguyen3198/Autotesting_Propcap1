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

WebUI.navigateToUrl('https://client-portal-dev.propcaptechnologieshk.com/')

WebUI.setText(findTestObject('Object Repository/Page_PropCap/input_Email_email'), email)

WebUI.setText(findTestObject('Object Repository/Page_PropCap/input_Password_password'), password)

WebUI.click(findTestObject('Object Repository/Page_PropCap/button_Login'))

WebUI.executeJavaScript('window.open();', [])

currentWindow = WebUI.getWindowIndex()

//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)

WebUI.navigateToUrl('https://www.yopmail.com')

WebUI.setText(findTestObject('Object Repository/Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'), 
    email)

WebUI.sendKeys(findTestObject('Object Repository/Page_YOPmail - Disposable Email Address - A_32619f/input_Type the Email name of your choice_login'), 
    Keys.chord(Keys.ENTER))

OTP = WebUI.getText(findTestObject('Page_Inbox/b_iLfzibSQ'))

WebUI.switchToWindowTitle('PropCap')

WebUI.sendKeys(findTestObject('Object Repository/Page_PropCap/input_OTP Expires in Minutes_otp'), OTP)

WebUI.click(findTestObject('Object Repository/Page_PropCap/span_Submit'))

WebUI.verifyTextPresent('You have been verified successfully', false)

WebUI.delay(5)

ActualUrl = 'https://client-portal-dev.propcaptechnologieshk.com/dashboard'

ExpectedUrl = WebUI.getUrl()

WebUI.verifyEqual(ActualUrl, ExpectedUrl)

WebUI.verifyTextPresent('You are successfully logged in', false)

WebUI.closeBrowser()


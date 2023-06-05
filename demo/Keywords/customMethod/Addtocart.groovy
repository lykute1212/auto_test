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
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByXPath
import org.testng.Assert

public class Addtocart {
	private WebDriver driver

	@Keyword
	def cart() {
		addToCart()
		//		removeToCard()
	}
	@Keyword
	def addToCart() {

		addItem(1)
	}


	//kiểm tra sản phẩm đã được thêm vô giỏ hàng hay chưa?
	public Boolean checkValueItem(List<WebElement> listItem, WebDriver driver, String text, int page) {
		for(int i = 2; i <= listItem.size(); i++) {
			String item = driver.findElement(By.xpath(objNameProduct(i))).getText() //lấy tên của từng item (thẻ h2)
			System.out.println("name trong giỏ hàng: " +item)

			if(item == text) { //text (là tên sản phẩm trước khi thêm/xóa vào giỏ hàng) so sánh tuyệt đối
				System.out.println("name trong giỏ hàng: " +item)
				//				String sum = driver.findElement("//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div[2]//input[@type = 'text']").getText()
				//				System.out.println("so luong: " +sum)
				return true
			}
		}
		return false
	}
	public String objNameProduct(int i) {
		return "//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div["+i+"]//h2"
	}
	public String objSumProduct(int i) {
		return "//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div["+i+"]//input"
	}
	public String objAllProduct() {
		return "//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div"
	}



	public addItem(int n) {
		driver = DriverFactory.getWebDriver()

		for(int i = 1; i <= n; i++) {

			WebUI.click(findTestObject('Object Repository/Object_Store/Add to cart/div_home__product-item-img')) //bấm vào item để vào trang chi tiết product

			String text = driver.findElement(By.xpath("//span[@class='product-info__name--item']")).getText() // lưu tên product mà mình muốn thêm vào giỏ hàng
			System.out.println(text)


			WebUI.click(findTestObject('Object Repository/Object_Store/Add to cart/input')) //set text số lượng

			WebUI.click(findTestObject('Object Repository/Object_Store/Add to cart/btn_add to cart')) //thêm giỏ hàng


			List<WebElement> listItem = driver.findElements(By.xpath("//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div"))
			Assert.assertTrue(checkValueItem(listItem, driver, text, i), "chưa thêm vào giỏ hàng")

			//			WebUI.click(findTestObject('Object Repository/Object_Store/Add to cart/btn_home'))

			System.out.println(listItem.size())
		}
	}


	@Keyword
	def removeToCard() {
		WebUI.navigateToUrl('http://localhost:3000/mycard')
		driver = DriverFactory.getWebDriver()
		int index = 2

		String name = driver.findElement(By.xpath(objNameProduct(index))).getText() //lưu lại tên product trước khi bạn muốn xóa khỏi giỏ hàng


		//click xóa khỏi giỏ hàng
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='app__container']/div[@class='grid wide']/div[@class='row sm-gutter app__content']/div[@class='my--card']/div[@class='col l-8']/div[@class='cart--wrap--info']/div["+index+"]//i")).click()



		// "!" phủ định ngược lại của giá trị boolean
		Assert.assertTrue(!checkValueItem(driver.findElements(By.xpath(objAllProduct())), driver, name), "chưa xóa khỏi giỏ hàng")

		WebUI.delay(2)
	}
}

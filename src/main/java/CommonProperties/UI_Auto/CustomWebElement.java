package CommonProperties.UI_Auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CustomWebElement {
	private WebDriver webDriver;

	public CustomWebElement(WebDriver webDriver) {
		this.webDriver = webDriver;

		// Call the page factory on this object to initialize custom webelements in
		// custom webelements (aka nesting)
		try {
			PageFactory.initElements(webDriver, this);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

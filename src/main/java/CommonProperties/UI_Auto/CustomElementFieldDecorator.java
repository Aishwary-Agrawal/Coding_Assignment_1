package CommonProperties.UI_Auto;

import org.openqa.selenium.WebDriver;

public class CustomElementFieldDecorator {

	private final WebDriver webDriver;

	/**
	 * The constructor. It constructs.
	 *
	 * @param webDriver     The webDriver which will be used to create the
	 *                      webelement.
	 **/
	public CustomElementFieldDecorator(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
}

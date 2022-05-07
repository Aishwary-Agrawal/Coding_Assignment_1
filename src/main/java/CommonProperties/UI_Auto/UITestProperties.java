package CommonProperties.UI_Auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UITestProperties {

	private final static Properties prop = new Properties();

	static {
		loadProperties();
	}

	public static String getWikipediaUrl() {
		return prop.getProperty("wikipedia.portal.base.url");
	}
	
	public static String getImdbUrl() {
		return prop.getProperty("imdb.portal.base.url");
	}

	private static void loadProperties() {
		InputStream input = null;
		try {
			String filepath = "../UI_Auto/UiTest.properties";
			File file = new File(filepath);
			input = new FileInputStream(file);

			// load a properties file
			prop.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

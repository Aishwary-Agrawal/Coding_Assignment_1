package CommonProperties.UI_Auto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {
	
	public static LocalDate parseCustomDates(String inputDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(inputDate, formatter);
		return date;
	}

}

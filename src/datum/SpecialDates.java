package datum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SpecialDates {
	private Map<String, String> specialDates;

	public SpecialDates() {
		// Ünnepek definálása
		specialDates = new HashMap<>();
		specialDates.put("2023-10-22", "Forradalom56");
		specialDates.put("2023-10-23", "Forradalom56");
		specialDates.put("2023-10-24", "Forradalom56");

		specialDates.put("2023-12-22", "Karacsony");
		specialDates.put("2023-12-23", "Karacsony");
		specialDates.put("2023-12-24", "Karacsony");
		specialDates.put("2023-12-25", "Karacsony");
		specialDates.put("2023-12-26", "Karacsony");
		specialDates.put("2023-12-27", "Karacsony");

		specialDates.put("2023-12-27", "Szilveszter");
		specialDates.put("2023-12-28", "Szilveszter");
		specialDates.put("2023-12-29", "Szilveszter");
		specialDates.put("2023-12-30", "Szilveszter");
		specialDates.put("2023-12-31", "Szilveszter");
		specialDates.put("2024-01-01", "Szilveszter");
		specialDates.put("2024-01-02", "Szilveszter");

		specialDates.put("2024-03-08", "Nonap");

		specialDates.put("2024-03-14", "Forradalom48");
		specialDates.put("2024-03-15", "Forradalom48");
		specialDates.put("2024-03-16", "Forradalom48");

		specialDates.put("2024-03-28", "Husvethetfo");
		specialDates.put("2024-03-29", "Husvethetfo");
		specialDates.put("2024-03-30", "Husvethetfo");
		specialDates.put("2024-03-31", "Husvethetfo");
		specialDates.put("2024-04-01", "Husvethetfo");
		specialDates.put("2024-04-02", "Husvethetfo");
		specialDates.put("2024-04-03", "Husvethetfo");

		specialDates.put("2024-08-16", "Allamalapitas");
		specialDates.put("2024-08-17", "Allamalapitas");
		specialDates.put("2024-08-18", "Allamalapitas");
		specialDates.put("2024-08-19", "Allamalapitas");
		specialDates.put("2024-08-20", "Allamalapitas");
		specialDates.put("2024-08-21", "Allamalapitas");
	}

	// Nem ünnepnapok
	public String getDate(String dateString) {
		String holiday = specialDates.get(dateString);
		String season = "";

		if (holiday != null) {
			return holiday;
		} else {
			if (isWinterMonth(dateString)) {
				season = "Tel";
			} else if (isSpringMonth(dateString)) {
				season = "Tavasz";
			} else if (isSummerMonth(dateString)) {
				season = "Nyar";
			} else if (isAutumnMonth(dateString)) {
				season = "Osz";
			}
			return season;
		}
	}

	// Évszakok szétválasztva az első kötőjel után
	private boolean isWinterMonth(String dateString) {
		int month = Integer.parseInt(dateString.split("-")[1]);
		return (month == 12 || month == 1 || month == 2);
	}

	private boolean isSpringMonth(String dateString) {
		int month = Integer.parseInt(dateString.split("-")[1]);
		return (month >= 3 && month <= 5);
	}

	private boolean isSummerMonth(String dateString) {
		int month = Integer.parseInt(dateString.split("-")[1]);
		return (month >= 6 && month <= 8);
	}

	private boolean isAutumnMonth(String dateString) {
		int month = Integer.parseInt(dateString.split("-")[1]);
		return (month >= 9 && month <= 11);
	}

	// Jelenlegi datum + unnep/evszak
	public static void main(String[] args) {
		SpecialDates specialDates = new SpecialDates();

		// Jelenlegi datum
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateOnlyFormat.format(calendar.getTime());
		// Jovobeni datum (napok szamat adja hozza)
		calendar.add(Calendar.DATE, 39);
		String futureDate = dateOnlyFormat.format(calendar.getTime());

		String resultCurrentDate = specialDates.getDate(currentDate);
		String resultFutureDate = specialDates.getDate(futureDate);

		System.out.println(currentDate + ": " + resultCurrentDate);
		System.out.println("Dátum x nap múlva: " + futureDate + ": " + resultFutureDate);

	}
}

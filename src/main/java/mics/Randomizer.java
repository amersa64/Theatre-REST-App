package mics;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Random;

public class Randomizer {

	public static LocalTime randomTime(){
		int minute = (int) Math.floor(Math.random()*4)*15;
		int hour = (int) Math.floor(Math.random()*24);
		return LocalTime.of(hour++, minute++);
	}

	public static LocalDate randomDate(){
//		int month =(int) Math.floor(Math.random()*12);
//		int day = (int) Math.floor(Math.random()*30);
//		return LocalDate.of(2017,++month,++day);
		Random  rnd;
		LocalDate    dt;
		long    ms;

		// Get a new random instance, seeded from the clock
		rnd = new Random();

		// Get an Epoch value roughly between 1940 and 2010
		// -946771200000L = January 1, 1940
		// Add up to 70 years to it (using modulus on the next long)
		ms = -946771200000L + (Math.abs(rnd.nextLong()) % (78L * 365 * 24 * 60 * 60 * 1000));

		// Construct a date
		dt = Instant.ofEpochMilli(ms).atZone(ZoneId.systemDefault()).toLocalDate();
		return dt;
	}

}

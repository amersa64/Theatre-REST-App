package mics;

import java.time.LocalDate;
import java.time.LocalTime;

public class Randomizer {

	public static LocalTime randomTime(){
		int minute = (int) Math.floor(Math.random()*4)*15;
		int hour = (int) Math.floor(Math.random()*24);
		return LocalTime.of(hour++, minute++);
	}

	public static LocalDate randomDate(){
		int month =(int) Math.floor(Math.random()*12);
		int day = (int) Math.floor(Math.random()*30);
		return LocalDate.of(2017,++month,++day);
	}

}

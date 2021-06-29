package bank.CustomerMS.validation;

import java.time.LocalTime;

import bank.CustomerMS.entity.CustomerHistory;

public class UserValidator {
	
	public static void validateUserLogTime(CustomerHistory history) {
		Integer time;
		LocalTime now=LocalTime.now();
		time=history.getLoginTime().getSecond()-now.getSecond();
		System.out.println(time);
	}

}

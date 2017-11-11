package edu.rporeba.bookstore.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class DateSource {

	Calendar calendar = Calendar.getInstance();

	int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

	int val = 6;

}

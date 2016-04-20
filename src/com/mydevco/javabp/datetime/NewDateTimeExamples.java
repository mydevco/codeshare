package com.mydevco.javabp.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewDateTimeExamples {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter1 = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM);
		
		DateTimeFormatter formatter2 = DateTimeFormatter
                .ofPattern("MM-dd-yyyy HH:mm:ss");
		
		Instant start = Instant.now();
        System.out.println(Duration.between(start, start.plusMillis(1000)).toMillis());
        LocalDate today = LocalDate.now();
        System.out.println(today.get(ChronoField.DAY_OF_WEEK));
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(today.get(ChronoField.DAY_OF_WEEK));
        LocalDate longBack = today.minus(2, ChronoUnit.DECADES);
        Period period = Period.between(today, longBack);
		System.out.println("Period between today and longback is " + period.getYears() + " years" + period.getMonths() + " months" + period.getDays() + " days");
        LocalDate july4th = LocalDate.of(2016, Month.JULY, 4);
        
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        
        System.out.println(formatter1.format(nowLocalDateTime));
        LocalDateTime sameTimeNextWeek = nowLocalDateTime.plusWeeks(1);
        System.out.println(formatter2.format(sameTimeNextWeek));
        
        ZoneId.getAvailableZoneIds().stream().sorted()
        .forEach(System.out::println);
        
        ZonedDateTime nyTime = ZonedDateTime.of(nowLocalDateTime,
                ZoneId.of("US/Eastern"));
        
        ZonedDateTime parisTime = ZonedDateTime.of(nowLocalDateTime,
                ZoneId.of("Europe/Paris"));
        
        Duration duration = Duration.between(nyTime, parisTime);
        System.out.printf("There are %d hours and %d minutes.%n",
                duration.toHours(),
                duration.toMinutes() % 60);
        
      
        
	}

}

package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {
  // private static final Integer MONTH_OF_LABOR_DAY = 5;
  private static final Integer DAY_OF_LABOR_DAY = 1;

  public static long getDaysBetweenNextLaborDay(LocalDate date) {
    LocalDate nextLaborDay;
    if (isBeforeLaborDayOfThisYear(date)) {
      nextLaborDay = LocalDate.of(date.getYear(), Month.MAY, DAY_OF_LABOR_DAY);
    } else {
      nextLaborDay = LocalDate.of(date.getYear() + 1, Month.MAY, DAY_OF_LABOR_DAY);
    }

    // Period period = Period.between(date, nextLaborDay);
    return ChronoUnit.DAYS.between(date, nextLaborDay);
  }

  private static boolean isBeforeLaborDayOfThisYear(LocalDate date) {
    return date.getMonthValue() < 5;
  }
}

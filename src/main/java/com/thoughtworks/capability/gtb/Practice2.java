package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    LocalDate nextWorkDate;
    switch (dayOfWeek) {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:
      case SUNDAY:
      default:
        nextWorkDate = date.plusDays(1);
        break;
      case FRIDAY:
        nextWorkDate = date.plusDays(3);
        break;
      case SATURDAY:
        nextWorkDate = date.plusDays(2);
        break;
    }
    return nextWorkDate;
  }
}

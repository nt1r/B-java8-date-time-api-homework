package com.thoughtworks.capability.gtb;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class MeetingSystemV3 {
  private static final String timePattern = "yyyy-MM-dd HH:mm:ss";
  private static final DateTimeFormatter londonFormatter = DateTimeFormatter.ofPattern(timePattern).withZone(ZoneId.of("Europe/London"));
  private static final DateTimeFormatter chinaFormatter = DateTimeFormatter.ofPattern(timePattern).withZone(ZoneId.of("Asia/Shanghai"));
  private static final DateTimeFormatter chicagoFormatter = DateTimeFormatter.ofPattern(timePattern).withZone(ZoneId.of("America/Chicago"));

  public static void main(String[] args) {
    String timeStr = "2020-04-01 14:30:00";
    arrangeMeetingTime(timeStr);
  }

  private static void arrangeMeetingTime(String timeStr) {
    ZonedDateTime meetingTime = ZonedDateTime.parse(timeStr, londonFormatter);
    ZonedDateTime now = ZonedDateTime.now();
    // System.out.println(now.getZone());

    if (now.isAfter(meetingTime)) {
      meetingTime = getTomorrowMeetingTime(meetingTime, now);
      printFormattedTime(meetingTime, chicagoFormatter);
    }
  }

  private static ZonedDateTime getTomorrowMeetingTime(ZonedDateTime meetingTime, ZonedDateTime now) {
    ZonedDateTime tomorrow = now.plus(Period.ofDays(1));
    int newDayOfYear = tomorrow.getDayOfYear();
    return meetingTime.withDayOfYear(newDayOfYear);
  }

  private static void printFormattedTime(ZonedDateTime meetingTime, DateTimeFormatter dateTimeFormatter) {
    String showTimeStr = dateTimeFormatter.format(meetingTime);
    System.out.println(showTimeStr);
  }
}

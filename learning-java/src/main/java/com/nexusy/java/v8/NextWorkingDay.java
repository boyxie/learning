package com.nexusy.java.v8;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @author lan
 * @since 2016-10-19
 */
public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (dow == DayOfWeek.FRIDAY) {
            temporal = temporal.plus(3, ChronoUnit.DAYS);
        } else if (dow == DayOfWeek.SATURDAY) {
            temporal = temporal.plus(2, ChronoUnit.DAYS);
        } else {
            temporal = temporal.plus(1, ChronoUnit.DAYS);
        }
        return temporal;
    }
}

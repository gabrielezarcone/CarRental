package com.gabrielez.CarRental.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    /**
     * Restituisce i giorni che passano da date1 a date2
     * @param date1 prima data
     * @param date2 seconda data
     * @return numero di giorni tra le due date
     */
    public static long diffGiorni(Date date1, Date date2){
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static boolean diffMenoNGiorni(Date date1, Date date2, long n){
        return diffGiorni(date1, date2) <= n;
    }

    /**
     * Trasforma una stringa dal formato "yyyy-MM-dd" in un oggetto Date
     * @param dateStr Stringa "yyyy-MM-dd"
     * @return oggetto Date corrispondente
     */
    public static Date parseDate(String dateStr){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Trasforma un oggetto Date in una stringa dal formato "yyyy-MM-dd"
     * @param date oggetto Date
     * @return Stringa "yyyy-MM-dd" corrispondente
     */
    public static String formatDate(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}

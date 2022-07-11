package com.apiproject.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class Utils {

    /**
     * convert a double (String with coma) to a double with a dot
     * @param doubleString
     * @return a double with a dot
     */
    public static Double convertDoubleWithComaToDoubleWithDot(String doubleString) {

        String[] doubleArgs = doubleString.split(",");
        if (doubleArgs.length == 1) return Double.parseDouble(doubleString);
        return Double.parseDouble(String.join(".", doubleArgs));
    }

    /**
     * converts a date (String) to a date (java.sql.Date)
     * @param dateString
     * @return Date
     * @throws ParseException
     */
    public static Date convertStringToDate(String dateString) throws ParseException {
        DateFormat iFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat oFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDateFormatted = oFormatter.format(iFormatter.parse(dateString));
        return Date.valueOf(strDateFormatted);
    }

    /**
     * converts a date (Date) to a String
     * @param date (Date)
     * @return String in format dd/MM/yyyy
     */
    public static String convertDateToString(Date date)  {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
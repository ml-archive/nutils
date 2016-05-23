package dk.nodes.nutils.ndateparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Constantin Gherghescu on 23-May-16.
 */
public class NDateParser {


    /**
     * Tries to parse an ISO 8601 string representation of a date/time
     *
     * @param dateString the string containing the date: "yyyy-MM-dd'T'HH:mm:ssZ"
     * @return the date represented by {@code dateString}
     */
    public static Date ParseDateFromISOString(String dateString) throws ParseException {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).parse(dateString);
    }

    /**
     * Tries to convert a {@code Date} object to an ISO 8601 string representation
     *
     * @param date A {@code Date} instance
     * @return ISO 8601 string representation: "yyyy-MM-dd'T'HH:mm:ssZ"
     */
    public static String DateToISOString(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        return df.format(date);
    }
}


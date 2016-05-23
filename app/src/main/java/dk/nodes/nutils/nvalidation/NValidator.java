package dk.nodes.nutils.nvalidation;

import android.text.TextUtils;
import android.util.Patterns;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * Created by Constantin Gherghescu on 23-May-16.
 */

public class NValidator {

    /**
     *
     * Checks if the {@code emailAddress} param is a valid email address
     * using the {@code android.util.Patterns.EMAIL_ADDRESS} validator
     *
     * @param emailAddress email address to be checked
     * @return true for valid email address, false otherwise
     */
    public static boolean IsEmailAddressValid(String emailAddress) {

        if (TextUtils.isEmpty(emailAddress)) {
            return false;
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    /**
     *
     * Checks if the {@code phoneNumber} param is a valid phone number, by creating a wrapper over
     * some <a href="https://github.com/googlei18n/libphonenumber/">googlei18n/libphonenumber</a>
     * methods. ( Documentation partially taken from
     * {@link com.google.i18n.phonenumbers.PhoneNumberUtil#parse(String, String)} ).
     *
     *
     *  <p> <p> It will accept a number in any format (E164, national, international etc), assuming it can be
     * interpreted with the {@code region} supplied. It also attempts to convert any alpha characters
     * into digits if it thinks this is a vanity number of the type "1800 MICROSOFT".
     *
     * @param phoneNumberStr phone number to be checked
     * @param region region that we are expecting the number to be from. This is only used
     *               if the number being parsed is not written in international format.
     *               If the number is guaranteed to
     *               start with a '+' followed by the country calling code, then
     *               "ZZ" or null can be supplied.
     * @return true for valid phone number, false otherwise
     */
    public static boolean IsPhoneNumberValid(String phoneNumberStr, String region) {

        if (TextUtils.isEmpty(phoneNumberStr)) {
            return false;
        }

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        Phonenumber.PhoneNumber phoneNumber;
        try {
            phoneNumber = phoneUtil.parse(phoneNumberStr, region);
        } catch (NumberParseException e) {
            return false;
        }

        return phoneUtil.isPossibleNumber(phoneNumber);
    }

}

package dk.nodes.nutils.nvalidation;

import android.text.TextUtils;

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

}

package utility;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 *
 * @author Hazar Gul Nazari
 */
public class Checker {

    public static final Predicate<String> isEmailCorrect = email -> Pattern.compile("[\\w._]+@\\w+(.\\w+)+").matcher(email).find();
    public static final Predicate<String> isPasswordCorrect = password -> password.length() >= 8;
}

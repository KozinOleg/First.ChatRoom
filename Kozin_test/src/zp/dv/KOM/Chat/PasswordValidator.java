package zp.dv.KOM.Chat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN ="([A-Za-z0-9-\\-\\_]{6,}$)";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String str) {
        matcher = pattern.matcher(str);
        return matcher.matches();

    }
}

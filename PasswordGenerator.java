import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = "!@#$%^&*()_=+\\/~?";

    private StringBuilder pool;

    public PasswordGenerator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
        pool = new StringBuilder();
        if (includeUpper) {
            pool.append(UPPERCASE_LETTERS);
        }
        if (includeLower) {
            pool.append(LOWERCASE_LETTERS);
        }
        if (includeNum) {
            pool.append(NUMBERS);
        }
        if (includeSym) {
            pool.append(SYMBOLS);
        }
    }

    public String generatePassword(int length) {
        if (pool.length() == 0) {
            throw new IllegalArgumentException("Character pool is empty. Select at least one character type.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0.");
        }

        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        int poolLength = pool.length();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(poolLength);
            password.append(pool.charAt(randomIndex));
        }

        return password.toString();
    }
}

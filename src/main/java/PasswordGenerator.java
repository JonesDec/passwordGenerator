import java.security.SecureRandom;
import java.util.Random;

public final class PasswordGenerator {

    public static final int minimumLengthCount = 4;

    private static final char[] ALPHA_UPPER_CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private static final char[] ALPHA_LOWER_CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toLowerCase().toCharArray();
    private static final char[] NUMERIC_CHARACTERS = "0123456789".toCharArray();
    private static final char[] ALLOWED_SPECIAL_CHARACTERS = "!@%*<.>?".toCharArray();
    private final char[] ALL_CHARS;
    private static Random rand = new SecureRandom();

    private int passwordWorkLength;

    public PasswordGenerator(int passwordWorkLength) {
        this.passwordWorkLength = passwordWorkLength;
        StringBuilder sb = new StringBuilder();
        sb.append(ALLOWED_SPECIAL_CHARACTERS)
                .append(ALPHA_LOWER_CHARACTERS)
                .append(ALPHA_UPPER_CHARACTERS)
                .append(NUMERIC_CHARACTERS);
        this.ALL_CHARS = sb.toString().toCharArray();
        assert passwordWorkLength >= 4;
    }

    public String generate() {
        return generate(this.passwordWorkLength);
    }

    public String generate(int desiredPasswordLength) {
        char[] password = new char[desiredPasswordLength];

        // Get the required characters out the way first
        password[0] = ALPHA_UPPER_CHARACTERS[rand.nextInt(ALPHA_UPPER_CHARACTERS.length)];
        password[1] = ALPHA_LOWER_CHARACTERS[rand.nextInt(ALPHA_LOWER_CHARACTERS.length)];
        password[2] = NUMERIC_CHARACTERS[rand.nextInt(NUMERIC_CHARACTERS.length)];
        password[3] = ALLOWED_SPECIAL_CHARACTERS[rand.nextInt(ALLOWED_SPECIAL_CHARACTERS.length)];

        //populate rest of the password with random chars
        for (int i = 4; i < passwordWorkLength; i++) {
            password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }

        //shuffle it up
        for (int i = 0; i < password.length; i++) {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }

        return new String(password);
    }
}

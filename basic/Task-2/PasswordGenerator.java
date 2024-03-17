import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        int length = 12; // specify the length of the password
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        String allChars = UPPERCASE_CHARS + LOWERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each character set
        password.append(getRandomChar(UPPERCASE_CHARS, random));
        password.append(getRandomChar(LOWERCASE_CHARS, random));
        password.append(getRandomChar(NUMBERS, random));
        password.append(getRandomChar(SPECIAL_CHARS, random));

        // Fill the remaining length of the password
        for (int i = 0; i < length - 4; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the generated password
        String shuffledPassword = shuffleString(password.toString());
        return shuffledPassword;
    }

    private static char getRandomChar(String charSet, SecureRandom random) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}

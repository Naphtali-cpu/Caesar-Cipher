import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        // User interface for Ceaser Cipher

        Scanner aScanner = new Scanner(System.in);
        String plainText;
        int shiftKey;

        System.out.println("Enter Text To Be Encrypted: ");
        plainText = aScanner.nextLine();

        System.out.println("Enter Encrypt Shift Key ");
        shiftKey = aScanner.nextInt();
        String encryptedText = EncryptText(plainText,shiftKey);

        System.out.println("The Encrypted Text: "+encryptedText);

        System.out.println("The Decrypted Text: "+DecryptText(encryptedText,shiftKey));
    }

//    Backend for the Ceaser Cipher Test
//    Encryption

    public static String EncryptText(String message, int shiftKey) {
        //c(x) =  x + shiftKey Mod(%) 26;
        final String ALPAHABETS = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();

        StringBuilder cipherText = new StringBuilder();

        for(int counter = 0;counter < message.length();counter++) {
            if(!Character.isLetter(message.charAt(counter))) {
                cipherText.append(message.charAt(counter));
            }
            else {
                int charPosition = ALPAHABETS.indexOf(message.charAt(counter));
                int keyValue = (charPosition + shiftKey) % 26;

                char cipherValue = ALPAHABETS.charAt(keyValue);

                cipherText.append(cipherValue);
            }
        }

        return cipherText.toString();
    }
//Decryption

    public static String DecryptText(String message, int shiftKey) {
        //c(x) =  x - shiftKey Mod(%) 26;
        final String ALPAHABETS = "abcdefghijklmnopqrstuvwxyz";

        message = message.toLowerCase();

        StringBuilder plainText = new StringBuilder();

        for(int counter = 0;counter < message.length();counter++) {

            if(!Character.isLetter(message.charAt(counter))) {
                plainText.append(message.charAt(counter));
            }

            else {
                int charPosition = ALPAHABETS.indexOf(message.charAt(counter));
                int keyValue = (charPosition - shiftKey) % 26;

                if (keyValue < 0) {

                    keyValue = ALPAHABETS.length() + keyValue;
                }

                char plainValue = ALPAHABETS.charAt(keyValue);

                plainText.append(plainValue);
            }
        }

        return plainText.toString();

    }
}

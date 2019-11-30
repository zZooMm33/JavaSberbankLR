package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Класс для кодирования пароля
 */
public class Encode {

    /**
     * Соль для наложения на пароль
     */
    private static final byte[] SALT = new byte[]{72, 101, 108, 108, 111, 32, 63, 63, 63, 63, 63, 33, 63, 63, 63, 33};

    /**
     * Метод для шифрования пароля
     * @param passwordToHash пароль пользователя
     * @return зашифрованный пароль
     */
    public static String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(SALT);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}

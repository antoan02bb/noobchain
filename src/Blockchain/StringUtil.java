package Blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil { //utility clas

    //Applies Sha256 to a String and returns the result
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies MessageDigest to out input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); //This will contain hash as hexadecimal

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

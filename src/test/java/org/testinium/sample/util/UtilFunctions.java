package org.testinium.sample.util;
import java.util.Random;
public class UtilFunctions {



        public static String generateRandomString() {
            int length = 6;
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // Kullanılacak karakter seti
            Random random = new Random();
            StringBuilder randomString = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length()); // Karakter setinden rastgele bir index seç
                randomString.append(characters.charAt(index)); // O karakteri ekle
            }

            return randomString.toString();
        }

        public static double convertStringToDouble(String stringAmount){

            stringAmount = stringAmount.replace(",", "");  // Virgülleri kaldırır
            return Double.parseDouble(stringAmount);// Ardından sayıyı sayısal formata çevirin
        }




}

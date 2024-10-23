package org.utility;

import java.util.Random;

public class RandomGeneration {

    // Method to generate random name
    public static String generateRandomName() {
        int length = 7;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            name.append(alphabet.charAt(index));
        }
        return name.toString();
    }

    // Method to generate random email
    public static String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate random username part of the email
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphabet.length());
            email.append(alphabet.charAt(index));
        }

        // Add a domain to the email
        email.append("@example.com");

        return email.toString();
    }
}

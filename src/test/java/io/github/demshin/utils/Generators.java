package io.github.demshin.utils;

import java.util.Random;

public class Generators {
    public static String getRandomID() {
        Random random = new Random();
        return String.valueOf(random.nextInt(99999));
    }

    public static String getRandomDiscount() {
        Random random = new Random();
        return String.valueOf(random.nextInt(98) + 1);
    }

    public static String getRandomName() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int N = 15;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public static Integer getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min.");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}

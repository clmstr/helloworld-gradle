package com.example;

import java.util.Random;

public class SeoUrlGenerator {

    static String DOMAIN = "https://short.com/";
    static String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUrl(String url, String keyword){
        if (keyword.length() > 20){
            throw new InvalidInputException("Too long keyword: " + keyword);
        }
        return DOMAIN + keyword;
    }

    public String generateShortUrl(String url){
        String generatedHash = generateHash();

        return DOMAIN + generatedHash;
    }

    private String generateHash() {
        Random random = new Random();
        String generatedHash = "";
        for (int i=0; i<4; i++) {
            int character = random.nextInt(CHARS.length());
            generatedHash = generatedHash.concat(""+ CHARS.charAt(character));
        }
        return generatedHash;
    }

}

package com.epam.lessons.lesson10;

public class Validator {

    public static void validateDoubleNumber(String number) {
        try {
            double parsedNumber = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new ValidationException("Input is not a number");
        }
    }

    public static void validateEmptyString(String str) {
        if(str == null || str.trim().isEmpty()) {
            throw new ValidationException("Input string is empty");
        }
    }
}
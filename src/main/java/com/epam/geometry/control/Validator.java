package com.epam.geometry.control;

import com.epam.geometry.control.exceptions.StringNotFoundException;



public class Validator {
    private static final String DOUBLE_PATTERN = "[-]?\\d*[.]?\\d+";

    public boolean isValid(String original){
        if (original == null) {
            throw new StringNotFoundException("String wasn't found!");
        }

        String regEx = "(" + DOUBLE_PATTERN + "\\s){3}" + DOUBLE_PATTERN;

        return original.matches(regEx);
    }


}

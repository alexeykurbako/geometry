package com.epam.test.validator;

import com.epam.geometry.control.Validator;
import com.epam.geometry.control.exceptions.StringNotFoundException;
import org.junit.Assert;
import org.junit.Test;



public class ValidatorTest {
    private final Validator valid = new Validator();
    @Test
    public void shouldSuccessValidatorTestSupplied() {
        //Given
        String testData = "-1.2 2.5 3.6 1.0";
        //When
        boolean receivedString = valid.isValid(testData);
        //Then
        Assert.assertTrue(receivedString);
    }

    @Test
    public void shouldFailedValidatorExceptionTestSupplied() {
        //Given
        String testData = "1.! 2.5 @.6 1.0";
        //When
        boolean receivedString = valid.isValid(testData);
        //Then
        Assert.assertFalse(receivedString);
    }

    @Test(expected = StringNotFoundException.class)
    public void shouldExceptionValidatorExceptionTestSupplied() {
        //When
        boolean receivedString = valid.isValid(null);
        //Then
        Assert.assertFalse(receivedString);
    }


}



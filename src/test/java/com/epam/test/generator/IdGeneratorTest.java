package com.epam.test.generator;

import com.epam.geometry.generator.IdGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdGeneratorTest {
    private final IdGenerator generator = new IdGenerator();

    @Test
    public void generateShouldReturnArithmeticalSequenceOfNumbers() {
        List<Integer> generatedIds = new ArrayList<>();
        generatedIds.add(generator.generateId());
        generatedIds.add(generator.generateId());
        List<Integer> expected = Arrays.asList(1, 2);
        Assert.assertEquals(expected, generatedIds);
    }
}

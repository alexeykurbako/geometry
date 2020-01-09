package com.epam.test.parser;
import com.epam.geometry.control.Parser;

import com.epam.geometry.control.exceptions.WrongLengthException;
import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Test;


public class ParserTest {
    private final IdGenerator idGenerator = new IdGenerator();
    private final Parser parser = new Parser(idGenerator);
    @Test
    public void shouldParserTestSupplied() throws WrongLengthException {
        //Given

        Cube givenCube = new Cube(idGenerator, new Point(1.2, 2.4, 5.6), 3.0);
        String givenString = "1.2 2.4 5.6 3.0";
        //When
        Cube receivedCube = parser.parseToCube(givenString);
        //Then
        Assert.assertEquals(givenCube, receivedCube);
    }

    @Test(expected = WrongLengthException.class)
    public void shouldExceptionParserTestSupplied() throws WrongLengthException {
        //Given
        Cube givenCube = new Cube(idGenerator, new Point(1.2, 2.4, 5.6), 3.0);
        String givenString = "1.2 2.4 5.6 -3.0";
        //When
        Cube receivedCube = parser.parseToCube(givenString);
        //Then
        Assert.assertEquals(givenCube, receivedCube);
    }
}


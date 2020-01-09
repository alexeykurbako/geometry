package com.epam.test;
import com.epam.geometry.control.Parser;
import com.epam.geometry.control.Validator;
import com.epam.geometry.control.exceptions.WrongLengthException;
import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.control.Director;
import com.epam.geometry.reader.ReaderFromFile;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class DirectorTest {
    private final static String PATH = "./src/test/java/com/epam/test/test_file.txt";
    private final static List<String> LIST_OF_STRINGS = Arrays.asList("1.2 3.4 5.6 %.0","1.4 1.4 6.3 2.0" , "8.3 7.6 1.@ 1.5", "9.3 !.2 3.3 4.0");
    private final static String VALID_STRING = "1.4 1.4 6.3 2.0";
    private final static IdGenerator idGenerator = new IdGenerator();
    private final static Cube VALID_CUBE = new Cube(idGenerator, new Point(1.4, 1.4, 6.3),2.0);
    private final static List<Cube> FINAl_LIST = Arrays.asList(VALID_CUBE);

    @Test
    public void shouldUpdateDirectorWhenPathSupplied() throws WrongLengthException, IOException {
    //given
    ReaderFromFile reader = Mockito.mock(ReaderFromFile.class);
    Validator validator = Mockito.mock(Validator.class);
    Parser parser = Mockito.mock(Parser.class);

    when(reader.read(PATH)).thenReturn(LIST_OF_STRINGS);
    when(validator.isValid(VALID_STRING)).thenReturn(true);
    when(parser.parseToCube(VALID_STRING)).thenReturn(VALID_CUBE);

    Director director = new Director(reader, validator, parser);
    //when
    List<Cube> actual = director.process(PATH);
    //then
    Assert.assertEquals(FINAl_LIST, actual);

    Mockito.verify(reader).read(PATH);
    Mockito.verify(validator).isValid(VALID_STRING);
    Mockito.verify(parser).parseToCube(VALID_STRING);

    }
}

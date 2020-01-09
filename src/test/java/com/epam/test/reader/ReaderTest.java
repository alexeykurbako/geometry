package com.epam.test.reader;



import com.epam.geometry.reader.ReaderFromFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    @Test
    public void shouldReaderTestSupplied() throws IOException {
        //Given
        ReaderFromFile reader = new ReaderFromFile();
        String PATH = "./src/test/java/resources/test_file.txt";
        List<String> givenList = Arrays.asList("1.2 3.4 5.6 %.0","1.4 1.4 6.3 2.0","8.3 7.6 1.@ 1.5","9.3 !.2 3.3 4.0");
        //When
        List<String> receivedList = reader.read(PATH);
        //Then
        Assert.assertEquals(givenList, receivedList);
    }
    @Test(expected = FileNotFoundException.class)
    public void shouldReaderExceptionTestSupplied() throws IOException {
        //Given
        ReaderFromFile reader = new ReaderFromFile();
        List<String> givenList = Arrays.asList("1.2 3.4 5.6 1.0","1.4 1.4 6.3 2.0","8.3 7.6 1.2 1.5","9.3 4.2 3.3 4.0");
        //When
        List<String> receivedList = reader.read(null);
        //Then
        Assert.assertEquals(givenList, receivedList);
    }
}

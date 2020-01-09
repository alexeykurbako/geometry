package com.epam.geometry.reader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ReaderFromFile implements Reader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class);
    @Override
    public List<String> read(String PATH) throws IOException {
        if(PATH == null){
            throw new FileNotFoundException("File isn't exist!");
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        List<String> elements = new ArrayList<>();
        String nextLine;

        while ((nextLine = bufferedReader.readLine()) != null) {
            elements.add(nextLine);
        }
        if (elements.isEmpty()) {
            LOGGER.warn("File hasn't lines!");
        }
        return elements;
    }
}


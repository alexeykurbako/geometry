package com.epam.geometry.control;
import com.epam.geometry.control.exceptions.WrongLengthException;
import com.epam.geometry.model.Cube;
import com.epam.geometry.reader.ReaderFromFile;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    final Logger LOGGER = Logger.getLogger(String.valueOf(ReaderFromFile.class));
    private List<Cube> finalList;
    private ReaderFromFile reader;
    private Validator valid;
    private Parser parser;

    public Director(ReaderFromFile reader, Validator valid, Parser parser){
        finalList = new ArrayList<>();
        this.reader = reader;
        this.valid = valid;
        this.parser = parser;
    }

    public List<Cube> process(String path) {
        List<String> listOfData = null;
        try {
            listOfData = reader.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String parameter: listOfData){
            if(valid.isValid(parameter)){
                Cube tempCube = null;
                try {
                    tempCube = parser.parseToCube(parameter);
                } catch (WrongLengthException ex) {
                    LOGGER.error("Length can't be less the zero!", ex);
                }
                finalList.add(tempCube);
            }
        }
        if (finalList.isEmpty()) {
            LOGGER.warn("FinalList is empty!");
        }
        return finalList;
    }
}

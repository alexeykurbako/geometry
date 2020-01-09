package com.epam.geometry.control;
import com.epam.geometry.control.exceptions.StringNotFoundException;
import com.epam.geometry.control.exceptions.WrongLengthException;
import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;


public class Parser {
    private final IdGenerator idGenerator;
    public Parser(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Cube parseToCube(String givenString) throws WrongLengthException {

        if(givenString == null){
            throw new StringNotFoundException("String wasn't found!");
        }

        String[] arrayOfData = givenString.split(" ");
        Double xCoordinate = Double.parseDouble(arrayOfData[0]);
        Double yCoordinate = Double.parseDouble(arrayOfData[1]);
        Double zCoordinate = Double.parseDouble(arrayOfData[2]);
        Double length = Double.parseDouble(arrayOfData[3]);

        if (length <= 0) {
            throw new WrongLengthException("Length can't be less then zero!");
        }
        return new Cube(idGenerator, new Point(xCoordinate,yCoordinate,zCoordinate),length);
    }
}

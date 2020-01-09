package com.epam.geometry.repository.comparator;
import com.epam.geometry.model.Cube;

import java.util.Comparator;

public class IdComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        return firstCube.getId().hashCode() - firstCube.getId().hashCode();
    }
}

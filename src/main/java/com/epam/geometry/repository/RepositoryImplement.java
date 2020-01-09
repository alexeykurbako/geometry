package com.epam.geometry.repository;

import com.epam.geometry.model.Cube;
import com.epam.geometry.repository.interfaces.Repository;
import com.epam.geometry.repository.specification.Specification;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.log4j.Level.ERROR;

public class RepositoryImplement implements Repository {
        private static Logger logger = Logger.getLogger(RepositoryImplement.class);
        private List<Cube> listOfCubes;

        public RepositoryImplement(){
            listOfCubes = new ArrayList<>();
        }

        public List<Cube> getListOfCubes(){
            return listOfCubes;
        }

        @Override
        public void add(Cube cube) {
            if(cube == null){
                throw new IllegalArgumentException("Cube can't have null value!");
            }
            listOfCubes.add(cube);

        }

        @Override
        public void remove(Cube cube) {
            if(cube == null){
                throw new IllegalArgumentException("Cube can't have null value!");
            }

            if(listOfCubes.contains(cube)){
                listOfCubes.remove(cube);
            } else {
                logger.log(ERROR, "Cube isn't exist in the list!");
            }
        }

        @Override
        public void update(Cube cubeBeforeChanging, Cube cubeAfterChanging) {
            if(cubeBeforeChanging == null || cubeAfterChanging == null){
                throw new IllegalArgumentException("Cube can't have null value!");
            }

            if(listOfCubes.contains(cubeBeforeChanging)){
                int quadrilateralIndex = listOfCubes.indexOf(cubeBeforeChanging);
                listOfCubes.set(quadrilateralIndex, cubeAfterChanging);
            } else {
                logger.log(ERROR, "Cube doesn't exist in the list!");
            }
        }

        @Override
        public List<Cube> query(Specification specification) {
            if(specification == null){
                throw new IllegalArgumentException("Specification can't have null value!");
            }
			return  listOfCubes.stream().
				    filter(specification::specified).
				    collect(Collectors.toList());
        }

        @Override
        public List<Cube> query(Specification specification, Comparator<Cube> comparator) {
            if(specification == null){
                throw new IllegalArgumentException("Specification can't have null value!");
            }
			return  listOfCubes.stream().
					filter(specification::specified).
					sorted(comparator).
					collect(Collectors.toList());
        }
    }


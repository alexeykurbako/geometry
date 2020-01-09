package com.epam.geometry.reader;

import java.io.IOException;
import java.util.List;

interface Reader{
    List<String> read(String path) throws IOException;
}
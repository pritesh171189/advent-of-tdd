package org.advent.util;

import org.advent.exception.InvalidFileNameException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    public List<String> getLinesListFromFile(String fileName) throws URISyntaxException, IOException {
        URL url = getClass().getClassLoader().getResource(fileName);
        if(url == null) {
            throw new InvalidFileNameException("Invalid file name");
        }
        return Files.lines(Paths.get(url.toURI())).collect(Collectors.toList());
    }
}

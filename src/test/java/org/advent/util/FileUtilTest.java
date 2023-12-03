package org.advent.util;

import org.advent.exception.InvalidFileNameException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    @Test
    void testGetLinesListFromFileInvalidFilePath() {
        assertThrowsExactly(InvalidFileNameException.class, () -> new FileUtil().getLinesListFromFile("day22input.txt"));
    }

    @Test
    void testGetLinesListFromFileValidFilePath() {
        try {
            List<String> lines = new FileUtil().getLinesListFromFile("day2input.txt");
            assertTrue(lines != null && !lines.isEmpty());
        } catch (Exception e) {
            fail("Exception occurred during getLinesListFromFile");
        }
    }
}

package org.advent.day2;

import org.advent.exception.InvalidFileNameException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

public class CubeGameTest {

    @Test
    void testGetPossibleGamesIdsSumInvalidFilePath() {
        CubeGame cubeGame = new CubeGame();
        Map<String,Integer> maxColourCount = new HashMap<>();
        maxColourCount.put("red",12);
        maxColourCount.put("green",13);
        maxColourCount.put("blue",14);
        assertThrowsExactly(InvalidFileNameException.class, () -> cubeGame.getPossibleGamesIdsSum("day21input.txt",maxColourCount));
    }

    @Test
    void testGetPossibleGamesIdsSumInvalidMaxColourCount() {
        CubeGame cubeGame = new CubeGame();
        Map<String,Integer> maxColourCount = null;
        assertThrowsExactly(RuntimeException.class, () -> cubeGame.getPossibleGamesIdsSum("day21input.txt",maxColourCount));
    }

    @Test
    void testGetPossibleGamesIdsSum() {
        CubeGame cubeGame = new CubeGame();
        Map<String,Integer> maxColourCount = new HashMap<>();
        maxColourCount.put("red",12);
        maxColourCount.put("green",13);
        maxColourCount.put("blue",14);
        try {
            assertThat(cubeGame.getPossibleGamesIdsSum("day2input.txt",maxColourCount), equalTo(2505));
        } catch (Exception e) {
            fail("Exception occurred during getPossibleGamesIdsSum {}",e);
        }
    }
}

package org.advent.day2part2;

import org.advent.exception.InvalidFileNameException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

public class CubeGameTest {

    @Test
    void testGetSumOfPowerOfAllSetsInvalidFilePath() {
        CubeGame cubeGame = new CubeGame();
        assertThrowsExactly(InvalidFileNameException.class, () -> cubeGame.getSumOfPowerOfAllSets("day22input.txt"));
    }
    @Test
    void testGetPossibleGamesIdsSum() {
        CubeGame cubeGame = new CubeGame();
        try {
            assertThat(cubeGame.getSumOfPowerOfAllSets("day2input.txt"), equalTo(70265));
        } catch (Exception e) {
            fail("Exception occurred during getPossibleGamesIdsSum {}",e);
        }
    }
}

package org.advent.day1;

import org.advent.exception.InvalidFileNameException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

public class CalibrationTest {

    @Test
    void testGetSumOfCalibrationValuesInvalidFilePath() {
        Calibration calibration = new Calibration();
        assertThrowsExactly(InvalidFileNameException.class, () -> calibration.getSumOfCalibrationValues("day11input.txt"));
    }

    @Test
    void testGetSumOfCalibrationValues() {
        Calibration calibration = new Calibration();
        try {
            assertThat(calibration.getSumOfCalibrationValues("day1input.txt"), equalTo(54990));
        } catch (Exception e) {
            fail("Exception occurred during getSumOfCalibrationValues {}",e);
        }
    }
}

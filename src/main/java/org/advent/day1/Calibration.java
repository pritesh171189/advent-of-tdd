package org.advent.day1;

import org.advent.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.StringJoiner;

public class Calibration {

    public int getSumOfCalibrationValues(String fileName) throws IOException, URISyntaxException {
        try {
            List<String> lines = new FileUtil().getLinesListFromFile(fileName);
            int totalCalibrationValue = 0;
            for (String line : lines) {
                boolean firstDigitFound = false, lastDigitFound = false;
                char firstDigit = 0, lastDigit = 0;
                int calibrationValue = 0;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c) && !firstDigitFound) {
                        firstDigit = c;
                        firstDigitFound = true;
                    } else if (Character.isDigit(c) && firstDigitFound) {
                        lastDigit = c;
                        lastDigitFound = true;
                    }

                }
                if (firstDigitFound && lastDigitFound) {
                    calibrationValue = Integer.parseInt(new StringJoiner("").add(String.valueOf(firstDigit)).add(String.valueOf(lastDigit)).toString());
                } else if (firstDigitFound && !lastDigitFound) {
                    calibrationValue = Integer.parseInt(new StringJoiner("").add(String.valueOf(firstDigit)).add(String.valueOf(firstDigit)).toString());
                }
                totalCalibrationValue += calibrationValue;
            }
            return totalCalibrationValue;
        } catch (Exception e) {
            throw e;
        }

    }

}

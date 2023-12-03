package org.advent.day2part2;

import org.advent.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeGame {

    public int getSumOfPowerOfAllSets(String fileName) throws IOException, URISyntaxException {
        int sumOfPowerOfAllSets = 0;
        try {
            List<String> lines = new FileUtil().getLinesListFromFile(fileName);
            for (String line : lines) {
                Map<String, Integer> colourMaxCount = new HashMap<>();
                String[] gameIdBalls = line.split(":");
                String gameDetails = gameIdBalls[1].trim();

                String[] gameDetailsArr = gameDetails.split(";");
                for (String part : gameDetailsArr) {
                    String[] countBalls = part.trim().split(",");
                    for (String countBall : countBalls) {
                        String[] countOneBall = countBall.trim().split(" ");
                        int count = Integer.parseInt(countOneBall[0].trim());
                        String colour = countOneBall[1].trim();
                        if (colourMaxCount.containsKey(colour) && count > colourMaxCount.get(colour)) {
                            colourMaxCount.put(colour, count);
                        } else if (!colourMaxCount.containsKey(colour)) {
                            colourMaxCount.put(colour, count);
                        }
                    }

                }
                Collection<Integer> countList = colourMaxCount.values();
                int power = 1;
                for (Integer count : countList) {
                    power = power * count;
                }
                sumOfPowerOfAllSets += power;

            }

        } catch (Exception e) {
            throw e;
        }
        return sumOfPowerOfAllSets;
    }

}

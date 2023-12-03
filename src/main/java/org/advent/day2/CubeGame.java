package org.advent.day2;

import org.advent.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class CubeGame {

    public int getPossibleGamesIdsSum(String fileName, Map<String, Integer> maxColourCount) throws IOException, URISyntaxException {
        int sumOfPossibleGameIds = 0;
        try {
            if (maxColourCount != null && maxColourCount.size() == 3 && maxColourCount.get("red") == 12 && maxColourCount.get("green") == 13 && maxColourCount.get("blue") == 14) {
                List<String> lines = new FileUtil().getLinesListFromFile(fileName);
                for (String line : lines) {
                    boolean possible = true;
                    String[] gameIdBalls = line.split(":");
                    int gameId = Integer.parseInt(gameIdBalls[0].trim().replace("Game ", ""));
                    String gameDetails = gameIdBalls[1].trim();

                    String[] gameDetailsArr = gameDetails.split(";");
                    for (String part : gameDetailsArr) {
                        String[] countBalls = part.trim().split(",");
                        for (String countBall : countBalls) {
                            String[] countOneBall = countBall.trim().split(" ");
                            int count = Integer.parseInt(countOneBall[0].trim());
                            String colour = countOneBall[1].trim();
                            if (count > maxColourCount.get(colour)) {
                                possible = false;
                                break;
                            }
                        }
                    }
                    if (possible) {
                        sumOfPossibleGameIds += gameId;
                    }
                }
            } else {
                throw new RuntimeException("Invalid maxColourCount map");
            }
        } catch (Exception e) {
            throw e;
        }
        return sumOfPossibleGameIds;
    }

}

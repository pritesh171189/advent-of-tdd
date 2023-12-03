package org.advent.day1part2;

import org.advent.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Calibration {

    public int getSumOfCalibrationValues(String fileName) throws IOException, URISyntaxException {
        try {
            List<String> lines = new FileUtil().getLinesListFromFile(fileName);
            int totalCalibrationValue = 0;
            Map<String,Integer> result = new LinkedHashMap<>();
            for (String line : lines) {
                boolean firstDigitFound = false, lastDigitFound = false;
                char firstDigit = 0, lastDigit = 0;
                int firstDigitIndex=-1 , lastDigitIndex= -1;
                int calibrationValue = 0;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c) && !firstDigitFound) {
                        firstDigit = c;
                        firstDigitIndex = i;
                        firstDigitFound = true;
                    }
                    else if (Character.isDigit(c) && firstDigitFound) {
                        lastDigit = c;
                        lastDigitIndex = i;
                        lastDigitFound = true;
                    }

                }
                Map<Integer,Character> indexNumber = new HashMap<>();
                Map<Integer,Character> indexNumberLast = new HashMap<>();

                int oneIndex = line.indexOf("one");
                if(oneIndex >= 0){
                    indexNumber.put(oneIndex,  '1');
                }
                int oneIndexLast = line.lastIndexOf("one");
                if(oneIndexLast >= 0){
                    indexNumberLast.put(oneIndexLast,  '1');
                }

                int twoIndex = line.indexOf("two");
                if(twoIndex >= 0){
                    indexNumber.put(twoIndex,'2');
                }
                int twoIndexLast = line.lastIndexOf("two");
                if(twoIndexLast >= 0){
                    indexNumberLast.put(twoIndexLast,  '2');
                }

                int threeIndex = line.indexOf("three");
                if(threeIndex >= 0){
                    indexNumber.put(threeIndex,'3');
                }
                int threeIndexLast = line.lastIndexOf("three");
                if(threeIndexLast >= 0){
                    indexNumberLast.put(threeIndexLast,  '3');
                }

                int fourIndex = line.indexOf("four");
                if(fourIndex >= 0){
                    indexNumber.put(fourIndex,'4');
                }
                int fourIndexLast = line.lastIndexOf("four");
                if(fourIndexLast >= 0){
                    indexNumberLast.put(fourIndexLast,  '4');
                }

                int fiveIndex = line.indexOf("five");
                if(fiveIndex >= 0){
                    indexNumber.put(fiveIndex,'5');
                }
                int fiveIndexLast = line.lastIndexOf("five");
                if(fiveIndexLast >= 0){
                    indexNumberLast.put(fiveIndexLast,  '5');
                }

                int sixIndex = line.indexOf("six");
                if(sixIndex >= 0){
                    indexNumber.put(sixIndex,'6');
                }
                int sixIndexLast = line.lastIndexOf("six");
                if(sixIndexLast >= 0){
                    indexNumberLast.put(sixIndexLast,  '6');
                }

                int sevenIndex = line.indexOf("seven");
                if(sevenIndex >= 0){
                    indexNumber.put(sevenIndex,'7');
                }
                int sevenIndexLast = line.lastIndexOf("seven");
                if(sevenIndexLast >= 0){
                    indexNumberLast.put(sevenIndexLast,  '7');
                }

                int eightIndex = line.indexOf("eight");
                if(eightIndex >= 0){
                    indexNumber.put(eightIndex,'8');
                }
                int eightIndexLast = line.lastIndexOf("eight");
                if(eightIndex >= 0){
                    indexNumberLast.put(eightIndexLast,  '8');
                }

                int nineIndex = line.indexOf("nine");
                if(nineIndex >= 0){
                    indexNumber.put(nineIndex,'9');
                }
                int nineIndexLast = line.lastIndexOf("nine");
                if(nineIndex >= 0){
                    indexNumberLast.put(nineIndexLast,  '9');
                }
                char actualFirstDigit = 0, actualLastDigit = 0;
                if (firstDigitFound && lastDigitFound) {
                    actualFirstDigit = indexNumber.isEmpty() ?  firstDigit : getActualFirstDigit(firstDigit,firstDigitIndex,indexNumber);
                    actualLastDigit = indexNumber.isEmpty() ?  lastDigit : getActualLastDigit(lastDigit,lastDigitIndex,indexNumberLast);
                } else if (firstDigitFound && !lastDigitFound) {
                    actualFirstDigit = indexNumber.isEmpty() ?  firstDigit : getActualFirstDigit(firstDigit,firstDigitIndex,indexNumber);
                    actualLastDigit = indexNumber.isEmpty() ?  firstDigit : getActualLastDigit(firstDigit,firstDigitIndex,indexNumberLast);
                } else if(!firstDigitFound && !lastDigitFound && !indexNumber.isEmpty()) {
                    actualFirstDigit = getActualFirstDigit((char) 0,Integer.MAX_VALUE,indexNumber);
                    actualLastDigit = getActualLastDigit((char) 0,Integer.MIN_VALUE,indexNumberLast);
                }
                calibrationValue = Integer.parseInt(new StringJoiner("").add(String.valueOf(actualFirstDigit)).add(String.valueOf(actualLastDigit)).toString());
                totalCalibrationValue += calibrationValue;
                result.put(line,calibrationValue);
            }
            return totalCalibrationValue;
        } catch (Exception e) {
            throw e;
        }

    }

    private char getActualLastDigit(char lastDigit, int lastDigitIndex, Map<Integer, Character> indexNumber) {
        int maximumIndexFromMap = getMaximumNumberFromList(indexNumber.keySet());
        if(maximumIndexFromMap > lastDigitIndex){
            return indexNumber.get(maximumIndexFromMap);
        } else{
            return lastDigit;
        }
    }



    private char getActualFirstDigit(char firstDigit, int firstDigitIndex, Map<Integer, Character> indexNumber) {
        int minimumIndexFromMap = getMinimumNumberFromList(indexNumber.keySet());
        if(minimumIndexFromMap < firstDigitIndex){
            return indexNumber.get(minimumIndexFromMap);
        } else{
            return firstDigit;
        }
    }

    private int getMinimumNumberFromList(Set<Integer> numbers) {
        int minIndex = Integer.MAX_VALUE;
        for(int num: numbers){
           if(num < minIndex){
               minIndex = num;
           }
        }
        return minIndex;
    }
    private int getMaximumNumberFromList(Set<Integer> numbers) {
        int maxIndex = Integer.MIN_VALUE;
        for(int num: numbers){
            if(num > maxIndex){
                maxIndex = num;
            }
        }
        return maxIndex;
    }

}

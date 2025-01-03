import stanford.karel.SuperKarel;

import java.awt.*;

public class Homework extends SuperKarel {

    private int stepsCount, beepersLeft;
    private int[] dimensions;
    private int width, length, linesOnWidth, linesOnLength, verticalStartPosition, horizontalStartPosition;
    private int totalPeer;
    private int chamberSize, numOfChambers, specialCaseLines;
    private boolean lengthMoreThanWidth, horizontalDone;


    public void run() {
        initialize();
        handleCases();
        printStats();
    }

    private void initialize() {
        initializeKarel();
        findDims();
        necessaryCalculations();
    }

    private void initializeKarel() {
        beepersLeft = 1000;
        setBeepersInBag(beepersLeft);
        stepsCount = 0;
        dimensions = new int[2];
        horizontalDone = false;
    }

    private void findDims() {
        for (int i = 0; i <= 1; i++) {
            while (frontIsClear())
                stepForward();
            dimensions[i] = stepsCount + i + 1;
            turnLeft();
        }
        dimensions[1] = dimensions[1] - dimensions[0];
        width = dimensions[0];
        length = dimensions[1];
        if (length >= width) {
            lengthMoreThanWidth = true;
        }
    }

    private void necessaryCalculations() {
        if (length % 2 == 0) {
            linesOnLength = 2;
            horizontalStartPosition = (length / 2) - 1;
        } else {
            linesOnLength = 1;
            horizontalStartPosition = (length / 2);
        }
        if (width % 2 == 0) {
            linesOnWidth = 2;
        } else {
            linesOnWidth = 1;
        }
        verticalStartPosition = (width / 2);

    }

    private void handleCases() {
        if ((length == 1 && (width == 1 || width == 2)) || (width == 1 && (length == 1 || length == 2))) {
            System.out.println("No chambers can be created(just one chamber).");
        } else if (width > 2 && length > 2) {
            normalCase(linesOnWidth, length);
        } else if ((width == 2 && length > 1 && length <= 4) || (length == 2 && width > 1 && width <= 4)) {
            placeZigzag();
        } else if ((width == 2 && length > 4) || (length == 2 && width > 4)) {
            handleSpecialCase();
        } else if (length == 1 || width == 1) {
            handleSingleDimensionCase();
        }

    }


    private void normalCase(int numOfLines, int length) {
        moveStepsForward(verticalStartPosition);
        for (int i = 0; i < numOfLines; i++) {
            fillVerticalLine(length);
            turnLeft();
            moveStepsForward(1);
        }
    }

    private void fillVerticalLine(int numOfSteps) {
        placeBeeper();
        for (int i = 0; i < numOfSteps - 1; i++) {
            stepForward();
            placeBeeper();
            if (i == horizontalStartPosition - 1 && !horizontalDone) {
                fillHorizontalLine(width);
            }
        }
    }

    private void fillHorizontalLine(int width) {
        turnRight();
        fillLine();
        if (linesOnLength == 2 && linesOnWidth == 2) {
            turnLeft();
            move();
            turnLeft();
            fillLine((width / 2));
            turnLeft();
            stepForward();
            turnAround();
        } else if (linesOnLength == 1 && linesOnWidth == 2) {
            turnAround();
            moveStepsForward((width / 2) - 1);
            turnAround();
        } else if (linesOnLength == 2) {
            turnLeft();
            stepForward();
            turnLeft();
            fillLine();
            turnLeft();
            stepForward();
            turnLeft();
            fillLine((width / 2) + 1);
            turnLeft();
            horizontalDone = true;
        } else if (linesOnLength == 1) {
            turnLeft();
            turnLeft();
            fillLine();
            turnAround();
            moveStepsForward((width / 2));
            horizontalDone = true;
        }
    }

    private void placeZigzag() {
        int biggerDim = 0;
        if (lengthMoreThanWidth) {
            biggerDim = length;
            stepForward();
        } else {
            biggerDim = width;
            turnRight();
        }
        placeBeeper();
        for (int i = 0; i < biggerDim - 1; i++) {
            if (i % 2 == 0) {
                leftZigzag();
            } else {
                rightZigzag();
            }
        }
    }

    private void handleSpecialCase() {
        specialCaseCalculations();
        specialCaseTwo();
    }


    private void handleSingleDimensionCase() {
        specialCaseCalculations();
        if (lengthMoreThanWidth) {
            turnLeft();
        }
        for (int i = 0; i < numOfChambers - 1; i++) {
            moveStepsForward(chamberSize);
            turnRight();
            if (specialCaseLines == 1) {
                placeBeeper();
            } else {
                fillLine(2);
            }
            if (i != numOfChambers - 2) stepForward();
        }
    }

    private void specialCaseTwo() {
        if (lengthMoreThanWidth) {
            stepForward();
            turnLeft();
        }
        for (int i = 0; i < numOfChambers - 1; i++) {
            moveStepsForward(chamberSize);
            if (specialCaseLines == 1) {
                if(i%2==0){
                    fillLine();
                    turnRight();
                }else {
                    turnAround();
                    fillLine();
                    turnLeft();
                }
            } else {
                fillLine();
                turnRight();
                stepForward();
                turnRight();
                fillLine();
                turnLeft();
            }

            if (i != numOfChambers - 2) stepForward();
        }
    }


    private void specialCaseCalculations() {
        int biggerDim = 0;
        if (lengthMoreThanWidth) {
            biggerDim = length;
        } else {
            biggerDim = width;
        }
        for (int i = 4; i > 0; i--) {
            if ((biggerDim - (i - 1)) % i == 0 && (biggerDim - ((i - 1) * 2)) != 0) {
                chamberSize = (biggerDim - (i - 1)) / i;
                numOfChambers = i;
                specialCaseLines = 1;
                break;
            } else if ((biggerDim - i) % i == 0 && (biggerDim - ((i - 1) * 2)) != 0) {
                chamberSize = (biggerDim - (i)) / i;
                numOfChambers = i + 1;
                specialCaseLines = 1;
                break;
            } else if ((biggerDim - ((i - 1) * 2)) % i == 0 && (biggerDim - ((i - 1) * 2)) != 0) {
                chamberSize = (biggerDim - ((i - 1) * 2)) / i;
                numOfChambers = i;
                specialCaseLines = 2;
                break;
            } else if ((biggerDim - (i * 2)) % i == 0 && (biggerDim - ((i - 1) * 2)) != 0) {
                chamberSize = (biggerDim - (i * 2)) / i;
                numOfChambers = i + 1;
                specialCaseLines = 2;
            }
        }
    }

    private void printStats() {
        System.out.printf("Chamber size: %d x %d\n", width, length);
        System.out.println("Steps count: " + stepsCount);
        System.out.println("Beepers left: " + beepersLeft);
    }

    private void fillLine(int length) {
        placeBeeper();
        for (int i = 0; i < length - 1; i++) {
            stepForward();
            placeBeeper();
        }
    }

    private void fillLine() {
        placeBeeper();
        while (frontIsClear()) {
            stepForward();
            placeBeeper();
        }
    }


    private void moveStepsForward(int steps) {
        for (int i = 0; i < steps; i++) {
            stepForward();
        }
        turnLeft();
    }

    private void placeBeeper() {
        if (beepersPresent()) return;
        putBeeper();
        beepersLeft--;
    }

    private void stepForward() {
        move();
        stepsCount++;
    }

    private void rightZigzag() {
        turnRight();
        stepForward();
        turnRight();
        stepForward();
        placeBeeper();
    }

    private void leftZigzag() {
        turnLeft();
        stepForward();
        turnLeft();
        stepForward();
        placeBeeper();
    }
}





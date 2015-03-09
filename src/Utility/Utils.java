package Utility;

public class Utils {

    public static double getDistance(int xPosA, int yPosA, int xPosB, int yPosB) {

        return Math.sqrt(Math.pow((xPosA - xPosB), 2) + Math.pow((yPosA - yPosB), 2));

    }

}

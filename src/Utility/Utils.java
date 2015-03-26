package Utility;

import java.awt.Point;

public class Utils {

    public static double getDistance(int xPosA, int yPosA, int xPosB, int yPosB) {

        return Math.sqrt(Math.pow((xPosA - xPosB), 2) + Math.pow((yPosA - yPosB), 2));

    }
    
    public static double convertCritterHealthToDisplayWidth(double currentHealth, double maxHealth){
    	
    	if(currentHealth >= maxHealth) return Constants.STORE_BUTTON_SIZE;
    	else{
    		double ratio = currentHealth/maxHealth;
	    	double displayWidth = Constants.STORE_BUTTON_SIZE*ratio;
	    	
	    	return displayWidth;	
    	}
    }
    
    public static Point convertMapCoordToScreen(int xCoord, int yCoord){
    	Point screenPoint = new Point(Constants.MAP_INITIAL_XPOS + Constants.MAP_CELL_SIZE*xCoord,
    			Constants.MAP_INITIAL_YPOS + Constants.MAP_CELL_SIZE*yCoord);
    	
    	return screenPoint;
    }
    
    public static Point convertScreenToMapCoord(Point screenPoint){
    	Point pointInCellCoordinates = new Point((((int)screenPoint.getX() - Constants.MAP_INITIAL_XPOS)/Constants.MAP_CELL_SIZE), 
    			(((int) screenPoint.getY() - Constants.MAP_INITIAL_YPOS)/Constants.MAP_CELL_SIZE));
    	
    	return pointInCellCoordinates;
    }
    
    //(15, 100) corresponds to (0,0)
    //(15, 150) corresponds to (0,1)
    //(65, 150) corresponds to (1,1)
    //(115, 200) corresponds to (2,2)
}

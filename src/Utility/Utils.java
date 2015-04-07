package Utility;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * @author Jose, Xin, Justin
 *
 */
public class Utils {

    public static double getDistance(int xPosA, int yPosA, int xPosB, int yPosB) {

        return Math.sqrt(Math.pow((xPosA - xPosB), 2) + Math.pow((yPosA - yPosB), 2));

    }
    
    public static double getAngle(int xPosA, int yPosA, int xPosB, int yPosB) {
    	
    	Point tower = Utils.convertMapCoordToScreen(xPosA,
                yPosA);
    	double rads;
    	double angle = 0;

		rads = Math.atan2((double) (tower.getX()-xPosB),(double) tower.getY()-yPosB);
		angle = Math.toDegrees(rads);

	    if(angle<0){
	    		angle = Math.abs(angle);
	    }
	    else{
	    	angle = 360 - angle;
	    }

		return angle;
    }

    public static double convertCritterHealthToDisplayWidth(double currentHealth, double maxHealth) {

        if (currentHealth >= maxHealth)
            return Constants.STORE_BUTTON_SIZE;
        else {
            double ratio = currentHealth / maxHealth;
            double displayWidth = Constants.STORE_BUTTON_SIZE * ratio;

            return displayWidth;
        }
    }

    public static Point convertMapCoordToScreen(int xCoord, int yCoord) {
        Point screenPoint =
                new Point(Constants.MAP_INITIAL_XPOS + Constants.MAP_CELL_SIZE * xCoord,
                        Constants.MAP_INITIAL_YPOS + Constants.MAP_CELL_SIZE * yCoord);

        return screenPoint;
    }
    
    
    // (15, 100) corresponds to (0,0)
    // (15, 150) corresponds to (0,1)
    // (65, 150) corresponds to (1,1)
    // (115, 200) corresponds to (2,2)
    public static Point convertScreenToMapCoord(Point screenPoint) {
        Point pointInCellCoordinates =
                new Point(
                        (((int) screenPoint.getX() - Constants.MAP_INITIAL_XPOS) / Constants.MAP_CELL_SIZE),
                        (((int) screenPoint.getY() - Constants.MAP_INITIAL_YPOS) / Constants.MAP_CELL_SIZE));

        return pointInCellCoordinates;
    }

    public static void playSound(String soundName, int loop) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            // Shouldn't be hit
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException e) {
        }
        // loop = 0 means no repetition
        clip.loop(loop);
        clip.start();
    }
}

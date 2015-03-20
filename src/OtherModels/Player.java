package OtherModels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import Utility.Constants;

/**
 * 
 * Singleton Player class
 * 
 * @author Jose
 *
 */
public class Player {

    private static Player uniqueInstance = null;

    private int lifePoints;

    // TODO need to be brought to presentation layer
    private int iconXPos = 700;
    private int iconYPos = 35;
    public Rectangle lifeIcon;

    private Player() {
        this.lifePoints = Constants.INITIAL_PLAYER_LIFE_POINTS;

        // TODO need to be brought to presentation layer
        lifeIcon =
                new Rectangle(iconXPos, iconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);
    }

    public static synchronized Player getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Player();
        }
        return uniqueInstance;
    }

    /**
     * 
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(lifeIcon.x, lifeIcon.y, lifeIcon.width, lifeIcon.height);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(255, 255, 255));
        g.drawString("" + lifePoints, iconXPos + lifeIcon.width + Constants.SPACING, iconYPos
                + Constants.STORE_BUTTON_SIZE / 2 + Constants.DISPLAY_SIZE / 4 - 1);
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

}
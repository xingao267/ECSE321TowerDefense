package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import OtherModels.Bank;
import OtherModels.Player;
import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class IconDisplay {

    private Rectangle moneyIcon;
    private Rectangle lifeIcon;

    private int iconXPos = 315;
    private int moneyIconYPos = 8;
    private int lifeIconYPos = 45;
    private BufferedImage moneyImage, lifeImage;


    public IconDisplay() {

    	try {
			moneyImage = ImageIO.read(new File(Constants.MONEY_IMAGE));
			lifeImage = ImageIO.read(new File(Constants.LIFE_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        moneyIcon =
                new Rectangle(iconXPos, moneyIconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);

        lifeIcon =
                new Rectangle(iconXPos, lifeIconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);
    }

    public void draw(Graphics g) {

        g.setColor(new Color(255, 215, 0));
        g.drawImage(moneyImage, moneyIcon.x, moneyIcon.y, moneyIcon.width, moneyIcon.height, null);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(255, 215, 0));
        g.drawString("" + Bank.getUniqueInstance().getBalance(), iconXPos + moneyIcon.width
                + Constants.SPACING, moneyIconYPos + Constants.STORE_BUTTON_SIZE / 2
                + Constants.DISPLAY_SIZE / 4 - 1);

        g.setColor(new Color(255, 0, 0));
        g.drawImage(lifeImage, lifeIcon.x, lifeIcon.y, lifeIcon.width, lifeIcon.height, null);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(255, 0, 0));
        g.drawString("" + Player.getUniqueInstance().getLifePoints(), iconXPos + lifeIcon.width
                + Constants.SPACING, lifeIconYPos + Constants.STORE_BUTTON_SIZE / 2
                + Constants.DISPLAY_SIZE / 4 - 1);
    }
}

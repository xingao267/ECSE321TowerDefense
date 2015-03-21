package OtherModels;

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
    

    private Player() {
        this.lifePoints = Constants.INITIAL_PLAYER_LIFE_POINTS;
    }

    public static synchronized Player getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Player();
        }
        return uniqueInstance;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

}

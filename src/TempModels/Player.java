package TempModels;

import Utility.Constants;

public class Player {

	public static int lifePoints;

	public Player() {
		this.lifePoints = Constants.INITIAL_PLAYER_LIFE_POINTS;
	}

	public static int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
}

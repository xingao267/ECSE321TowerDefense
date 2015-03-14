package TempModels;

public class Player {
	
	public static int lifePoints = 100;
	
	public Player(){
		
	}
	
	public static int getLifePoints(){
		return lifePoints;
	}
	
	public void setLifePoints(int lifePoints){
		this.lifePoints = lifePoints;
	}
}

package CritterModels;

import TempModels.Cell;

public class RegenerativeCritter extends Critter {

	private String type = "Regenerative Critter";
	private double speed = 0.5;
	private int bounty = 2;
	private int strength = 1;
	private boolean isBeingHit = false;
	
	private Cell location;
	private int xPos, yPos;
	private int maxHealthPoints;
	private int healthPoints;
	
	/**
	 * Constructor of the RegenerativeCritter class
	 * @param level		Level at which the critter is being spawned
	 */
	public RegenerativeCritter(int level){
		super();
		if(level > 5){
			this.bounty += (level/5)*this.bounty;
		}
		this.healthPoints = 15*level*level + 5*level + 80;
		this.maxHealthPoints = this.healthPoints;
		
		if(!isBeingHit){												//will need to be added into game loop
			regenerate(level);
		}
	}
	
	
	/**
	 * Regenerates the a certain amount of health points every seconds that the critter is not being hit, depending on the game level.
	 * @param level	Level at which the game is currently at.
	 */
	public void regenerate(int level){								//regenerates a certain amount of health every certain interval of time
		long lastExecutionTime = 0;									//only begins regenerating after critter has been spawned
		int regenerativeAmount = 40 + 8*level + 2*level*level;
		if(System.currentTimeMillis() - lastExecutionTime >= 0){
			if(healthPoints + regenerativeAmount > maxHealthPoints)
				healthPoints = maxHealthPoints;
			else
				healthPoints += regenerativeAmount;
			
			lastExecutionTime = System.currentTimeMillis();
		}
	}
	
		
	
	public String getType() {
		return type;
	}

	public double getSpeed(){
		return speed;
	}
	
	public int getBounty(){
		return bounty;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getHealthPoints(){
		return healthPoints;
	}
	
	public Cell getLocation(){
		return location;
	}
	
	public boolean isBeingHit() {
		return isBeingHit;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setBounty(int bounty){
		this.bounty = bounty;
	}
	
	public void setStrength(int strength){
		this.strength = strength;
	}
	
	public void setHealthPoints(int healthPoints){
		this.healthPoints = healthPoints;
	}

	public void setBeingHit(boolean isBeingHit) {
		this.isBeingHit = isBeingHit;
	}


    public int getXPos() {
        return xPos;
    }


    public void setXPos(int xPos) {
        this.xPos = xPos;
    }


    public int getYPos() {
        return yPos;
    }


    public void setYPos(int yPos) {
        this.yPos = yPos;
    }
	
}

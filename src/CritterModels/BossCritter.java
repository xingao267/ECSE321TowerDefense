package CritterModels;

import TempModels.Cell;

public class BossCritter extends Critter{

	private String type = "Boss Critter";
	private int strength = 5;
	private boolean isBeingHit = false;
	
	private Cell location;
	private int xPos, yPos;
	private double speed;							//from 0-1
	private int bounty;
	private int healthPoints;
	
	/**
	 * Constructor of the BossCritter class
	 * @param level		Level at which the critter is being spawned
	 */
	public BossCritter(double speed, int bounty, int healthPoints){
		super();
		this.speed = speed;
		this.bounty = bounty;
		this.healthPoints = healthPoints;
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
	
	public void setType(String type) {
		this.type = type;
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
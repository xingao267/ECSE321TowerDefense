package CritterModels;

import TempModels.Cell;

public class NormalCritter extends Critter {
	
	private String type = "Normal Critter";
	private double speed = 0.5;							//from 0-1
	private int bounty = 2;
	private int strength = 1;
	private boolean isBeingHit = false;
	
	private Cell location;
	private int xPos, yPos;
	private int healthPoints;
    
	
	/**
	 * Constructor of the NormalCritter class
	 * @param level		Level at which the critter is being spawned
	 */
	public NormalCritter(int level){
		super();
		if(level > 5){
			this.bounty += (level/5)*this.bounty;
		}
		this.healthPoints = 15*level*level + 5*level + 80;
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
		this.isBeingHit  = isBeingHit;
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

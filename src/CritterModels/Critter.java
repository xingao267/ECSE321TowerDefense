package CritterModels;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import Map.Cell;
import Utility.Utils;

/**
 * Generic base class Critter data model
 *
 * @author Jose
 *
 */
public abstract class Critter extends Rectangle {

    /** speed of critter. Range from 0 to 1 */
    protected double speed;

    /** speed of critter. */
    protected double health;

    /** bounty awarded of killing a critter. */
    protected int bounty;

    /** strength of critter. */
    protected int strength;

    /** if critter is being hit. */
    protected boolean isBeingHit;

    /** if critter is slowed. */
    protected boolean isSlowed;

    /** level of critter. */
    protected int level;

    /** x position of critter. */
    protected int xPos;
    protected int screenXPos;

    /** y position of critter. */
    protected int yPos;
    protected int screenYPos; 
    
    /** whether critter is in the game or not */
    protected boolean inGame = false;

    public Critter(int level) {

        this.level = level;
//        this.xPos = xPos;
//        this.yPos = yPos;
        this.isBeingHit = false;
    }

    /**
     * Returns whether the critter is dead or not
     * 
     * @return boolean value representing whether the critter is dead or not
     */
    public boolean isDead() {
        return (health <= 0);
    }

    /**
     * Sets the location and the X and Y position of the critter to be the position of the entry
     * point Cell of the Path
     * 
     * @param entryPoint First Cell on the Path
     */
    public void spawn(Cell entryPoint) {
        Point screenEntryPoint = Utils.convertMapCoordToScreen(entryPoint.getXCoordinate(), 
        		entryPoint.getYCoordinate());
        
    	xPos = entryPoint.getXCoordinate();
        yPos = entryPoint.getYCoordinate();
        screenXPos = (int) screenEntryPoint.getX();
        screenYPos = (int) screenEntryPoint.getY();
        
        inGame = true;
        
        System.out.println("critter spawned");
    }
    
    /**
     * Moves a critter at a certain speed to the next cell location
     * 
     * @param nextXPos X position of the next cell
     * @param nextYPos Y position of the next cell
     * @param speed Speed at which critter will move to the next cell
     */
    public void move(double speed) {
        // physics of critter movement
    	screenXPos++;
    	
/*    	Point nextScreenPoint = Utils.convertMapCoordToScreen(nextCell.getXCoordinate(), 
        		nextCell.getYCoordinate());
    	
        setxPos(nextCell.getXCoordinate());
        setyPos(nextCell.getYCoordinate());
        
        setScreenXPos((int) nextScreenPoint.getX());
        setScreenYPos((int) nextScreenPoint.getY());
 */   }
    
    public void draw(Graphics g){
    	if(inGame){
    		g.fillRect(x, y, width, height);
    	}
    }

    public void setLocation(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * @return the bounty
     */
    public int getBounty() {
        return bounty;
    }

    /**
     * @param bounty the bounty to set
     */
    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the isBeingHit
     */
    public boolean isBeingHit() {
        return isBeingHit;
    }

    /**
     * @param isBeingHit the isBeingHit to set
     */
    public void setBeingHit(boolean isBeingHit) {
        this.isBeingHit = isBeingHit;
    }

    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the isSlowed
     */
    public boolean isSlowed() {
        return isSlowed;
    }

    /**
     * @param isSlowed the isSlowed to set
     */
    public void setSlowed(boolean isSlowed) {
        this.isSlowed = isSlowed;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public int getScreenXPos() {
		return screenXPos;
	}

	public void setScreenXPos(int screenXPos) {
		this.screenXPos = screenXPos;
	}

	public int getScreenYPos() {
		return screenYPos;
	}

	public void setScreenYPos(int screenYPos) {
		this.screenYPos = screenYPos;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	/*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Critter [speed=" + speed + ", health=" + health + ", bounty=" + bounty
                + ", strength=" + strength + ", isBeingHit=" + isBeingHit + ", isSlowed="
                + isSlowed + ", level=" + level + ", xPos=" + xPos + ", yPos=" + yPos + "]";
    }

}

package CritterModels;


import java.awt.Point;
import java.awt.image.BufferedImage;

import Map.Cell;
import OtherModels.Player;
import Utility.Constants;
import Utility.Utils;
import Window.Screen;

/**
 * Generic base class Critter data model
 *
 * @author Jose
 *
 */
public abstract class Critter {

    /** Critter type */
    protected String critterType;

    /** speed of critter. Range from 0 to 1 */
    protected double initialSpeed;
    protected double speed;

    /** health of critter. */
    protected double health;
    protected double maxHealth;

    /** bounty awarded for killing a critter. */
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

    /** Spawn Rate of critter */
    protected int spawnRate;

    /** whether critter is in the game or not */
    protected boolean inGame = false;

    /** whether critter has reached the exit point */
    public boolean reachedExit = false;

    /** critter movement variables */
    protected int up = 0, down = 1, right = 2, left = 3;
    protected int direction = right;
    protected int walkFrame = 0;
    protected int screenDistanceMoved = 0;
    protected int distanceMovedWhileSlowed = 0;
    protected boolean hasMovedUp = false, hasMovedDown = false, hasMovedRight = false,
            hasMovedLeft = false;

    /** Contains the sprite sheet associated with the critter */
    protected BufferedImage img;
    protected BufferedImage slowImg;


    public Critter(int level) {

        this.level = level;
        this.isBeingHit = false;
        this.isSlowed = false;
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
        Point screenEntryPoint =
                Utils.convertMapCoordToScreen(entryPoint.getXCoordinate(),
                        entryPoint.getYCoordinate());

        xPos = entryPoint.getXCoordinate();
        yPos = entryPoint.getYCoordinate();
        screenXPos = (int) screenEntryPoint.getX();
        screenYPos = (int) screenEntryPoint.getY();

        inGame = true;
    }

    /**
     * Moves a critter at a certain speed to the next cell location
     * 
     * @param nextXPos X position of the next cell
     * @param nextYPos Y position of the next cell
     * @param speed Speed at which critter will move to the next cell
     */
    public void moveAlongPath(double speed, Player player) {
        // physics of critter movement

        if (walkFrame >= 11 - speed) {
            if(isSlowed){
	        	if (direction == right) {
	                screenXPos++;
	            } else if (direction == left) {
	                screenXPos--;
	            } else if (direction == up) {
	                screenYPos--;
	            } else if (direction == down) {
	                screenYPos++;
	            }
	
	            screenDistanceMoved++;
	            distanceMovedWhileSlowed++;
	            
	            if (screenDistanceMoved == Constants.MAP_CELL_SIZE) {
	                if (direction == right) {
	                    xPos++;
	                    hasMovedRight = true;
	                } else if (direction == left) {
	                    xPos--;
	                    hasMovedLeft = true;
	                } else if (direction == up) {
	                    yPos--;
	                    hasMovedUp = true;
	                } else if (direction == down) {
	                    yPos++;
	                    hasMovedDown = true;
	                }
	
	                if (!hasMovedLeft) {
	                    try {
	                        if (!Screen.map.getCell(xPos + 1, yPos).isScenery()) {
	                            direction = right;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedRight) {
	                    try {
	                        if (!Screen.map.getCell(xPos - 1, yPos).isScenery()) {
	                            direction = left;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedDown) {
	                    try {
	                        if (!Screen.map.getCell(xPos, yPos - 1).isScenery()) {
	                            direction = up;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedUp) {
	                    try {
	                        if (!Screen.map.getCell(xPos, yPos + 1).isScenery()) {
	                            direction = down;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	                try {
	                    if (Screen.map.getCell(xPos, yPos).isExit()) {
	                        reachedExit = true;
	                        removeCritter();
	                        loseLife(player);
	                    }
	                } catch (Exception e) {
	                }
	
	                hasMovedUp = false;
	                hasMovedDown = false;
	                hasMovedRight = false;
	                hasMovedLeft = false;
	                screenDistanceMoved = 0;
	                
	            }
	            
	            if(distanceMovedWhileSlowed == 2*Constants.MAP_CELL_SIZE){
	            	setSlowed(false);
	            	setSpeed(initialSpeed);
	            	distanceMovedWhileSlowed = 0;
	            }
            }
            else{
            	if (direction == right) {
	                screenXPos++;
	            } else if (direction == left) {
	                screenXPos--;
	            } else if (direction == up) {
	                screenYPos--;
	            } else if (direction == down) {
	                screenYPos++;
	            }
	
	            screenDistanceMoved++;
	            
	            if (screenDistanceMoved == Constants.MAP_CELL_SIZE) {
	                if (direction == right) {
	                    xPos++;
	                    hasMovedRight = true;
	                } else if (direction == left) {
	                    xPos--;
	                    hasMovedLeft = true;
	                } else if (direction == up) {
	                    yPos--;
	                    hasMovedUp = true;
	                } else if (direction == down) {
	                    yPos++;
	                    hasMovedDown = true;
	                }
	
	                if (!hasMovedLeft) {
	                    try {
	                        if (!Screen.map.getCell(xPos + 1, yPos).isScenery()) {
	                            direction = right;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedRight) {
	                    try {
	                        if (!Screen.map.getCell(xPos - 1, yPos).isScenery()) {
	                            direction = left;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedDown) {
	                    try {
	                        if (!Screen.map.getCell(xPos, yPos - 1).isScenery()) {
	                            direction = up;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	
	                if (!hasMovedUp) {
	                    try {
	                        if (!Screen.map.getCell(xPos, yPos + 1).isScenery()) {
	                            direction = down;
	                        }
	                    } catch (Exception e) {
	                    }
	                }
	                try {
	                    if (Screen.map.getCell(xPos, yPos).isExit()) {
	                        reachedExit = true;
	                        removeCritter();
	                        loseLife(player);
	                    }
	                } catch (Exception e) {
	                }
	
	                hasMovedUp = false;
	                hasMovedDown = false;
	                hasMovedRight = false;
	                hasMovedLeft = false;
	                screenDistanceMoved = 0;
	            }
            }

            walkFrame = 0;
        } else {
            walkFrame++;
        }
    }

    public void removeCritter() {
        inGame = false;
    }

    public void loseLife(Player player) {
        if(player.getLifePoints() - strength < 0){
        	player.setLifePoints(0);	
        }
        else{
        	player.setLifePoints(player.getLifePoints() - strength);
        }
    }

    public String getCritterType() {
        return critterType;
    }

    public void setCritterType(String critterType) {
        this.critterType = critterType;
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
     * @return the max health
     */
    public double getMaxHealth() {
        return maxHealth;
    }

    /**
     * @param health the max health to set
     */
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
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

    public int getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean hasReachedExit() {
        return reachedExit;
    }

    public void setReachedExit(boolean reachedExit) {
        this.reachedExit = reachedExit;
    }

    public BufferedImage getImage() {
        if (isSlowed()) {
            return this.slowImg;
        } else {
            return this.img;
        }
    }

    public int getDirection() {
        return this.direction;
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

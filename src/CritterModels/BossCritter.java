package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class BossCritter extends Critter {

    /**
     * Constructor of the BossCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public BossCritter(String critterType, int speed, int bounty, int health) {
        super(Constants.MAX_CRITTER_LEVEL);

        if(critterType.equals(Constants.ARMORED_CRITTER_TYPE)){
        	this.spawnRate = Constants.ARMORED_CRITTER_SPAWN_RATE;
        }
        else if(critterType.equals(Constants.BULLET_PROOF_CRITTER_TYPE)){
        	this.spawnRate = Constants.BULLET_PROOF_CRITTER_SPAWN_RATE;
        }
        else if(critterType.equals(Constants.NORMAL_CRITTER_TYPE)){
        	this.spawnRate = Constants.NORMAL_CRITTER_SPAWN_RATE;
        }
        else if(critterType.equals(Constants.REGENERATIVE_CRITTER_TYPE)){
        	this.spawnRate = Constants.REGENERATIVE_CRITTER_SPAWN_RATE;
        }
        else if(critterType.equals(Constants.SPEED_CRITTER_TYPE)){
        	this.spawnRate = Constants.SPEED_CRITTER_SPAWN_RATE;
        }
        
        this.strength = Constants.BOSS_CRITTER_STRENGTH;
        this.speed = speed;
        this.bounty = bounty;
        this.health = health;
        this.maxHealth = health;
        try {
			this.img= ImageIO.read(new File(Constants.TANK_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}

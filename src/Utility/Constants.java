package Utility;


/**
 * Constants
 *
 * @author Xin
 *
 */
public class Constants {

    /** Initial Player life points. */
    public static final int INITIAL_PLAYER_LIFE_POINTS = 100;

    /** Life points display constants. */
    public static final int DISPLAY_SIZE = 30;
    public static final int SPACING = 5;

    /** Store display constants */
    public static final int STORE_BUTTON_SIZE = 50;
    public static final int STORE_SPACING = 8;
    public static final int STORE_OFFSET = 15;
    public static final int STORE_YPOS = 15;
    public static final int NUM_TOWERS = 5;

    /** Main Menu Button Contants */
    public static final int MAIN_MENU_XPOS = 670;
    public static final int MAIN_MENU_YPOS = 10;

    /** Map display constants */
    public static final int MAP_INITIAL_XPOS = 20;
    public static final int MAP_INITIAL_YPOS = 110;
    public static final int MAP_CELL_SIZE = STORE_BUTTON_SIZE;

    /** KeyHandler constants */
    public static final int KEYHANDLER_OFFSET = 11;

    /** Save Button Constant */
    public static final int SAVE_BUTTON_YPOS = 40;

    /** Send Next Wave Button Constant */
    public static final int SEND_NEXT_WANVE_YPOS = 45;

    /** Initial Bank balance. */
    public static final int INITIAL_BANK_BALANCE = 30;

    /** Game thread sleep time */
    public static final int GAME_THREAD_SLEEP_TIME = 10;

    /*--------------------------------------------------------------------------------------------------------------------*/

    public static final String MONEY_IMAGE = "source/image/money.png";

    public static final String LIFE_IMAGE = "source/image/life.png";

    public static final String REGULAR_TOWER_IMAGE = "source/image/regular_tower.png";

    public static final String BOMBER_TOWER_IMAGE = "source/image/bomber_tower.png";

    public static final String SPEED_TOWER_IMAGE = "source/image/speed_tower.png";

    public static final String DECELERATOR_TOWER_IMAGE = "source/image/decelerator_tower.png";

    public static final String LONGRANGE_TOWER_IMAGE = "source/image/longrange_tower.png";

    public static final String[] TOWER_IMAGE_SET = {REGULAR_TOWER_IMAGE, BOMBER_TOWER_IMAGE,
            DECELERATOR_TOWER_IMAGE, LONGRANGE_TOWER_IMAGE, SPEED_TOWER_IMAGE};

    /*--------------------------------------------------------------------------------------------------------------------*/
    public static final String CAR_IMAGE = "source/image/critters/car.png";
    public static final String SLOW_CAR_IMAGE = "source/image/critters/car_slow.png";
   
    public static final String FASTCAR_IMAGE = "source/image/critters/fastcar.png";
    public static final String SLOW_FASTCAR_IMAGE = "source/image/critters/fastcar_slow.png";
    
    public static final String PICKUP_IMAGE = "source/image/critters/pickup.png";
    public static final String SLOW_PICKUP_IMAGE = "source/image/critters/pickup_slow.png";

    public static final String VAN_IMAGE = "source/image/critters/van.png";
    public static final String SLOW_VAN_IMAGE = "source/image/critters/van_slow.png";

    public static final String TRUCK_IMAGE = "source/image/critters/truck.png";
    public static final String SLOW_TRUCK_IMAGE = "source/image/critters/truck_slow.png";

    public static final String TANK_IMAGE = "source/image/critters/tank.png";
    public static final String SLOW_TANK_IMAGE = "source/image/critters/tank_slow.png";

    /*--------------------------------------------------------------------------------------------------------------------*/
    public static final String SCENERY_IMAGE = "source/image/scenery.png";
    /*--------------------------------------------------------------------------------------------------------------------*/
    public static final String MAIN_MENU_IMAGE = "source/image/main_menu.png";
    /*--------------------------------------------------------------------------------------------------------------------*/

    public static final String CLICK_ONE_SOUND = "source/sound/click_one.wav";

    public static final String GAME_START = "source/sound/the_dawn.wav";

    public static final String NEXT_WAVE = "source/sound/car_ignition.wav";

    public static final String CONSTRUCTION = "source/sound/construction.wav";

    /*--------------------------------------------------------------------------------------------------------------------*/

    public static final double RT_2 = Math.sqrt(2);

    /** Initial Tower Level. */
    public static final int INITIAL_TOWER_LEVEL = 1;

    /** Max Tower Level. */
    public static final int MAX_TOWER_LEVEL = 5;

    /** Regular Tower Constants. */
    public static final String REGULAR_TOWER_TYPE = "Regular Tower";

    public static final int REGULAR_INITIAL_COST = 10;

    public static final int[] REGULAR_UPGRADE_COST = {0, 0, 15, 25, 45, 70, Integer.MAX_VALUE};
    public static final double[] REGULAR_REFUND_VALUE =
            {
                    0,
                    0.8 * REGULAR_INITIAL_COST,
                    0.8 * (REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2]),
                    0.8 * (REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3]),
                    0.8 * (REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3] + REGULAR_UPGRADE_COST[4]),
                    0.8 * (REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3]
                            + REGULAR_UPGRADE_COST[4] + REGULAR_UPGRADE_COST[5])};
    public static final double[] REGULAR_RANGE = {0, 1 * RT_2, 1 * RT_2, 2 * RT_2, 2 * RT_2,
            3 * RT_2};
    public static final double[] REGULAR_RATE = {0, 4, 5, 6, 7, 8};

    public static final double[] REGULAR_DAMAGE_PER_HIT = {0, 20, 35, 60, 100, 170};
    public static final double[] REGULAR_POWER = {
            REGULAR_DAMAGE_PER_HIT[0] * REGULAR_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[1] * REGULAR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[2] * REGULAR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[3] * REGULAR_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[4] * REGULAR_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[5] * REGULAR_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    /** Long Range Tower Constants. */
    public static final String LONGRANGE_TOWER_TYPE = "Long Range Tower";

    public static final int LONGRANGE_INITIAL_COST = 100;

    public static final int[] LONGRANGE_UPGRADE_COST =
            {0, 0, 115, 175, 260, 365, Integer.MAX_VALUE};
    public static final double[] LONGRANGE_REFUND_VALUE =
            {
                    0,
                    0.8 * LONGRANGE_INITIAL_COST,
                    0.8 * (LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2]),
                    0.8 * (LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2] + LONGRANGE_UPGRADE_COST[3]),
                    0.8 * (LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2]
                            + LONGRANGE_UPGRADE_COST[3] + LONGRANGE_UPGRADE_COST[4]),
                    0.8 * (LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2]
                            + LONGRANGE_UPGRADE_COST[3] + LONGRANGE_UPGRADE_COST[4] + LONGRANGE_UPGRADE_COST[5])};
    public static final double[] LONGRANGE_RANGE = {0, 3 * RT_2, 6 * RT_2, 9 * RT_2, 12 * RT_2,
            15 * RT_2};
    public static final double[] LONGRANGE_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] LONGRANGE_DAMAGE_PER_HIT = {0, 250, 300, 400, 600, 1000};
    public static final double[] LONGRANGE_POWER = {
            LONGRANGE_DAMAGE_PER_HIT[0] * LONGRANGE_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[1] * LONGRANGE_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[2] * LONGRANGE_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[3] * LONGRANGE_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[4] * LONGRANGE_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[5] * LONGRANGE_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    /** Speed Tower Constants. */
    public static final String SPEED_TOWER_TYPE = "Speed Tower";

    public static final int SPEED_INITIAL_COST = 200;

    public static final int[] SPEED_UPGRADE_COST = {0, 0, 250, 350, 500, 750, Integer.MAX_VALUE};
    public static final double[] SPEED_REFUND_VALUE =
            {
                    0,
                    0.8 * SPEED_INITIAL_COST,
                    0.8 * (SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2]),
                    0.8 * (SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3]),
                    0.8 * (SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3] + SPEED_UPGRADE_COST[4]),
                    0.8 * (SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3]
                            + SPEED_UPGRADE_COST[4] + SPEED_UPGRADE_COST[5])};
    public static final double[] SPEED_RANGE =
            {0, 1 * RT_2, 1 * RT_2, 2 * RT_2, 2 * RT_2, 3 * RT_2};
    public static final double[] SPEED_RATE = {0, 5, 7, 9, 11, 13};

    public static final double[] SPEED_DAMAGE_PER_HIT = {0, 100, 150, 220, 300, 400};
    public static final double[] SPEED_POWER = {
            SPEED_DAMAGE_PER_HIT[0] * SPEED_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            SPEED_DAMAGE_PER_HIT[1] * SPEED_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            SPEED_DAMAGE_PER_HIT[2] * SPEED_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            SPEED_DAMAGE_PER_HIT[3] * SPEED_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            SPEED_DAMAGE_PER_HIT[4] * SPEED_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            SPEED_DAMAGE_PER_HIT[5] * SPEED_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    /** Bomber Tower Constants. */
    public static final String BOMBER_TOWER_TYPE = "Bomber Tower";

    public static final int BOMBER_INITIAL_COST = 20;

    public static final int[] BOMBER_UPGRADE_COST = {0, 0, 15, 25, 45, 80, Integer.MAX_VALUE};
    public static final double[] BOMBER_REFUND_VALUE =
            {
                    0,
                    0.8 * BOMBER_INITIAL_COST,
                    0.8 * (BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2]),
                    0.8 * (BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3]),
                    0.8 * (BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3] + BOMBER_UPGRADE_COST[4]),
                    0.8 * (BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3]
                            + BOMBER_UPGRADE_COST[4] + BOMBER_UPGRADE_COST[5])};
    public static final double[] BOMBER_RANGE = {0, 1 * RT_2, 2 * RT_2, 2 * RT_2, 3 * RT_2,
            4 * RT_2};
    public static final double[] BOMBER_RATE = {0, 2, 3, 4, 5, 6};

    public static final double[] BOMBER_DAMAGE_PER_HIT = {0, 28, 39, 54, 75, 105};
    public static final double[] BOMBER_POWER = {
            BOMBER_DAMAGE_PER_HIT[0] * BOMBER_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[1] * BOMBER_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[2] * BOMBER_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[3] * BOMBER_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[4] * BOMBER_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[5] * BOMBER_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    public static final double[] BOMBER_EFFECT_RANGE = {0, 1, 2, 3, 4, 5};

    /** Decelerator Tower Constants. */
    public static final String DECELERATOR_TOWER_TYPE = "Frost Tower";

    public static final int DECELERATOR_INITIAL_COST = 50;

    public static final int[] DECELERATOR_UPGRADE_COST = {0, 0, 75, 120, 170, 230,
            Integer.MAX_VALUE};
    public static final double[] DECELERATOR_REFUND_VALUE =
            {
                    0,
                    0.8 * DECELERATOR_INITIAL_COST,
                    0.8 * (DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2]),
                    0.8 * (DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2] + DECELERATOR_UPGRADE_COST[3]),
                    0.8 * (DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2]
                            + DECELERATOR_UPGRADE_COST[3] + DECELERATOR_UPGRADE_COST[4]),
                    0.8 * (DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2]
                            + DECELERATOR_UPGRADE_COST[3] + DECELERATOR_UPGRADE_COST[4] + DECELERATOR_UPGRADE_COST[5])};
    public static final double[] DECELERATOR_RANGE = {0, 1 * RT_2, 2 * RT_2, 3 * RT_2, 4 * RT_2,
            5 * RT_2};
    public static final double[] DECELERATOR_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] DECELERATOR_DAMAGE_PER_HIT = {0, 0, 0, 0, 0, 0};
    public static final double[] DECELERATOR_POWER = {
            DECELERATOR_DAMAGE_PER_HIT[0] * DECELERATOR_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[1] * DECELERATOR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[2] * DECELERATOR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[3] * DECELERATOR_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[4] * DECELERATOR_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[5] * DECELERATOR_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    public static final double[] DECELERATOR_EFFECT = {0, .35, .4, 0.45, 0.5, 0.6};
    public static final double[] DECELERATOR_EFFECT_RANGE = {0, 1, 2, 3, 4, 5};

    /*--------------------------------------------------------------------------------------------------------------------*/

    /** Maximum Critter Level */
    public static final int MAX_CRITTER_LEVEL = 20;

    /** Armored Critter Constants. */
    public static final String ARMORED_CRITTER_TYPE = "Armored Critter";
    public static final int ARMORED_CRITTER_SPEED = 4;
    public static final int ARMORED_CRITTER_BOUNTY = 4;
    public static final int ARMORED_CRITTER_STRENGTH = 2;
    public static final int ARMORED_CRITTER_SPAWN_RATE = 250;

    /** Boss Critter Constants. */
    public static final int BOSS_CRITTER_STRENGTH = 5;

    /** Bullet Proof Critter Constants. */
    public static final String BULLET_PROOF_CRITTER_TYPE = "BulletProof Critter";
    public static final int BULLET_PROOF_CRITTER_SPEED = 3;
    public static final int BULLET_PROOF_CRITTER_BOUNTY = 4;
    public static final int BULLET_PROOF_CRITTER_STRENGTH = 2;
    public static final int BULLET_PROOF_CRITTER_SPAWN_RATE = 300;

    /** Normal Critter Constants. */
    public static final String NORMAL_CRITTER_TYPE = "Normal Critter";
    public static final int NORMAL_CRITTER_SPEED = 5;
    public static final int NORMAL_CRITTER_BOUNTY = 4;
    public static final int NORMAL_CRITTER_STRENGTH = 2;
    public static final int NORMAL_CRITTER_SPAWN_RATE = 300;

    /** Speed Critter Constants. */
    public static final String SPEED_CRITTER_TYPE = "Speed Critter";
    public static final int SPEED_CRITTER_SPEED = 9;
    public static final int SPEED_CRITTER_BOUNTY = 4;
    public static final int SPEED_CRITTER_STRENGTH = 2;
    public static final int SPEED_CRITTER_SPAWN_RATE = 100;

    /** Regenerative Critter Constants. */
    public static final String REGENERATIVE_CRITTER_TYPE = "Regenerative Critter";
    public static final int REGENERATIVE_CRITTER_SPEED = 6;
    public static final int REGENERATIVE_CRITTER_BOUNTY = 4;
    public static final int REGENERATIVE_CRITTER_STRENGTH = 2;
    public static final int REGENERATIVE_CRITTER_SPAWN_RATE = 300;

}

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
    public static final int MAP_INITIAL_YPOS = 100;
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

    // TODO actual url to be changed later
    public static final String REGULAR_TOWER_IMAGE = "source/image/regular_tower.png";

    public static final String BOMBER_TOWER_IMAGE = "source/image/bomber_tower.png";

    public static final String SPEED_TOWER_IMAGE = "source/image/speed_tower.png";

    public static final String DECELERATOR_TOWER_IMAGE = "source/image/decelerator_tower.png";

    public static final String LONGRANGE_TOWER_IMAGE = "source/image/longrange_tower.png";

    public static final String[] TOWER_IMAGE_SET = {REGULAR_TOWER_IMAGE, BOMBER_TOWER_IMAGE,
            SPEED_TOWER_IMAGE, DECELERATOR_TOWER_IMAGE, LONGRANGE_TOWER_IMAGE};

    /*--------------------------------------------------------------------------------------------------------------------*/

    /** Initial Tower Level. */
    public static final int INITIAL_TOWER_LEVEL = 1;

    /** Max Tower Level. */
    public static final int MAX_TOWER_LEVEL = 5;

    /** Regular Tower Constants. */
    public static final String REGULAR_TOWER_TYPE = "Regular Tower";

    public static final int REGULAR_INITIAL_COST = 10;

    public static final int[] REGULAR_UPGRADE_COST = {0, 0, 10, 15, 25, 45, Integer.MAX_VALUE};
    public static final int[] REGULAR_REFUND_VALUE = {
            0,
            REGULAR_INITIAL_COST,
            REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2],
            REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3],
            REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3]
                    + REGULAR_UPGRADE_COST[4],
            REGULAR_INITIAL_COST + REGULAR_UPGRADE_COST[2] + REGULAR_UPGRADE_COST[3]
                    + REGULAR_UPGRADE_COST[4] + REGULAR_UPGRADE_COST[5]};
    public static final double[] REGULAR_RANGE = {0, 1, 2, 3, 4, 5};
    public static final double[] REGULAR_RATE = {0, 4, 5, 6, 7, 8};

    public static final double[] REGULAR_DAMAGE_PER_HIT = {0, 5, 10, 15, 30, 50};
    public static final double[] REGULAR_POWER = {
            REGULAR_DAMAGE_PER_HIT[0] * REGULAR_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[1] * REGULAR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[2] * REGULAR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[3] * REGULAR_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[4] * REGULAR_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            REGULAR_DAMAGE_PER_HIT[5] * REGULAR_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    /** Long Range Tower Constants. */
    public static final String LONGRANGE_TOWER_TYPE = "Long Range Tower";

    public static final int LONGRANGE_INITIAL_COST = 150;

    public static final int[] LONGRANGE_UPGRADE_COST = {0, 0, 75, 115, 175, 260, Integer.MAX_VALUE};
    public static final int[] LONGRANGE_REFUND_VALUE = {
            0,
            LONGRANGE_INITIAL_COST,
            LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2],
            LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2] + LONGRANGE_UPGRADE_COST[3],
            LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2] + LONGRANGE_UPGRADE_COST[3]
                    + LONGRANGE_UPGRADE_COST[4],
            LONGRANGE_INITIAL_COST + LONGRANGE_UPGRADE_COST[2] + LONGRANGE_UPGRADE_COST[3]
                    + LONGRANGE_UPGRADE_COST[4] + LONGRANGE_UPGRADE_COST[5]};
    public static final double[] LONGRANGE_RANGE = {0, 3, 6, 9, 12, 15};
    public static final double[] LONGRANGE_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] LONGRANGE_DAMAGE_PER_HIT = {0, 2, 4, 6, 8, 10};
    public static final double[] LONGRANGE_POWER = {
            LONGRANGE_DAMAGE_PER_HIT[0] * LONGRANGE_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[1] * LONGRANGE_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[2] * LONGRANGE_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[3] * LONGRANGE_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[4] * LONGRANGE_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            LONGRANGE_DAMAGE_PER_HIT[5] * LONGRANGE_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    /** Speed Tower Constants. */
    public static final String SPEED_TOWER_TYPE = "Speed Tower";

    public static final int SPEED_INITIAL_COST = 50;

    public static final int[] SPEED_UPGRADE_COST = {0, 0, 25, 50, 50, 100, Integer.MAX_VALUE};
    public static final int[] SPEED_REFUND_VALUE = {
            0,
            SPEED_INITIAL_COST,
            SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2],
            SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3],
            SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3]
                    + SPEED_UPGRADE_COST[4],
            SPEED_INITIAL_COST + SPEED_UPGRADE_COST[2] + SPEED_UPGRADE_COST[3]
                    + SPEED_UPGRADE_COST[4] + SPEED_UPGRADE_COST[5]};
    public static final double[] SPEED_RANGE = {0, 1, 2, 3, 4, 5};
    public static final double[] SPEED_RATE = {0, 5, 7, 9, 11, 13};

    public static final double[] SPEED_DAMAGE_PER_HIT = {0, 1, 2, 3, 4, 5};
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
    public static final int[] BOMBER_REFUND_VALUE = {
            0,
            BOMBER_INITIAL_COST,
            BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2],
            BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3],
            BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3]
                    + BOMBER_UPGRADE_COST[4],
            BOMBER_INITIAL_COST + BOMBER_UPGRADE_COST[2] + BOMBER_UPGRADE_COST[3]
                    + BOMBER_UPGRADE_COST[4] + BOMBER_UPGRADE_COST[5]};
    public static final double[] BOMBER_RANGE = {0, 1, 2, 3, 4, 5};
    public static final double[] BOMBER_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] BOMBER_DAMAGE_PER_HIT = {0, 2, 4, 6, 8, 10};
    public static final double[] BOMBER_POWER = {
            BOMBER_DAMAGE_PER_HIT[0] * BOMBER_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[1] * BOMBER_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[2] * BOMBER_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[3] * BOMBER_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[4] * BOMBER_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            BOMBER_DAMAGE_PER_HIT[5] * BOMBER_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    public static final double[] BOMBER_EFFECT_RANGE = {0, 1, 2, 3, 4, 5};

    /** Decelerator Tower Constants. */
    public static final String DECELERATOR_TOWER_TYPE = "Decelerator Tower";

    public static final int DECELERATOR_INITIAL_COST = 100;

    public static final int[] DECELERATOR_UPGRADE_COST = {0, 0, 75, 120, 170, 230,
            Integer.MAX_VALUE};
    public static final int[] DECELERATOR_REFUND_VALUE = {
            0,
            DECELERATOR_INITIAL_COST,
            DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2],
            DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2] + DECELERATOR_UPGRADE_COST[3],
            DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2] + DECELERATOR_UPGRADE_COST[3]
                    + DECELERATOR_UPGRADE_COST[4],
            DECELERATOR_INITIAL_COST + DECELERATOR_UPGRADE_COST[2] + DECELERATOR_UPGRADE_COST[3]
                    + DECELERATOR_UPGRADE_COST[4] + DECELERATOR_UPGRADE_COST[5]};
    public static final double[] DECELERATOR_RANGE = {0, 1, 2, 3, 4, 5};
    public static final double[] DECELERATOR_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] DECELERATOR_DAMAGE_PER_HIT = {0, 0, 0, 0, 0, 0};
    public static final double[] DECELERATOR_POWER = {
            DECELERATOR_DAMAGE_PER_HIT[0] * DECELERATOR_RATE[0] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[1] * DECELERATOR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[2] * DECELERATOR_RATE[1] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[3] * DECELERATOR_RATE[3] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[4] * DECELERATOR_RATE[4] * GAME_THREAD_SLEEP_TIME / 1000,
            DECELERATOR_DAMAGE_PER_HIT[5] * DECELERATOR_RATE[5] * GAME_THREAD_SLEEP_TIME / 1000};

    public static final double[] DECELERATOR_EFFECT_RANGE = {0, 1, 2, 3, 4, 5};

    /*--------------------------------------------------------------------------------------------------------------------*/

    /** Maximum Critter Level */
    public static final int MAX_CRITTER_LEVEL = 20;

    /** Armored Critter Constants. */
    public static final int ARMORED_CRITTER_SPEED = 4;
    public static final int ARMORED_CRITTER_BOUNTY = 4;
    public static final int ARMORED_CRITTER_STRENGTH = 1;

    /** Boss Critter Constants. */
    public static final int BOSS_CRITTER_STRENGTH = 5;

    /** Bullet Proof Critter Constants. */
    public static final int BULLET_PROOF_CRITTER_SPEED = 5;
    public static final int BULLET_PROOF_CRITTER_BOUNTY = 4;
    public static final int BULLET_PROOF_CRITTER_STRENGTH = 1;

    /** Normal Critter Constants. */
    public static final int NORMAL_CRITTER_SPEED = 5;
    public static final int NORMAL_CRITTER_BOUNTY = 4;
    public static final int NORMAL_CRITTER_STRENGTH = 1;

    /** Speed Critter Constants. */
    public static final int SPEED_CRITTER_SPEED = 10;
    public static final int SPEED_CRITTER_BOUNTY = 4;
    public static final int SPEED_CRITTER_STRENGTH = 1;

    /** Regenerative Critter Constants. */
    public static final int REGENERATIVE_CRITTER_SPEED = 5;
    public static final int REGENERATIVE_CRITTER_BOUNTY = 4;
    public static final int REGENERATIVE_CRITTER_STRENGTH = 1;

}

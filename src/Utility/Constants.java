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
    public static final int MAIN_MENU_YPOS = 15;

    /** Map display constants */
    public static final int MAP_INITIAL_XPOS = STORE_OFFSET;
    public static final int MAP_INITIAL_YPOS = 100;
    public static final int MAP_CELL_SIZE = STORE_BUTTON_SIZE;

    /** KeyHandler constants */
    public static final int KEYHANDLER_OFFSET = 11;

    /** Save Button Constant */
    public static final int SAVE_BUTTON_YPOS = 50;

    /** Initial Bank balance. */
    public static final int INITIAL_BANK_BALANCE = 30;

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
    public static final double[] REGULAR_POWER = {0, 2, 4, 6, 8, 10};
    public static final double[] REGULAR_RATE = {0, 2, 3, 4, 5, 6};

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
    public static final double[] LONGRANGE_POWER = {0, 2, 4, 6, 8, 10};
    public static final double[] LONGRANGE_RATE = {0, 1, 2, 3, 4, 5};

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
    public static final double[] SPEED_POWER = {0, 1, 2, 3, 4, 5};
    public static final double[] SPEED_RATE = {0, 5, 7, 9, 11, 13};

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
    public static final double[] BOMBER_POWER = {0, 2, 4, 6, 8, 10};
    public static final double[] BOMBER_RATE = {0, 1, 2, 3, 4, 5};

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
    public static final double[] DECELERATOR_POWER = {0, 0, 0, 0, 0, 0};
    public static final double[] DECELERATOR_RATE = {0, 1, 2, 3, 4, 5};

    public static final double[] DECELERATOR_EFFECT_RANGE = {0, 1, 2, 3, 4, 5};

    /*--------------------------------------------------------------------------------------------------------------------*/

    /** Maximum Critter Level */
    public static final int MAX_CRITTER_LEVEL = 20;

    /** Armored Critter Constants. */
    public static final int ARMORED_CRITTER_SPEED = 4;
    public static final int ARMORED_CRITTER_BOUNTY = 2;
    public static final int ARMORED_CRITTER_STRENGTH = 1;

    /** Boss Critter Constants. */
    public static final int BOSS_CRITTER_STRENGTH = 5;

    /** Bullet Proof Critter Constants. */
    public static final int BULLET_PROOF_CRITTER_SPEED = 5;
    public static final int BULLET_PROOF_CRITTER_BOUNTY = 2;
    public static final int BULLET_PROOF_CRITTER_STRENGTH = 1;

    /** Ghost Critter Constants. */
    public static final int GHOST_CRITTER_SPEED = 6;
    public static final int GHOST_CRITTER_BOUNTY = 2;
    public static final int GHOST_CRITTER_STRENGTH = 1;

    /** Normal Critter Constants. */
    public static final int NORMAL_CRITTER_SPEED = 10;
    public static final int NORMAL_CRITTER_BOUNTY = 2;
    public static final int NORMAL_CRITTER_STRENGTH = 1;

    /** Speed Critter Constants. */
    public static final int SPEED_CRITTER_SPEED = 10;
    public static final int SPEED_CRITTER_BOUNTY = 2;
    public static final int SPEED_CRITTER_STRENGTH = 1;

    /** Regenerative Critter Constants. */
    public static final int REGENERATIVE_CRITTER_SPEED = 5;
    public static final int REGENERATIVE_CRITTER_BOUNTY = 2;
    public static final int REGENERATIVE_CRITTER_STRENGTH = 1;

}

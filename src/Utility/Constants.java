package Utility;

/**
 * Constants
 *
 * @author Xin
 *
 */
public class Constants {

    /** Initial Tower Level. */
    public static final int INITIAL_TOWER_LEVEL = 1;

    /** Max Tower Level. */
    public static final int MAX_TOWER_LEVEL = 5;

    /** Regular Tower Constants. */
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

}

package Window;

import javax.swing.JFrame;

/**
 * 
 * @author Jose
 *
 */
public class Frame extends JFrame {

    /** Default Serial ID */
    private static final long serialVersionUID = 1L;

    public static String title = "ECSE 321 - Tower Defense";
    public static int width, height;


    public Frame() {
        new JFrame();

        setSize(800, 600);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(false);
        setResizable(false);
        setLocationRelativeTo(null);
        width = getWidth();
        height = getHeight();

        init();
    }

    public void init() {

        Screen screen = new Screen(this);
        this.add(screen);

        setVisible(true);
    }


    public static void main(String[] args) {
        new Frame();
    }
}

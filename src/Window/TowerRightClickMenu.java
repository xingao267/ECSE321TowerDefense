/**
 * 
 */
package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SpringLayout;

import Utility.SpringUtilities;
import Controllers.FurthestCritterFromTowerStrategy;
import Controllers.GameController;
import Controllers.NearestCritterToTowerStrategy;
import Controllers.StrongestCritterStrategy;
import Controllers.WeakestCritterStrategy;
import Exceptions.MaxLevelReachedException;
import Exceptions.NotEnoughMoneyException;

/**
 * @author Xin, Justin
 *
 */
public class TowerRightClickMenu extends JPopupMenu {

    /** Default serial ID */
    private static final long serialVersionUID = 1L;
        
    private JFrame frame;
    JMenuItem upgradeButtom;

    JMenuItem sellButtom;

    JMenuItem moveButtom;
    
    JMenuItem strategyButton;

    public TowerRightClickMenu() {

        upgradeButtom = new JMenuItem("Upgrade");
        sellButtom = new JMenuItem("Sell");
        moveButtom = new JMenuItem("Move");
        strategyButton = new JMenuItem("Change Strategy");

        if (!Screen.levelStarted) {
            add(upgradeButtom);
            upgradeButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        GameController.getUniqueInstance().upgradeTower(
                                GameController.getUniqueInstance().getHoveredTowerOnMap());
                        GameController.getUniqueInstance().setMaxLevelReached(false);
                        GameController.getUniqueInstance().setNoMoneyCaught(false);
                    } catch (MaxLevelReachedException e1) {
                        GameController.getUniqueInstance().setMaxLevelReached(true);
                    } catch (NotEnoughMoneyException e1) {
                        GameController.getUniqueInstance().setNoMoneyCaught(true);
                    }
                }
            });

            add(sellButtom);
            sellButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameController.getUniqueInstance().sellTower(
                            GameController.getUniqueInstance().getHoveredTowerOnMap());

                }
            });

            add(moveButtom);
            moveButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameController.getUniqueInstance().setSelectedTowerToMove(
                            GameController.getUniqueInstance().getHoveredTowerOnMap());
                    GameController.getUniqueInstance().setTowerMoveClicked(true);
                }
            });
            
            add(strategyButton);
            strategyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	changeStrategy();
                	
                }
            });
        }
    }

    /**
     * @return the upgradeButtom
     */
    public JMenuItem getUpgradeButtom() {
        return upgradeButtom;
    }

    /**
     * @param upgradeButtom the upgradeButtom to set
     */
    public void setUpgradeButtom(JMenuItem upgradeButtom) {
        this.upgradeButtom = upgradeButtom;
    }

    /**
     * @return the removeButtom
     */
    public JMenuItem getRemoveButtom() {
        return sellButtom;
    }

    /**
     * @param removeButtom the removeButtom to set
     */
    public void setRemoveButtom(JMenuItem removeButtom) {
        this.sellButtom = removeButtom;
    }

    /**
     * @return the moveButtom
     */
    public JMenuItem getMoveButtom() {
        return moveButtom;
    }

    /**
     * @param moveButtom the moveButtom to set
     */
    public void setMoveButtom(JMenuItem moveButtom) {
        this.moveButtom = moveButtom;
    }
    
    private void changeStrategy(){
    	final String message = "Select Targeting Strategy: ";
        JPanel userPanel = new JPanel(new SpringLayout());

        JLabel label = new JLabel(message, JLabel.TRAILING);
        userPanel.add(label);
        JButton nearestButton = new JButton("Nearest Critter First");
        JButton furthestButton = new JButton("Furthest Critter First");
        JButton weakestButton = new JButton("Weakest Critter First");
        JButton strongestButton = new JButton("Strongest Critter First");
        userPanel.add(new JLabel());
        userPanel.add(nearestButton);
        userPanel.add(furthestButton);
        userPanel.add(weakestButton);
        userPanel.add(strongestButton);
        

        SpringUtilities.makeCompactGrid(userPanel, userPanel.getComponentCount(), 1,6, 6, 6, 6);

        nearestButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	 GameController.getUniqueInstance().setTowerTargetingStrategy(new NearestCritterToTowerStrategy());
            	 frame.setVisible(false);
                 frame.dispose();
            }
        });
        
        furthestButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	 GameController.getUniqueInstance().setTowerTargetingStrategy(new FurthestCritterFromTowerStrategy());
            	 frame.setVisible(false);
                 frame.dispose();
            }
        });
        
        weakestButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	 GameController.getUniqueInstance().setTowerTargetingStrategy(new WeakestCritterStrategy());
            	 frame.setVisible(false);
                 frame.dispose();
            }
        });
        
        strongestButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	 GameController.getUniqueInstance().setTowerTargetingStrategy(new StrongestCritterStrategy());
            	 frame.setVisible(false);
                 frame.dispose();
            }
        });

        // Create and set up the window.
        frame = new JFrame("Change Targeting Strategy");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set up the content pane.
        userPanel.setOpaque(true); // content panes must be opaque
        frame.setContentPane(userPanel);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

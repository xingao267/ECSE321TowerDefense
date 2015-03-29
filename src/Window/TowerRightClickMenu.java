/**
 * 
 */
package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Controllers.GameController;
import Exceptions.MaxLevelReachedException;
import Exceptions.NoEnoughMoneyException;

/**
 * @author Xin
 *
 */
public class TowerRightClickMenu extends JPopupMenu {

    /** Default serial ID */
    private static final long serialVersionUID = 1L;

    JMenuItem upgradeButtom;

    JMenuItem removeButtom;

    JMenuItem moveButtom;

    public TowerRightClickMenu() {

        upgradeButtom = new JMenuItem("Upgrade");
        removeButtom = new JMenuItem("Remove");
        moveButtom = new JMenuItem("Move");

        add(upgradeButtom);

        if (!Screen.levelStarted) {
            add(removeButtom);
            removeButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameController.getUniqueInstance().sellTower(GameController.getUniqueInstance().getHoveredTowerOnMap());

                }
            });

            add(moveButtom);
            moveButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameController.getUniqueInstance().setSelectedTowerToMove(GameController.getUniqueInstance().getHoveredTowerOnMap());
                    GameController.getUniqueInstance().setTowerMoveClicked(true);
                }
            });
        }

        upgradeButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    GameController.getUniqueInstance().upgradeTower(GameController.getUniqueInstance().getHoveredTowerOnMap());
                    GameController.getUniqueInstance().setMaxLevelReached(false);
                    GameController.getUniqueInstance().setNoMoneyCaught(false);
                } catch (MaxLevelReachedException e1) {
                    GameController.getUniqueInstance().setMaxLevelReached(true);
                } catch (NoEnoughMoneyException e1) {
                    GameController.getUniqueInstance().setNoMoneyCaught(true);
                }
            }
        });
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
        return removeButtom;
    }

    /**
     * @param removeButtom the removeButtom to set
     */
    public void setRemoveButtom(JMenuItem removeButtom) {
        this.removeButtom = removeButtom;
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

}

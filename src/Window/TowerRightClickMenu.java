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

    GameController gameController;

    JMenuItem upgradeButtom;

    JMenuItem removeButtom;

    public TowerRightClickMenu() {

        this.gameController = GameController.getUniqueInstance();

        upgradeButtom = new JMenuItem("Upgrade");
        removeButtom = new JMenuItem("Remove");

        add(upgradeButtom);
        add(removeButtom);

        upgradeButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    gameController.upgradeTower(gameController.getHoveredTowerOnMap());
                    gameController.setMaxLevelReached(false);
                    gameController.setNoMoneyCaught(false);
                } catch (MaxLevelReachedException e1) {
                    gameController.setMaxLevelReached(true);
                } catch (NoEnoughMoneyException e1) {
                    gameController.setNoMoneyCaught(true);
                }
            }
        });

        removeButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameController.sellTower(gameController.getHoveredTowerOnMap());

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

}

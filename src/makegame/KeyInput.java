/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Admin
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean uP = false;
    private boolean dP = false;
    private boolean lP = false;
    private boolean rP = false;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
//                //key even for player 1
//                if (key == KeyEvent.VK_W) {
//                    tempGameObject.setVelY(-2);
//                    uP = true;
//                }
//                if (key == KeyEvent.VK_S) {
//                    tempGameObject.setVelY(2);
//                    dP = true;
//
//                }
//                if (key == KeyEvent.VK_A) {
//                    tempGameObject.setVelX(-2);
//                    lP = true;
//                }
//                if (key == KeyEvent.VK_D) {
//                    tempGameObject.setVelX(2);
//                    rP = true;
//                }

                //key even for player 1
                if (key == KeyEvent.VK_W) {
                    tempGameObject.setVelY(-2);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempGameObject.setVelY(2);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempGameObject.setVelX(-2);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempGameObject.setVelX(2);
                    keyDown[3] = true;
                }

            }

        }

    }

    public void keyReleased(KeyEvent e) {//neu khong set released object se troi khong dung lai
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
//                //key even for player 1
//                if (key == KeyEvent.VK_W) {
//                    uP = false;
//                    if (dP) {
//                        tempGameObject.setVelY(2);
//                    }
//                    tempGameObject.setVelY(0);
//
//                }
//                if (key == KeyEvent.VK_S) {
//                    dP = false;
//                    if (uP) {
//                        tempGameObject.setVelY(-2);
//                    }
//                    tempGameObject.setVelY(0);
//                }
//                if (key == KeyEvent.VK_A) {
//                    lP = false;
//                    if (rP) {
//                        tempGameObject.setVelX(2);
//                    }
//                    tempGameObject.setVelX(0);
//                }
//                if (key == KeyEvent.VK_D) {
//                    rP = false;
//                    if (lP) {
//                        tempGameObject.setVelX(-2);
//                    }
//                    tempGameObject.setVelX(0);
//                }
            //key even for player 1
                if (key == KeyEvent.VK_W) {
                    tempGameObject.setVelY(-2);
                }
                if (key == KeyEvent.VK_S) {
                    keyDown[1]=false;      
                }
                if (key == KeyEvent.VK_A) {
                    keyDown[2]=false;      
                }
                if (key == KeyEvent.VK_D) {
                    keyDown[3]=false;      
                }
            
                if (!keyDown[0]&&!keyDown[1]) {
                    tempGameObject.setVelY(-2);
                }
                if (!keyDown[2]&&!keyDown[3]) {
                    tempGameObject.setVelX(2);
                }
            }

        }
    }
}

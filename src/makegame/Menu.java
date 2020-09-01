/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static sun.security.krb5.internal.KDCOptions.with;

/**
 *
 * @author Admin
 */
public class Menu extends MouseAdapter {

    private Handler handler;
    private Game game;

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        mouseOver(mx, my, 200, 100, 200, 100);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, 200, 100, 200, 100)) {
            game.gameState = Game.STATE.Game;
             handler.addObject(new Player(200, 200, ID.Player, handler));
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int witdh, int height) {
        if (mx > x && mx < x + witdh) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font font = new Font("arial", 1, 50);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawRect(200, 100, 200, 100);
        g.drawString("Play", 250, 150);
    }
}

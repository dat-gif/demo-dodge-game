/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BaseEnemy extends GameObject {

    private Handler handler;

    public BaseEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        velX = 1;
        velY = 1;
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.yellow, 16, 16, 0.01f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

}

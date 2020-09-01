/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp((int) x, 0, Game.WIDTH - 32);//khong cho di qua bien gioi
        y = Game.clamp((int) y, 0, Game.HEIGHT - 62);
        handler.addObject(new Trail((int) x, (int) y, id, Color.blue, 32, 32, 0.05f, handler));
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.BaseEnemy) {
                if (getBounds().intersects(tempGameObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
            if (tempGameObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempGameObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 1;
                }
            }
            if (tempGameObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempGameObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 1;
                }
            }
        }
    }

    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.red);//de thu thoi, khong viet lien player2 vao day
        }

        g.fillRect((int) x, (int) y, 32, 32);

    }

    public Rectangle getBounds() {//tao 1 vung hang giao bao quanh player(hit box)
        return new Rectangle((int) x, (int) y, 32, 32);
    }

}

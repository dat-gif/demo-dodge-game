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
public class SmartEnemy extends GameObject {
//biet duoi theo nguoi choi

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
                player = tempGameObject;
            }
//            if (handler.objects.get(i).getId() == ID.Player) {
//                player = handler.objects.get(i);
//            }
        }
    }

    public void tick() {
        x += velX;
        y += velY;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
                player = tempGameObject;
            }
//            if (handler.objects.get(i).getId() == ID.Player) {
//                player = handler.objects.get(i);
//            }
        }

        float difX = x - player.getX() - 8;

        float difY = y - player.getY() - 8;
        //float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) (-1.0 / distance) * difX;
        velY = (float) (-1.0 / distance) * difY;

        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.green, 16, 16, 0.01f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}

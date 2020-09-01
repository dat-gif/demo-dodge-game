/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private double scoreKep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKep += 0.005;

        if (scoreKep >= 10) {
            scoreKep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
               // handler.addObject(new SmartEnemy(r.nextInt(((Game.WIDTH - 32) - 1) + 1) + 2, r.nextInt(((Game.HEIGHT - 32) - 1) + 1) + 2, ID.SmartEnemy, handler));
                handler.addObject(new BaseEnemy(r.nextInt(((Game.WIDTH-32) - 1) + 1) + 1, r.nextInt(((Game.HEIGHT-32) - 1) + 1) + 1, ID.BaseEnemy, handler));
            }
            if (hud.getLevel() == 3) {
                handler.addObject(new BaseEnemy(r.nextInt((Game.WIDTH - 1) + 1) + 1, r.nextInt((Game.HEIGHT - 1) + 1) + 1, ID.BaseEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((Game.WIDTH - 1) + 1) + 1, r.nextInt((Game.HEIGHT - 1) + 1) + 1, ID.SmartEnemy, handler));
            }
            if (hud.getLevel() == 4) {
                for (int i = 0; i < handler.objects.size(); i++) {
                    GameObject temGameObject = handler.objects.get(i);
                    if (temGameObject.getId() == ID.BaseEnemy) {
                        handler.removeObject(temGameObject);
                    }
                }
                handler.addObject(new FastEnemy(r.nextInt((Game.WIDTH - 1) + 1) + 1, r.nextInt((Game.HEIGHT - 1) + 1) + 1, ID.FastEnemy, handler));
            }

        }

    }
}

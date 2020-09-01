
package makegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public class FastEnemy extends GameObject{
private Handler handler;
    public FastEnemy(int x, int y, ID id,Handler handler) {
        super(x, y, id);
    velX=3;
    velY=3;
    this.handler=handler;
    }

    @Override
    public void tick() {
    x+=velX;
    y+=velY;
    //chan object bay qua window    
    if (y<=0||y>=Game.HEIGHT-32) {
            velY*=-1;
        }
        if (x<=0||x>=Game.WIDTH-32) {
            velX*=-1;
        }
    //handler.addObject(new Trail(x, y,ID.Trail, Color.red, 16, 16, 0.01f, handler));
    }

    @Override
    public void render(Graphics g) {
    g.setColor(Color.red);
    g.fillRect((int)x,(int) y, 10, 10);
    }

      public Rectangle getBounds() {
        return new Rectangle((int)x,(int) y, 10, 10);
    }
    
}

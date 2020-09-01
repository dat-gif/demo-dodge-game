/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public abstract class GameObject {

    protected float x, y;//toa do
    protected ID id;//id cua nguoi choi hay linh
    protected float velX, velY;//toc do cua 2 hunong x,y

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public GameObject() {
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Admin
 */
public class HUD {

    public static int HEALTH = 100;
    private int greenValue;
    private double score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = HEALTH * 2;
        greenValue = Game.clamp(greenValue, 0, 200);
        score += 0.0005;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(20, 20, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(20, 20, HEALTH*2 , 32);
        g.setColor(Color.WHITE);
        g.drawRect(20, 20, 200, 32);
        g.drawString(String.format("%10s%.2f", "Score :", score), 200, 10);
        g.drawString("Level : " + level, 100, 10);
    }

    public void score(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

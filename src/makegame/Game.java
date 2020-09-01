/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE {

        Menu,
        Game
    };

    public STATE gameState = STATE.Menu;

    public Game() {
        handler = new Handler();//nen de tao hander len truoc boi tao window truoc hander co the gay loi
//        if (gameState == STATE.Game) {
//        handler.addObject(new Player(200, 200, ID.Player, handler));
//
//        } 
        menu = new Menu(this,handler);
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        new Window(WIDTH, HEIGHT, "bUID gAME", this);

    }

    public void run() {
        //game loop// tìm hiểu thêm về game loop
        this.requestFocus();///
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {//update
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
            spawner.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        }

    }

    private void render() {
        
        BufferStrategy bs = this.getBufferStrategy();//lớp lấy hình để làm video
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
//
//        /////////
        Graphics g = bs.getDrawGraphics();
        //  g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //////////

        if (gameState == STATE.Game) {
            hud.render(g);//test thoi
        } else if (gameState == STATE.Menu) {
           menu.render(g);
        }
        handler.render(g);

        g.dispose();
        bs.show();

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }

    }

    public static void main(String[] args) {
        new Game();
    }

}

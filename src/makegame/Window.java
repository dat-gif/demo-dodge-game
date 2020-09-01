/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Window extends Canvas {

    private static final long serialVersionUID = -240840600533728354l;

    public Window(int with, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(with, height));
        frame.setMaximumSize(new Dimension(with, height));
        frame.setMinimumSize(new Dimension(with, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//thucnsu dung threat
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//để null cửa sổ sẽ hiện ở giũa màn hình
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}

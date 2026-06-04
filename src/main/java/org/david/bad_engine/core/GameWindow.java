package org.david.bad_engine.core;

import org.david.bad.auxiliary.Size;
import org.david.bad.code.annotation.SingletonClass;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a window for this game.
 *
 * @author Mr. GodDavid
 * @since 3/30/2026
 */
@SingletonClass
public final class GameWindow {

    private static GameWindow instance;
    private static Size windowSize;

    private final JFrame window;
    @SuppressWarnings("FieldCanBeLocal")
    private final GameWindowResizeListener resizeListener;

    private GameWindow(Game game) {
        window = new JFrame();
        window.setTitle("My Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resizeListener = GameWindowResizeListener.getInstance();

        window.add(game);
        window.pack();
        windowSize = new Size(window.getWidth(), window.getHeight());
        window.addComponentListener(resizeListener);
        window.setCursor(createCursor());
        window.setLocationRelativeTo(null);
    }

    public static GameWindow getInstance(Game game) {
        if (instance == null) {
            instance = new GameWindow(game);
        }
        return instance;
    }

    public static void updateWindowSize(int width, int height) {
        windowSize.setSize(width, height);
    }

    private Cursor createCursor() {
        // TODO define custom cursor image.
        return null;
    }

    public void show() {
        window.setVisible(true);
    }

    public static Size getWindowSize() {
        return windowSize;
    }
}

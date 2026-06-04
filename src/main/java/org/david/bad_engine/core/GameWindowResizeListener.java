package org.david.bad_engine.core;

import org.david.bad.code.annotation.SingletonClass;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Listens to window resizing events of game.
 *
 * @author Mr. GodDavid
 * @since 4/22/2026
 */
@SingletonClass
public final class GameWindowResizeListener extends ComponentAdapter {

    private static GameWindowResizeListener instance;

    private GameWindowResizeListener() {
    }

    public static GameWindowResizeListener getInstance() {
        if (instance == null) {
            instance = new GameWindowResizeListener();
        }
        return instance;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        GameWindow.updateWindowSize(e.getComponent().getWidth(), e.getComponent().getHeight());
    }
}

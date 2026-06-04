package org.david.bad_engine.core;

import org.david.bad.code.annotation.SingletonClass;

import java.awt.*;

/**
 * Renderer of this game. Renders all game items and characters.
 *
 * @author Mr. GodDavod
 * @since 4/18/2026
 */
@SingletonClass
public final class Renderer {

    private static Renderer instance;

    private Renderer() {
    }

    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }

    /**
     * Renders all {@code MovingEntity} of this game every frame.
     *
     * @param g2d that can be considered as the graphics rendering pipeline that built inside {@link Graphics2D} class.
     */
    public void render(Graphics2D g2d) {
        // TODO draws stuffs here.
    }
}

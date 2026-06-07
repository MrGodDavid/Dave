package org.david.bad_engine.core.logic;

import java.awt.*;

/**
 * This interface contains the method that the user must implement to render games.
 *
 * @author Mr. GodDavid
 * @since 6/7/2026
 */
public interface GameRenderLogic {

    /**
     * Game render logic goes here.
     *
     * @param g2d acts as rendering pipeline.
     */
    void render(Graphics2D g2d);
}

package org.david.bad_engine.core;

import org.david.bad.code.annotation.SingletonClass;
import org.david.bad_engine.core.logic.GameRenderLogic;
import org.david.bad_engine.core.logic.GameUpdateLogic;

/**
 * Wrapper class of this game. Creates a window and run a Thread of this game.
 * <p>This class only contains {@code Window} and {@code GameLoop}.</p>
 *
 * @author Mr. GodDavid
 * @since 3/30/2026
 */
@SingletonClass
public final class GameWrapper {

    private static GameWrapper instance;

    private final GameWindow gameWindow;
    private final GameLoop gameLoop;

    private GameWrapper(GameUpdateLogic updateLogic, GameRenderLogic renderLogic) {
        Game game = Game.getInstance(updateLogic, renderLogic);
        gameWindow = GameWindow.getInstance(game);
        gameLoop = GameLoop.getInstance(game);
    }

    public static GameWrapper getInstance(GameUpdateLogic updateLogic, GameRenderLogic renderLogic) {
        if (instance == null) {
            instance = new GameWrapper(updateLogic, renderLogic);
        }
        return instance;
    }

    /**
     * Launches the game.
     */
    public void launch() {
        gameWindow.show();
        gameLoop.start();
    }
}

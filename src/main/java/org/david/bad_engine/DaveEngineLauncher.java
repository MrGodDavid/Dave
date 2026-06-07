package org.david.bad_engine;

import org.david.bad.code.annotation.UninstantiableClass;
import org.david.bad_engine.core.GameWrapper;
import org.david.bad_engine.core.logic.GameRenderLogic;
import org.david.bad_engine.core.logic.GameUpdateLogic;

/**
 * Entry class of execution of this engine.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
@UninstantiableClass(reason = UninstantiableClass.Reason.UTILITY_CLASS)
public final class DaveEngineLauncher {

    private static GameUpdateLogic gameUpdateLogic;
    private static GameRenderLogic gameRenderLogic;

    private DaveEngineLauncher() {
        throw new IllegalStateException("This is a root game launcher class and cannot be instantiated");
    }

    public static void registerGameUpdateLogic(GameUpdateLogic gameUpdateLogic) {
        DaveEngineLauncher.gameUpdateLogic = gameUpdateLogic;
    }

    public static void registerGameRenderLogic(GameRenderLogic gameRenderLogic) {
        DaveEngineLauncher.gameRenderLogic  = gameRenderLogic;
    }

    public static void launch() {
        GameWrapper gameWrapper = GameWrapper.getInstance(gameUpdateLogic, gameRenderLogic);
        gameWrapper.launch();

        System.out.println(System.getProperty("user.dir"));
    }
}

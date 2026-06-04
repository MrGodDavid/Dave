package org.david.bad_engine;

import org.david.bad.code.annotation.UninstantiableClass;
import org.david.bad_engine.core.GameWrapper;

/**
 * Entry class of execution of this engine.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
@UninstantiableClass(reason = UninstantiableClass.Reason.UTILITY_CLASS)
public final class Launcher {

    private Launcher() {
        throw new IllegalStateException("This is a root game launcher class and cannot be instantiated");
    }

    public static void main(String[] args) {
        GameWrapper gameWrapper = GameWrapper.getInstance();
        gameWrapper.launch();

        System.out.println(System.getProperty("user.dir"));
    }
}

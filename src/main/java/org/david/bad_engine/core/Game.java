package org.david.bad_engine.core;

import org.david.bad.auxiliary.Size;
import org.david.bad.code.annotation.SingletonClass;
import org.david.bad_engine.core.logic.GameRenderLogic;
import org.david.bad_engine.core.logic.GameUpdateLogic;
import org.david.bad_engine.input.InputManager;
import org.david.bad_engine.input.KeyboardListener;
import org.david.bad_engine.input.MouseInputListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * The actual game reference of this project.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
@SingletonClass
public final class Game extends JPanel {

    // WINDOW SIZE
    public static final int UNIT_LENGTH = 64;
    public static final int NUM_OF_TILE_WIDTH = 16;
    public static final int NUM_OF_TILE_HEIGHT = 12;
    public static final int WINDOW_WIDTH = UNIT_LENGTH * NUM_OF_TILE_WIDTH; // 64 * 16 = 1024 px
    public static final int WINDOW_HEIGHT = UNIT_LENGTH * NUM_OF_TILE_HEIGHT; // 64 * 12 = 768 px
    public static final Size GAME_WINDOW_SIZE = new Size(WINDOW_WIDTH, WINDOW_HEIGHT);

    // GAME ATTRIBUTES
    private static Random randomGenerator;
    private static Game instance;
    private static Font font_m6x11plus;

    // Managers goes here.
    private final InputManager inputManager;
    private final Renderer renderer;
    private final GameUpdateLogic gameUpdateLogic;

    /**
     * Constructs a {@code Game} object,
     */
    private Game(GameUpdateLogic updateLogic, GameRenderLogic renderLogic) {
        Game.font_m6x11plus = createFont("/font/m6x11plus.ttf");
        Game.randomGenerator = new Random(GameLoop.generateRandomSeed());

        final KeyboardListener keyboardListener = KeyboardListener.getInstance();
        final MouseInputListener mouseInputListener = MouseInputListener.getInstance();
        this.inputManager = InputManager.getInstance(keyboardListener, mouseInputListener);
        this.gameUpdateLogic = updateLogic;

        renderer = Renderer.getInstance(renderLogic);

        super.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        super.setDoubleBuffered(true);
        super.setFocusable(true);
        super.setFocusTraversalKeysEnabled(false);

        super.addKeyListener(keyboardListener);
        super.addMouseListener(mouseInputListener);
        super.addMouseMotionListener(mouseInputListener);
    }

    /**
     * Gets the instance of {@code Game} object. Since this class is a singleton class, meaning this class can be
     * instantiated once, this method returns the static reference of this class once it is instantiated.
     *
     * @return the static reference of this class.
     */
    public static Game getInstance(GameUpdateLogic updateLogic, GameRenderLogic renderLogic) {
        if (instance == null) {
            instance = new Game(updateLogic, renderLogic);
        }
        return instance;
    }

    /**
     * Updates all game's characters, ui components, objects, items, etc. every frame 60 times.
     *
     * @param deltaTime the time between each update.
     */
    public void update(double deltaTime) {
        inputManager.update();
    }

    /**
     * Renders all game's characters, ui components, objects, items, etc. every frame 60 times.
     * <p>Wrapper method of {@link JPanel#repaint()}.</p>
     */
    public void render() {
        super.repaint();
    }

    /**
     * Calls the UI delegate's paint method, if the UI delegate
     * is non-<code>null</code>.  We pass the delegate a copy of the
     * <code>Graphics</code> object to protect the rest of the
     * paint code from irrevocable changes
     * (for example, <code>Graphics.translate</code>).
     * <p>
     * If you override this in a subclass you should not make permanent
     * changes to the passed in <code>Graphics</code>. For example, you
     * should not alter the clip <code>Rectangle</code> or modify the
     * transform. If you need to do these operations you may find it
     * easier to create a new <code>Graphics</code> from the passed in
     * <code>Graphics</code> and manipulate it. Further, if you do not
     * invoke super's implementation you must honor the opaque property, that is
     * if this component is opaque, you must completely fill in the background
     * in an opaque color. If you do not honor the opaque property you
     * will likely see visual artifacts.
     * <p>
     * The passed in <code>Graphics</code> object might
     * have a transform other than the identify transform
     * installed on it.  In this case, you might get
     * unexpected results if you cumulatively apply
     * another transform.
     *
     * @param g the <code>Graphics</code> object to protect
     * @see #paint
     * @see ComponentUI
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        renderer.render(g2d);

        g2d.dispose();
    }

    /**
     * Creates game's font. The font of this game is font_monica.
     *
     * @param filePath that is not null.
     * @return the font created through the given file path.
     */
    @SuppressWarnings("SameParameterValue")
    private Font createFont(final String filePath) {
        InputStream iS = Game.class.getResourceAsStream(filePath);
        if (iS == null) {
            System.out.println("[WARNING]:  Unable to find file " + filePath);
            return null;
        }
        try {
            return Font.createFont(Font.TRUETYPE_FONT, iS);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException("[ERROR]:  Could not find font through file path [" + filePath + "]");
        }
    }

    // =============================================== [GETTERS & SETTERS] ===============================================

    /**
     * Accessor of {@code font_m6x11plus} instance field.
     *
     * @return {@code font_m6x11plus} instance field.
     */
    public static Font getGameFont() {
        return Game.font_m6x11plus;
    }

    /**
     * Accessor of {@code randomGenerator} instance field.
     *
     * @return {@code randomGenerator} instance field.
     */
    public static Random getRandomGenerator() {
        return randomGenerator;
    }

}

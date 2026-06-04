package org.david.bad_engine.input;

import com.mrgoddavid.vector.Vector2d;
import org.david.bad.code.annotation.SingletonClass;
import org.david.bad_engine.core.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Manages the user's keyboard and mouse input.
 * Construct this class by providing {@code KeyboardListener}
 * and {@code MouseInputListener}.
 *
 * <p>
 * Uses the {@code update(double)} method to process and update user input each frame.
 * </p>
 *
 * <p>
 * Processes all input logic within this class. Do not implement any logic inside {@code KeyboardListener}
 * or {@code MouseInputListener}.
 * </p>
 *
 * @author Mr. GodDavid
 * @since 3/31/2026
 */
@SingletonClass
@SuppressWarnings("unused")
public final class InputManager {

    @SuppressWarnings("unused")
    private static KeyboardListener keyboardListener;
    private static MouseInputListener mouseInputListener;

    private static InputManager instance;

    private InputManager(KeyboardListener keyboardListener, MouseInputListener mouseInputListener) {
        InputManager.keyboardListener = keyboardListener;
        InputManager.mouseInputListener = mouseInputListener;
    }

    /**
     * Returns the single instance of {@code InputManager}. This method initializes the {@code InputManager} if the
     * instance is not being initialized. Otherwise, returns the instance of {@code InputManager}.
     *
     * @param keyboardListener   the key listener that is used to construct this class.
     * @param mouseInputListener the mouse input listener that is used to construct this class.
     * @return the only instance of {@code InputManager}
     */
    public static InputManager getInstance(KeyboardListener keyboardListener, MouseInputListener mouseInputListener) {
        if (InputManager.instance == null) {
            InputManager.instance = new InputManager(keyboardListener, mouseInputListener);
        }
        return InputManager.instance;
    }

    /**
     * Updates the game based on input from {@code KeyboardListener} and {@code MouseInputListener}.
     */
    public void update() {
        if (MouseInputListener.isButtonDown(MouseInputListener.MouseButton.LEFT_BUTTON)) {
            System.out.println("You pressed left button!");
        }
        if (MouseInputListener.isButtonDown(MouseInputListener.MouseButton.RIGHT_BUTTON)) {
            System.out.println("You pressed right button!");
        }

        if (KeyboardListener.isKeyPressed(KeyEvent.VK_W)) {
            System.out.println("You pressed W key!");
        }

        if (KeyboardListener.isKeyTyped(KeyEvent.VK_S)) {
            System.out.println("You typed S key!");
        }

        if (KeyboardListener.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            System.exit(0);
        }
    }

    public static boolean isMouseMoved() {
        return MouseInputListener.isMouseMoved();
    }

    /**
     * Wrapper method of {@link KeyboardListener#isKeyTyped(int)}.
     *
     * @param keyCode that indicates which key is typed on keyboard.
     * @return true if the correspond key is typed.
     */
    public static boolean isKeyDown(int keyCode) {
        return KeyboardListener.isKeyTyped(keyCode);
    }

    /**
     * Wrapper method of {@link KeyboardListener#isKeyPressed(int)}.
     *
     * @param keyCode that indicates which key is pressed on keyboard.
     * @return true if the correspond key is pressed.
     */
    public static boolean isKeyPressed(int keyCode) {
        return KeyboardListener.isKeyPressed(keyCode);
    }

    /**
     * Wrapper method of {@link MouseInputListener#isButtonDown(MouseInputListener.MouseButton)}.
     *
     * @param button that indicates which mouse button is pressed on mouse.
     * @return true if the correspond mouse button is pressed.
     */
    public static boolean isButtonDown(MouseInputListener.MouseButton button) {
        return MouseInputListener.isButtonDown(button);
    }

    public static boolean isButtonPressed(MouseInputListener.MouseButton button) {
        return MouseInputListener.isButtonPressed(button);
    }

    // =============================================== [GETTERS & SETTERS] ===============================================

    public static Vector2d getMousePosition() {
        return mouseInputListener.getMouseCursorPosition();
    }
}

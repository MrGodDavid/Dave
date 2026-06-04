package org.david.bad.auxiliary;

/**
 * Size object, Holds width and height, which are both integers.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
public final class Size {

    private int width, height;

    /**
     * Non-argument constructor. By default, the Size has 0 x 0 dimension.
     */
    public Size() {
        this(0, 0);
    }

    /**
     * Constructs a Size object. Sets the width and height of Size by the parameters of its constructor.
     *
     * @param width  that is an integer.
     * @param height that is an integer.
     */
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Sets new width and height to Size object.
     *
     * @param width  new width that is an integer.
     * @param height new height that is an integer.
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Accessor of the instance field {@code width} of Size.
     *
     * @return the instance field {@code width}.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Accessor of the instance field {@code height} of Size.
     *
     * @return the instance field {@code height}.
     */
    public int getHeight() {
        return height;
    }
}

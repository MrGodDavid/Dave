package org.david.bad.code.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Use this annotation when indicating a class is not instantiable. Contains a private constructor that
 * throws a {@link RuntimeException} if using that constructor.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
@Retention(RetentionPolicy.SOURCE)
public @interface UninstantiableClass {

    /**
     * Reasons of using this UninstantiableClass annotation.
     */
    enum Reason {
        UTILITY_CLASS;
    }

    /**
     * Registers reason of using this UninstantiableClass annotation.
     *
     * @return an array of reasons of using this annotation.
     */
    Reason[] reason();
}

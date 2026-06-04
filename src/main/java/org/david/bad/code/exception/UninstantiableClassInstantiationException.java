package org.david.bad.code.exception;

/**
 * Throws this exception when user attempts to instantiate an uninstantiable class.
 *
 * @author Mr. GodDavid
 * @since 6/3/2026
 */
public class UninstantiableClassInstantiationException extends RuntimeException {

    public UninstantiableClassInstantiationException() {
        super("[ERROR]: You cannot instantiate utility class!");
    }
}

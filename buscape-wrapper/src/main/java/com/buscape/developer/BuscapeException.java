package com.buscape.developer;

/**
 * Indicates errors that occurs inside the API wrapper. 
 * @author cartagena
 */
public final class BuscapeException extends Exception {
	
	private static final long serialVersionUID = -4749034515436513686L;

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */
	public BuscapeException(String message, Throwable cause) {
		super(message, cause);
	}

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for 
     *          later retrieval by the {@link #getMessage()} method.
     */
	public BuscapeException(String message) {
		super(message);
	}

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */
	public BuscapeException(Throwable cause) {
		super(cause);
	}
}
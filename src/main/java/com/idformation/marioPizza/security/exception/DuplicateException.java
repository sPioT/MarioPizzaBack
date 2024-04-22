package com.idformation.marioPizza.security.exception;

public class DuplicateException extends Exception {

	/**
	 * Constructor.
	 *
	 * @param message a message
	 */
	public DuplicateException(final String message) {
		super(message);
	}

	private static final long serialVersionUID = 5935347721582769510L;

}

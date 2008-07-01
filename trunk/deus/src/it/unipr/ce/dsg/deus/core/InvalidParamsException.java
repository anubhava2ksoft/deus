package it.unipr.ce.dsg.deus.core;

/**
 * This class represents the exceptions thrown in case the parameters passed to
 * simulation objects are wrong.
 * 
 * @author Matteo Agosti (agosti@ce.unipr.it)
 * @author Michele Amoretti (amoretti@ce.unipr.it)
 * 
 */
public class InvalidParamsException extends Exception {
	public InvalidParamsException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;
}

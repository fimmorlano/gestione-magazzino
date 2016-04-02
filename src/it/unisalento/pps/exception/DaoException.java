package it.unisalento.pps.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(Throwable t) {
		super(t);
	}

	public DaoException(String message) {
		super(message);
	}

}
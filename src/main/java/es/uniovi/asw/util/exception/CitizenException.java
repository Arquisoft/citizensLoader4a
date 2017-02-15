package es.uniovi.asw.util.exception;

/**
 * Created by Pelayo Garcia Lartategui on 15/02/2017.
 */
public class CitizenException extends Exception{
    private static final long serialVersionUID = 4001710687990554589L;

    public CitizenException() {
    }

    public CitizenException(String message) {
        super(message);
    }

    public CitizenException(Throwable cause) {
        super(cause);
    }

    public CitizenException(String message, Throwable cause) {
        super(message, cause);
    }

}



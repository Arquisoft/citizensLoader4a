package es.uniovi.asw.util.Exception;

/**
 * Created by Pelayo Garcia Lartategui on 15/02/2017.
 */
public class CustomException extends Exception{
    private static final long serialVersionUID = 4001710687990554589L;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

}



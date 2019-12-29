package 异常;

public class Main  extends Exception{
    public Main() {
        super();
    }

    public Main(String message) {
        super(message);
    }

    public Main(String message, Throwable cause) {
        super(message, cause);
    }

    public Main(Throwable cause) {
        super(cause);
    }

    protected Main(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package lotto.exceptions;

public abstract class GlobalException extends IllegalArgumentException {

    public GlobalException(String s) {
        super(s);
    }
}

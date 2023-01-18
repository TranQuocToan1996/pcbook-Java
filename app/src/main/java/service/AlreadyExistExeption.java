package service;

public class AlreadyExistExeption extends RuntimeException {
    public AlreadyExistExeption(String message) {
        super(message);
    }
}

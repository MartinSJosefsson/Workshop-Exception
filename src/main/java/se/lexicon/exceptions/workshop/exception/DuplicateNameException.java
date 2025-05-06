package se.lexicon.exceptions.workshop.exception;

public class DuplicateNameException extends RuntimeException {
    private String name;

    public DuplicateNameException(String message) {
        super(message);
    }

    public DuplicateNameException(String message, String name) {
        this(message);        setName(name);
    }

    public String getName() {
        return name;

    }
    private void setName(String name) {
        this.name = name;
    }

}

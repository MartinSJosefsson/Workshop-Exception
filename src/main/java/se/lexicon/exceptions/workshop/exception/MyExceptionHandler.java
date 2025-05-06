package se.lexicon.exceptions.workshop.exception;

public class MyExceptionHandler {

    public static void handleExceptions(Exception e) {

        switch (e) {
            case IllegalArgumentException ex -> System.out.println("Invalid Params: " + ex.getMessage());
            case DuplicateNameException ex -> System.out.println(ex.getMessage() + ex.getName());
            default -> {
                System.out.println("Unexpected error occurred: ");
                e.printStackTrace();
            }

        }

    }
}
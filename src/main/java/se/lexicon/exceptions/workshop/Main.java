package se.lexicon.exceptions.workshop;

import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.MyExceptionHandler;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
            List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

            List<String> lastNames = CSVReader_Writer.getLastNames();

            NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

//            nameService.addFemaleFirstName("Alice");
            nameService.addLastName("Andersson");

            Person test = nameService.getNewRandomPerson();
            System.out.println(test);
        } catch (Exception e) {
            MyExceptionHandler.handleExceptions(e);
        }

    }

}
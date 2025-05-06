package se.lexicon.exceptions.workshop.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader_Writer {
    /**
     * This method getMaleFirstNames should use a try-catch-finally without resources
     * * Should catch FileNotFoundException and IOException
     * * You should also close the Buffered reader in the finally block     *     * @return List<String>of male firstnames
     */
    public static List<String> getMaleFirstNames() {
        BufferedReader reader = null;
        List<String> names = null;
        try {
            reader = Files.newBufferedReader(Paths.get("firstname_males.txt"));
            names = reader.lines().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Did not go through!");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file");
            }
        }
        return names;
    }

    /**
     * This method getFemaleFirstNames should make use of a try-catch with resources     *     * @return
     */
    public static List<String> getFemaleFirstNames() {
        List<String> names = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("firstname_female.txt"))) {
            names = reader.lines().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error finding the file");
        }
        return names;
    }

    /**
     * This method fetches strings from a file and put them into a list
     * * This method might throw IOException which due to the throws cause need to
     * * be handled by the caller.     *     * @return List <String> of last names     * @throws IOException
     */
    public static List<String> getLastNames() throws IOException {
        List<String> names = null;
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("lastnames.txt"));
            names = reader.lines().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return names;
    }

    public static void saveLastNames(List<String> lastNames) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("lastnames.txt"))) {
            for (String toWrite : lastNames) {
                writer.append(toWrite).append(",");
            }
        }
    }

    public static void saveFemaleNames(List<String> femaleNames) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("firstname_female.txt"));) {
            for (String toWrite : femaleNames) {
                try {
                    writer.append(toWrite + ",");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void saveMaleNames(List<String> maleNames) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("firstname_males.txt"))) {
            for (String toWrite : maleNames) {
                try {
                    writer.append(toWrite).append(",");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
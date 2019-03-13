package ru.academit.mitiukliaev;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadListFromFile {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayList/src/ru/academit/mitiukliaev/arraylist/input.txt"))) {
            ArrayList<String> fileData = new ArrayList<>();
            while (scanner.hasNext()) {
                fileData.add(scanner.nextLine());
            }
            System.out.println(fileData);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.konrad.projekt;

import java.io.*;
import java.util.Scanner;

public class Main {
    static String fileName = null;
    static EmployeeManager eMan = new EmployeeManager();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;
    static int chooser;

    public static void main(String[] args) {
        loadFile();
        while(running) {
            ProgramUtils.clearScreen();
            ProgramUtils.printMainMenu();
        System.out.println("Podaj swój wybór: ");
        chooser = ProgramUtils.getInt();
        while(chooser==-1) {
            chooser = ProgramUtils.getInt();
        }
            switch (chooser) {
                case 0:
                    saveAndQuit();
                    break;
                case 1:
                    ProgramUtils.clearScreen();
                    System.out.println(eMan.toString());

                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchByHrid();
                    break;
                case 5:
                    ProgramUtils.clearScreen();
                    eMan.getByOne();
                    break;
                case 6:
                    eMan.sortAsc();
                    break;
                case 7:
                    eMan.sortDesc();
                    break;
                case 8:
                    saveFile();
                    break;
                default:
                    System.out.println("Wybrałeś niepoprawną opcje");
                    break;
            }
        }
    }


    private static void saveFile() {
        fileName = "dane.ser";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(eMan);
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się znaleźć pliku!");
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać dancyh do pliku!");
        }
    }

    private static void searchByHrid() {
        int search = -1;
        Employee e;
        System.out.println("\nPodaj HRID jakie chcesz wyszukać: ");
        while(search == -1) {
            search = ProgramUtils.getInt();
        }
        e = eMan.getEmployeeByHrid(search);
        if(e==null) {
            System.out.println("Nie znaleziono takiego pracownika!");
        } else {
            System.out.println("\nZnaleziony pracownik: ");
            System.out.println(e.toString());
        }
    }

    private static void searchByName() {
        String search;
        Employee e;
        System.out.println("Podaj nazwisko do wyszukania: ");
        search = in.next();
        e = eMan.getEmployeeByLastName(search);
        if(e==null) {
            System.out.println("Nie znaleziono pracownika o nazwisku: " + search);
        } else {
            System.out.println("Znaleziony pracownik: ");
            System.out.println(e.toString());
        }
    }

    private static void addNewEmployee() {
        int hrid;
        String firstName;
        String lastName;
        String department;
        int salary;
        String phoneNumber;

        System.out.println("\nDodawanie nowego pracownika");
        System.out.println("\nPodaj HR ID: ");
        hrid = ProgramUtils.getInt();
        while(hrid<=0) {
            hrid = ProgramUtils.getInt();
        }
        System.out.println("Podaj imię: ");
        firstName = in.next();
        System.out.println("Podaj nazwisko: ");
        lastName = in.next();
        System.out.println("Podaj dział w jakim został zatrudniony pracownik: ");
        department = in.next();
        System.out.println("Podaj wysokosc pensji: ");
        salary = ProgramUtils.getInt();
        while(salary <= 0) {
            salary = ProgramUtils.getInt();
        }
        System.out.println("Podaj numer telefonu: ");
        phoneNumber = in.next();

        Employee e = new Employee(hrid, firstName, lastName, department, salary, phoneNumber);
        eMan.addEmployee(e);
    }

    private static void saveAndQuit() {
        running = false;
        saveFile();
    }

    private static void loadFile() {
        fileName = "dane.ser";
        FileInputStream fis = null;
        ObjectInputStream oin = null;

        File file = new File(fileName);
        if(file.exists()) {
            try {
                fis = new FileInputStream(file);
                oin = new ObjectInputStream(fis);
                eMan = (EmployeeManager) oin.readObject();
            } catch (Exception e) {
                System.out.println("Wystąpił problem podczas pobierania danych z pliku!");
            }
        } else {
            System.out.println("\nPlik z danymi nie istnieje!");
        }
    }
}

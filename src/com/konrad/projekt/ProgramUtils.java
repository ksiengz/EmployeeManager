package com.konrad.projekt;

import java.util.Scanner;

/**
 * Created by Konrad on 02.02.2017.
 */
public class ProgramUtils {

    public static void printMainMenu() {
        System.out.println("\nWybierz 1 aby wyświetlić listę pracowników"
                + "\nWybierz 2 aby dodać nowego pracownika"
                + "\nWybierz 3 aby wyszukać pracownika po nazwisku" +
                "\nWybierz 4 aby wyszukać pracownika po hrid" +
                "\nWybierz 5 aby przeglądać bazę po jednym elemencie" +
                "\nWybierz 6 aby posortować dane po hrid rosnąco" +
                "\nWybierz 7 aby posortować dane po hrid malejąco" +
                "\nWybierz 8 aby zapisać aktualny stan bazy" +
                "\nWybierz 0 aby zapisać bazę i wyjść z programu");
    }

    public static int getInt() {
        Scanner in = new Scanner(System.in);
        try{
            return in.nextInt();
        } catch (Exception e) {
            System.out.println("Podaj prawidłową liczbę");
            return -1;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}

/*
 * Project: UB07 Strings
 * encrypts/decrypts Strings in a limited
 * Extras: put in "HOW DO YOU TURN THIS ON" for extra commands
 * Author: Benjamin Lamprecht
 * Last Change: 02.11.2021
 */


import java.util.Scanner;

public class Encryption {

    static Scanner scanner = new Scanner(System.in);
    static boolean inOption = false;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("1 - Encrypt text");
        System.out.println("2 - Decrypt text");
        System.out.println("9 - Quit");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("> ");
        //
        switch (getIntOption()) {
            case 1 -> {
                System.out.println(Enigma.encode());
                menu();
            }
            case 2 -> {
                System.out.println(Enigma.decode());
                menu();
            }
            case 9 -> {
            }
            default -> menu();
        }
    }

    public static int getIntOption() {

        while (true) {
            try {
                int i = i = Integer.parseInt(scanner.nextLine());
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                menu();
                return 9;
            }

        }
    }
    public static int getIntRotation() {

        while (true) {
            try {
                System.out.print("Enter rotation: ");
                int i = i = Integer.parseInt(scanner.nextLine());
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
            }

        }
    }
}

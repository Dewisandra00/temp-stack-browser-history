package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String currentPage = "Home";

        while (true) {
            System.out.println("\n=== Browser History ===");
            System.out.println("Current Page: " + currentPage);
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int pilih = sc.nextInt();
            sc.nextLine(); // enter

            switch (pilih) {
                case 1:
                    System.out.print("Enter new page URL: ");
                    String newPage = sc.nextLine();

                    backStack.push(currentPage);
                    currentPage = newPage;
                    forwardStack.clear();

                    System.out.println("You visited: " + currentPage);
                    break;

                case 2:
                    if (!backStack.isEmpty()) {
                        forwardStack.push(currentPage);
                        currentPage = backStack.pop();
                        System.out.println("Back to: " + currentPage);
                    } else {
                        System.out.println("Tidak bisa Back!");
                    }
                    break;

                case 3:
                    if (!forwardStack.isEmpty()) {
                        backStack.push(currentPage);
                        currentPage = forwardStack.pop();
                        System.out.println("Forward to: " + currentPage);
                    } else {
                        System.out.println("Tidak bisa Forward!");
                    }
                    break;

                case 4:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

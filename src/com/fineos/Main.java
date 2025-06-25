package com.fineos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        ClaimService service = new ClaimService("claims.db");
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Submit Claim 2. List Claims 3. Update Status 4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.print("Type: ");
                    String type = scanner.next();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    service.submitClaim(name, type, amount);
                    break;
            }

        }

    }

}
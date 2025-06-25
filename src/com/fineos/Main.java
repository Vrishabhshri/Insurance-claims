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
                case 2:
                    service.listClaims();
                    break;
                case 3:
                    System.out.print("Claim ID: ");
                    int id = scanner.nextInt();
                    System.out.print("New Status: ");
                    String status = scanner.next();
                    service.updateClaimStatus(id, status);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
            }

        }

    }

}
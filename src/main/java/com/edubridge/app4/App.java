package com.edubridge.app4;

import java.util.List;
import java.util.Scanner;

import com.edubridge.app4.model.Aircooler; // Import Aircooler model
import com.edubridge.app4.service.AircoolerService; // Import the service for Aircoolers

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        AircoolerService service = new AircoolerService(); // Instantiate service for air coolers
        String brand, model, specifications;
        double price;

        do {
            System.out.println("Welcome to Aircooler Management Application");
            System.out.println("============================================");
            System.out.println("1. Add Aircooler");
            System.out.println("2. View All Aircoolers");
            System.out.println("3. Search Aircooler");
            System.out.println("4. Update Aircooler");
            System.out.println("5. Delete Aircooler");
            System.out.println("6. Delete All Aircoolers");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New Aircooler");
                    System.out.println("------------------");
                    System.out.print("Enter Aircooler Brand: ");
                    brand = in.next();
                    System.out.print("Enter Aircooler Model: ");
                    model = in.next();
                    System.out.print("Enter Aircooler Price: ");
                    price = in.nextDouble();
                    System.out.print("Enter Specifications: ");
                    specifications = in.next();

                    Aircooler aircooler = new Aircooler();
                    aircooler.setBrand(brand);
                    aircooler.setModel(model);
                    aircooler.setPrice(price);
                    aircooler.setSpecifications(specifications);

                    service.addAircooler(aircooler); // Add air cooler to the service
                    break;

                case 2:
                    System.out.println("View All Aircoolers");
                    System.out.println("--------------------");
                    List<Aircooler> aircoolers = service.getAllAircoolers(); // Fetch all air coolers
                    if (!aircoolers.isEmpty()) {
                        for (Aircooler ac : aircoolers) {
                            System.out.println(ac.getId() + "\t" + ac.getBrand() + "\t" + ac.getModel() + "\t" + ac.getPrice() + "\t" + ac.getSpecifications());
                        }
                    } else {
                        System.out.println("No air coolers found.");
                    }
                    break;

                case 3:
                    System.out.println("Search Aircooler");
                    System.out.println("-----------------");
                    System.out.print("Please enter air cooler id: ");
                    int id = in.nextInt();
                    Aircooler ac = service.getAircoolerById(id); // Fetch air cooler by ID
                    if (ac != null) {
                        System.out.println("Aircooler Brand: " + ac.getBrand());
                        System.out.println("Aircooler Model: " + ac.getModel());
                        System.out.println("Aircooler Price: " + ac.getPrice());
                        System.out.println("Specifications: " + ac.getSpecifications());
                    } else {
                        System.out.println("No air cooler found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update Aircooler Details");
                    System.out.println("--------------------------");
                    System.out.print("Enter Aircooler Id: ");
                    int aircoolerId = in.nextInt();
                    System.out.print("Enter Aircooler Brand: ");
                    brand = in.next();
                    System.out.print("Enter Aircooler Model: ");
                    model = in.next();
                    System.out.print("Enter Aircooler Price: ");
                    price = in.nextDouble();
                    System.out.print("Enter Specifications: ");
                    specifications = in.next();

                    Aircooler updatedAircooler = new Aircooler();
                    updatedAircooler.setId(aircoolerId);
                    updatedAircooler.setBrand(brand);
                    updatedAircooler.setModel(model);
                    updatedAircooler.setPrice(price);
                    updatedAircooler.setSpecifications(specifications);

                    service.updateAircooler(updatedAircooler); // Update air cooler information
                    break;

                case 5:
                    System.out.println("Delete Aircooler");
                    System.out.println("------------------");
                    System.out.print("Please enter air cooler id: ");
                    int aircoolerIdToDelete = in.nextInt();
                    service.deleteAircooler(aircoolerIdToDelete); // Delete an air cooler by ID
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all air coolers? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllAircoolers(); // Delete all air coolers
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a correct option.");
                    break;
            }

        } while (option != 0);
    }
}

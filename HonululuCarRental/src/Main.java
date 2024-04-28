import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ourMenu(input);
        pickCustomer(input);
        writeContract(input);
    }

    public static void ourMenu(Scanner input) {
        System.out.println("X****************************************************************X");
        System.out.print("\t\tWelcome to Contract Creater\n");
        String italic = ("\t\t\033[3m" + "only at Honolulu Car Rental APS" + "\033[0m");
        System.out.println(italic);
        System.out.println("X****************************************************************X");
    }

    public static void pickCustomer(Scanner input) {
        int answer;

        System.out.println("Press 1 for Private Renter\nPress 2 for Company Renter");
        answer = input.nextInt();

        if (answer == 1) {
            priCustomer(input);
        } else if (answer == 2) {
            comCustomer(input);
        }
    }
    public static void priCustomer(Scanner input) {
        System.out.println("Enter Name of Driver");
        String nameDriver = input.next();

        System.out.println("Enter Adress");
        String address = input.next();
        input.nextLine(); //Spørg Cay, hvorfor virker det at indsætte nextLine her?

        System.out.println("Enter zip code");
        int zip = input.nextInt();

        System.out.println("Enter city");
        String city = input.next();

        System.out.println("Enter phone number");
        int phoneNr = input.nextInt();

        System.out.println("Enter e-mail");
        String email = input.next();

        System.out.println("Enter Drivers License Number");
        int licenseNr = input.nextInt();

        System.out.println("Enter Driver since date (MM-DD-YY");
        String sinceDate = input.next();

    }
        public static void writeContract(Scanner input, String nameDriver, String Address) throws IOException {

            //anvender localdate til at bruge den aktuelle dato på hvornår kontrakten oprettes
            LocalDate currentDate = LocalDate.now();

            //Vi vil have systemet til at oprette en fil der hedder Contract + dagens dato
            String fileName = "Contract_" + currentDate + ".txt";

            //Filen oprettes
            FileWriter writer = new FileWriter(fileName);

            // Write some content to the file
            writer.write("This is a new contract created on " + currentDate + ".");

            writer.write("Name:" + nameDriver);
            writer.write("Number:" + address);
            writer.close();
        }
    public static void comCustomer(Scanner input) {
        int answer;
        String ans;

        System.out.println("Enter Name of Driver");
        System.out.println("Enter Adress");
        System.out.println("Enter zip code");
        System.out.println("Enter city");
        System.out.println("Enter phone number");
        System.out.println("Enter e-mail");

        System.out.println("Enter Company Name");
        System.out.println("Enter Company Address");
        System.out.println("Enter Company Phone number");
        System.out.println("Enter Company Registration Number (6 digits)");

    }


    public static void options(Scanner input) {

        System.out.println("Select car category:\nPress 1 for Family\nPress 2 for Luxery\nPress 3 for Sport\nPress 0 to quit.");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.println("Press 1 for \nPress 2 for xx\nPress 3 for xxx");
                break;

            case 2:
                System.out.println("Press 1 for x");
                break;


            case 3:
                System.out.println("Press 1 for x jfdsjf");
                break;

            case 0:
                System.out.println("Thank you, Goodbye!");
                System.exit(0);

            default:
                System.out.println("Number is invalid, please choose a number between 0-3.");

        }
    }
}


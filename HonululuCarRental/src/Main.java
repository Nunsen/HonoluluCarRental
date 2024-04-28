import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ourMenu(input);
        pickCustomer(input);
        //options(input);
    }
    public static void ourMenu(Scanner input) {
        System.out.println("X****************************************************************X");
        System.out.print("\t\tWelcome to Contract Creater\n");
        String italic = ("\t\t\033[3m" + "only at Honolulu Car Rental APS" + "\033[0m");
        System.out.println(italic);
        System.out.println("X****************************************************************X");
    }

    public static void pickCustomer(Scanner input) throws IOException {
        int answer;

        System.out.println("Press 1 for Private Renter\nPress 2 for Company Renter");
        answer = input.nextInt();

        if (answer == 1) {
            customerInfo(input);
        } else if (answer == 2) {
            customerInfo(input);
            comCustomer(input);
        }
    }
    public static void customerInfo(Scanner input) throws IOException {
        System.out.println("Enter Name of Driver");
        String nameDriver = input.next();

        System.out.println("Enter Adress");
        String address = input.nextLine();
        input.nextLine();

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
        input.nextLine();
        String sinceDate = input.next();

        writeContract(input, nameDriver, address,zip, city, phoneNr, email, licenseNr, sinceDate);
    }
    public static void comCustomer(Scanner input) {
        System.out.println("Enter Company Name");
        String comName = input.next();

        System.out.println("Enter Company Address");
        String comAddress = input.next();

        System.out.println("Enter Company Phone number");
        int comPhone = input.nextInt();

        System.out.println("Enter Company Registration Number (6 digits)");
        int comReg = input.nextInt();

        writeContract(input, comName, comAddress, comPhone, comReg);
    }
    public static void writeContract(Scanner input, String nameDriver, String address, int zip, String city, int phoneNr, String email, int licenseNr, String sinceDate, String comName, String comAddress, int comPhone, int comReg) throws IOException {
        //anvender localdate til at bruge den aktuelle dato på hvornår kontrakten oprettes
        LocalDate currentDate = LocalDate.now();

        //Vi vil have systemet til at oprette en fil der hedder Contract + dagens dato
        String fileName = "Contract_" + currentDate + ".txt";

        //Filen oprettes
        FileWriter writer = new FileWriter(fileName);

        // Write some content to the file
        writer.write("This is a new contract created on " + currentDate + "." + "\n");

        writer.write("Name of Driver: " + nameDriver + "\n");
        writer.write("Address: " + address + "\n");
        writer.write("Zip code: " + zip + "\n");
        writer.write("City: "+ city + "\n");
        writer.write("Phone number: " + phoneNr + "\n");
        writer.write("E-mail: " + email + "\n");
        writer.write("Drives License Number: " + licenseNr + "\n");
        writer.write("Driver since date: " + sinceDate + "\n");

        writer.write("Comany Name: " + comName + "\n");
        writer.write("Company Address: " + comAddress + "\n");
        writer.write("Company Phone number: " + comPhone + "\n");
        writer.write("Company Registration Number: "+ comReg + "\n");

        writer.close();
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


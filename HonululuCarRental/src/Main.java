import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ourMenu(input);
        pickCustomer(input);
        //pickCar(input);
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

        //vælge om det er privat eller company, tilføjer boolean for at tilføje ekstra spørgsmål hvis customerIsCompany
        if (answer == 1) {
            customerInfo(input, false);
        } else if (answer == 2) {
            customerInfo(input, true);
        }
    }
    public static void customerInfo(Scanner input, boolean customerIsCompany) throws IOException {
        System.out.println("Enter Name of Driver");
        String nameDriver = input.next();
        input.nextLine();

        System.out.println("Enter Adress");
        String address = input.next();
        input.nextLine();
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
        String sinceDate = input.next();

        //boolean hvis der bliver valgt 2 (dvs. true til at customerIsCompany)
        if (customerIsCompany){
            System.out.println("Enter Company Name");
            String comName = input.next();

            System.out.println("Enter Company Address");
            String comAddress = input.next();

            System.out.println("Enter Company Phone number");
            int comPhone = input.nextInt();

            System.out.println("Enter Company Registration Number (6 digits)");
            int comReg = input.nextInt();

            //hvis det er company skal alle parametre bruges
            writeContract(input, customerIsCompany, nameDriver, address, zip, city, phoneNr, email, licenseNr, sinceDate,
                    comName, comAddress, comPhone, comReg);
        }else {
            /*Hvis ikke customerIsCompany skal de sidste parametre ikke bruges, derfor anvendes en pladsholder!
            Man kan ikke slette dem helt, da de stadig findes nede i metoden.*/
            writeContract(input, customerIsCompany, nameDriver, address, zip, city, phoneNr, email, licenseNr, sinceDate,
                    "", "", 0, 0);
        }
    }
    public static void writeContract(Scanner input, boolean customerIsCompany, String nameDriver, String address, int zip, String city, int phoneNr, String email, int licenseNr, String sinceDate, String comName, String comAddress, int comPhone, int comReg) throws IOException {
        //anvender localdate til at bruge den aktuelle dato på hvornår kontrakten oprettes
        LocalDate currentDate = LocalDate.now();

        //Vi vil have systemet til at oprette en fil der hedder Contract + dagens dato, fremfor at vi laver en fil
        String fileName = "Contract_" + currentDate + ".txt";

        //Filen oprettes
        FileWriter writer = new FileWriter(fileName);

        //følgende informationer skrives ind i filen
        writer.write("This is a new contract created on " + currentDate + "." + "\n");

            writer.write("Name of Driver: " + nameDriver + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Zip code: " + zip + "\n");
            writer.write("City: " + city + "\n");
            writer.write("Phone number: " + phoneNr + "\n");
            writer.write("E-mail: " + email + "\n");
            writer.write("Drives License Number: " + licenseNr + "\n");
            writer.write("Driver since date: " + sinceDate + "\n");

        /*HVIS der blev valgt at customerIsCompany (hvilket gennem && operator tjekkes ved at tjekke
         om det første spørgsmål comName.isEmpty, dvs. at det er udfyldt (det er det)
         --> så printes følgende også over i filen*/
         if (customerIsCompany && !comName.isEmpty()){
            writer.write("Comany Name: " + comName + "\n");
            writer.write("Company Address: " + comAddress + "\n");
            writer.write("Company Phone number: " + comPhone + "\n");
            writer.write("Company Registration Number: " + comReg + "\n");
        }
         writer.close();
    }
    public static void pickCar(Scanner input) {

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


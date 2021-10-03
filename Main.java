/*
---------------------------------------------------------------------------------------------------------
Assignment 1
Question: 2
Written by: Nicole Um (40112704)

Purpose: The program is used to keep track of the consumer information within the consumer database.
 ---------------------------------------------------------------------------------------------------------
*/

package com.company;
import java.util.Scanner;

/**
 * COMP 249
 * Class Main is the Driver class of assignment 1
 * @author Nicole Um (40112704)
 * @version 1.2
 * Assignment#: 1
 * Due Date: October 3rd, 2021, 11:59PM
 */
public class Main {

    private static Consumer[] consumerDatabase;
    private static int overallTracker =0, option1Tracker =0, option2Tracker = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //welcome message
        System.out.println("*****************************************************************************" +
                "\n\t\t\t\t\tWelcome to the Consumer Database!" +
                "\n*****************************************************************************\n");

        //Prompting the user for maximum number of consumers the company can handle.
        System.out.print("Enter the maximum number of consumers the company can manage > ");
        int maxNum = scanner.nextInt();
        consumerDatabase = new Consumer[maxNum];

        //main menu
        do {
            System.out.println("\n************************************************************************");
            System.out.println("What do you want to do?");
            System.out.println("\t1. Enter a new Consumer (password required)\n"
                    + "\t2. Change information of a Consumer (password required)\n"
                    + "\t3. Display all Consumers similar to a given consumer\n"
                    + "\t4. Display all Consumers with given age and location\n"
                    + "\t5. Quit" +
                    "\n************************************************************************\n");

            System.out.print("Please enter your choice > ");
            int menuChoice = scanner.nextInt();

            //switch to carry out function depending on user's choice
            switch (menuChoice) {
                case 1:
                    option1Tracker = passwordChecker(); // calling password checker to check the password validity

                    //if user enters 3 incorrect password, overallTracker is increased by 1 and the main menu page will be displayed
                    if (option1Tracker == 3) {
                        option1Tracker = 0;
                        overallTracker++;
                        if(overallTracker<3){System.out.println("Wrong password! Going back to the main menu...");}
                        break; //to leave the outer do/while & go back to main menu
                    }
                    else{ //if user enters the correct password, mainOption1() will be carried out
                        mainOption1();
                        break;
                    }

                case 2:
                    option2Tracker = passwordChecker();  //if user enters 3 incorrect password, the system will exit

                    if (option2Tracker == 3) {
                        System.out.println("Program terminated due to safety reasons.");
                        System.exit(0);
                    }
                    else{
                        mainOption2(); //if user enters the correct password, mainOption2() will be carried out
                    }
                    break;
                case 3:
                    //gathering age, gender, and education values and those values will be the parameter of findConsumerBy method to perform the search
                    System.out.println("Enter age, gender, and education values.");
                    System.out.print("\tAge: ");
                    int enteredAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\tGender: ");
                    String enteredGender = scanner.next();
                    System.out.println("\tEducation: ");
                    System.out.println("\t1. Elementary" + "\n\t2. Highschool" + "\n\t3. University" + "\n\t4. Others\n");
                    int eduSelected = scanner.nextInt();
                    while(eduSelected <1 || eduSelected >4){
                        System.out.println("Please enter a valid input.\n");
                        System.out.println("\n\t" + "Education:");
                        System.out.println("\t1. Elementary" + "\n\t2. Highschool" + "\n\t3. University" + "\n\t4. Others\n");
                        eduSelected = scanner.nextInt();
                        scanner.nextLine();
                    }
                    Edu enteredEdu;
                    if(eduSelected == 1){enteredEdu = Edu.ELEMENTARY;}
                    else if(eduSelected ==2){enteredEdu = Edu.HIGHSCHOOL;}
                    else if(eduSelected ==3){enteredEdu = Edu.UNIVERSITY;}
                    else {enteredEdu = Edu.OTHERS;}
                    findConsumerBy(enteredAge, enteredGender, enteredEdu); //calling the method
                    break;
                case 4:
                    //gather age and postal code values and those values will be the parameter of findConsumerByAgeNLocation method to perform the search
                    System.out.print("Please enter age and postal code.\n" + "\tAge: ");
                    enteredAge = scanner.nextInt();
                    System.out.print("\tPostal Code: ");
                    String enteredPostalCode = scanner.next();
                    scanner.nextLine();
                    findConsumerByAgeNLocation(enteredAge, enteredPostalCode); //calling the method
                    break;
                case 5: //quitting the program
                    System.out.println("Thank you for using the Consumer Database! Have a great day.");
                    System.exit(0);
            }
        }
        while (overallTracker < 3 && option2Tracker < 3) ; //ensuring that the number of times that user enters incorrect password stays within the allowed limit


        //program exit after consecutive 12 failed attempts (when overallTracker is 3)
        if (overallTracker == 3) {
            System.out.println("Program has detected suspicious activity and will terminate immediately!");
            System.exit(0);
        }
        scanner.close();
    }

    /**
     * A public static void method that accepts enter age, gender, and education values adn then performs the search to display the information of all consumers similar to the one entered by the user.
     * @param age an integer age value
     * @param gender a String gender value
     * @param edu an enum education status value
     */
    public static void findConsumerBy (int age, String gender, Edu edu){
        int numberOfResults = 0;
        int numOfConsumer = Consumer.getNumberOfConsumer();
        if (numOfConsumer!=0) {
            for (int i=0; i < Consumer.getNumberOfConsumer(); i++) {
                if (consumerDatabase[i].getAge() == age && consumerDatabase[i].getGender().equalsIgnoreCase(gender) && consumerDatabase[i].getEducation() == edu) {
                    System.out.println(consumerDatabase[i].toString() + "\n");
                    numberOfResults++;
                }
            }
        }
        if(numberOfResults==0){System.out.println("No consumer found.\n");}
    }

    /**
     * A public static void method that accepts entered age and postal code as parameters and performs the search to display the information of all consumers similar to the one entered by the user.
     * @param age an integer age value
     * @param postalCode a String postal code value
     */
    public static void findConsumerByAgeNLocation(int age, String postalCode){
        int numberOfResults = 0;
        int numOfConsumer = Consumer.getNumberOfConsumer();
        if(numOfConsumer!=0) {
            for (int i=0; i < Consumer.getNumberOfConsumer(); i++) {
                if (consumerDatabase[i].getAge() == age && consumerDatabase[i].getPostalCode().equalsIgnoreCase(postalCode)) {
                    System.out.println(consumerDatabase[i].toString() + "\n");
                    numberOfResults++;
                }
            }
        }
        if(numberOfResults==0){System.out.println("No consumer found.");}
    }

    /**
     * A static void method that carries out functions of main menu option 1.
     */
    public static void mainOption1(){
        Scanner scanner = new Scanner(System.in);
        int consumerToAdd;
        int availableSpace;
        do {
            System.out.print("How many users do you want to add?  > ");
            consumerToAdd = scanner.nextInt();
            scanner.nextLine();

            availableSpace = 0;
            for (int i =0; i<consumerDatabase.length; i++){if (consumerDatabase[i] == null) {availableSpace++;}}

            if (consumerToAdd > availableSpace) {System.out.println("There is no enough space in the consumer database! Please enter smaller number again.");}
            else if(consumerToAdd <= 0){System.out.println("Please enter a valid input.");}

        }
        while (consumerToAdd > availableSpace || consumerToAdd <=0);

        for (int i = 0; i < consumerToAdd; i++) {
            Consumer newConsumer = new Consumer();
            System.out.println("Please enter the following information for User " + (i+1) + ":");
            System.out.print("\t" + "Name: ");
            String enteredName = scanner.nextLine();
            newConsumer.setName(enteredName);

            System.out.print("\t" + "Age: ");
            newConsumer.setAge(scanner.nextInt());
            scanner.nextLine();

            System.out.print("\t" + "Street Number: ");
            newConsumer.setStreetNum(scanner.nextInt());
            scanner.nextLine();

            System.out.print("\t" + "Street Name: ");
            newConsumer.setStreetName(scanner.nextLine());

            System.out.print("\t" + "City: ");
            newConsumer.setCity(scanner.nextLine());

            System.out.print("\t" + "Postal Code: ");
            newConsumer.setPostalCode(scanner.nextLine());

            System.out.println("\t" + "Gender:");
            System.out.print("\t1. Male" + "\n\t2. Female" + "\n\t3. Others\n");
            int genderChoice = scanner.nextInt();
            scanner.nextLine();
            while(genderChoice<1 || genderChoice > 3){
                System.out.println("Please enter a valid input.");
                System.out.println("\t" + "Gender: ");
                System.out.print("\t1. Male" + "\n\t2. Female" + "\n\t3. Others\n");
                genderChoice = scanner.nextInt();
                scanner.nextLine();
            }
            if (genderChoice == 1){newConsumer.setGender("Male");}
            else if (genderChoice == 2){newConsumer.setGender("Female");}
            else {newConsumer.setGender("Others");}

            System.out.println("\n\t" + "Marital Status: ");
            System.out.println("\t1. Single" + "\n\t2. Married" + "\n\t3. Widowed" + "\n\t4. Divorced" + "\n\t5. Others");
            int mStatusChoice = scanner.nextInt();
            scanner.nextLine();
            while(mStatusChoice <1 || mStatusChoice >5){
                System.out.println("Please enter a valid input.\n");
                System.out.println("\n\t" + "Marital Status:");
                System.out.println("\t1. Single" + "\n\t2. Married" + "\n\t3. Widowed" + "\n\t4. Divorced" + "\n\t5. Others");
                mStatusChoice = scanner.nextInt();
                scanner.nextLine();
            }
            if (mStatusChoice == 1){newConsumer.setMaritalStatus(MStatus.SINGLE);}
            else if (mStatusChoice == 2){newConsumer.setMaritalStatus(MStatus.MARRIED);}
            else if (mStatusChoice ==3){newConsumer.setMaritalStatus(MStatus.WIDOWED);}
            else if (mStatusChoice == 4){newConsumer.setMaritalStatus(MStatus.DIVORCED);}
            else {newConsumer.setMaritalStatus(MStatus.OTHERS);}

            System.out.println("\n\t" + "Education: ");
            System.out.println("\t1. Elementary" + "\n\t2. Highschool" + "\n\t3. University" + "\n\t4. Others");
            int eduChoice = scanner.nextInt();
            scanner.nextLine();
            while(eduChoice <1 || eduChoice >4){
                System.out.println("Please enter a valid input.\n");
                System.out.println("\n\t" + "Education:");
                System.out.println("\t1. Elementary" + "\n\t2. Highschool" + "\n\t3. University" + "\n\t4. Others");
                eduChoice = scanner.nextInt();
                scanner.nextLine();
            }
            if (eduChoice == 1){newConsumer.setEducation(Edu.ELEMENTARY);}
            else if (eduChoice == 2){newConsumer.setEducation(Edu.HIGHSCHOOL);}
            else if (eduChoice == 3){newConsumer.setEducation(Edu.UNIVERSITY);}
            else {newConsumer.setEducation(Edu.OTHERS);}

            consumerDatabase[i] = newConsumer;
        }
    }

    /**
     * A static void method that carries out the functions of main menu option 2.
     */
    public static void mainOption2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which consumer information would you like to change? Please enter the consumer number >");
        int consumerNum = scanner.nextInt();
        scanner.nextLine();
        int infoChangeChoice;
        int reEnterYesOrNo;

        while(consumerDatabase[consumerNum-1] == null){
            do {
                System.out.println("There is no information about consumer #" + consumerNum + "\n" +
                        "\t1. Re-enter another consumer.\n\t2. Quit");
                reEnterYesOrNo = scanner.nextInt();
                scanner.nextLine();
            }
            while (!(reEnterYesOrNo ==1 || reEnterYesOrNo ==2));

            if (reEnterYesOrNo == 1){
                System.out.print("Which consumer information would you like to change? Please enter the consumer number >");
                consumerNum = scanner.nextInt();
                scanner.nextLine();
            }
            else {
                System.out.println("Going back to the main menu...");
                return;
            }
        }

        do{
            System.out.println("Displaying the current information of consumer #" + consumerNum + "\n");
            System.out.println("Consumer: # " + consumerNum);
            System.out.println(consumerDatabase[consumerNum - 1].toString());

            System.out.print("What information would you like to change? \n" +
                    "\t1.\tConsumer name\n" +
                    "\t2.\tLocation\n" +
                    "\t3.\tAge\n" +
                    "\t4.\tGender\n" +
                    "\t5.\tMarital Status\n" +
                    "\t6.\tQuit\n" +
                    "Please enter your choice > ");
            infoChangeChoice = scanner.nextInt();

            while ((infoChangeChoice < 1) || (infoChangeChoice > 6)) {
                System.out.println("Please enter a valid menu choice.");
                System.out.println("Please enter your choice > ");
                infoChangeChoice = scanner.nextInt();
            }

            switch (infoChangeChoice) {
                case 1:
                    System.out.print("Enter a new consumer name: ");
                    consumerDatabase[consumerNum - 1].setName(scanner.next());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter a new consumer location >");
                    System.out.print("\tStreet Number: ");
                    consumerDatabase[consumerNum - 1].setStreetNum(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("\tStreet Name: ");
                    consumerDatabase[consumerNum - 1].setStreetName(scanner.nextLine());
                    System.out.print("\tCity: ");
                    consumerDatabase[consumerNum - 1].setCity(scanner.nextLine());
                    System.out.print("\t Postal Code: ");
                    consumerDatabase[consumerNum - 1].setPostalCode(scanner.nextLine());
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter a new consumer age: ");
                    consumerDatabase[consumerNum - 1].setAge(scanner.nextInt());
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter a new consumer gender > ");
                    consumerDatabase[consumerNum - 1].setGender(scanner.next());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n\t" + "Marital Status: ");
                    System.out.println("\t1. Single" + "\n\t2. Married" + "\n\t3. Widowed" + "\n\t4. Divorced" + "\n\t5. Others");
                    int mStatusChoice = scanner.nextInt();
                    scanner.nextLine();
                    while(mStatusChoice <1 || mStatusChoice >5){
                        System.out.println("Please enter a valid input.\n");
                        System.out.println("\n\t" + "Marital Status:");
                        System.out.println("\t1. Single" + "\n\t2. Married" + "\n\t3. Widowed" + "\n\t4. Divorced" + "\n\t5. Others");
                        mStatusChoice = scanner.nextInt();
                        scanner.nextLine();
                    }
                    if (mStatusChoice == 1){consumerDatabase[consumerNum-1].setMaritalStatus(MStatus.SINGLE);}
                    else if (mStatusChoice == 2){consumerDatabase[consumerNum-1].setMaritalStatus(MStatus.MARRIED);}
                    else if (mStatusChoice ==3){consumerDatabase[consumerNum-1].setMaritalStatus(MStatus.WIDOWED);}
                    else if (mStatusChoice == 4){consumerDatabase[consumerNum-1].setMaritalStatus(MStatus.DIVORCED);}
                    else {consumerDatabase[consumerNum-1].setMaritalStatus(MStatus.OTHERS);}
                    break;
                default:
                    break;
            }
        }
        while (infoChangeChoice != 6) ;

        System.out.println("Going back to the main menu ...");//GOING BACK TO THE MAIN MENU
        }

    /**
     * Checks password for option 1 and option and exits the option after failing inputting the correct password for three times.
     * @return passwordTracker an integer variable that counts whenever user enters an incorrect password.
     */
    public static int passwordChecker(){
        String password;
        Scanner scanner = new Scanner(System.in);
        int passwordTracker = 0;
        final String PWD = "password";

        do {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            if (!password.equals(PWD)) {
                passwordTracker++;
                if (passwordTracker <3) {System.out.println("Wrong password! Please enter your password again.");}
            }
        }
        while (!password.equals(PWD) && passwordTracker < 3);

        if(passwordTracker < 3){return passwordTracker = 0;} //if user enters correct password
        else return passwordTracker; //returns passwordTracker =3
    }
}
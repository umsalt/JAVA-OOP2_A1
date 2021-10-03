/*
---------------------------------------------------------------------------------------------------------
Assignment 1
Question: 2
Written by: Nicole Um (40112704)

General explanation:    Consumer class creates objects of type Consumer. Each consumer will be stored in an array: consumerDatabase from the Driver Class.
                        This class includes default constructor, a copy constructor, a constructor, accessors and mutators of each member variables, declaration of each member variables.
                        equals method, toString method, as well as a static method called getNumberOfConsumer to keep track of number of consumers being created.
 ---------------------------------------------------------------------------------------------------------
*/

/**
 * This program creates objects of type Consumer. Each consumer object has a name, an age, a location which consists of a street number, a street name, a city, and a postal code, gender, marital status, and education.
 * Driver Class: ConsumerDemo
 * COMP 249
 * Class Main is the Driver class of assignment 1
 * @author Nicole Um (40112704)
 * @version 1.2
 * Assignment#: 1
 * Due Date: October 3rd, 2021, 11:59PM
 */
package com.company;

public class Consumer {
    /**
     * Member variables: streetNum (int), age (int), name (String), streetName (String), city (String), gender (String), postalCode (String), mStat (enum), and edu (enum)
     * numberOfConsumer (int) tracks the number of consumers in the database.
     */
    private int streetNum, age;
    private String name, streetName, city, gender, postalCode;
    private MStatus mStat;
    private Edu edu;


    private static int numberOfConsumer =0;

    /**
     * default constructor
     */
    public Consumer(){
        this.streetNum = 0;
        this.age = 0;
        this.name = null;
        this.streetName = null;
        this.postalCode = null;
        this.city = null;
        this.gender = null;
        this.mStat = null;
        this.edu = null;
        numberOfConsumer++;

    }

    /**
     * Constructs and initializes the following variables
     * @param name a String variable representing the name of the consumer.
     * @param age an integer variable representing the age of the consumer.
     * @param streetNum an integer variable representing the street number of the consumer's location.
     * @param streetName a String variable representing the street name of the consumer's location.
     * @param city a String variable representing the city of the consumer's location.
     * @param postalCode a String variable representing the postal code of the consumer's location.
     * @param gender a String variable representing the gender of the consumer.
     * @param mStat an enum variable that represents the consumer's marital status.
     * @param edu an enum variable that represents the consumer's education status.
     */
    public Consumer(String name, int age, int streetNum, String streetName, String city,
                    String postalCode, String gender, MStatus mStat, Edu edu) {
        this.streetNum = streetNum;
        this.age = age;
        this.name = name;
        this.streetName = streetName;
        this.city = city;
        this.gender = gender;
        this.postalCode = postalCode;
        this.mStat = mStat;
        this.edu = edu;

        numberOfConsumer++;
    }

    /**
     * Copy Constructor
     * @param anotherConsumer a consumer object to copy consumer information.
     */
    public Consumer(Consumer anotherConsumer){
        this.name = anotherConsumer.name;
        this.age = anotherConsumer.age;
        this.streetNum = anotherConsumer.streetNum;
        this.streetName = anotherConsumer.streetName;
        this.city = anotherConsumer.city;
        this.postalCode = anotherConsumer.postalCode;
        this.gender = anotherConsumer.gender;
        this.mStat = anotherConsumer.mStat;
        this.edu = anotherConsumer.edu;

    }

    /**
     * Accessor for streetNum
     * @return streetNum of the consumer object
     */
    public int getStreetNum() {return streetNum;}
    /**
     * Mutator for streetNum
     * @param streetNum sets the consumer's streetNumber.
     */
    public void setStreetNum(int streetNum) {this.streetNum = streetNum;}

    /**
     * Accessor for age
     * @return age of the consumer object
     */
    public int getAge() {return age;}

    /**
     * Mutator for age
     * @param age integer
     */
    public void setAge(int age) {this.age = age;}

    /**
     * Accessor for name
     * @return name of the consumer object
     */
    public String getName() {return name;}

    /**
     * Mutator for name
     * @param name String
     */
    public void setName(String name) {this.name = name;}

    /**
     * Accessor for street name
     * @return streetName of the consumer object
     */
    public String getStreetName() {return streetName;}

    /**
     * Mutator for street name
     * @param streetName String
     */
    public void setStreetName(String streetName) {this.streetName = streetName;}

    /**
     * Accessor for city
     * @return city of the consumer object
     */
    public String getCity() {return city;}

    /**
     * Mutator for city
     * @param city String
     */
    public void setCity(String city) {this.city = city;}

    /**
     * Accessor for gender
     * @return gender of the consumer object
     */
    public String getGender() {return gender;}

    /**
     * Mutator for gender
     * @param gender String
     */
    public void setGender(String gender) {this.gender = gender;}

    /**
     * Accessor for postal code
     * @return postal code of the consumer object
     */
    public String getPostalCode() {return postalCode;}

    /**
     * Mutator for postal code
     * @param postalCode String
     */
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    /**
     * Accessor for marital status
     * @return mStat marital status of the consumer object
     */
    public MStatus getMaritalStatus() {return mStat;}

    /**
     * Mutator for marital status
     * @param mStat enum variable from MStatus
     */
    public void setMaritalStatus(MStatus mStat ){this.mStat = mStat;}

    /**
     * Accessor for education
     * @return edu of the consumer object
     */
    public Edu getEducation(){return edu;}

    /**
     * Mutator for education
     * @param edu variable from Edu enum object
     */
    public void setEducation(Edu edu){this.edu = edu;}

    /**
     * toString Method that prints out consumer object's information.
     * @return prints out Consumer object's information as String.
     */
    public String toString() {return ("Name: " +name + "\n"+ "Age: " + age + "\n" + "Location: " + streetNum + " " + streetName + " " + city + " " + postalCode + "\n"+ "Gender: " + gender + "\n" + "Marital Status: " + mStat);}

    /**
     * A method that tracks the number of consumers in the database.
     * @return numberOfConsumer a number of consumer in the consumer database
     */
    public static int getNumberOfConsumer() {return numberOfConsumer;}

    /**
     * Equals method
     * @param a a consumer object to be compared with.
     * @return boolean value where returns true if the content is the same, and false if otherwise.
     */
    public boolean equals(Consumer a) {return this.name.equals(a.name)  && this.age == a.age && this.gender.equals(a.gender) && this.edu == a.edu;}
}

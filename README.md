# JAVA-OOP2_A1
Object Oriented Programming (JAVA) assignment #1: review of arrays and classes. 

Following is the assignment instructions. 

Consumer Class:
For this part, you are required to design and implement a Consumer class based on the below mentioned
specifications:
- A Consumer object has nine attributes, name (String), street number (int), street name (String), city (String), postal code (String), age (int), gender (String), marital status (Enum), education (Enum).
- Upon creation of a Consumer object, it must immediately be initialized with valid values for all the nine attributes. (Hint: use constructors.).
- The design should allow enough flexibility so that the value of any of these attributes can be modified later. For example, it should be possible to create a Consumer object with a given city and then change it later. The design should also allow a user to obtain value of any attributes. (Hint: use accessors & mutators.)
- The design should allow all information of an object to be displayed at once through utilization of System.out.print() method. (Hint: use toString() method).- - It is required to know how many Consumer objects have been created. For that, you need to add a method, called getNumberOfConsumers(), to the class. This method must return total number of Consumer objects created prior to invocation of this method. The method would simply return 0 if no Consumer has been created by the time the method is called. (Hint: use Static – You are allowed to add other attributes to the class.).
- It is required to compare two Consumer objects for similarity. Two Consumer objects are similar if they have the same age, gender, and education. (Hint: use equals() method).
- It is required to display any Consumer object (all info of that object) using System.out.println() method. (Hint: use toSting() method).

Driver Class:
You are hired by a marketing company to write a software application that helps them keep track of their consumer base.
Write a driver program that will contain the main()method and will perform the following: (Note: You can have the main function in a separate driver file, or in the same file if you prefer)
- Display a welcome message.
- Prompt the user for maximum number of consumers the company can handle. Create an empty
array, called consumerDatabase that will keep track of created Consumer objects.
- Display a main menu (figure 1) with the following choices and keep prompting the user until they
enter a number between 1 and 5 inclusive:

   
   What do you want to do?
1. Enter a new Consumer (password required)
2. Change information of a Consumer (password required)
3. Display all Consumers similar to a given consumer
4. Display all Consumers with given age and location
5. Quit
Please enter your choice >

 Figure 1. Main menu
1. When option 1 is entered:
• Prompt the user for his/her password. (Make sure you have a constant variable containing the
password “password” – do not use any other password as it will be easier for the grader to check your assignments). The user has a maximum of 3 attempts to enter the correct password. After the 3rd wrong attempt, the main menu in figure 1 is displayed again. Additionally, after this process is repeated 4 times (i.e. after consecutive 12 failed attempts), the program must display a message: “Program has detected suspicious activity and will terminate immediately!”, then the program must exit.
• If the correct password is entered, ask the user how many consumers he/she wants to enter. Check to make sure that there is enough space in the consumerDatabase (array of Consumer) to add that many consumers. If so, add them; otherwise inform the user that he/she can only add the number of remaining places in the array. (How the consumer information will be input/entered by the user, is up to you).

2. When option 2 is entered:
• Prompt the user for his/her password. (Make sure you have a constant containing the password
“password” as a constant – do not use another password). Again, the user has 3 attempts to enter the correct password. However, after the 3rd wrong attempt entry, the program must exit with a message “program terminated due to safety reasons” (notice difference in behavior to the one above).
• Once the correct password is entered, user is asked which consumer he/she wishes to update. The Consumer number is the index in the array consumerDatabase. If there is no Consumer at the specified index location, display a message asking user if he/she wishes to re-enter another consumer, or quit this operation and go back to the main menu. If the consumer is present, display the current information of that consumer in the following format:
Consumer: # x (index of the consumer in the consumerDatabase array) Name: name of the consumer
Location: Street number, Street name, City name, Postal Code
Age: Age value
Gender: Gender Value
Marital Status: Marital Status Value
Then ask the user which attribute they wish to change by displaying the following menu.

What information would you like to change?
1. Consumer name
2. Location
3. Age
4. Gender
5. Marital Status
6. Quit
Please enter your choice >

• Once the user has entered a correct choice, make the changes to the attribute then display again all the attributes on the screen to show that the attribute has been changed. Keep prompting the user for additional changes until the user enters 6. Each time the user is prompted for a choice make sure that a number from 1 to 6 is entered, otherwise keep prompting until a valid number is entered. (Ensure that the user can change any of the choice 1 to 5 on figure 2).

3. When option 3 (in the main menu shown in figure.1) is entered, prompt the user to enter age, gender, and education values. You then need to display the information of all consumers similar to the one entered by the user. (Hint: You may use a static method, for instance called findConsumersBy, which accepts enter age, gender, and education values and then performs the needed search).

4. When option 4 (in the main menu shown in figure. 1) is entered, prompt the user to enter values for age and postal code. You then need to display all consumers that have same age and postal code as entered by the user. (Hint: You may use a static method, called findConsumerByAgeNGender, which accepts age and postal code, then performs the needed search).

5. When option 5 (in the main menu shown in figure. 1) is entered, display a closing message, and end the driver.

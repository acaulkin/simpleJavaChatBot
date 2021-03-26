import java.util.Scanner;

public class chatBot {
    // Creating scanner object to be utilized by all methods
    public static Scanner scanner = new Scanner(System.in);

    // Driver method
    public static void main(String[] args) {

        // Initial startup message displayed to user
        startup();

        // User inputs name, name is displayed back in a message to user
        nameInput();

        // Guessing the user's age
        ageGuessing();

        // Counting to a number
        countToNumber();

        // Programming knowledge test
        // Yes, this contains a recursive call. Why? Because I am a masochist.
        knowledgeTest();
    }

    public static void knowledgeTest() {
        String[] initialMessage = {"Now I will test your programming knowledge.",
        "Why do we use methods?",
        "1.) To repeat a statement multiple time.",
        "2.) To decompose a program into small subroutines.",
        "3.) To determine the execution time of a program.",
        "4.) To interrupt the execution of a program."};
        displayMessage(initialMessage);

        String correctAnswerMessage = checkIfCorrect();

        System.out.println(correctAnswerMessage);
    }

    public static void countToNumber() {
        String[] initialMessage = {"Now I will prove to you I can count to any number.",
        "Please input a number for me to count to: "};
        displayMessage(initialMessage);
        int numberToCountTo = Integer.parseInt(scanner.nextLine());

        for (int index = 1; index <= numberToCountTo; index++) {
            System.out.println(index + "!");
        }
    }

    public static void ageGuessing() {
        String[] initialMessage = {"Let me guess your age.",
                "Tell me the remainders of dividing your age by 3, 5, and 7.",
                "For example, if you are 22, you would enter: 1 2 1"};
        displayMessage(initialMessage);

        String[] ageRemainders = scanner.nextLine().split(" ");
        Integer[] coefficients = {70, 21, 15};
        int runningSum = 0;
        // Looping through the age remainders because...
        // I like it better than manually accessing the values by reference
        for (int index = 0; index < ageRemainders.length; index++) {
            Integer currentAge = Integer.parseInt(ageRemainders[index]);
            runningSum += coefficients[index] * currentAge;
        }
        int userAge = runningSum % 105;

        System.out.println("Your age is: " + userAge + "!");
    }

    // Helper function that asks the for the user's name and then outputs its reults to the console
    public static void nameInput() {
        String userName = scanner.nextLine();
        System.out.println("What a great name you have, " + userName + "!");
    }

    // Startup message to user
    public static void startup() {
        String[] message = {"Hello! My name is Aid.",
                "I was created in 2021 by Andrew (AJ) Caulkins to help teach him Java.",
                "Please, remind me your name."};

        displayMessage(message);
    }

    // Recursive function to determine if the user input the correct answer within the knowledge test
    public static String checkIfCorrect() {
        String userInput = scanner.nextLine();
        if (userInput.equals("2")) {
            return "Correct Answer! Have a nice day.";
        }
        else {
            System.out.println("Incorrect Answer; try again!");
            return checkIfCorrect();
        }
    }

    // Helper method used to display larger (longer than one line) messages to the screen
    public static void displayMessage(String[] messageToDisplay) {
        for (String thisMessage : messageToDisplay) {
            System.out.println(thisMessage);
        }
    }
}

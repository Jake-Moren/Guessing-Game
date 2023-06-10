// Programmer: Jake Moren
// Class: CS 141 OL
// Date: 2/13/2023
// Assignment: Lab 4 Guessing Game  
// Reference Material: CS141 Week 7 videos and W3 Schools
// Purpose: To practive the use of while loops and methods

import java.util.Scanner;
import java.util.Random;

public class JMGuess
{//start of class
   
   public static void main(String [] args)
   {//start of main method
      Scanner input = new Scanner(System.in);
      int totalGames = 0;
      double totalGuesses = 0;
      double guessesPerGame = 0;
      int bestGame = 1000;
      boolean continueGame = true;
      intstructions(); 
           
      while(continueGame)
      {//start of while loop
         int numTries = playGame();
         totalGuesses += numTries; //totalGuesses = totalGuesses + numTries 
         // sum += numTries;
         totalGames++;
         if(numTries < bestGame)
         {//start of if statement
            bestGame = numTries;
         }//end of if statement
         
         System.out.println("Would you like to play again? Yes or No)");
         String userAnswer = input.next(); 
         
         if(userAnswer.toLowerCase().startsWith("y"))
         {//start of if statement
            continueGame = true;
         }//end of if statement
         else if(userAnswer.toLowerCase().startsWith("n"))
         {//start of else statement
            continueGame = false; 
            System.out.printf("Thank you for playing!%n%n");
            System.out.println("Overall results");
         
         }//end of else statment
      }//end of while loop
      
      report(totalGames, totalGuesses, guessesPerGame, bestGame);
   
   }//end of main method

   public static void intstructions()
   {//start of intsrtuctions method
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }//end of instructions method 
   
   public static int playGame()
   {//start of playGame method
      Scanner input = new Scanner(System.in);
      final int RANGE = 100;
      int numTries = 0;
      Random rand = new Random();//1-100
      int randomNumber = rand.nextInt(RANGE) + 1;
      int guess = -1; 

      while(guess != randomNumber)
         {//start of while loop
            numTries++; 
            //System.out.println(randomNumber);
            System.out.println("What number do you guess?");
            guess = input.nextInt();
            if (guess > randomNumber) 
            {//start of if statement
               System.out.println("It's Lower");
         
            }//end of if statement
            else if (guess < randomNumber)
            {//start of else statement
               System.out.println("It's Higher");
            }//end of else statement
            
            else
            {//start of else statement 
               String triesVariable = " try";
               if(numTries > 1) triesVariable = " tries";
               System.out.print("Congratulations, you got it in " + numTries);
               System.out.println(triesVariable);
            }//end of else statement           
          }//end of while loop
         
   return numTries;
   }//end of playGame method
   public static void report(int totalGames,
    double totalGuesses,
     double guessesPerGame, int bestGame)

   {//start of report method
      System.out.println("Total Games:" + totalGames);
      System.out.println("Total Guesses:" + totalGuesses) ;
      System.out.printf("Guesses per game: %.1f%n",  totalGuesses/totalGames);
      System.out.println("Best game:" + bestGame);
   }//end of report mehtod
}//end of class
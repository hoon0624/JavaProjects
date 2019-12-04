
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    
    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband", 
        "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher", 
        "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge", 
        "harmony", "problem","awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant", 
        "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain", 
        "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich", 
        "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter", 
        "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure", 
        "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling", 
        "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different", 
        "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education", 
        "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball", 
        "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government", 
        "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university", 
        "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard", 
        "understand", "leadership", "revolution"};  
    
    // this method takes an integer as input and returns a radom String from the array above. 
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }
    
    
    public static void main(String[] args) {
        play(1234);
    }
    
    // a method to check if the guess is valid 
    public static boolean isValidGuess(char a) {
    	if(a < 'a'|| a > 'z') {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    // a method to generate the array of guess 
    public static int[] generateArrayOfGuesses(String s) {
    	int[] arrayOfGuess = new int [s.length()];
    	
    	return arrayOfGuess;
    }
    
    // a method to check the guess and update the array if needed
    public static boolean checkAndUpdate(String s, int[] guesses, char c) {
    	for(int i = 0; i< s.length(); i++) {
    		if(s.charAt(i) == c) {
    			guesses[i] = 1;	
    			
    		}
    	}
    	for(int j = 0; j<s.length(); j++) {
    		if(s.charAt(j) == c) {
    			return true;
    		}
    	}
    	return false; 	
    }
    
    // a method to get the string to display
    public static String getWordToDisplay(String s, int[] guesses, char c) {
    	String display = "";
    	for(int i = 0; i<s.length(); i++) {
    		if(s.charAt(i) == c) {
    			display += Character.toString((char) (c - 32)); 
    		}
    		else if(guesses[i] == 1) {
    			display += Character.toString(s.charAt(i));
    		}
    		else {
    			display += "-"; 
    		}
    	}
    	return display;  	
    }
    
    // a method to check if the word has been completely guessed 
    public static boolean isWordGuessed(int[] guesses) {
    	int temp=0;
    	for(int i = 0; i<guesses.length; i++) {
    		if(guesses[i] == 1) {
    			temp++;
    		}
    	}
    	if(temp == guesses.length) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // a method to simulate a game
    public static void play(int a) {
    	Scanner read = new Scanner(System.in);
    	// generate a random word
    	String secretWord = (getRandomWord(a));
    	// generate array of guesses
    	int[] arrayOfGuess = generateArrayOfGuesses(secretWord);
    	// display welcome message
    	System.out.print("Welcome to Guess the Word!\n" + "Your secret word has been generated. It has "); 
    	System.out.print(secretWord.length() + " characters. You have 10 lives. Good luck!");
    	System.out.println();
    	
    
    	int life = 10;
        while(life > 0) {
        	// display a message how many lives the player has left and ask for their next guess
        	System.out.println("You have " + life + " lives left. Please enter a character:");
        		
        	String guess = read.nextLine();
        		
        	// display an error message if the player provides string that contains more than one character
            if(guess.length() > 1) {
            	System.out.println("You can only enter one single character. Try again!");
            	read.nextLine();
            }
            	
            // display an error message if the player provides a single character that isn't valid
            if(isValidGuess(guess.charAt(0)) == false) {
            	System.out.println("The character must be a lower case letter of the English alphabet. Try again!");
            	read.nextLine();
           	}
            	
        	// if the guess is correct 
            if(checkAndUpdate(secretWord, arrayOfGuess, guess.charAt(0)) == true) { 
       			System.out.println("Good job! The secret word contains the character " + "'" + guess.charAt(0) + "'");
       			System.out.println(getWordToDisplay(secretWord, arrayOfGuess, guess.charAt(0)));
       		}
       		
       		// if the guess is not correct
            if(checkAndUpdate(secretWord, arrayOfGuess, guess.charAt(0)) != true) {
       			System.out.println("There is no such character. Try again!");
       			System.out.println(getWordToDisplay(secretWord, arrayOfGuess, guess.charAt(0)));
       			life--;
       		}
       		
            // if the player has guessed the word
           	if(isWordGuessed(arrayOfGuess) == true) {
       			System.out.println("Congratulations you guessed the secret word!");
       			read.close();
       			break;
       		}
        }
        // if the player couldn't guess the word
        if(life == 0) {
        	System.out.println("You have no lives left, better luck next time! The secret word was: " + "\"" + secretWord + "\"");
        	read.close();
        }
    
    }
    
      
}    
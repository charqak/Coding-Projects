import java.util.Scanner;

public class StringValidation {
    public static void main(String[] args){        
//Using a scanner to read the input string
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String input = scan.nextLine();
        boolean isValid =  checkString(input);

        if(isValid == true){
            System.out.println("The srting entered is valid.");
        }
        else{
            System.out.println("The string entered is invalid.");
        }
        
        scan.close();
    }

//Method that carries out all of the validation checks on the string to see if it passes each condition
    private static boolean checkString(String input){
        boolean valid = true;
        boolean messagePrinted = false;
    
        if(!(Character.isUpperCase(input.charAt(0)))){
            System.out.println("Invalid string, first letter must start with a capital.");
            valid = false;
        }

//Creating a character array from the input string to make it easier to find quote marks 
//Setting up a counter to keep track of the amount of quote marks used in the sentence
        char[] chars = input.toCharArray();
        int countPuncuation = 0;
        for(char ch : chars){
            if(ch == '\"'){
                countPuncuation++;
            }
        }
//Then divide this number by 2 to see if there is an even amount
        if(countPuncuation % 2 != 0){
            System.out.println("Invalid string, it has an odd amount of quotation marks.");
            valid = false;
        }

        if(!(input.endsWith(".") || input.endsWith("?") || input.endsWith("!"))){
            System.out.println("Invalid string, does not end with ., ?, !");
            valid = false;
        }
//Comparing the indexes of periods to ensure that if there is one, it's at the end of the sentence
        else if(!(input.indexOf(".") == input.lastIndexOf('.'))){
            System.out.println("Invalid string, another period character what detected.");
            valid = false;
        }

//Using the character array from above to search through the input string to find any numbers
//If a number is found, need to find the actual value of the character to check whether it is less than 13
//Check if the error message has been printed or not
        for(char c : chars){
            if(Character.isDigit(c)){
                int value = Character.getNumericValue(c);
                if(value < 12){
                    if(!messagePrinted){
                        System.out.println("Invalid string, numbers under 13 must be spelled out.");
                        messagePrinted = true;
                    }
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
 
}

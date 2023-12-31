import java.util.Scanner; 
public class passwordService {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    System.out.println("Welcome to our password servise project\n");
    do{
        System.out.println("To generate password, please enter 1 \n" +
                "To check the strength of your password, please enter 2 \n"+
                "To generate passwords and check their strengths, please enter 3 \n"+
                "To exist the program please enter 0");
        choice = input.nextInt();

        switch (choice){
            case 1 : System.out.println("Enter the password length");
            double len = input.nextDouble();
            String [] passwords = generatePasswords(len);
            printPasswords(passwords);
            break;  
            case 2 : System.out.println("Enter your password");
            String password = input.next();
            int score = checkStrength(password);
            printStrength(score);
            System.out.println();
            break;          
            case 3 : System.out.println("Enter the password lenght");
            len = input.nextDouble();
            String [] passwords2 = generatePasswords(len);
            int [] scoreArr= new int[3];
            for (int i = 0; i <passwords2.length; i++){
                scoreArr[i] = checkStrength(passwords2[i]);
            }
            printPasswords(passwords2,scoreArr);
            break;        
            case 0 : System.out.println("Message: Program ended");
            break;
            default: System.out.println("Error: invalid value");        
        }
    }while(choice!=0);
}

//method to generates 3 possible passwords
public static String[] generatePasswords(double len){
    String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabsdefghijklmnopqrstuvwxyz!@#$%&*-=,?123456789";
    char[] character = possible.toCharArray();
    String[] passwords = new String[3];   
    
    if (len % 1 == 0){    
    int num = (int)len;
    for (int r = 0; r<3; r++){
        char [] password = new char[num];        
        for (int i = 0; i < num; i++){
            int random = (int) (Math.random()* character.length);
            char symbol = character[random];
            password [i] = symbol;
        }
     //casting the array from char to string
     passwords[r] = String.valueOf(password);
     }
    return passwords;
    }
    else{
        passwords[0] = null;
    }
    return passwords;
    } 

//prints the generated password by the previuse method
public static void printPasswords(String[] passwords){
    if (passwords[0] != null){
    System.out.println("Here are a few options:");
        for (String password : passwords) {
            System.out.println(password);
        }}
        else {
        System.out.println("Length should be a positive integer");
    }
    System.out.println();
}

// generates and check the stringth
public static void printPasswords(String[] passwords, int[] scores){ 
    if (passwords[0] != null){
    System.out.println("Here are a few options");
    for (int i = 0; i <passwords.length; i++){        
        System.out.print(passwords[i]+ "\f\f\f");
        String pass = String.valueOf(passwords[i]);
        int score = checkStrength(pass);
        printStrength(score);
    }
        System.out.println();
    }
    else{
        System.out.println("Length should be a positive integer");            
            }
}

//method checkStrength calculates and returns the score of the given password
public static int checkStrength(String password){
        int score = 0;
        boolean upper = false;
        boolean lower = false;
        boolean num = false;
        boolean symbol = false;
        
        for (int i = 0; i <password.length(); i++){
            char x = password.charAt(i);
            
            if (Character.isUpperCase(x)) upper = true;
            else if (Character.isLowerCase(x)) lower = true;
            else if (Character.isDigit(x)) num = true;
            else symbol = true;
    }
        if (upper)
            score++;
        if (lower)
            score++;
        if(num)
            score++;
        if (symbol)
            score++;
        if (password.length()>=8)
            score++;
        return score;
}

//method printStrength prints the corresponding strength to the given score * @param score
    public static void printStrength(int score) {
        if (score >= 5) {
            System.out.print("This is a very good password!\n");
        } else if (score >= 4) {
            System.out.print("This is a good password, but you can still do better\n");
        } else if (score >= 3) {
            System.out.print("This is a medium password, try making it better\n");
        } else {
            System.out.print("This is a weak password, you should find a new one!\n");
        }
    }    
}

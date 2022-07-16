import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Kalkulator {
    private Scanner input;
    private String from;
    private String to;
    private int amount;

    private Waluta waluta;

    //private HashMap<>

    public Kalkulator(){
        input = new Scanner(System.in);

        waluta = new Waluta();

        System.out.println("-------------------------------------------------------");
        System.out.println("You have:");
        System.out.println("USD | Euro | PLN | Jen | DKK");
        System.out.println("-------------------------------------------------------");

        from = input.nextLine();

        System.out.println("-------------------------------------------------------");
        System.out.println("You want:");
        System.out.println("USD | Euro | PLN | Jen | DKK");
        System.out.println("-------------------------------------------------------");

        to = input.nextLine();

        System.out.println("-------------------------------------------------------");
        System.out.println("Amount you want to convert:");
        System.out.println("-------------------------------------------------------");

        amount = input.nextInt();

        waluta.converter(from, to, amount);
    }

}

package blackjack;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s [] = new  String[4];
        System.out.println("Enter the name of Player 1");
          s[0] = in.next();
        System.out.println("Enter the name of Player 2");
        s[1] = in.next();
        System.out.println("Enter the name of Player 3");
        s[2] = in.next();
        s[3] = "Dealer";
        Game g = new Game(s);
        g.run_game();
    }
}
/*



 */


package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private  int highScore = 0, lst_random =0;
    private Card [] all = new Card[52];
    private Player players [] = new Player[4];
    private Boolean [] take = new Boolean[52];
    private  Scanner in = new Scanner(System.in);
    Game(String [] s)
    {
        generateTheCardDeck();
        for(int i = 0; i< 4 ; i++)
            players[i]=new Player(s[i]);
    }
    private  void setInformationOfPlayers()
    {
        players[0].add(get_rand());
        players[0].add(get_rand());
        players[1].add(get_rand());
        players[1].add(get_rand());
        players[2].add(get_rand());
        players[2].add(get_rand());
        players[3].add(get_rand());
        players[3].add(get_rand());
    }
    public void run_game()
    {

        setInformationOfPlayers();
        GUI gui = new GUI();
        gui.runGUI(all,players[0].getCards(),players[1].getCards(),players[2].getCards(),players[3].getCards());
        int cnt = 0 ;
        while ( players[0].getScore() < 21&& ++cnt <= 3)
        {
            System.out.println("enter 1 to hit or 0 to stand For Player 1");
            int x  = in.nextInt();
            System.out.println();
            if(x==1)
            {
                 Card cur = get_rand();
                players[0].add(cur);
                gui.updatePlayerHand(cur,0);
            }
            else if(x == 0 )
            {
                break;
            }
            else
            {
                System.out.println("Not Valid Answer");
            }

        }
        cnt =0 ;
        while ( players[1].getScore() < 21&& ++cnt <= 3)
        {

            System.out.println("enter 1 to hit or 0 to stand For Player 2");
            int x  = in.nextInt();
            System.out.println();
            if(x==1)
            {
                Card cur = get_rand();
                players[1].add(cur);
                gui.updatePlayerHand(cur,1);
            }
            else if(x == 0 )
            {
                break;
            }
            else
            {
                System.out.println("Not Valid Answer");
            }

        }
        cnt = 0;
        while ( players[2].getScore() < 21&& ++cnt <= 3)
        {

            System.out.println("enter 1 to hit or 0 to stand For Player 3");
            int x  = in.nextInt();
            System.out.println();
            if(x==1)
            {
                Card cur = get_rand();
                players[2].add(cur);
                gui.updatePlayerHand(cur,2);
            }
            else if(x == 0 )
            {
                break;
            }
            else
            {
                System.out.println("Not Valid Answer");
            }

        }
        highScore = Math.max(players[0].getScore(),players[1].getScore());
        highScore = Math.max( highScore,players[2].getScore());
        for(int i = 0; i< 52; i++)
        {
            if(take[i]==true)
                all[i]=null;
        }
        while ( highScore != 21  && players[3].getScore()<21)
        {
            Card cur = get_rand();
            players[3].add(cur);
            all[lst_random]=null;
            gui.updateDealerHand(cur,all);
            highScore = Math.max( highScore,players[3].getScore());
        }
        int win = 0 ,mxx=0;
        Boolean exist = false,push = false;
        for(int i = 0; i<4 ; i++)
        {
            if(players[i].getScore() == mxx )
            {
                push = true;
                break;
            }
            if(players[i].getScore() > mxx && players[i].getScore() <= 21)
            {
                win = i + 1;
                mxx = players[i].getScore();
                exist=  true;
            }
        }
        if(exist && push == false)
        {
            for(int i = 0; i<4 ; i++) {
                if (players[i].getScore() == mxx) {
                    if(i == 3)
                    {
                        System.out.println("Dealer Is Win With Score = "  + players[win-1].getScore());
                    }
                    else
                        System.out.println("Player "+ players[i].getName() +" Is Win With Score = " + players[win-1].getScore());
                }
            }
        }
        else if( push == true)
        {
            System.out.println("BUSTED");
        }
        else
            System.out.println("Tie");
        System.out.println("Game END!");
    }
    private Card get_rand()
    {
        int randomIndex;
        while(true)
        {
            Random rand = new Random();
            randomIndex = rand.nextInt(51);
            if( take[randomIndex]==false)
            {
                take[randomIndex] = true;
                lst_random = randomIndex;
                break;
            }
        }
        return all[randomIndex];
    }
    private void generateTheCardDeck()
    {
        for(int i = 0 ; i< 52 ;i++){
            all[i]= new Card();
            take[i]= new Boolean(false);
        }
        for(int i = 0; i<13 ;i++){
            all[i].setSuit(0);
            all[i].setRank(i%13);
            all[i].setValue(Math.min(1+(i%13),10));
        }
        for(int i = 13; i<2*13 ;i++){
            all[i].setSuit(1);
            all[i].setRank(i%13);
            all[i].setValue(Math.min(1+(i%13),10));
        }
        for(int i =  2*13 ; i<3*13 ;i++){
            all[i].setSuit(2);
            all[i].setRank(i%13);
            all[i].setValue(Math.min(1+(i%13),10));
        }
        for(int i =3 * 13 ; i< 4*13 ;i++){
            all[i].setSuit(3);
            all[i].setRank(i%13);
            all[i].setValue(Math.min(1+(i%13),10));
        }
    }
}

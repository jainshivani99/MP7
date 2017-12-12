import java.util.ArrayList;
import java.util.Scanner;

public class PlayWar {
	
	private static final int TOTAL_NUM_CARDS = Deck.TOTAL_NUM_CARDS;
	
	public static Player determineWinner(Player p1, Player p2){
		if (p1.getCount() == TOTAL_NUM_CARDS || p2.getCount() == 0) {
			return p1;
		} else if (p2.getCount() == TOTAL_NUM_CARDS || p1.getCount() == 0) {
			return p2;
		} 
		return null;
	}
		
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Player 1, what is your name? ");
		String name = myScan.nextLine();
		Player p1 = new Player(name);
        p1.setName(name);
        myScan.nextLine();
        
        System.out.println("Player 2, what is your name? ");
        String name2 = myScan.nextLine();
        Player p2 = new Player(name2);
        p2.setName(name2);
        myScan.nextLine();
        myScan.close();
        
        Deck deck1 = new Deck();
		//Shuffle cards
		deck1.shuffleCards();
		System.out.println("Deck is now shuffled!");
		//Deal deck of cards
		deck1.dealCards(p1, p2);
		//Play the game
		ArrayList<Card> warCards = new ArrayList<Card>();
		boolean isWinner = false;	
		while(!isWinner) {
			Card p1Card;
			if (p1.hasCard()) {
				p1Card = p1.playCard(warCards);
				System.out.println("Player 1 played: " + p1Card);
			} else {
				isWinner = false;
				break;
			}
			Card p2Card;
			if (p2.hasCard()) {
				p2Card = p2.playCard(warCards);
				System.out.println("Player 2 played: " + p2Card);
			} else {
				isWinner = false;
				break;
			}
			Player roundWinner = deck1.compareCards(p1, p2, p1Card, p2Card);
			if (roundWinner == null) {
				System.out.println("War has begun!");
				continue;
			} else {
				roundWinner.addCollection(warCards);
				warCards = new ArrayList<Card>();
			}
			isWinner = (p1.getCount() == TOTAL_NUM_CARDS) || (p2.getCount() == TOTAL_NUM_CARDS);
		}
		System.out.println("The winner is " + determineWinner(p1, p2).getName());
	}
	
}

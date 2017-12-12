import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck; 
	public static final int TOTAL_NUM_CARDS = 52;
	
	public Deck() {
		this.deck = new ArrayList<Card>();   
		//Initialize deck of cards
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 15; j++) {
				deck.add(new Card(j, i));
			}
		}
	}
	
	public void shuffleCards() {
		Collections.shuffle(deck);
	}
	
	public void dealCards(Player p1, Player p2) {
		for (int i = 0; i < TOTAL_NUM_CARDS; i++) {
			if (i % 2 == 0) {
				p1.addCard(deck.remove(deck.size() - 1));
			} else {
				p2.addCard(deck.remove(deck.size() - 1));
			}
		}
	}
	
	public Player compareCards(Player p1, Player p2, Card card1, Card card2) {
		if (card1.getValue() > card2.getValue()) {
			return p1;
		} else if (card1.getValue() < card2.getValue()) {
			return p2;
		} else {
			return null;
		}
	}
	
}

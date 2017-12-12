import java.util.ArrayList;

public class Player {
	
	public String name;
	private ArrayList<Card> playerCards;
	
	/**Constructor for the player class 
	 * 
	 * @param name name of the player
	 * @param playerCards array list containing the card hand of the player
	 */
	public Player (String name) {
		this.name = name;
		this.playerCards = new ArrayList<Card>();
	}
	
	public int getCount() {
		int count = playerCards.size();
		return count;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String playerName) {
		this.name = playerName;
	}
	
	public ArrayList<Card> getPlayerCards() {
		return this.playerCards;
	}

	public void addCard(Card x) {
		playerCards.add(x);
	}
	
	public void addCollection(ArrayList<Card> collection) {
		playerCards.addAll(collection);
	}
	
	public boolean hasCard() {
		if (playerCards.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Card playCard(ArrayList<Card> warCards) {
		Card playedCard = playerCards.remove(playerCards.size() - 1);
		warCards.add(playedCard);
		return playedCard;
	}
}

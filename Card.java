public class Card {

		private int value;
		private String name;
		private SuitName suit;
		public enum SuitName {
	        HEARTS,
	        CLUBS,
	        SPADES,
	        DIAMONDS;
	}
		/**
		 * Constructor for the Card class.
		 * @param name
		 * @param suit
		 */
		public Card(int value, int suitValue) {
			if (suitValue == 0) {
				this.suit = SuitName.HEARTS;
			}
			if (suitValue == 1) {
				this.suit = SuitName.CLUBS;
			} 
			if (suitValue == 2) {
				this.suit = SuitName.SPADES;
			}
			if (suitValue == 3) {
				this.suit = SuitName.DIAMONDS;
			}
			this.value = value;
			if(value < 11) {
				this.name = Integer.toString(value);
			} else if (value >= 11 && value <= 14) {
				if (value == 11) {
					this.name = "Jack";
				} else if (value == 12) {
					this.name = "Queen";
				} else if (value == 13) {
					this.name = "King";
				} else {
					this.name = "Ace";
				}
			} else {
				this.name = null;
			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Card [name= " + name + ", suit= " + suit + "]";
		}

		public String getName() {
			return name;
		}
		public SuitName getSuit() {
			return suit;
		}
		public int getValue() {
			return value;
		}
		
}
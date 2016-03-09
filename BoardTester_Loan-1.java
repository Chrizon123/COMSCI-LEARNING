import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class BoardTester_Loan
{
   public static void main(String[] args)
   {
     String[] usualRanks = {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
     String[] usualSuits = {"hearts","clubs","diamonds","spades"};
     int[] usualValues =  {1,2,3,4,5,6,7,8,9,10,10,10,10};

     BlackJackBoard playBoard = new BlackJackBoard(21,usualRanks,usualSuits,usualValues);
     playBoard.playBJ();
   }
}
/**
 * This class represents a Board that can be used in a collection
 * of solitaire games similar to Elevens.  The variants differ in
 * card removal and the board size.
 */
abstract class Board {

	/**
	 * The cards on this board.
	 */
	private List<Card> cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;

	/**
	 * Creates a new <code>Board</code> instance.
	 * @param size the number of cards in the board
	 * @param ranks the names of the card ranks needed to create the deck
	 * @param suits the names of the card suits needed to create the deck
	 * @param pointValues the integer values of the cards needed to create
	 *                    the deck
	 */
	public Board(int size, String[] ranks, String[] suits, int[] pointValues) {
		cards = new ArrayList<Card>();
		deck = new Deck(ranks, suits, pointValues);
		if (I_AM_DEBUGGING) {
			System.out.println(deck);
			System.out.println("----------");
		}
      newGame();
	}
   public int getSum()
   {
     int sum = 0;
     for( int x = 0; x < cards.size(); x++ )
     {
       sum += cards.get(x).pointValue();
     }   
     for( int x = 0; x < cards.size(); x++ )
     {
       if(cards.get(x).rank().equals("ace") && sum + 10 <= 21)
       {
         sum+= 10;
       }
     }  
     return sum;
   }
	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	public void newGame() {
		deck.shuffle();
      cards = new ArrayList<Card>();
      cards.add(deck.deal());
      cards.add(deck.deal());
      while(getSum() > 21)
      {
   		deck.shuffle();
         cards = new ArrayList<Card>();
         cards.add(deck.deal());
         cards.add(deck.deal());
      }
	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		return cards.size();

	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
   public void myDeal()
   {
     cards.add(deck.deal());
   }
	public Card deal() {
		return deck.deal();
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		return deck.size();
   }
   public void shuffle()
   {
      deck.shuffle();
   }
	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	 public String toString() {
		String s = "";
		for (int k = 0; k < cards.size(); k++) {
			s = s + k + ": " + cards.get(k) + "\n";
		}
		return s;
	}

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any m

	/**
	 * Method to be completed by the concrete class that determines
	 * if the selected cards form a valid group for removal.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 
	public abstract boolean isLegal(List<Integer> selectedCards);

	/**
	 * Method to be completed by the concrete class that determines
	 * if there are any legal plays left on the board.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 
	public abstract boolean anotherPlayIsPossible();

	/**
	 * Deal cards to this board to start the game.
	 */

}
class BlackJackBoard extends Board
{
  private ArrayList<Card> dealer;
  private int wins;
  
  public boolean isBust()
  {
    int sum = dealerSum();
    if(sum > 21){return true;}
    return false;
  }
  public String dealerString()
  {
    String s = "";
    for (int k = 0; k < dealer.size(); k++) 
    {
	   s = s + k + ": " + dealer.get(k) + "\n";
    }
    s = s + "Total Value: " + dealerSum();
    return s;
  }
  
  public int dealerSum()
  {
    int sum = 0;
    for( int x = 0; x < dealer.size(); x++ )
    {
      sum += dealer.get(x).pointValue();
    }   
    for( int x = 0; x < dealer.size(); x++ )
    {
      if(dealer.get(x).rank().equals("ace") && sum + 10 <= 21)
      {
        sum+= 10;
      }
    }  
    return sum;
  }
  public void dealerHit()
  {
    while(dealerSum() < 17){dealerDeal();System.out.println("Dealer's hand:\n" + dealerString());}  
  }
  public void dealerDeal()
  {
    dealer.add(deal());
  }
  public BlackJackBoard(int size, String[] ranks, String[] suits, int[] pointValues)
  {
    super(size, ranks, suits, pointValues);
    dealer = new ArrayList<Card>();
    dealer.add(deal());
    dealer.add(deal());
    wins = 0;
  }
  public String toString()
  {
    return ("Your Hand: \n" + super.toString() + "Total Value: " + getSum());
    
  }
  public void findWinner()
  {
    if(getSum() > dealerSum() && getSum() <=21)
    {
      wins++;
      System.out.println("YOU WIN!\nTotal Wins: " + wins);
    }
    else if(dealerSum() > getSum() && dealerSum() <= 21)
    {
      System.out.println("YOU LOSE!\nTotal Wins: " + wins);
    }
    else if(dealerSum() == getSum())
    {
      System.out.println("TIE");
    }
  }
  public void newGame() {
		super.newGame();
      dealer = new ArrayList<Card>();
      dealer.add(deal());
      dealer.add(deal());
      while(dealerSum() > 21)
      {
   		super.newGame();
         dealer = new ArrayList<Card>();
         dealer.add(deal());
         dealer.add(deal());
      }
	}
  public void playBJ()
  {
     newGame();
     boolean currentPlay = true;
     boolean playing = true;
     while (playing)
     {
        while (currentPlay)
        {
          //Start of game
          System.out.println(toString());
          System.out.println("Hit? (Y)es or (N)o?");
          Scanner scan = new Scanner(System.in);
          String answer = scan.nextLine();
          if(answer.equals("Y"))
          {
            myDeal();
            if(getSum() > 21)
            {
              System.out.println(toString());
              System.out.println("YOU BUSTED!");
              currentPlay = false;
            }
          }
          else
          {
            System.out.println("Dealer's hand:\n" + dealerString());
            dealerHit();
            if(isBust())
            {
              wins++;
              System.out.println("DEALER BUSTED!\nYOU WIN!\nTotal Wins: " + wins);
              currentPlay = false;
            }
            findWinner();
            currentPlay = false;
          }
        }
        System.out.println("Play again? (Y)es or (N)o?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if(answer.equals("Y"))
        {
            currentPlay = true;
            newGame();
        }
        else {playing = false;}
     }

  }
  
}
/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
class Card {

	/**
	 * String value that holds the suit of the card
	 */
	private String suit;

	/**
	 * String value that holds the rank of the card
	 */
	private String rank;

	/**
	 * int value that holds the point value.
	 */
	private int pointValue;


   /**
	 * Creates a new <code>Card</code> instance.
	 *
	 * @param cardRank  a <code>String</code> value
	 *                  containing the rank of the card
	 * @param cardSuit  a <code>String</code> value
	 *                  containing the suit of the card
	 * @param cardPointValue an <code>int</code> value
	 *                  containing the point value of the card
	 */
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		//initializes a new Card with the given rank, suit, and point value
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}


	/**
	 * Accesses this <code>Card's</code> suit.
	 * @return this <code>Card's</code> suit.
	 */
	public String suit() {
		return suit;
	}

	/**
	 * Accesses this <code>Card's</code> rank.
	 * @return this <code>Card's</code> rank.
	 */
	public String rank() {
		return rank;
	}

   /**
	 * Accesses this <code>Card's</code> point value.
	 * @return this <code>Card's</code> point value.
	 */
	public int pointValue() {
		return pointValue;
	}

	/** Compare this card with the argument.
	 * @param otherCard the other card to compare to this
	 * @return true if the rank, suit, and point value of this card
	 *              are equal to those of the argument;
	 *         false otherwise.
	 */
	public boolean matches(Card otherCard) {
		return otherCard.suit().equals(this.suit())
			&& otherCard.rank().equals(this.rank())
			&& otherCard.pointValue() == this.pointValue();
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a <code>Deck</code> in an easily readable format or performing
	 * other similar functions.
	 *
	 * @return a <code>String</code> containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		for (int j = 0; j < ranks.length; j++) {
			for (String suitString : suits) {
				cards.add(new Card(ranks[j], suitString, values[j]));
			}
		}
		size = cards.size();
		shuffle();
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		for (int k = cards.size() - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = cards.get(k);
			cards.set(k, cards.get(randPos));
			cards.set(randPos, temp);
		}
		size = cards.size();
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		if (isEmpty()) {
			return null;
		}
		size--;
		Card c = cards.get(size);
		return c;
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
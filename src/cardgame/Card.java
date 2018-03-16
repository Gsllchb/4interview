package cardgame;

public class Card {
  public static final byte DIAMOND = 0;
  public static final byte CLUB = 1;
  public static final byte HEART = 2;
  public static final byte SPADE = 3;

  private final int num;
  private final byte suit;

  public Card(int num, byte suit) {
    if (num <= 0 || num > 13) {
      throw new IllegalArgumentException();
    }
    if (suit < 0 || suit > 3) {
      throw new IllegalArgumentException();
    }
    this.num = num;
    this.suit = suit;
  }

  public int getNum() {
    return num;
  }

  public byte getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    switch (suit) {
      case DIAMOND: return "diamond " + num;
      case CLUB: return "club " + num;
      case HEART: return "heart " + num;
      case SPADE: return "spade " + num;
    }
    return null;
  }

  public boolean equals(Object c) {
    return num == ((Card) c).num && suit == ((Card) c).suit;
  }

  @Override
  public int hashCode() {
    return (num - 1) * 4 + suit;
  }
}

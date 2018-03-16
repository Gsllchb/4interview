package cardgame;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.ArrayList;

public class Desk {
  private int numOfPlayer;
  private ArrayList<ArrayList<Card>> players;
  private Card[] prevCards = null;

  public Desk(int numOfPlayer) {
    players = new ArrayList<>();
    for (int i = 0; i < numOfPlayer; ++i) {
      players.add(new ArrayList<>());
    }
  }

  public int getNumOfPlayer() {
    return numOfPlayer;
  }

  public void give(int playerId, final Card c) {
    players.get(playerId).add(c);
  }

  public boolean play(int playerId, final Card[] cards) {
    if (isBigger(cards) && contain(playerId, cards)) {
      prevCards = cards;
      remove(playerId, cards);
      if (players.get(playerId).length() == 0) {
        players.set(playerId, null);
        --numOfPlayer;
      }
      return true;
    }
    return false;
  }

  public boolean contain(int playerId, final Card[] cards) {
    Card[] cardsClone = new Card[cards.length];
    System.arraycopy(cards, 0, cardsClone, 0, cards.length);
    ArrayList<Card> allCard = players.get(playerId);
    for (int i = 0; i < allCard.length(); ++i) {
      for (int j = 0; j < cardsClone.length; ++j) {
        if (cardsClone[j] != null && cardsClone[j].equals(allCard.get(i))) {
          cardsClone[j] = null;
        }
      }
    }
    for (Card c: cardsClone) {
      if (c != null) {
        return false;
      }
    }
    return true;
  }

  private void remove(int playerId, final Card[] cards) {
    for (Card c: cards) {
      players.get(playerId).remove(c);
    }
  }

  public boolean isBigger(final Card[] cards) {
    throw new NotImplementedException();
  }

}

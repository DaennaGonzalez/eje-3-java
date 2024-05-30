import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;
    private static final String[] PALOS = {"Tréboles", "Corazones", "Picas", "Diamantes"};
    private static final String[] COLORES = {"Negro", "Rojo"};
    private static final String[] VALORES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

    public Deck() {
        deck = new ArrayList<>();
        for (String palo : PALOS) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
            for (String valor : VALORES) {
                deck.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!deck.isEmpty()) {
            Card firstCard = deck.remove(0);
            System.out.println(firstCard);
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        } else {
            System.out.println("No hay cartas en el deck.");
        }
    }

    public void pick() {
        if (!deck.isEmpty()) {
            Random rand = new Random();
            Card randomCard = deck.remove(rand.nextInt(deck.size()));
            System.out.println(randomCard);
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        } else {
            System.out.println("No hay cartas en el deck.");
        }
    }

    public void hand() {
        if (deck.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = deck.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        } else {
            System.out.println("No hay suficientes cartas en el deck.");
        }
    }
}

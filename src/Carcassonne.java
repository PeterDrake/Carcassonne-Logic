public class Carcassonne {

	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.toString());
		
		System.out.println("0 = grass\n1 = road\n2 = road end point\n"
				+ "3 = city\n4 = cloister\n5 = city crest\n");
		
		System.out.println("For more information on distribution, see this image:\n"
				+ "http://www.erzo.org/~shannon/images-gg/carc-tiles-main.jpg");
	}
}

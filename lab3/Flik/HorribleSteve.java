public class HorribleSteve {
	public static void main (String [] args) {
		for (int j = 0, i=0; i < 500; ++i, ++j) {
			if (!Flik.isSameNumber(i, j)) {
				System.out.println("i is " + i);
          break; // break exits the for loop!

			}
		}

	}
} 
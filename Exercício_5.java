public class Exercício_5 {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		while (x != 1) {
			if ( (x & 1) == 0 )
				x = x/2;
			else
				x = (x*3) + 1;
			
			if (x == 1)
				System.out.print(x);
			else
				System.out.print(x + " -> ");
		}
	}

}

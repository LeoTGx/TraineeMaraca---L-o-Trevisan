public class Exercício_9 {
	public static void main(String[] args) {
		int fib0 = 0,fib = 0;
		while(fib < 100){
            
			if (fib == 0) {
                fib = 1;
                fib0 = 0;
            } else {
                fib = fib + fib0;
                fib0 = fib - fib0;
            }
			System.out.println(fib);
        }
	}
}

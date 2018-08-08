public class Exercício_8 {
	static int fib(int n) {
        int fib = 0;
        int fib0 = 0;
  
        for (int i = 1; i <= n; i++) {
  
            if (i == 1) {
                fib = 1;
                fib0 = 0;
            } else {
                fib += fib0;
                fib0 = fib - fib0;
            }
  
        }
  
        return fib;
    }
  
    public static void main(String[] args) {
    	int x;
        for (int i = 0; ; i++) {
        	x = Exercício_8.fib(i);
        	if (x < 100)
        		System.out.println(x);
        	else{
        		System.out.println(x);
        		break;
        	}
        	
        }
  
    }
}

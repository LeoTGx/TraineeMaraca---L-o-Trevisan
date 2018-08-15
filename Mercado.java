import java.util.concurrent.TimeUnit;

class Filas{
	public int tamanho, inicio, fim;
	public double[] fila = new double[100000];
	public Caixas caixa;
	public long t_total, t_inicial;
	
	public Filas(){
		t_inicial = System.nanoTime();
		t_total = 0;
		inicio = 0;
		fim = 0;
		tamanho = 0;
	}
	
	public void link(Caixas caixa) {
		this.caixa = caixa;
	}
	
	public void adiciona(double tempo){ //Adiciona um cliente ao final da fila, caso seja o primeiro ao entrar na fila
		if(inicio == 0) {			   //ele eh adicionado e retirado imediatamente para ser atendido.
			inicio++;
			fim = 2;
			fila[0] = tempo;
			caixa.atendimento(fila[0]);
		}else{
			tamanho++;
			fim++;
			fila[fim-1] = tempo; 
		}
	}
	
	public void tira() { //Tira o primeiro da fila e retorna 0 quando a fila esta vazia
		inicio++;
		if (tamanho == 0) {
			
		}else
			tamanho--;
		if(inicio == fim) {
			t_total = System.nanoTime() - t_inicial;
		}else {
			caixa.atendimento(fila[inicio]);
		}
	}
}

class Caixas{
	double t;
	int vazio;
	public Filas fila;
	long entrou;
	
	public Caixas(){
		vazio = 0;
		t = 0;
	}
	
	public void link(Filas fila) {
		this.fila = fila;
	}
	
	public void atendimento(double tempo) {
		vazio = 1;
		entrou = System.nanoTime();
		t = tempo;
			if(System.nanoTime() - entrou < t) {
				do {
					
				}while(System.nanoTime() - entrou < t);
				vazio = 0;
				fila.tira();
				
			}
	}
}


public class Mercado {
	
	public static int menor_fila(Filas[] fila, Caixas[] cx) {
		int aux = 999999, menor=0;
		for (int i = 0; i < 5; i++) {
			System.out.println(cx[i].vazio);
			if(fila[i].tamanho < aux && cx[i].vazio == 0) {
				aux = fila[i].tamanho;
				menor = i;
			}
		}
		return menor;
	}

	public static void main(String[] args) {
		double tempoat;
		double tempo_final = 0;
		int x;
		int aux[] = new int[5];
		Filas[] filas_ind = new Filas[5];
		Caixas[] caixas_ind = new Caixas[5];
		
		for (int i = 0; i < 5; i++) {
			caixas_ind[i] = new Caixas();
			filas_ind[i] = new Filas();
			caixas_ind[i].link(filas_ind[i]);
			filas_ind[i].link(caixas_ind[i]);
			aux[i] = 0;
			
		}
		
		for (int i = 0; i < 10; i++) {
			tempoat = 0.2*1000000000;
			x = menor_fila(filas_ind, caixas_ind);
			filas_ind[x].adiciona(tempoat);
		}
			do {
				for (int i = 0; i < 5; i++) {
					System.out.println(filas_ind[i].t_total);
					if(filas_ind[i].t_total != 0) {
						aux[i] = 1;
					}	
				}
			}while(aux[0] == 0 || aux[1] == 0 || aux[2] == 0 || aux[3] == 0 || aux[4] == 0);
			
			for (int i = 0; i < 5; i++) {
				if(filas_ind[i].t_total > tempo_final) {
					tempo_final = filas_ind[i].t_total;
				}
			}
		
		System.out.println(tempo_final/1000000000);
		
	}

}

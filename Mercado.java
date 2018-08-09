import java.util.concurrent.TimeUnit;

class Filas{
	public int tamanho, inicio, fim;
	public double[] fila = new double[10000];
	public Caixas caixa;
	public long t_total, t_inicial;
	
	public Filas(Caixas caixa){
		t_inicial = System.nanoTime();
		t_total = 0;
		this.caixa =  caixa;
		inicio = 0;
		fim = 0;
		tamanho = 0;
	}
	
	public void adiciona(double tempo){ //Adiciona um cliente ao final da fila, caso seja o primeiro ao entrar na fila
		if(inicio == 0) {			   //ele eh adicionado e retirado imediatamente para ser atendido.
			inicio++;
			fim += 2;
			fila[0] = tempo;
			caixa.atendimento(fila[0]);
		}else{
			tamanho++;
			fim++;
			fila[fim-2] = tempo; 
		}
	}
	
	public void tira() { //Tira o primeiro da fila e retorna 0 quando a fila esta vazia
		inicio++;
		if (tamanho == 0) {
			
		}else
			tamanho--;
		if(inicio == fim) {
			t_total = t_inicial - System.nanoTime();
		}else {
			caixa.atendimento(fila[inicio]);
		}
	}
}

class Caixas{
	double t;
	int vazio;
	public Filas fila;
	long entrou, aux;
	public Caixas(Filas fila){
		this.fila = fila;
		vazio = 0;
		t = 0;
	}
	public void atendimento(double tempo) {
		entrou = System.nanoTime();
		vazio = 1;
		t = tempo;
			if(System.nanoTime() - entrou < t) {
				do {
					aux = System.nanoTime() - entrou;
				}while(aux < t);
				vazio = 0;
				fila.tira();
				
			}
	}
}


public class Mercado {
	
	public static int menor_fila(Filas[] fila, Caixas[] cx) {
		int aux = 999999, menor=0;
		for (int i = 0; i < 5; i++) {
			if(fila[i].tamanho < aux) {
				aux = fila[i].tamanho;
				menor = i;
				if(fila[i].tamanho == aux) {
					if( cx[i].vazio == 0) {
						menor = i;
					}		
				}
			}
		}
		return menor;
	}

	public static void main(String[] args) {
		double tempoat;
		long tempo_final = 0;
		int x;
		Filas[] filas_ind = new Filas[5];
		Caixas[] caixas_ind = new Caixas[5];
		for (int i = 0; i < 5; i++) {
			caixas_ind[i] = new Caixas(filas_ind[i]);
			filas_ind[i] = new Filas(caixas_ind[i]);
		}
		for (int i = 0; i < 10; i++) {
			tempoat = Math.random()*1000000000;
			x = menor_fila(filas_ind, caixas_ind);
			filas_ind[x].adiciona(tempoat);
		}
		if(filas_ind[0].t_total == 0 && filas_ind[1].t_total == 0 && filas_ind[2].t_total == 0 && filas_ind[0].t_total == 0 && filas_ind[3].t_total == 0 && filas_ind[4].t_total == 0) {
			do {
				
			}while(filas_ind[0].t_total == 0 && filas_ind[1].t_total == 0 && filas_ind[2].t_total == 0 && filas_ind[0].t_total == 0 && filas_ind[3].t_total == 0 && filas_ind[4].t_total == 0);
		}else {
			for (int i = 0; i < 5; i++) {
				if(filas_ind[i].t_total > tempo_final) {
					tempo_final = filas_ind[i].t_total;
				}
			}
		}
		
		System.out.println(tempo_final);
		
	}

}

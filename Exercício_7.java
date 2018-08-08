public class Exercício_7 {
	public static void main(String[] args) {
		
		int gastosJaneiro = 15000;
        int gastosFevereiro = 23000;
        int gastosMarco = 17000;
        
        int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
        
        System.out.println("O total de gastos no trimestre foi = " + gastosTrimestre);
        
        float mediaMensal = gastosTrimestre/3;
        
        System.out.println("Valor da média mensal = " + mediaMensal);
	}

}

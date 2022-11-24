package entidade;

public class CalculoFerias {

	private double salarioBruto;

	public CalculoFerias(double salarioBruto) {

		this.salarioBruto = salarioBruto;
	}

	public double getSalarioBruto() {

		return salarioBruto;

	}

	public void setSalarioBruto(double salarioBruto) {

		this.salarioBruto = salarioBruto;
	}

	/* INICIO DO METODO PRA CALCULAR O VALOR DO DESCONTO INSS */
	public double calcInss() {
		double descontoInss = 0;
		double valorDesconto;
		// 1ª faixa - 0 ate 1212,00

		if (salarioBruto > 0.00 && salarioBruto <= 1212.00) {
			// O calculo de 7,5 % de 1212,00 é ( 90,90 )
			descontoInss = 90.90;

		}
		// 2ª faixa - 1212,01 até 2427,35

		else if (salarioBruto > 1212.00 && salarioBruto <= 2427.35) {
			// o calculo de 9,0 % de 2427,35 - 1212,00 é ( 109,38 )

			// se o valor estiver aqui dentro eu vou subitrair meu valor por 2427,35 e tirar
			// 9 % dele. Ai meu desconto vai ser 90,90 + o valor tirado desse calculo

			valorDesconto = ((salarioBruto - 1212.00) * 9) / 100;

			descontoInss = (90.0 + valorDesconto);

		}

		// 3ª faixa 2427,36 até 3641,03

		else if (salarioBruto > 2427.35 && salarioBruto <= 3641.03) {
			// o calculo de 12 % de 3641,03 - 2427,35 é ( 145,64 )

			valorDesconto = ((salarioBruto - 2427.35) * 12) / 100;

			descontoInss = (90.90 + 109.38 + valorDesconto);

		}

		// 4ª faixa 3641,04 até 7087,22
		else if (salarioBruto > 3641.04 && salarioBruto <= 7087.22) {

			valorDesconto = ((salarioBruto - 3641.03) * 14) / 100;
			descontoInss = (90.00 + 109.38 + 145.64 + valorDesconto);

		} else {

			descontoInss = 828.39;
		}

		return Math.ceil(descontoInss); // ( RETORNAR COM DUAS CASA DECIMAIS )
	}
	/* FINAL DO METODO PRA CALCULAR O VALOR DO DESCONTO INSS */

	/* INICIO DO METODO PARA CALCULAR O DESCONTO DO IMPOSTO DE RENDA */

	public double calcIr() {
		// o desconto do imposto de renda é o
		// salario já com o Inss descontado * a porcentagem - a parcela a deduzir

		// ( ( salario - calcInss() ) * procentagem) - parcela deduzida

		double descontoIr;
		double sal = salarioBruto - calcInss();

		// até 1903,98 ( isento )
		if (sal > 0 && sal <= 1903.98) {

			descontoIr = 0;
		}

		// 1903,99 até 2826,65 ( 7,5 % ) / 142,80

		else if (sal > 1903.98 && sal <= 2826.65) {

			descontoIr = ((sal * 7.5) / 100) - 142.80;

		}

		// 2826,66 até 3751,05

		else if (sal > 2826.65 && sal <= 3761.05) {

			descontoIr = ((sal * 15) / 100) - 354.80;
		}

		// 3751,06 até 4664,68

		else if (sal > 3761.05 && sal <= 4664.68) {

			descontoIr = ((sal * 22.5) / 100) - 636.13;
		}
		// maior que 4664,68
		else {

			descontoIr = ((sal * 27.5) / 100) - 869.36;
		}

		

		return descontoIr;
	}
	
	public double calTerco() { 
		
		return (salarioBruto * 1 ) / 3;
	}

	/* FINAL DO METODO PARA CALCULAR O DESCONTO DO IMPOSTO DE RENDA */
	
	public double descontos() { 
		
		return  calcInss() + calcIr();
	}
	
	public double mostrarFerias() { 
		
		return (salarioBruto + calTerco() -  descontos() );
	}

}

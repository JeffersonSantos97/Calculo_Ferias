package programa;

import java.util.Scanner;

import entidade.CalculoFerias;

public class UsarCalculo {

	public static void main(String[] args) {
		Scanner sc = new Scanner ( System.in );
		
		CalculoFerias calculo;
		
		System.out.println("Entre com o salario bruto: ");
		double salarioBruto = sc.nextDouble();
		
		calculo = new CalculoFerias(salarioBruto);
		
		System.out.println("Valor a receber: " + calculo.mostrarFerias());
		System.out.println("Desconto inns: " + calculo.calcInss());
		System.out.println("Desconto IR: " + calculo.calcIr());
		System.out.println("Descontos: " + calculo.descontos());
		
		
		
		
		
		sc.close();

	}

}

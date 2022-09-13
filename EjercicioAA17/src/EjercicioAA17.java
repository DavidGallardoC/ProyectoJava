import java.util.Scanner;

public class EjercicioAA17 {

	public static void main(String[] args) {
		
		Adivinar adivinar_numero = (int t1, int t2) -> t1 == t2;
		int intentos = 0;
		int numero;
		int aleatorio = (int) (Math.random() * 1000000 + 1);
		
		Usuario u1 = new Usuario();
		Scanner sc = new Scanner(System.in);
		System.out.print("Cual es tu nombre ");
		u1.setNombre(sc.nextLine());
		System.out.print("Cual es tu edad ");
		u1.setEdad(sc.nextInt());
		System.out.println(u1.toString());
		
		
		System.out.println("Adivina un numero de 1 al 1000000");
		numero = sc.nextInt();
		intentos++;
		while (comprobar(numero, aleatorio, adivinar_numero) != true && intentos <= 4) {
			//4 porque ya hice uno arriba
			numero = sc.nextInt();
			intentos++;
		}
		if (intentos == 5) {
			System.out.println("El número a adivinar era " + aleatorio);
		}
		
		sc.close();
	}
	
	
	public static boolean comprobar(int n1, int n2, Adivinar formato) {
		boolean resultado = formato.ejecutar(n1, n2);

		if (resultado) {
			System.out.println("Adivinaste, campeon!");
			return resultado;
		} else {
			System.out.println("Sigue intentandolo.");
			return resultado;
		}

	}

	interface Adivinar {
		boolean ejecutar(int n1, int n2);
	}	
	
}
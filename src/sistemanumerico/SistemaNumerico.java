/*
12. Se desea desarrollar en java una clase que almacene el valor de una cantidad en sistema numérico decimal, 
y que implemente métodos que permitan convertir dicha cantidad al sistema octal, binario y hexadecimal.
 */
package sistemanumerico;

import java.util.Scanner;
import java.util.ArrayList;

public class SistemaNumerico {

    int num;

    public SistemaNumerico() {
        this.num = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static String decimalAOctal(int decimal) {
        String octal = "";// Almacenamos el número octal que será el resultado
        String caracteresOctales = "01234567";
        while (decimal > 0) {
            int residuo = decimal % 8;// El residuo es lo que se suma, y se usa como índice. Recordemos que el carácter se pone "a la izquierda", por eso
            octal = (caracteresOctales.charAt(residuo) + octal);// concatenamos el carácter y luego lo que ya lleva sumado el octal
            decimal /= 8;// Lo vamos dividiendo entre 8 para que en algún momento llegue a 0
        }
        return octal;
    }

    public static String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789ABCDEF";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal; // Agregar a la izquierda
            decimal /= 16;
        }
        return hexadecimal;
    }
    
    public static String DecimalABinario(long decimal) {
	if (decimal <= 0) {
		return "0";
	}
	StringBuilder binario = new StringBuilder();
	while (decimal > 0) {
		short residuo = (short) (decimal % 2);
		decimal = decimal / 2;
		// Insertar el dígito al inicio de la cadena
		binario.insert(0, String.valueOf(residuo));
	}
	return binario.toString();
}

    public static void main(String[] args) {
        String hexa, bin, oct;
        // capturamos num decimal
        Scanner teclado = new Scanner(System.in);
        //instanciamos la clase
        SistemaNumerico sm = new SistemaNumerico();
        System.out.println("Ingrese Numero decimal: ");
        sm.setNum(teclado.nextInt());
        hexa = Integer.toHexString(sm.getNum());
        bin = Integer.toBinaryString(sm.getNum());
        oct = Integer.toOctalString(sm.getNum());
        System.out.println("---------------------------------------------");
        System.out.println("CONERSION CON METODOS MANUALES");
        System.out.println("Conversion a Octal: " + sm.decimalAOctal(sm.getNum()));
        System.out.println("Conversion a Hexadecimal: " + sm.decimalAHexadecimal(sm.getNum()));
        System.out.println("Conversion a Binario: " + sm.DecimalABinario(sm.getNum()));
         //Funciones predefinidas por javs.
        System.out.println("---------------------------------------------");
        System.out.println("CONERSION CON METODOS PROPIOS DE JAVA");
        System.out.println("Conversion a Octal: " + oct);
        System.out.println("Conversion a Hexadecimal: " + hexa);
        System.out.println("Conversion a Binario: " + bin);
        
    }

}

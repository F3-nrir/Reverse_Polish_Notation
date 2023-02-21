/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extras;

/**
 *
 * @author F3nrir
 */
import java.util.*;

public class Notacion_Polaca_Inversa {

    public static void main(String[] args) {
        System.out.println("Entre una operacion en notacion polaca inversa, separando cada elemento por un solo espacio, cuando desee terminar entre '=', asegurese de escribir correctamente la ecuacion:");
        System.out.println("Ejemplo: 2 15 * 10 / 5 + -2 - ="
                + "\n( ( 2 * 15 ) / 10 ) + 5 - ( -2 )"
                + "\nAdelante:");
        ArrayList<String> x = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String a = "";
        while (!a.contains("=")) {
            a = sc.next();
            if (a.contains("=")) {
                break;
            } else {
                x.add(a);
            }
        }
        sc.close();
        System.out.println(calcular(x));
    }

    public static int calcular(ArrayList<String> x) {
        String operadores = "+-*/";

        Stack<String> stack = new Stack<>();

        for (String t : x) {
            if (!operadores.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(Math.round(b / a)));
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}

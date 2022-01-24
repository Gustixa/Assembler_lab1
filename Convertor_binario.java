import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * 
 */
public class Convertor_binario {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// es meramente estético.
        int amount_bits = 0;
        boolean next_step = false;
        amount_bits = bits();
        // Se le suma 1, para que se pueda agregar el valor del signo.
        int[] bits = new int[amount_bits + 1];
        bits[0] = 0;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// es meramente estético.

        for (int i = 0; i < amount_bits; i++) {
            do {
                int value = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el bit para su numero binario: "));

                if (value == 0 || value == 1) {

                    bits[i + 1] = value;
                    next_step = true;
                } else {
                    System.out.println("DEBE INGRESAR UN VALOR COMO 1 O 0, NO PUEDE SER DIFERENTE DE ELLO.");
                }
            } while (!next_step);

            // mas 1, para que no afecte el signo

        }
        C2(bits);
        /**
         * for (int i = 0; i < amount_bits; i++) {
         * System.out.println(bits[i]);
         * }
         */

    }

    /**
     * 
     * @return
     */
    private static int bits() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// es meramente estético.
        String[] options = { "1 bit", "2 bits", "3 bits", "4 bits", "5 bits", "6 bits", "7 bits", "8 bits" };
        int selection = 0;
        boolean next_step = false;
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        try {
            selection = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las opciones: "));
            if (selection < 1 || selection > options.length) {
                System.err.println("DEBE INGRESAR UN VALOR DENTRO DE LAS OPCIONES");
            } else {
                next_step = true;
            }
        } catch (NumberFormatException e) {
            System.err.println("DEBE INGRESAR UN VALOR NUMERICO");
        }

        return selection;
    }

    /**
     * 
     */
    private static void C1(int bits[]) throws IOException, InterruptedException {

    }

    /**
     * 
     */
    private static void C2(int bits[]) throws IOException, InterruptedException {
        // Aumento del arreglo en caso de Overflow.
        int[] complement_a2 = new int[bits.length + 3];
        complement_a2 = bits;
        for (int i = 0; i < bits.length; i++) {
            if (complement_a2[i + 1] == 0) {
                complement_a2[i + 1] = 1;
            } else if (complement_a2[i + 1] == 1) {
                complement_a2[i + 1] = 0;
            }
        }
        // Modificar
        int value = complement_a2[bits.length - 1] + 1;

        for (int i = 0; i < bits.length; i++) {
            complement_a2[bits.length - 1] += 1;
        }
    }
}

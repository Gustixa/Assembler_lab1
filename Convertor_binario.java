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
        for (int i = 1; i < amount_bits; i++) {
            do {
                try {
                    int value = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el bit para su numero binario: "));
                    if (value == 0 || value == 1) {
                        bits[i] = value;
                        next_step = true;
                    } else {
                        System.out.println("DEBE INGRESAR UN VALOR COMO 1 O 0, NO PUEDE SER DIFERENTE DE ELLO.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("DEBE INGRESAR VALORES NUMERICOS");
                }

            } while (!next_step);
        }
        change(bits);
        C2(bits);
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
     * Metodo que devuelve el valor binario con su magnitud y singo
     * 
     * @param bits: int[]
     * @throws IOException
     * @throws InterruptedException
     */
    private static void change(int bits[]) throws IOException, InterruptedException {
        bits[0] = 1;
        int value;
        System.out.println("El primer valor representa el signo del numero 0-positivo, 1-negativo");
        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
    }

    /**
     * 
     * @param bits
     * @throws IOException
     * @throws InterruptedException
     */
    private static void C2(int bits[]) throws IOException, InterruptedException {
        // Aumento del arreglo en caso de Overflow.
        int[] complement_a2 = new int[bits.length + 3];
        complement_a2 = bits;
        complement_a2[0] = 1;
        int value = 0, carry = 0;
        for (int i = 1; i < bits.length; i++) {
            if (complement_a2[i] == 0) {
                complement_a2[i] = 1;
            } else if (complement_a2[i] == 1) {
                complement_a2[i] = 0;
            }
        }
        value = complement_a2[bits.length - 1] + 1;
        // 0 101101 + 1 = 101110

        if (value == 2) {
            complement_a2[bits.length - 1] = 0;
            carry = 1;
            for (int i = 1; i < (bits.length + 1); i++) {
                do {
                    complement_a2[(bits.length - i) - 1] += 1;
                } while (complement_a2[(bits.length - i) - 1] == 2);
            }

        } else if (value == 1) {
            complement_a2[bits.length - 1] = 1;
        }
        System.out.println();
        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
    }
}

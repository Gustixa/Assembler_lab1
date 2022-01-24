import javax.swing.JOptionPane;

public class Binario {
    public static void main(String[] args) {
        int amount_bits = options_selection();
        int[] bits = new int[amount_bits + 1];
    }

    /**
     * 
     * @return
     */
    private static int options_selection() {
        System.out.println("1. 1 bit" + "\n 2. 2 bits");
        int value = Integer.parseInt(JOptionPane.showInputDialog("seleccione una opcion: "));
        return value;
    }

}
package view;

import model.object.Producte;

import java.util.Map;

public class Vista {
    public static void mostrarMissatge(String message) {
        System.out.println(message);
    }

    public static void mostrarCaixa() {

    }

    public static void mostrarCarrito(Map<Integer, Producte> carrito, Map<Integer, Integer> quantitats) {
        if (carrito.isEmpty()) {
            System.out.println("El carro està buit.");
        }

        mostrarMissatge("Carret:");
        for (Map.Entry<Integer, Producte> entry : carrito.entrySet()) {
            Producte producte = entry.getValue();
            int quantitat = quantitats.get(entry.getKey());
            mostrarMissatge(producte.getNom() + " -> " + quantitat);
        }
    }
}

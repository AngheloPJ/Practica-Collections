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
            System.out.println("No hi ha contingut al carret!");
            return;
        }

        mostrarMissatge("Carret:");
        carrito.forEach((codiBarres, producte) -> {
            int quantitat = quantitats.get(codiBarres);
            mostrarMissatge(producte.getNom() + " -> " + quantitat);
        });
        mostrarMissatge("");
    }
}

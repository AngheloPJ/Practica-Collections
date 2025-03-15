package view;

import model.object.Producte;

import java.util.List;
import java.util.Map;

public class Vista {
    public static void mostrarMissatge(String message) {
        System.out.println(message);
    }

    public static void mostrarCarrito(List<Producte> carrito, Map<Integer, Integer> quantitats) {
        if (carrito.isEmpty()) {
            System.out.println("No hi ha contingut al carret!");
            return;
        }

        mostrarMissatge("Carret:");
        quantitats.forEach((codiBarres, quantitat) -> {
            Producte producte = carrito.stream().filter(p -> p.getCodiDeBarres() == codiBarres)
                    .findFirst()
                    .orElse(null);

            if (producte != null) {
                System.out.println(producte.getNom() + " -> " + quantitat);
            }
        });

        mostrarMissatge("");
    }
}

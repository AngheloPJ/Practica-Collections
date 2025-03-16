package view;

import model.object.Alimentacio;
import model.object.Producte;
import model.object.Textil;

import java.time.format.DateTimeFormatter;
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

            if (producte != null) System.out.println(producte.getNom() + " -> " + quantitat);
        });

        mostrarMissatge("");
    }

    public static void mostrarAlimentsOrdenats(List<Producte> productes) {
        String ticket = "";
        ticket += "-----------------------------------\n";
        for (Producte producte : productes) {
            if (producte instanceof Alimentacio aliment) {
                String dataFormateada = aliment.getDataCaducitat().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ticket += aliment.getNom() + " - " + dataFormateada + "\n";
            }
        }
        ticket += "-----------------------------------\n";
        mostrarMissatge(ticket);
    }

    public static void mostrarTextilsOrdenats(List<Producte> productes) {
        String ticket = "";
        ticket += "-----------------------------------\n";
        for (Producte producte : productes) {
            if (producte instanceof Textil textil) {
                ticket += textil.getNom() + " - " + textil.getComposicio() + "\n";
            }
        }
        ticket += "-----------------------------------\n";
        mostrarMissatge(ticket);
    }

    public static void mostrarTickets(List<String> tickets) {
        for (String ticket : tickets) {
            Vista.mostrarMissatge(ticket);
        }
    }
}

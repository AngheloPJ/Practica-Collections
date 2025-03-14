package model;

import model.object.Alimentacio;
import model.object.Electronica;
import model.object.Producte;
import model.object.Textil;

import java.time.LocalDate;
import java.util.*;

public class Model {
    private static final Map<Integer, Producte> carrito = new HashMap<>(); // Carret
    private static final Map<Integer, Integer> quantitats = new HashMap<>(); // Quantitat

    private static final List<String> tickets = new ArrayList<>(); // Tickets

    public static void afegirProducte(String nom, float preu, int codiBarres, String dataCaducitat) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Alimentacio producte = new Alimentacio(nom, preu, codiBarres, dataCaducitat);

        if (carrito.containsKey(codiBarres) && carrito.get(codiBarres).getPreuBase() == producte.getPreuBase())
            quantitats.put(codiBarres, quantitats.get(codiBarres) + 1);
        else {
            carrito.put(codiBarres, producte);
            quantitats.put(codiBarres, 1);
        }
    }

    public static void afegirTextil(String nom, float preu, int codiBarres, String composicio) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Textil producte = new Textil(nom, preu, codiBarres, composicio);
        if (carrito.containsKey(codiBarres) && carrito.get(codiBarres).getPreuBase() == producte.getPreuBase())
            quantitats.put(codiBarres, quantitats.get(codiBarres) + 1);
        else {
            carrito.put(codiBarres, producte);
            quantitats.put(codiBarres, 1);
        }
    }

    public static void afegirElectronica(String nom, float preu, int codiBarres, int diesGarantia) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Electronica producte = new Electronica(nom, preu, codiBarres, diesGarantia);
        if (carrito.containsKey(codiBarres) && carrito.get(codiBarres).getPreuBase() == producte.getPreuBase())
            quantitats.put(codiBarres, quantitats.get(codiBarres) + 1);
        else {
            carrito.put(codiBarres, producte);
            quantitats.put(codiBarres, 1);
        }
    }

    public static void passarPerCaixa() {
        if (carrito.isEmpty()) {
            System.out.println("El carro està buit. No hi ha productes per processar.");
            return;
        }

        String tickets = "";
        tickets += "Tiquet de compra - SAPAMERCAT\n";
        tickets += "-----------------------------------\n";
        tickets += "Data: " + LocalDate.now();
        tickets += "-----------------------------------\n";

        carrito.clear();
    }

    public static Map<Integer, Producte> getCarrito() {
        return carrito;
    }

    public static Map<Integer, Integer> getQuantitat() {
        return quantitats;
    }
}
package model;

import model.object.Alimentacio;
import model.object.Electronica;
import model.object.Producte;
import model.object.Textil;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static void afegirTextil(String nom, float preu, String composicio, int codiBarres) throws Exception {
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

    public static String passarPerCaixa() {
        if (carrito.isEmpty()) {
            System.out.println("El carro està buit. No hi ha productes per processar.");
            return null;
        }

        String tickets = "";
        tickets += "-----------------------------------\n";
        tickets += "Data: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        tickets += "-----------------------------------\n";

        double preuFinal = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        for (Map.Entry<Integer, Producte> entry : carrito.entrySet()) {
            int codiBarres = entry.getKey();
            Producte producte = entry.getValue();
            int quantitat = quantitats.get(codiBarres);

            double preuUnitari = producte.getPreuBase();
            double preuQuantitat = preuUnitari * quantitat;

            preuFinal += preuQuantitat;
            tickets += producte.getNom() + "   " + quantitat + "   " + decimalFormat.format(preuUnitari) + "€   " + decimalFormat.format(preuQuantitat) + "€\n";
        }

        tickets += "-----------------------------------\n";
        tickets += "Total: " + decimalFormat.format(preuFinal) + "€\n";

        carrito.clear();
        quantitats.clear();
        return tickets;
    }

    public static Map<Integer, Producte> getCarrito() {
        return carrito;
    }

    public static Map<Integer, Integer> getQuantitat() {
        return quantitats;
    }
}
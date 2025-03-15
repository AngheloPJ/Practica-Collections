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
    private static final List<Producte> carrito = new ArrayList<>(); // Carret
    private static final List<String> tickets = new ArrayList<>(); // Tickets

    public static void afegirProducte(String nom, float preu, int codiBarres, String dataCaducitat) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Alimentacio producte = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
        carrito.add(producte);
    }

    public static void afegirTextil(String nom, float preu, String composicio, int codiBarres) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Textil producte = new Textil(nom, preu, codiBarres, composicio);
        carrito.add(producte);
    }

    public static void afegirElectronica(String nom, float preu, int codiBarres, int diesGarantia) throws Exception {
        //if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Electronica producte = new Electronica(nom, preu, codiBarres, diesGarantia);
        carrito.add(producte);
    }

    public static String passarPerCaixa() {
        if (carrito.isEmpty()) {
            System.out.println("El carro està buit. No hi ha productes per processar.");
            return null;
        }

        String ticket = "";
        ticket += "-----------------------------------\n";
        ticket += "Data: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        ticket += "-----------------------------------\n";

        Map<Integer, Integer> quantitats = calcularQuantitats();

        double preuFinal = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        for (Map.Entry<Integer, Integer> entry : quantitats.entrySet()) {
            int codiBarres = entry.getKey();
            int quantitat = entry.getValue();

            Producte producte = carrito.stream()
                    .filter(p -> p.getCodiDeBarres() == codiBarres)
                    .findFirst()
                    .orElse(null);

            if (producte != null) {
                double preuUnitari = producte.getPreuBase();
                double preuQuantitat = preuUnitari * quantitat;

                preuFinal += preuQuantitat;
                ticket += producte.getNom() + "   " + quantitat + "   " + decimalFormat.format(preuUnitari) + "€   " + decimalFormat.format(preuQuantitat) + "€\n";
            }
        }

        ticket += "-----------------------------------\n";
        ticket += "Total: " + decimalFormat.format(preuFinal) + "€\n";

        carrito.clear();
        quantitats.clear();
        tickets.add(ticket);

        return ticket;
    }

    public static List<String> ordenarPerTextil() {
        Collections.sort(tickets);
        return tickets;
    }

    public static String cercarTextilPerCodi(int codiDeBarres) {
        return carrito.stream()
                .filter(producte -> producte.getCodiDeBarres() == codiDeBarres)
                .map(Producte::getNom)
                .findFirst()
                .orElse("No s'ha trobat cap producte amb aquest codi de barres");
    }

    public static Map<Integer, Integer> calcularQuantitats() {
        Map<Integer, Integer> quantitats = new HashMap<>();
        for (Producte producte : carrito) {
            int codiBarres = producte.getCodiDeBarres();
            quantitats.put(codiBarres, quantitats.getOrDefault(codiBarres, 0) + 1);
        }
        return quantitats;
    }


    public static List<Producte> getCarrito() {
        return carrito;
    }

    public static List<String> getTickets() {
        return tickets;
    }
}
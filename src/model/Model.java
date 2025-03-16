package model;

import model.exceptions.DataCaducitatException;
import model.exceptions.LimitCaractersException;
import model.exceptions.LimitProductesException;
import model.exceptions.NegatiuException;
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

    public static void afegirProducte(String nom, float preu, int codiBarres, String dataCaducitat) throws LimitProductesException, LimitCaractersException, NegatiuException, DataCaducitatException {
        if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Alimentacio producte = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
        carrito.add(producte);
    }

    public static void afegirTextil(String nom, float preu, String composicio, int codiBarres) throws LimitProductesException, LimitCaractersException, NegatiuException {
        if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
        Textil producte = new Textil(nom, preu, codiBarres, composicio);
        carrito.add(producte);
    }

    public static void afegirElectronica(String nom, float preu, int codiBarres, int diesGarantia) throws LimitProductesException, LimitCaractersException, NegatiuException {
        if (carrito.size() >= 100) throw new LimitProductesException("El carret està ple!");
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

            Producte producte = cercarCodiBarres(codiBarres);

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

    public static void ordenarPerCaducitat() {
        carrito.sort((p1, p2) -> {
            if (p1 instanceof Alimentacio && p2 instanceof Alimentacio) {
                return ((Alimentacio) p1).compareTo((Alimentacio) p2);
            }
            return 0;
        });
    }

    public static void ordenarPorTextil() {
        carrito.sort((p1, p2) -> {
            if (p1 instanceof Textil && p2 instanceof Textil) {
                return ((Textil) p1).compareTo((Textil) p2);
            }
            return 0;
        });
    }

    public static Producte cercarCodiBarres(int codiDeBarres) {
        return carrito.stream()
                .filter(p -> p.getCodiDeBarres() == codiDeBarres)
                .findFirst()
                .orElse(null);
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
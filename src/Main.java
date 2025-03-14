import model.Model;
import utils.LoggerUtil;
import view.Vista;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int opcio;
            do {
                Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
                LoggerUtil.title("INICI DEL PROJECTE");

                Vista.mostrarMissatge("1) Gestionar Magatzem i Compres");
                Vista.mostrarMissatge("2) Introduir producte");
                Vista.mostrarMissatge("3) Passar per caixa");
                Vista.mostrarMissatge("4) Mostrar carret de compra");
                Vista.mostrarMissatge("0) Acabar");

                Vista.mostrarMissatge("Escull una opció (0-3): ");
                opcio = opcions(scan.nextInt());
                scan.nextLine();
            } while (opcio != 0);
        } catch (Exception e) { /* Canviar exception por valores más adecuados */
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println(e); // ToString
        }
    }

    private static int opcions (int opcio) throws Exception {
        switch (opcio) {
            case 1:
                LoggerUtil.title("MAGATZEM I COMPRES");
                Vista.mostrarMissatge("1) Caducitat");
                Vista.mostrarMissatge("2) Tiquets de compra");
                Vista.mostrarMissatge("3) Composició tèxtil");
                Vista.mostrarMissatge("0) Tornar");
                subOpcionsMagatzem(scan.nextInt());
                scan.nextLine();
                break;
            case 2:
                LoggerUtil.title("PRODUCTE");
                Vista.mostrarMissatge("1) Alimentació");
                Vista.mostrarMissatge("2) Tèxtil");
                Vista.mostrarMissatge("3) Elèctronica");
                Vista.mostrarMissatge("0) Tornar");
                subOpcionsProducte(scan.nextInt());
                scan.nextLine();
                break;
            case 3:
                LoggerUtil.title("SAPAMERCAT");
                break;
            case 4:
                LoggerUtil.title("CARRET DE COMPRA");
                Vista.mostrarCarrito(Model.getCarrito(), Model.getQuantitat());
                break;
            case 0:
                Vista.mostrarMissatge("Has finalitzat el menú del supermercat.");
                break;
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }

        return opcio;
    }

    private static void subOpcionsMagatzem (int opcio) throws Exception {
        switch (opcio) {
            case 1:
                Vista.mostrarMissatge("AUN NO EXISTE!");
                break;
            case 2:
                Vista.mostrarMissatge("AUN NO EXISTE!");
                break;
            case 3:
                Vista.mostrarMissatge("AUN NO EXISTE!");
                break;
            case 0:
                Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
                LoggerUtil.title("INICI DEL PROJECTE");

                Vista.mostrarMissatge("1) Gestionar Magatzem i Compres");
                Vista.mostrarMissatge("2) Introduir producte");
                Vista.mostrarMissatge("3) Passar per caixa");
                Vista.mostrarMissatge("4) Mostrar carret de compra");
                Vista.mostrarMissatge("0) Acabar");

                Vista.mostrarMissatge("Escull una opció (0-4): ");
                opcions(scan.nextInt());
                scan.nextLine();
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }
    }

    private static void subOpcionsProducte (int opcio) throws Exception {
        switch (opcio) {
            case 1:
                demanarDadesAlimentacio();
                break;
            case 2:
                Vista.mostrarMissatge("AUN NO EXISTE!");
                break;
            case 3:
                Vista.mostrarMissatge("AUN NO EXISTE!");
                break;
            case 0:
                Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
                LoggerUtil.title("INICI DEL PROJECTE");

                Vista.mostrarMissatge("1) Gestionar Magatzem i Compres");
                Vista.mostrarMissatge("2) Introduir producte");
                Vista.mostrarMissatge("3) Passar per caixa");
                Vista.mostrarMissatge("4) Mostrar carret de compra");
                Vista.mostrarMissatge("0) Acabar");

                Vista.mostrarMissatge("Escull una opció (0-4): ");
                opcions(scan.nextInt());
                scan.nextLine();
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }
    }

    /* Alimentacio */
    private static void demanarDadesAlimentacio() throws Exception {
        Vista.mostrarMissatge("Afegir aliment");
        Vista.mostrarMissatge("Nom del producte: ");
        scan.nextLine();
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        scan.nextLine();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Data caducitat (dd/mm/aaaa): ");
        String dataCaducitat = scan.next();

        Model.afegirProducte(nom, preu, codiBarres, dataCaducitat);
    }

    /* Textil */
    private static void demanarDadesTextil() {
        Vista.mostrarMissatge("Afegir téxtil");
        Vista.mostrarMissatge("Nom del producte: ");
        String nom = scan.next();
        scan.nextLine(); // Consume the remaining newline
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        scan.nextLine();
        Vista.mostrarMissatge("Composició: ");
        String composicio = scan.next();
        scan.nextLine();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();
        scan.nextLine();

        /* Mandar a caixa */
    }

    /* Electronica */
    private static void demanarDadesElectronica() {
        Vista.mostrarMissatge("Afegir electrònica");
        Vista.mostrarMissatge("Nom del producte: ");
        String nom = scan.next();
        scan.nextLine(); // Consume the remaining newline
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        scan.nextLine();
        Vista.mostrarMissatge("Garantia (dies): ");
        int galarantia = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();
        scan.nextLine();

        /* Mandar a caixa */
    }

}
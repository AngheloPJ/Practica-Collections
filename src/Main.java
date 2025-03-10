import utils.LoggerUtil;
import view.Vista;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
        LoggerUtil.title("INICI DEL PROJECTE");

        Vista.mostrarMissatge("1) Introduir producte");
        Vista.mostrarMissatge("2) Passar per caixa");
        Vista.mostrarMissatge("3) Mostrar carret de compra");
        Vista.mostrarMissatge("0) Acabar");

        Vista.mostrarMissatge("Escull una opció (0-3): ");
        try {
            opcions(scan.nextInt());
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }


    }

    private static void opcions (int opcio) {
        switch (opcio) {
            case 1:
                LoggerUtil.title("PRODUCTE");
                Vista.mostrarMissatge("1) Alimentació");
                Vista.mostrarMissatge("2) Tèxtil");
                Vista.mostrarMissatge("3) Elèctronica");
                Vista.mostrarMissatge("0) Tornar");
                subOpcions(scan.nextInt());
                break;
            case 2:
                LoggerUtil.title("SAPAMERCAT");
                break;
            case 3:
                LoggerUtil.title("CARRET DE COMPRA");
                break;
            case 0:
                Vista.mostrarMissatge("Has finalitzat el menú del supermercat.");
                break;
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }
    }

    private static void subOpcions (int opcio) {
        switch (opcio) {
            case 1:
                demanarDadesProducte();
                break;
            case 2:
                Vista.mostrarMissatge("AUN NO EXISTE BRO!");
                break;
            case 3:
                Vista.mostrarMissatge("AUN NO EXISTE BRO!");
                break;
            case 0:
                Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
                LoggerUtil.title("INICI DEL PROJECTE");

                Vista.mostrarMissatge("1) Introduir producte");
                Vista.mostrarMissatge("2) Passar per caixa");
                Vista.mostrarMissatge("3) Mostrar carret de compra");
                Vista.mostrarMissatge("0) Acabar");

                Vista.mostrarMissatge("Escull una opció (0-3): ");
                opcions(scan.nextInt());
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }
    }

    /* Alimentacio */
    private static void demanarDadesProducte() {
        Vista.mostrarMissatge("Afegir aliment");
        Vista.mostrarMissatge("Nom del producte: ");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();
        Vista.mostrarMissatge("Data caducitat (dd/mm/aaaa): ");
        String dataCaducitat = scan.next();

        /* Mandar a caixa */
    }

    /* Textil */
    private static void demanarDadesProducte(String nom, float preu, String composicio, int codiBarres) {

    }

    /* Electronica */
    private static void demanarDadesProducte(String nom, float preu, int garantia, int codiBarres) {

    }

}
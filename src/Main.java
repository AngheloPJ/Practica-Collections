import model.Model;
import model.exceptions.DataCaducitatException;
import model.exceptions.LimitCaractersException;
import model.exceptions.LimitProductesException;
import model.exceptions.NegatiuException;
import utils.LoggerUtil;
import view.Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int opcio;
            do {
                enviarMenuPrincipal();
                opcio = opcions(scan.nextInt());
                scan.nextLine();
            } while (opcio != 0);
        } catch (InputMismatchException e) {
            Vista.mostrarMissatge("L'opció ha de ser un número!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
                Vista.mostrarMissatge(Model.passarPerCaixa());
                break;
            case 4:
                LoggerUtil.title("CARRET DE COMPRA");
                Vista.mostrarCarrito(Model.getCarrito(), Model.calcularQuantitats());
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
                Model.ordenarPerCaducitat();
                Vista.mostrarAlimentsOrdenats(Model.getCarrito());
                break;
            case 2:
                Vista.mostrarTickets(Model.getTickets());
                break;
            case 3:
                Model.ordenarPorTextil();
                Vista.mostrarTextilsOrdenats(Model.getCarrito());
                break;
            case 0:
                enviarMenuPrincipal();
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
                demanarDadesTextil();
                break;
            case 3:
                demanarDadesElectronica();
                break;
            case 0:
                enviarMenuPrincipal();
                opcions(scan.nextInt());
                scan.nextLine();
            default:
                Vista.mostrarMissatge("No existeix aquesta opció!");
                break;
        }
    }

    /* Alimentacio */
    private static void demanarDadesAlimentacio() throws LimitProductesException, LimitCaractersException, NegatiuException, DataCaducitatException {
        Vista.mostrarMissatge("Afegir aliment");
        Vista.mostrarMissatge("Nom del producte: ");
        scan.nextLine();
        String nom = scan.nextLine();
        if (nom.length() > 20) throw new LimitCaractersException("El nom del producte ha ser inferior a 20 caràcters.");
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu!");
        scan.nextLine();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Data caducitat (dd/mm/aaaa): ");
        String dataCaducitat = scan.next();

        Model.afegirProducte(nom, preu, codiBarres, dataCaducitat);
    }

    /* Textil */
    private static void demanarDadesTextil() throws LimitProductesException, LimitCaractersException, NegatiuException {
        Vista.mostrarMissatge("Afegir téxtil");
        Vista.mostrarMissatge("Nom del producte: ");
        String nom = scan.next();
        if (nom.length() > 20) throw new LimitCaractersException("El nom del producte ha ser inferior a 20 caràcters.");
        scan.nextLine(); // Consume the remaining newline
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu!");
        scan.nextLine();
        Vista.mostrarMissatge("Composició: ");
        String composicio = scan.next();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();

        Model.afegirTextil(nom, preu, composicio, codiBarres);
    }

    /* Electronica */
    private static void demanarDadesElectronica() throws LimitProductesException, LimitCaractersException, NegatiuException {
        Vista.mostrarMissatge("Afegir electrònica");
        scan.nextLine();
        Vista.mostrarMissatge("Nom del producte: ");
        String nom = scan.nextLine();
        if (nom.length() > 20) throw new LimitCaractersException("El nom del producte ha ser inferior a 20 caràcters.");
        Vista.mostrarMissatge("Preu: ");
        float preu = scan.nextFloat();
        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu!");
        scan.nextLine();
        Vista.mostrarMissatge("Garantia (dies): ");
        int garantia = scan.nextInt();
        Vista.mostrarMissatge("Codi de barres: ");
        int codiBarres = scan.nextInt();

        Model.afegirElectronica(nom, preu, garantia, codiBarres);
    }

    /* Enviar el menú incial */
    private static void enviarMenuPrincipal() {
        Vista.mostrarMissatge("BENVINGUT AL SAPAMERCAT");
        LoggerUtil.title("INICI DEL PROJECTE");

        Vista.mostrarMissatge("1) Gestionar Magatzem i Compres");
        Vista.mostrarMissatge("2) Introduir producte");
        Vista.mostrarMissatge("3) Passar per caixa");
        Vista.mostrarMissatge("4) Mostrar carret de compra");
        Vista.mostrarMissatge("0) Acabar");

        Vista.mostrarMissatge("Escull una opció (0-4): ");
    }

}
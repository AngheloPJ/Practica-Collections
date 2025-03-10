package utils;

import view.Vista;

public class LoggerUtil {
    public static void title(String name) {
        String barras = "";
        for (int i = 0; i < (name.length() + 8); i++) barras += "-";

        Vista.mostrarMissatge(barras);
        Vista.mostrarMissatge("--- " + name + " ---");
        Vista.mostrarMissatge(barras);
    }
}
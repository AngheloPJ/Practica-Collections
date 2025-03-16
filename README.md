 ## Pràctica - Collections

> [!NOTE]
> La multinacional <b>SAPAMERCAT</b> us demana que li dissenyeu una aplicació revolucionaria! Consisteix en fer que el carro de la compra mostri, en temps real, el preu dels productes que s'hi van introduint.
> L'empresa us indica que l'aplicació, de moment, només ha de permetre gestionar les dades d'uns quants dels seus productes: alimentació, tèxtil i electrònica. Aquests productes tenen unes característiques comuns (preu, nom i codi de barres) i un conjunt de característiques específiques de cada tipus de producte:

### 1. Gestió Magatzem i Compres
- 1.1. Caducitat<br/>
Per poder <ins>ordenar</ins> per  $${\color{red}Caducitat}$$ he $${\color{orange}implementat}$$ el $${\color{aqua}CompareTo<>}$$ i $${\color{lightskyblue}compareTo()}$$:
```java
public class Alimentacio extends Producte implements Comparable<Alimentacio> {
    private final LocalDate dataCaducitat;

    @Override
    public int compareTo(Alimentacio alimentacio) {
        return this.dataCaducitat.compareTo(alimentacio.dataCaducitat);
    }
}
```
- 1.2. Tiquets de compra
  - Per poder <ins>mostrar</ins> els $${\color{lightgray}tickets}$$ he fet servir una colecció diferent.
```java
    private static final List<String> tickets = new ArrayList<>(); // Tickets
    tickets.add(ticket); // Aixó ho faig servir en "Passar per caixa"

    public static List<String> getTickets() {
        return tickets;
    }
    
```
- 1.3. Composició tèxtil<br/>
  - Per poder <ins>ordenar</ins> segons la $${\color{fuchsia}Composició \space tèxtil}$$ he fet servir el $${\color{aqua}CompareTo<>}$$ i $${\color{lightskyblue}compareTo()}$$ també:
```java
public class Textil extends Producte implements Comparable<Textil> {
    private final String composicio;

    @Override
    public int compareTo(Textil textil) {
        return this.composicio.compareTo(textil.composicio);
    }
}
```
- Per poder trobar els <ins>maitexos</ins> $${\color{darkorange}Codi \space de \space barres}$$ he fet servir el $${\color{aquamarine}equals()}$$:
```java
    @Override
    public boolean equals(Object t) {
        if (this == t) return true;
        if (!(t instanceof Textil)) return false;

        Textil textil = (Textil) t;
        return getCodiDeBarres() == textil.getCodiDeBarres();
    }
```
- 1.0. Tornar ➜ $${\color{lightgreen}FET}$$

### 2. Introduir producte
> [!IMPORTANT]
> Vaig començar utilitzant $${\color{gold}HashMap}$$ pero em vaig a donar que <ins>segons l'enunciat</ins><br/>
> Ha de tenir <ins>valors duplicats</ins> el $${\color{greenyellow}Carret}$$</ins> i que la $${\color{cyan}Caixa}$$ és independent del carret.<br/>
> $${\color{lightgreen}Llavors}$$ el que he fet ha sigut **canviar** el $${\color{gold}HashMap}$$ per $${\color{gray}ArrayList}$$<br/> per aconseguir guardar <ins>duplicats</ins>. 
- 2.1. Alimentació ➜ $${\color{lightgreen}FET}$$
- 2.2. Tèxtil ➜ $${\color{lightgreen}FET}$$
- 2.3. Electrònica ➜ $${\color{lightgreen}FET}$$
- 2.0. Tornar ➜ $${\color{lightgreen}FET}$$

### 3. Passar per caixa
> [!IMPORTANT]
> Per poder juntar els $${\color{darkorange}Codi \space de \space barres}$$ he fet servir $${\color{gold}HashMap}$$ per guardar-ho com a $${\color{lightgren}Clau primària}$$<br/>
> Així aconsegueixo que $${\color{lightgreen}es \space guarden}$$ només <ins>una vegada</ins>.
- Mostrar capçelera ➜ $${\color{lightgreen}FET}$$
- Introduïr productes iguals ➜ $${\color{lightgreen}FET}$$
- Buidar carro ➜ $${\color{lightgreen}FET}$$

### 4. Mostrar carro de la compra
> [!IMPORTANT]
> Ja que esto era $${\color{darkorange}independent}$$ de la $${\color{cyan}Caixa}$$ he fet un mètod per obtenir la quantitat.

- Mostrar llista i quantitat ➜ $${\color{lightgreen}FET}$$
  - Utilitzant $${\color{gold}HashMap}$$ he fet l'ús de _`.getOrDefault(<variable>, <valor_per_defecte>) + 1`_ per <ins>sumar</ins> si troba una quantitat ja guardada.
```java
public static Map<Integer, Integer> calcularQuantitats() {
        Map<Integer, Integer> quantitats = new HashMap<>();
        for (Producte producte : carrito) {
            int codiBarres = producte.getCodiDeBarres();
            quantitats.put(codiBarres, quantitats.getOrDefault(codiBarres, 0) + 1);
        }
        return quantitats;
    }
```

### 0. Sortir
- Finalitzar el menú ➜ $${\color{lightgreen}FET}$$

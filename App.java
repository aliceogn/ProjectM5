import java.util.Arrays;

public class App {
    private Visor Visor;
    private Llista llista;
    private Categoria[] categories;

    // Esta función muestra por pantalla estándar las categorías disponibles
    private void mostraCategories() {
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i]);
        }
    }
    private void afegeixCategoria(String nom) {
        Article[] articles;
        Categoria categoria = new Categoria(nom, articles);   // creem una nova categoria
        categories = Arrays.copyOf(categories, categories.length + 1 );   // copiem l'array de categories que teniem i la fem 1 posició més gran
        categories[categories.length - 1] = categoria;    // aquí guardem la nova categoria a la nova última posició de l'array
    }
    private void esborraCategoria(String nom) {
        Categoria[] newArray = new Categoria[categories.length - 1];

        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getNom() != nom) { 
                int j = 0;
                newArray[j++] = categories[i];
            }
            // mirar funcionalitat per a comprovar si el nom de la categoria coincideix amb una existent
        }
        this.categories = newArray;
    }
    private void afegirArticle(String nom) {
        Article[] articles;
        Article article = new Article(nom, categories);   // creem una nova categoria
        categories = Arrays.copyOf(categories, categories.length + 1 );   // copiem l'array de categories que teniem i la fem 1 posició més gran
        categories[categories.length - 1] = categoria;
    }
    private void esborrarArticle() {

    }
    private void afegirItem() {

    }
    private void esborrarItem() {

    }
    private void seleccionaVisor() {

    }
    private String mostraLlista() {

    }
    private String mostraLlista(Categoria categoria) {

    }
    private static void mostraMenuPrincipal () {
        System.out.println("MENU PRINCIPAL\n");
        System.out.println("Opcions: \n");
        System.out.println("0. Afegir categoria");
        System.out.println("1. Esborrar categoria");
        System.out.println("2. Afegir article");
        System.out.println("3. Esborrar article");
        System.out.println("4. Afegir item");
        System.out.println("5. Esborrar item");
        System.out.println("6. Mostrar categories");
        System.out.println("7. Seleccionar visor");
        System.out.println("8. Mostrar llista");
        System.out.println("9. Mostrar llista per categories");
        System.out.println("\nIndica la opció escollida");
    }
    public static void main(String[] args) {
        App.mostraMenuPrincipal();
        int numEscollit = Integer.parseInt(Entrada.readLine());
        switch(numEscollit) {
            case 0: System.out.println("Anomena la nova categoria");
                    String novaCategoria = Entrada.readLine();
                    afegeixCategoria(novaCategoria); // mirar array de artículos??
            case 1: mostraCategories();
                    System.out.println("Quina categoria vol esborrar?");
                    String categoriaAEsborrar = Entrada.readLine();
                    System.out.println("Està segur?");
                    System.out.println("\n0. No");
                    System.out.println("\n1. Si");
                    int resposta = Integer.parseInt(Entrada.readLine());
                    if (resposta == 1) {
                        esborraCategoria(categoriaAEsborrar);
                    }
                    else {
                        mostraMenuPrincipal();
                    }
            case 2: System.out.println("Anomena el nou article");
                    String nouArticle = Entrada.readLine();
                    System.out.println("A quina categoria pertany?");
                    Categoria categoriaEscollida = Entrada.readLine();
                    afegirArticle(nouArticle, );
            case 3: System.out.println("Quin article vol esborrar?");
                    String articleAEsborrar = Entrada.readLine();
                    System.out.println("Està segur?");
                    System.out.println("\n0. No");
                    System.out.println("\n1. Si");
                    int resposta = Integer.parseInt(Entrada.readLine());
                    if (resposta == 1) {
                        esborraCategoria(categoriaAEsborrar);
                    } 
                    else {
                        mostraMenuPrincipal();
        }
    }
}
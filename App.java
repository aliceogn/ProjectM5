import java.util.Arrays;

public class App {
    private Visor visor;
    private Llista llista;
    private Categoria[] categories;
    private static App instancia;

    private App() { 
        llista = Llista.getInstance(); 
    }
    // fem un singleton perquè només utilitzarem una App
    private static App getInstance() { 
        if (instancia == null) {
            instancia = new App();
        }
        return instancia;
    }
    // Aquesta funció mostra per sortida estàndar les categories disponibles
    private void mostraCategories() {
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i]);   // fer toString
        }
    }
    private void afegeixCategoria(String nom) {
        Categoria categoria = new Categoria(nom);   // creem una nova categoria
        categories = Arrays.copyOf(categories, categories.length + 1 );   // copiem l'array de categories que teniem i la fem 1 posició més gran
        categories[categories.length - 1] = categoria;    // aquí guardem la nova categoria a la nova última posició de l'array
    }
    private void esborraCategoria(Categoria categoria) {
        // esborrar els articles de la categoria abans
        
        Categoria[] newArray = new Categoria[categories.length - 1];

        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getNom() != categoria.getNom()) { 
                int j = 0;
                newArray[j] = categories[i];
                j++;
            }
        }
        this.categories = newArray;
    }
    private void afegirArticle(String nom, Categoria categoria) {
        categoria.createArticle(nom);
    }
    private void esborrarArticle(Article article) {
        // esborrar items abans
        Article[] articles = article.getCategoria().getArticles();
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
    // Aquest mètode busca, a partir del nom donat, la categoria a la qual pertany i la retorna
    private Categoria trobaCategoria(String nom) {
        for (Categoria categoria: categories) {
            if (categoria.getNom().equals(nom)) {
                return categoria;
            }
        }
        return null;  // si no ha trobat la categoria amb el nom que se li ha passat retornem null
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
        System.out.println("10. Sortir del programa");
        System.out.println("\nIndica la opció escollida");
    }
    public static void main(String[] args) {
        App app = getInstance();
        boolean volSortir = false;
        while(!volSortir) {
            mostraMenuPrincipal();
            int numEscollit = Integer.parseInt(Entrada.readLine());
            switch(numEscollit) {
                case 0:
                    System.out.println("Anomena la nova categoria");
                    app.afegeixCategoria(Entrada.readLine()); // mirar array de artículos??
                    break;
                case 1:
                    app.mostraCategories();
                    System.out.println("Quina categoria vol esborrar?");
                    Categoria categoriaAEsborrar = app.trobaCategoria(Entrada.readLine());
                    System.out.println("Està segur?");
                    System.out.println("\n0. No");
                    System.out.println("\n1. Si");
                    int resposta = Integer.parseInt(Entrada.readLine());
                    if (resposta == 1) {
                        app.esborraCategoria(categoriaAEsborrar);
                    }
                    else {
                        mostraMenuPrincipal();
                    }
                    break;
                case 2: 
                    System.out.println("Anomena el nou article");
                    String nomArticle = Entrada.readLine();
                    System.out.println("A quina categoria pertany?");
                    Categoria categoriaEscollida = app.trobaCategoria(Entrada.readLine());
                    app.afegirArticle(nomArticle, categoriaEscollida);
                    break;
                case 3: 
                    System.out.println("Quin article vol esborrar?");
                    String articleAEsborrar = Entrada.readLine();
                    System.out.println("Està segur?");
                    System.out.println("\n0. No");
                    System.out.println("\n1. Si");
                    int resposta3 = Integer.parseInt(Entrada.readLine());
                    if (resposta3 == 1) {
                        app.esborrarArticle(articleAEsborrar); // fer funció per agafar article 
                    } 
                    else {
                        mostraMenuPrincipal();
                    }
                    break;
                case 10:
                    volSortir = true;
                    System.out.println("Fins aviat!");
            }
        }
    }
}
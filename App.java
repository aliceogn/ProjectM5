import java.util.Arrays;

public class App {
    private Visor visor;
    private Llista llista;
    private Categoria[] categories;
    private static App instancia;

    private App() { 
        llista = Llista.getInstance(); 
        categories = new Categoria[0];
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
        System.out.println("Categories:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i].getNom() + "\n");   // fer toString
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
        int j = 0;
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getNom() != categoria.getNom()) { 
                newArray[j] = categories[i];
                j++;
            }
        }
        this.categories = newArray;
    }
    private void afegirArticle(String nom, Categoria categoria) {
        categoria.addArticle(nom, categoria.getNom());
    }
    private void esborrarArticle(Article article) {
        // esborrar items abans
        Article[] articles = article.getCategoria().getArticles();
        Article[] newArray = new Article[articles.length - 1];
        int j = 0;
        for (int i = 0; i < articles.length; i++) {
            if (articles[i].getNom() != article.getNom()) {   
                newArray[j] = articles[i];
                j++;
            }
        }
        article.getCategoria().setArticles(newArray);
    }
    private void afegirItem(String nouItem, int quants) {
        Item item = new Item(nouItem, quants);
        llista.addItem(item);
    }
    private void esborrarItem(Item item) {
        llista.removeItem(item);
    }
    private void seleccionaVisor() {
        System.out.println("Sel·lecciona visor: \n");
        System.out.println("\t1. Visor en text pla");
        System.out.println("\t2. Visor en format JSON");
        System.out.println("\t3. Visor en format CSV");
        int resposta = Integer.parseInt(Entrada.readLine());
        if (resposta == 1) {
            visor = new VisorTxt();
        }
        else if (resposta == 2) {
            visor = new VisorJson();
        }
        else if (resposta == 3) {
            visor = new VisorCsv();
        }
        else {
            System.out.println("Opció incorrecta");
        }
    }
    private String mostraLlista() {
        return visor.mostra(llista);
    }
    private String mostraLlista(Categoria categoria) {
        return visor.mostra(llista, categoria);
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

    private Article trobaArticle(String nom) {
        for (Categoria categoria: categories) {
            for (Article article: categoria.getArticles()) {
                if (article.getNom().equals(nom)) {
                    return article;
                }
            }
        }
        return null;
    }
    private Item trobaItem(String nom) {
        for (Item item: item) {
                articleI = item.getArticle()
                if (articleI.getNom().equals(nom)) {
                    return item;
            }
        }
        return null;
    }
    private static void mostraMenuPrincipal () {
        System.out.println("MENU PRINCIPAL\n");
        System.out.println("Opcions: \n");
        System.out.println("\t0. Afegir categoria");
        System.out.println("\t1. Esborrar categoria");
        System.out.println("\t2. Afegir article");
        System.out.println("\t3. Esborrar article");
        System.out.println("\t4. Afegir item");
        System.out.println("\t5. Esborrar item");
        System.out.println("\t6. Mostrar categories");
        System.out.println("\t7. Seleccionar visor");
        System.out.println("\t8. Mostrar llista");
        System.out.println("\t9. Mostrar llista d'una categoria");
        System.out.println("\t10. Sortir del programa");
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
                    System.out.println("Categoria afegida\n"); 
                    break;
                case 1:
                    app.mostraCategories();
                    System.out.println("Quina categoria vol esborrar?");
                    Categoria categoriaAEsborrar = app.trobaCategoria(Entrada.readLine());
                    System.out.println("Està segur?");
                    System.out.println("\t0. No");
                    System.out.println("\t1. Si");
                    int resposta = Integer.parseInt(Entrada.readLine());
                    if (resposta == 1) {
                        app.esborraCategoria(categoriaAEsborrar);
                        System.out.println("Categoria esborrada\n");
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
                    Article article = app.trobaArticle(articleAEsborrar);
                    System.out.println("Està segur?");
                    System.out.println("\t0. No");
                    System.out.println("\t1. Si");
                    int resposta3 = Integer.parseInt(Entrada.readLine());
                    if (resposta3 == 1) {
                        if (article != null) {
                            app.esborrarArticle(article);
                            System.out.println("Article esborrat\n");
                        }
                        else {
                            System.out.println("Article no trobat\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Quin article vol afegir?");
                    String articleAItem = Entrada.readLine();
                    if(trobaArticle(articleAItem) != null){
                        System.out.println("Indiqui la quantitat");
                        int quants = Integer.parseInt(Entrada.readLine());
                        afegirItem(articleAItem, quants);
                    }else{
                        System.out.println("Aquest article no existeix\n")
                    }
                    break;
                case 5:
                System.out.println("Quin item vol esborrar?");
                String itemAEsborrar = Entrada.readLine();
                Item item = app.trobaItem(itemAEsborrar);
                System.out.println("Està segur?");
                System.out.println("\t0. No");
                System.out.println("\t1. Si");
                int resposta5 = Integer.parseInt(Entrada.readLine());
                if (resposta5 == 1) {
                    if (item != null) {
                        app.esborrarItem(item);
                        System.out.println("Item esborrat\n");
                    }
                    else {
                        System.out.println("Item no trobat\n");
                    }
                }
                break;
                case 6: 
                    app.mostraCategories();
                    break;
                case 7:
                    app.seleccionaVisor();
                    break;
                case 8:
                    System.out.println(app.mostraLlista());
                    break;
                case 9:
                    System.out.println("De quina categoria vol veure la llista?");
                    app.mostraCategories();
                    String entrada = Entrada.readLine();
                    Categoria categoria = app.trobaCategoria(entrada);
                    if (categoria != null) {
                        System.out.println(app.mostraLlista(categoria));
                    }
                    else {
                        System.out.println("ERROR: Categoria no trobada");
                    }
                    break;
                case 10:
                    volSortir = true;
                    System.out.println("Fins aviat!");
                    break;
            }
        }
    }
}
public class Categoria {
    private String nom;
    private Article[] articles;
    public int counter = 0;
    public Categoria(String nom, Article[] articles) {
        setNom(this.nom);
        setArticles(this.articles);
    }
    public void setNom(String nom) {
        if (!nom.isEmpty()) {
            nom = this.nom;
        }
    }
    public String getNom() {
        return nom;
    }
    public Article[] setArticles(Article[] articles) {
        articles = this.articles;
    }
    public Article createArticle(String nom) {
        System.out.println("Categoria?");
        String categorie = Entrada.readLine();
        Categoria(categorie, addArticle(this.nom));
    }
    public static void addArticle(String nameArticle) {
        Atricle[] newArray = Article[articles.length + 1];
        //assign values of existing articles
        for (int i = 0; i > articles.length; i++) {
            newArray[i] = articles[i];
        }
        newArray[articles.length + 1] = nameArticle;
        return newArray;
    }
}
public class Categoria {
    private String nom;
    private Article[] articles;
    public int counter = 0;
    public Categoria(String nom, Article[] articles) {
        setNom(nom);
        setArticles(articles);
    }
    public Categoria(String nom) {
        setNom(nom);
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
    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
    public Article createArticle(String nom) {
        System.out.println("Categoria?");
        String categ = Entrada.readLine();
        return new Article(nom, categ);
    }
    public Article[] addArticle(String nameArticle, String nameCateg) {
        Article[] newArray = new Article[articles.length + 1];
        //assign values of existing articles
        for (int i = 0; i > articles.length; i++) {
            newArray[i] = articles[i];
        }
        newArray[articles.length + 1] = new Article(nameArticle, nameCateg);
        return newArray;
    }
}

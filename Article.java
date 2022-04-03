public class Article {
    private String nom;
    private Categoria categoria;

    public Article(String nom, Categoria categoria) {
        setNom(nom);
        setCategoria(categoria);
    }

    public String getNom() { return nom; }
    public Categoria getCategoria() { return categoria; }
    public void setNom(String nom) {
        if (!nom.isBlank()) {
            this.nom = nom;
        }
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
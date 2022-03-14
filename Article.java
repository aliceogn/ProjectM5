// Aquest programa presenta la classe Article.java per al projecte App Llista de la compra

public class Article {
    private String nom;
    private Categoria categoria;

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
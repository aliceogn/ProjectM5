public class Item {
    private int quantitat;
    private Article article;

    public Item(int quantitat, Article article) {
        setQuantitat(quantitat);
        setArticle(article);
    }
    public int getQuantitat(){
        return this.quantitat;
    }
    public void setQuantitat(int quantitat){
        if(quantitat>0){
            this.quantitat = quantitat;
        }
    }
    public Article getArticle() { return this.article; }
    public void setArticle(Article article) {
        this.article = article;
    }
}
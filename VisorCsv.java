public class VisorCsv  implements Visor{
    public String mostra(Llista llista) {
        String message = "";
        Item[] items = llista.getItems();
        for (Item item: items) {
            Article article = item.getArticle();
            message += article.getNom() + ", " + article.getCategoria().getNom() + ", " + Integer.toString(item.getQuantitat())  + "\n";
        }
        return message;
    } 
    public String mostra(Llista llista, Categoria categoria) {
        String message = "";
        Item[] items = llista.getItems();
        for (Item item: items) {
            Article article = item.getArticle();
            if (article.getCategoria() == categoria) {
                message += article.getNom() + ", " + article.getCategoria().getNom() + ", " + Integer.toString(item.getQuantitat())  + "\n";
            }
        }
        return message;
    }
}

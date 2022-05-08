public class VisorJson implements Visor {
    public String mostra(Llista llista) {
        String message = "[\n";
        Item[] items = llista.getItems();
        for (Item item: items) {
            Article article = item.getArticle();
            message += "\t{" + "\n\t\"article\": " + "\""+ article.getNom() + "\",\n" + "\t\"categoria\": " + "\""+ article.getCategoria().getNom() + "\"," + "\n\t\"quantitat\": " + Integer.toString(item.getQuantitat())  + "\n\t}\n";
        }
        message += "]\n";
        return message;
    } 
    public String mostra(Llista llista, Categoria categoria) {
        String message = "";
        Item[] items = llista.getItems();
        for (Item item: items) {
            Article article = item.getArticle();
            if (article.getCategoria() == categoria) {
                message += "[\n" + "\t{" + "\n\t\" article \": " + "\""+ article.getNom() + "\",\n" + "\t\" categoria \": " + "\""+ article.getCategoria().getNom() + "\"," + "\n\t" + Integer.toString(item.getQuantitat())  + "\t}\n" + "]";
            }
        }
        return message;
    }
}

import java.util.Arrays;

public class Llista {
    private Item[] items;
    private static Llista instancia;

    private Llista() { 
        items = new Item[0];
    }
    public static Llista getInstance() {
        if (instancia == null) {
            instancia = new Llista();
        }
        return instancia;
    }
    public Item[] getItems() { return items; }
    public void addItem(Item item) {  
        items = Arrays.copyOf(items, items.length + 1 );   
        items[items.length - 1] = item;   
    }
    public void removeItem(Item item) {
        Item[] newArray = new Item[items.length - 1];

        for (int i = 0; i < items.length; i++) {
            if (
                !items[i].getArticle().getNom().equals(item.getArticle().getNom()) ||
                items[i].getQuantitat() != item.getQuantitat()
            ) { 
                int j = 0;
                newArray[j] = items[i];
                j++;
            }
        }
        items = newArray;
    }
   
}

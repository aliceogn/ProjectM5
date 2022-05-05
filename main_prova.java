public class main_prova {
    public static void main(String[] args) {
        Llista llista = Llista.getInstance();
        Categoria begudes = new Categoria("begudes");
        Article article = new Article("cocacola", begudes);
        Item beguda = new Item(2, article);
        llista.addItem(beguda);

        Article articuno = new Article("tomaquet", "verdures");
        Item tomaquet = new Item(3, articuno);
        llista.addItem(tomaquet);
        Visor visor = new VisorTxt();
        System.out.print(visor.mostra(llista));
        System.out.print(visor.mostra(llista, begudes));
    }
}

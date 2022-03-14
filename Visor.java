// Aquesta inferfície presenta les capçaleres de les funcions que cada tipus de visor haurà d'implementar

public interface Visor {
    public String mostra(Llista llista);
    public String mostra(Llista llista, Categoria categoria);
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Entrada {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Llegeix una línia de l'entrada estàndard i la retorna en forma de
     * String
     *
     * Converteix IOException en RuntimeException per evitar que sigui
     * obligatòri gestionar-la i així simplificar l'accés al llenguatge a
     * estudiants nous
     */
    public static String readLine() throws RuntimeException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FilaDePecas {

    private final Queue<FormatoMatriz> fila = new LinkedList<>();
    private final FormatoMatriz[] pecasDisponiveis;
    private static Random random = new Random();

    public FilaDePecas(FormatoMatriz[] pecasDisponiveis) {
        this.pecasDisponiveis = pecasDisponiveis;
        for (int i = 0; i < 4; i++) {
            addElementoAleatorio();
        }
    }



    public FormatoMatriz getPrimeiraPeca () {
        addElementoAleatorio();
        return fila.poll();
    }

    public Queue<FormatoMatriz> getPecas() {
        return fila;
    }

    private void addElementoAleatorio() {
        fila.add(pecasDisponiveis[random.nextInt(pecasDisponiveis.length)]);
    }
}

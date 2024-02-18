import java.util.*;

public class FilaDePecas {

    private final Queue<FormatoMatriz> fila = new LinkedList<>();
    private final Peca[] pecasDisponiveis;
    private static Random random = new Random();


    public FilaDePecas(Peca[] pecasDisponiveis) {
        this.pecasDisponiveis = pecasDisponiveis;



    }

    public void preencherFila(int tamanhoDaFila) {
        for (int i = 0; i < tamanhoDaFila; i++) {
            addElementoAleatorio();
        }
    }


    public FormatoMatriz getPrimeiraPeca() {
        addElementoAleatorio();
        return fila.poll();
    }

    public List<FormatoMatriz> getPecas() {
        return fila.stream().toList();
    }

    private void addElementoAleatorio() {

        try {
            fila.add((Peca) pecasDisponiveis[random.nextInt(pecasDisponiveis.length)].clone());

        } catch (Exception e) {

        }

    }


}

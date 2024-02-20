import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

       // FilaDePecas filaDePecas = new FilaDePecas(new Peca[]{new PecaMaluca(), new I(), new L()});
        FilaDePecas filaDePecas = new FilaDePecas(Peca.todasAsPecas);

        CampoDoJogo campoDoJogo = new CampoDoJogo(new Dimension(10, 20), filaDePecas);
        campoDoJogo.loopGame();




    }


}
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class CampoDoJogo implements KeyListener {

    private final ArrayList<ArrayList<Espaco>> gridGame = new ArrayList();
    private Point[][] posicaoPecaNaMatrizPrincipal;
    private Point[][] posicaoFuturaNaMatrizPrincipal;
    private ArrayList<ArrayList<Espaco>> copiaDoGridPrincipal;
    private boolean pecaFixa = false;
    private FormatoMatriz pecaGuardada;
    private FormatoMatriz pecaAtual;
    private boolean trocaDisponivel = true;
    private boolean asd;
    private FilaDePecas pecasDisponiveisNoJogo;
    private Espaco[][] espacoPecaGuardada;
    private Espaco[][] espacoPecasFuturas;


    public CampoDoJogo(Dimension tamanhoDoCampo, FilaDePecas pecasDisponiveisNoJogo) {
        this.pecasDisponiveisNoJogo = pecasDisponiveisNoJogo;
        tamanhoDoCampo.width *= 2;
        tamanhoDoCampo.height *= 2;
        preencherCampo(tamanhoDoCampo);
        preencherEspacoPecaGuardada(tamanhoDoCampo.height);
        preencherEspacoPecasFuturas(tamanhoDoCampo.height);

        int tamanhoMaximoDasPecasEmpilhadas = 0;
        for (; tamanhoDoCampo.height >= tamanhoMaximoDasPecasEmpilhadas + 10; tamanhoMaximoDasPecasEmpilhadas += 10);
        pecasDisponiveisNoJogo.preencherFila(tamanhoMaximoDasPecasEmpilhadas / 10);


    }

    public void preencherEspacoPecasFuturas(int height) {

        espacoPecasFuturas = new Espaco[height][11];

        for (int i = 0; i < espacoPecasFuturas.length; i++) {
            for (int j = 0; j < espacoPecasFuturas[0].length; j++) {

                espacoPecasFuturas[i][j] = new Espaco(Espaco.ESPACO_LADO_ESQUERDO);

            }

        }
    }

    public void preencherEspacoPecaGuardada(int height) {

        espacoPecaGuardada = new Espaco[height][11];

        for (int i = 0; i < espacoPecaGuardada.length; i++) {
            for (int j = 0; j < espacoPecaGuardada[0].length; j++) {

                espacoPecaGuardada[i][j] = new Espaco(Espaco.ESPACO_LADO_ESQUERDO);

            }

        }

    }

    public void preencherCampo(Dimension tamanhoDoCampo) {

        for (int i = 0; i < tamanhoDoCampo.height; i++) {

            ArrayList<Espaco> lista = new ArrayList<>();

            for (int j = 0; j < tamanhoDoCampo.width; j++) {
                lista.add(new Espaco(Espaco.ESPACO_VAZIO));
            }

            gridGame.add(lista);
        }

    }

    private boolean fimDeJogo() {
        for (int j = 0; j < gridGame.get(0).size(); j += 2) {
            if (!gridGame.get(3).get(j).getTipo().equals(Espaco.ESPACO_VAZIO)) {
                System.out.println("FIM DE JOGO");
                System.exit(0);
                return true;
            }

        }

        return false;
    }

    public void loopGame() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(-200, 0, 0, 0);
        frame.addKeyListener(this);
        frame.setVisible(true);

        while (!fimDeJogo()) {


            adicionarPeca(pecasDisponiveisNoJogo.getPrimeiraPeca());
            atualizarPecasFuturas();

            Thread gravidade = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!colisao(0, +1) && !pecaFixa) {
                        moverPara(0, +2);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            gravidade.start();


            try {
                gravidade.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!pecaFixa)
                fixarPeca();


        }
    }

    private void atualizarPecasFuturas() {

        List<FormatoMatriz> pecasFuturas = pecasDisponiveisNoJogo.getPecas();

        for (int i = 0; i < espacoPecasFuturas.length; i++) {
            for (int j = 0; j < espacoPecasFuturas[0].length; j++) {
                espacoPecasFuturas[i][j].setTipo(Espaco.ESPACO_LADO_ESQUERDO);
            }
        }


        for (int i = 1, iPeca = 0; i < espacoPecasFuturas.length && iPeca < pecasFuturas.size(); i += pecasFuturas.get(iPeca).getFormatoMatriz().length + 2, iPeca++) {

            String[][] formatoPecaAtual = pecasFuturas.get(iPeca).getFormatoMatriz();
            for (int j = 0; j < formatoPecaAtual.length; j++) {
                for (int k = 0; k < formatoPecaAtual[0].length; k++) {
                    if (formatoPecaAtual[j][k] != null) {

                        espacoPecasFuturas[i + j][k + 1].setTipo(formatoPecaAtual[j][k]);

                    }


                }

            }


        }
    }

    public void adicionarPeca(FormatoMatriz formatoMatriz) {

        String[][] formatoDaPeca = formatoMatriz.getFormatoMatriz();
        copiaDoGridPrincipal = clonarGridPrincipal();
        posicaoPecaNaMatrizPrincipal = new Point[formatoDaPeca.length][formatoDaPeca[0].length];
        pecaAtual = formatoMatriz;


        for (int i = 0; i < formatoDaPeca.length; i++) {
            for (int j = 0; j < formatoDaPeca[0].length; j++) {

                if (formatoDaPeca[i][j] != null) {

                    int centroX = (copiaDoGridPrincipal.get(0).size() / 2) + j - 2;

                    copiaDoGridPrincipal.get(i).get(centroX).setTipo(formatoDaPeca[i][j]);
                    posicaoPecaNaMatrizPrincipal[i][j] = new Point(centroX, i);
                }


            }

        }

        imprimirGame(copiaDoGridPrincipal);
        pecaFixa = false;

    }

    public void retirarPosicaoFuturaVisao() {

        if (posicaoFuturaNaMatrizPrincipal != null)
            for (int i = 0; i < posicaoFuturaNaMatrizPrincipal.length; i++) {
                for (int j = 0; j < posicaoFuturaNaMatrizPrincipal[0].length; j++) {
                    if (posicaoFuturaNaMatrizPrincipal[i][j] != null)
                        if (copiaDoGridPrincipal.get(posicaoFuturaNaMatrizPrincipal[i][j].y).get(posicaoFuturaNaMatrizPrincipal[i][j].x).getTipo().equals(Espaco.POSICAO_FUTURA))
                            copiaDoGridPrincipal.get(posicaoFuturaNaMatrizPrincipal[i][j].y).get(posicaoFuturaNaMatrizPrincipal[i][j].x).setTipo(Espaco.ESPACO_VAZIO);

                }

            }
    }

    public void guardarPeca() {
        if (trocaDisponivel) {
            trocaDisponivel = false;
            FormatoMatriz formatoMatriz = pecaAtual;
            if (pecaGuardada != null) {
                adicionarPeca(pecaGuardada);


            } else {
                adicionarPeca(pecasDisponiveisNoJogo.getPrimeiraPeca());
            }


            pecaGuardada = formatoMatriz;

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < espacoPecaGuardada[0].length; j++) {
                    espacoPecaGuardada[i][j].setTipo(Espaco.ESPACO_LADO_ESQUERDO);
                }
            }

            for (int i = 0; i < pecaGuardada.getFormatoMatriz().length; i++) {
                for (int j = 0; j < pecaGuardada.getFormatoMatriz()[0].length; j++) {
                    if (pecaGuardada.getFormatoMatriz()[i][j] != null)
                        espacoPecaGuardada[i + 1][j + 1].setTipo(pecaGuardada.getFormatoMatriz()[i][j]);
                }

            }

        }

        moverPara(0, 0);


    }

    public void posicaoFuturaPreVisao() {


        int preVisualizacaoAltura = 1;

        posicaoFuturaNaMatrizPrincipal = new Point[posicaoPecaNaMatrizPrincipal.length][posicaoPecaNaMatrizPrincipal[0].length];

        while (!colisao(0, preVisualizacaoAltura)) {
            preVisualizacaoAltura++;
        }

        preVisualizacaoAltura--;


        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {
                if (posicaoPecaNaMatrizPrincipal[i][j] != null) {

                    posicaoFuturaNaMatrizPrincipal[i][j] = new Point(posicaoPecaNaMatrizPrincipal[i][j]);
                    posicaoFuturaNaMatrizPrincipal[i][j].y += preVisualizacaoAltura;
                    if (copiaDoGridPrincipal.get(posicaoFuturaNaMatrizPrincipal[i][j].y).get(posicaoFuturaNaMatrizPrincipal[i][j].x).getTipo().equals(Espaco.ESPACO_VAZIO))
                        copiaDoGridPrincipal.get(posicaoFuturaNaMatrizPrincipal[i][j].y).get(posicaoFuturaNaMatrizPrincipal[i][j].x).setTipo(Espaco.POSICAO_FUTURA);

                }

            }
        }


        imprimirGame(copiaDoGridPrincipal);

    }

    public void moverPara(int direcaoX, int direcaoY) {

        retirarPosicaoFuturaVisao();

        boolean reversoX = direcaoX > 0;
        boolean reversoY = direcaoY > 0;

        for (int i = reversoY ? posicaoPecaNaMatrizPrincipal.length - 1 : 0;
             reversoY ? i >= 0 : i < posicaoPecaNaMatrizPrincipal.length; i += reversoY ? -1 : 1) {
            for (int j = reversoX ? posicaoPecaNaMatrizPrincipal[0].length - 1 : 0;
                 reversoX ? j >= 0 : j < posicaoPecaNaMatrizPrincipal[0].length; j += reversoX ? -1 : 1) {
                if (posicaoPecaNaMatrizPrincipal[i][j] != null) {

                    String tipo = copiaDoGridPrincipal.get(posicaoPecaNaMatrizPrincipal[i][j].y).get(posicaoPecaNaMatrizPrincipal[i][j].x).getTipo();

                    int y = posicaoPecaNaMatrizPrincipal[i][j].y;
                    int x = posicaoPecaNaMatrizPrincipal[i][j].x;

                    copiaDoGridPrincipal.get(y).get(x).setTipo(Espaco.ESPACO_VAZIO);
                    copiaDoGridPrincipal.get(y + direcaoY).get(x + direcaoX).setTipo(tipo);
                    posicaoPecaNaMatrizPrincipal[i][j].y += direcaoY;
                    posicaoPecaNaMatrizPrincipal[i][j].x += direcaoX;


                }

            }


        }

        posicaoFuturaPreVisao();
        imprimirGame(copiaDoGridPrincipal);


    }


    public boolean colisao(int direcaoX, int direcaoY) {


        for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {

            for (int i = posicaoPecaNaMatrizPrincipal.length - 1; i > 0; i -= 2) {

                if (posicaoPecaNaMatrizPrincipal[i][j] != null) {

                    try {

                        Espaco espacoFuturo = gridGame.get(posicaoPecaNaMatrizPrincipal[i][j].y + direcaoY).get(posicaoPecaNaMatrizPrincipal[i][j].x + direcaoX);


                        if (!(espacoFuturo.getTipo().equals(Espaco.ESPACO_VAZIO)))

                            return true;


                    } catch (IndexOutOfBoundsException e) {


                        return true;

                    }


                }

            }

        }


        return false;
    }

    public void imprimirGame(ArrayList<ArrayList<Espaco>> copia) {



        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < espacoPecaGuardada[0].length; j++) {
                System.out.print("   ");

            }
            for (int j = 0; j < gridGame.get(0).size(); j++) {
                System.out.print(Espaco.ESPACO_VAZIO);

            }
            System.out.println();
        }


        for (int i = 0; i < gridGame.size(); i++) {
            for (int j = 0; j < espacoPecaGuardada[0].length; j++) {
                System.out.print(espacoPecaGuardada[i][j]);

            }

            for (int j = 0; j < gridGame.get(0).size(); j++) {
                System.out.print(copia.get(i).get(j));
            }

            for (int j = 0; j < espacoPecasFuturas[0].length; j++) {
                System.out.print(espacoPecasFuturas[i][j]);
            }

            System.out.println();

        }


    }



    private ArrayList<ArrayList<Espaco>> clonarGridPrincipal() {
        ArrayList<ArrayList<Espaco>> copia = new ArrayList<>();

        for (ArrayList<Espaco> sublistaOriginal : gridGame) {
            ArrayList<Espaco> sublistaClonada = new ArrayList<>();

            for (Espaco espacoOriginal : sublistaOriginal) {
                Espaco espacoClonado = new Espaco(espacoOriginal.getTipo());
                sublistaClonada.add(espacoClonado);
            }

            copia.add(sublistaClonada);
        }

        return copia;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (!colisao(+1, 0))
                    moverPara(+2, 0);
                break;
            case KeyEvent.VK_LEFT:
                if (!colisao(-1, 0))
                    moverPara(-2, 0);
                break;
            case KeyEvent.VK_DOWN:
                if (!colisao(0, +1))
                    moverPara(0, +2);
                break;
            case KeyEvent.VK_SPACE:
                fixarPeca();
                break;
            case KeyEvent.VK_UP:
                asd = true;
                girarPecaHorario();
                break;
            case KeyEvent.VK_CONTROL:
                asd = true;

                girarPecaAntiHorario();
                break;
            case KeyEvent.VK_SHIFT:
                Thread adicionarPeca = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        guardarPeca();
                    }
                });
                adicionarPeca.start();

                break;
        }


    }

    boolean colisaoNaRotacao(Point[][] posicaoPecaRotacionada) {


        for (int i = 0; i < posicaoPecaRotacionada.length; i++) {
            for (int j = 0; j < posicaoPecaRotacionada[0].length; j++) {

                if (posicaoPecaRotacionada[i][j] != null) {
                    if (!gridGame.get(posicaoPecaRotacionada[i][j].y).get(posicaoPecaRotacionada[i][j].x).getTipo().equals(Espaco.ESPACO_VAZIO)) {
                        return true;
                    }
                }


            }
        }


        return false;
    }

    void atualizarPecaRotacionada(Point[][] posicaoPecaRotacionada, String[][] pecaAtualRotacionada) {
        pecaAtual.setFormatoMatriz(pecaAtualRotacionada);
        posicaoPecaNaMatrizPrincipal = posicaoPecaRotacionada;
        copiaDoGridPrincipal = clonarGridPrincipal();

        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {


                if (posicaoPecaNaMatrizPrincipal[i][j] != null) {
                    copiaDoGridPrincipal.get(posicaoPecaNaMatrizPrincipal[i][j].y).get(posicaoPecaNaMatrizPrincipal[i][j].x).setTipo(pecaAtual.getFormatoMatriz()[i][j]);

                }


            }
        }

        moverPara(0, 0);
    }

    //refatorar depois as funcoes de rotacao

    void girarPecaHorario() {


        Point[][] posicaoPecaRotacionada = new Point[posicaoPecaNaMatrizPrincipal.length][posicaoPecaNaMatrizPrincipal[0].length];
        String[][] pecaAtualRotacionada = new String[pecaAtual.getFormatoMatriz().length][pecaAtual.getFormatoMatriz()[0].length];


        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {

                int ajuste = posicaoPecaNaMatrizPrincipal[0].length - 1 - i;


                if (posicaoPecaNaMatrizPrincipal[i][j] != null) {

                    posicaoPecaRotacionada[j][ajuste] = new Point(posicaoPecaNaMatrizPrincipal[i][j].x, posicaoPecaNaMatrizPrincipal[i][j].y);
                    posicaoPecaRotacionada[j][ajuste].y += j - i;
                    posicaoPecaRotacionada[j][ajuste].x += (ajuste) - j;
                    pecaAtualRotacionada[j][ajuste] = pecaAtual.getFormatoMatriz()[i][j];


                } else {
                    posicaoPecaRotacionada[j][ajuste] = null;
                    pecaAtualRotacionada[j][ajuste] = null;
                }


            }
        }


        try {
            if (!colisaoNaRotacao(posicaoPecaRotacionada))
                atualizarPecaRotacionada(posicaoPecaRotacionada, pecaAtualRotacionada);
            else {
                if (asd) {
                    asd = false;
                    moverPara(0, -4);
                    girarPecaHorario();
                } else {
                    moverPara(0, +4);
                }
            }


        } catch (IndexOutOfBoundsException e) {


            if (ajusteParaRotacionar(posicaoPecaRotacionada)) {
                girarPecaHorario();

            } else {
                moverPara(0, -4);
                if (ajusteParaRotacionar(posicaoPecaRotacionada)) {
                    girarPecaHorario();
                } else {
                    moverPara(0, +4);
                }
            }


        }


    }


    void girarPecaAntiHorario() {


        Point[][] posicaoPecaRotacionada = new Point[posicaoPecaNaMatrizPrincipal.length][posicaoPecaNaMatrizPrincipal[0].length];
        String[][] pecaAtualRotacionada = new String[pecaAtual.getFormatoMatriz().length][pecaAtual.getFormatoMatriz()[0].length];

        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {

                int ajuste = posicaoPecaNaMatrizPrincipal[0].length - 1 - i;

                if (posicaoPecaNaMatrizPrincipal[j][ajuste] != null) {
                    posicaoPecaRotacionada[i][j] = new Point(posicaoPecaNaMatrizPrincipal[j][ajuste].x, posicaoPecaNaMatrizPrincipal[j][ajuste].y);
                    posicaoPecaRotacionada[i][j].y -= j - i;
                    posicaoPecaRotacionada[i][j].x -= (ajuste) - j;
                    pecaAtualRotacionada[i][j] = pecaAtual.getFormatoMatriz()[j][ajuste];
                } else {
                    pecaAtualRotacionada[i][j] = null;
                    pecaAtualRotacionada[i][j] = null;
                }

            }
        }

        try {
            if (!colisaoNaRotacao(posicaoPecaRotacionada))
                atualizarPecaRotacionada(posicaoPecaRotacionada, pecaAtualRotacionada);
            else {
                if (asd) {
                    asd = false;
                    moverPara(0, -4);
                    girarPecaAntiHorario();
                } else {
                    moverPara(0, +4);
                }
            }


        } catch (IndexOutOfBoundsException e) {


            if (ajusteParaRotacionar(posicaoPecaRotacionada)) {
                girarPecaAntiHorario();

            } else {
                moverPara(0, -4);
                if (ajusteParaRotacionar(posicaoPecaRotacionada)) {
                    girarPecaAntiHorario();
                } else {
                    moverPara(0, +4);
                }
            }


        }

    }

    boolean ajusteParaRotacionar(Point[][] posicaoPecaRotacionada) {
        for (int i = 0; i < posicaoPecaRotacionada.length; i++) {
            for (int j = 0; j < posicaoPecaRotacionada[0].length; j++) {
                if (posicaoPecaRotacionada[i][j] != null) {
                    if (posicaoPecaRotacionada[i][j].x < 0) {
                        if (!colisao(+1, 0)) {
                            moverPara(+2, 0);
                            return true;
                        }


                    } else if (posicaoPecaRotacionada[i][j].x >= gridGame.get(0).size()) {

                        if (!colisao(-1, 0)) {
                            moverPara(-2, 0);
                            return true;
                        }


                    } else if (posicaoPecaRotacionada[i][j].y >= gridGame.size()) {

                        if (!colisao(0, -1)) {
                            moverPara(0, -2);
                            return true;
                        }


                    }
                }

            }
        }

        return false;
    }

    private void fixarPeca() {


        for (int i = 0; i < posicaoFuturaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoFuturaNaMatrizPrincipal[0].length; j++) {
                try {
                    if (posicaoFuturaNaMatrizPrincipal[i][j] != null)
                        gridGame.get(posicaoFuturaNaMatrizPrincipal[i][j].y).get(posicaoFuturaNaMatrizPrincipal[i][j].x).setTipo(pecaAtual.getFormatoMatriz()[i][j]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("FIM DE JOGO");
                    System.exit(0);
                }


            }
        }

        quebrarLinhas();
        adicionarPeca(pecasDisponiveisNoJogo.getPrimeiraPeca());
        atualizarPecasFuturas();
        posicaoFuturaPreVisao();
        trocaDisponivel = true;


    }

    private void quebrarLinhas() {

        for (int i = gridGame.size() - 1; i >= 2; ) {

            if (linhaQuebrada(i)) {
                for (int k = i; k >= 2; k -= 2) {
                    for (int j = 0; j < gridGame.get(0).size(); j++) {
                        gridGame.get(k).get(j).setTipo(gridGame.get(k - 2).get(j).getTipo());
                        gridGame.get(k - 1).get(j).setTipo(gridGame.get(k - 3).get(j).getTipo());

                    }
                }
            } else {
                i -= 2;
            }


        }


    }

    private boolean linhaQuebrada(int indice) {

        for (int j = 0; j < gridGame.get(0).size(); j++) {
            if (gridGame.get(indice).get(j).getTipo().equals(Espaco.ESPACO_VAZIO))
                return false;
        }

        return true;


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}

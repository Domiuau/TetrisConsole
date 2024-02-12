import java.awt.*;


public class Testes {

    public static void main(String[] args) {
        FilaDePecas filaDePecas = new FilaDePecas(Peca.todasAsPecas);
        Point point[][] = {{new Point(19, 20), new Point(20, 20), new Point(21, 20)},
                {new Point(19, 21), new Point(20, 21), new Point(21, 21)},
                {null, null, null}};
        imprimirMatriz(point);
        System.out.println();
        girarPecaHorario( point);



    }


    static void girarPecaHorario(Point[][] posicaoPecaNaMatrizPrincipal) {


        Point[][] copiaMatriz = new Point[posicaoPecaNaMatrizPrincipal.length][posicaoPecaNaMatrizPrincipal[0].length];

        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {

                int ajuste = posicaoPecaNaMatrizPrincipal[0].length - 1 - i;


                    copiaMatriz[j][ajuste] = posicaoPecaNaMatrizPrincipal[i][j];

                    if (posicaoPecaNaMatrizPrincipal[i][j] != null) {
                        copiaMatriz[j][ajuste].y += j - i;
                        copiaMatriz[j][ajuste].x += (ajuste) - j;
                    }

            }
        }

        imprimirMatriz(copiaMatriz);
    }

    static void girarPecaAntiHorario(Point[][] posicaoPecaNaMatrizPrincipal) {


        Point[][] copiaMatriz = new Point[posicaoPecaNaMatrizPrincipal.length][posicaoPecaNaMatrizPrincipal[0].length];

        for (int i = 0; i < posicaoPecaNaMatrizPrincipal.length; i++) {
            for (int j = 0; j < posicaoPecaNaMatrizPrincipal[0].length; j++) {

                int ajuste = posicaoPecaNaMatrizPrincipal[0].length - 1 - i;
                copiaMatriz[i][j] = posicaoPecaNaMatrizPrincipal[j][ajuste];

                if (posicaoPecaNaMatrizPrincipal[j][ajuste] != null) {
                    copiaMatriz[i][j].y -= j - i;
                    copiaMatriz[i][j].x -= (ajuste) - j;
                }

            }
        }

        imprimirMatriz(copiaMatriz);
    }


    public static void imprimirMatriz(Object[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                //  if (matriz[i][j] != null)

                System.out.print(matriz[i][j] + " ");

            }
            System.out.println();
        }
    }
}

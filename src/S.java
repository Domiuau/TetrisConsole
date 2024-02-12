public class S extends Peca {

    private String[][] formatoPecaS = {{null, null, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S},
            {null, null, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S},
            {Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, null, null},
            {Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, Espaco.COR_S, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null}
    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaS;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaS = novoFormato;
    }

}
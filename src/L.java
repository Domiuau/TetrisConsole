public class L extends Peca {

    private String[][] formatoPecaL = {
            {null, null, Espaco.COR_L, Espaco.COR_L, null, null},
            {null, null, Espaco.COR_L, Espaco.COR_L, null, null},
            {null, null, Espaco.COR_L, Espaco.COR_L, null, null},
            {null, null, Espaco.COR_L, Espaco.COR_L, null, null},
            {null, null, Espaco.COR_L, Espaco.COR_L, Espaco.COR_L, Espaco.COR_L},
            {null, null, Espaco.COR_L, Espaco.COR_L, Espaco.COR_L, Espaco.COR_L}


    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaL;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaL = novoFormato;
    }

}

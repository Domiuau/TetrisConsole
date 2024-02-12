public class I extends Peca {

    private String[][] formatoPecaI = {
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null},
            {null, null, Espaco.COR_I, Espaco.COR_I, null, null, null, null}

    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaI;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaI = novoFormato;
    }


}


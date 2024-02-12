public class J extends Peca {

    private String[][] formatoPecaJ = {{null, null, Espaco.COR_J, Espaco.COR_J, null, null},
            {null, null, Espaco.COR_J, Espaco.COR_J, null, null},
            {null, null, Espaco.COR_J, Espaco.COR_J, null, null},
            {null, null, Espaco.COR_J, Espaco.COR_J, null, null},
            {Espaco.COR_J, Espaco.COR_J, Espaco.COR_Z, Espaco.COR_T, null, null},
            {Espaco.COR_J, Espaco.COR_J, Espaco.COR_I, Espaco.COR_Z, null, null}


    };

    @Override
    public String[][] getFormatoMatriz() {
        return formatoPecaJ;
    }
    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaJ = novoFormato;
    }

}

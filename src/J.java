public class J extends Peca {

    private String[][] formatoPecaJ = {{null, null, null, null, Espaco.COR_J, Espaco.COR_J},
            {null, null, null, null, Espaco.COR_J, Espaco.COR_J},
            {null, null, null, null, Espaco.COR_J, Espaco.COR_J},
            {null, null, null, null, Espaco.COR_J, Espaco.COR_J},
            {null, null, Espaco.COR_J, Espaco.COR_J, Espaco.COR_J, Espaco.COR_J},
            {null, null, Espaco.COR_J, Espaco.COR_J, Espaco.COR_J, Espaco.COR_J}


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

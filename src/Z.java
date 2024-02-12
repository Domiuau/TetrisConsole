public class Z extends Peca {

    private String[][] formatoPecaZ = {{Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, null, null},
            {Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, null, null},
            {null, null, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z},
            {null, null, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z, Espaco.COR_Z},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},

    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaZ;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaZ = novoFormato;
    }


}

public class T extends Peca {

    private String[][] formatoPecaT = {{null, null, Espaco.COR_T, Espaco.COR_T, null, null},
                                       {null, null, Espaco.COR_T, Espaco.COR_T, null, null},
            {Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T},
            {Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T, Espaco.COR_T},
            {null,null,null,null,null,null},
            {null,null,null,null,null,null}
    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaT;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaT = novoFormato;
    }


}

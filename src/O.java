public class O extends Peca {


    private String[][] formatoPecaO = {{Espaco.COR_O, Espaco.COR_O, Espaco.COR_O, Espaco.COR_O},
            {Espaco.COR_O, Espaco.COR_O, Espaco.COR_O, Espaco.COR_O},
            {Espaco.COR_O, Espaco.COR_O, Espaco.COR_O, Espaco.COR_O},
            {Espaco.COR_O, Espaco.COR_O, Espaco.COR_O, Espaco.COR_O}


    };

    @Override
    public String[][] getFormatoMatriz() {

        return formatoPecaO;


    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaO = novoFormato;
    }

}

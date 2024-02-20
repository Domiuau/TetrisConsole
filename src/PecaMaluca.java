public class PecaMaluca extends Peca {

    private String[][] formatoPecaMaluca = {
            {null, null, Espaco.COR_S, Espaco.COR_J, null, null, Espaco.COR_I, Espaco.COR_O},
            {null, null, Espaco.COR_Z, Espaco.COR_T, null, null, Espaco.COR_L, Espaco.COR_T},
            {Espaco.COR_S, Espaco.COR_Z, null, null, Espaco.COR_T, Espaco.COR_S, null, null,},
            {Espaco.COR_T, Espaco.COR_O, null, null, Espaco.COR_O, Espaco.COR_J, null, null,},
            {Espaco.COR_Z, Espaco.COR_L, null, null, Espaco.COR_T, Espaco.COR_I, null, null,},
            {Espaco.COR_I, Espaco.COR_Z, null, null, Espaco.COR_O, Espaco.COR_J, null, null,},
            {null, null, Espaco.COR_L, Espaco.COR_J, null, null, Espaco.COR_T, Espaco.COR_S},
            {null, null, Espaco.COR_J, Espaco.COR_I, null, null, Espaco.COR_Z, Espaco.COR_S},


    };

//    private String[][] formatoExemplo = {
//            {null, null,   null, null,   null, null,   null, null},
//            {null, null,   null, null,   null, null,   null, null},
//
//            {null, null,   null, null,   null, null,   null, null},
//            {null, null,   null, null,   null, null,   null, null},
//
//            {null, null,   null, null,   null, null,   null, null},
//            {null, null,   null, null,   null, null,   null, null},
//
//            {null, null,   null, null,   null, null,   null, null},
//            {null, null,   null, null,   null, null,   null, null},
//
//
//    };


    @Override
    public String[][] getFormatoMatriz() {
        return formatoPecaMaluca;
    }

    @Override
    public void setFormatoMatriz(String[][] novoFormato) {
        this.formatoPecaMaluca = novoFormato;
    }
}

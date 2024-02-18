public class Espaco {

    public static final String ESPACO_VAZIO = "\u001B[40m . " + "\u001B[0m";
    public static final String COR_T = "\u001B[45m   " + "\u001B[0m";
    public static final String COR_L = "\u001B[43m   " + "\u001B[0m";
    public static final String COR_J = "\u001B[44m   " + "\u001B[0m";
    public static final String COR_O = "\u001B[103m   " + "\u001B[0m";
    public static final String COR_S = "\u001B[102m   " + "\u001B[0m";
    public static final String COR_Z = "\u001B[101m   " + "\u001B[0m";
    public static final String COR_I = "\u001B[106m   " + "\u001B[0m";
    public static final String POSICAO_FUTURA = "\u001B[47m   " + "\u001B[0m";
    public static final String ESPACO_LADO_ESQUERDO = "\u001B[108m   " + "\u001B[0m";


    private String tipo;




    @Override
    public String toString() {
        return tipo;
    }

    public Espaco() {
    }

    public Espaco(String tipo) {
        this.tipo = tipo;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

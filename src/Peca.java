public abstract class Peca implements FormatoMatriz, Cloneable {

    public static final Peca[] todasAsPecas = {new I(), new J(), new L(), new O(), new S(), new T(), new Z()};


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

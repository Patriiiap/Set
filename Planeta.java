package CuerposCelestes;

public class Planeta extends CuerpoCeleste{

    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste cuerpoCeleste) {

        if (cuerpoCeleste.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return super.addSatelite(cuerpoCeleste);
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

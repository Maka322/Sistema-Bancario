package banco;

public class ParametrosCorriente {
    double comisionPorTransaccion;
    double limiteSobregiro;

    public ParametrosCorriente(double comisionPorTransaccion, double limiteSobregiro) {
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobregiro = limiteSobregiro;
    }
}

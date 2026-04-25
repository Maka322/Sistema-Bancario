package banco;

public class ParametrosInversion {
    double tasaAnual;
    int plazoMeses;
    double penalizacion;

    public ParametrosInversion(double tasaAnual, int plazoMeses, double penalizacion) {
        this.tasaAnual = tasaAnual;
        this.plazoMeses = plazoMeses;
        this.penalizacion = penalizacion;
    }
}

package banco;

import java.text.DecimalFormat;

public class CuentaInversion extends CuentaBancaria {
    private double tasaAnual;
    private int plazoMeses;
    private double penalizacionRetiroAnticipado;

    public CuentaInversion(String numeroCuenta, String titular, double saldo, ParametrosInversion params) {
        super(numeroCuenta, titular, saldo);
        this.tasaAnual = params.tasaAnual;
        this.plazoMeses = params.plazoMeses;
        this.penalizacionRetiroAnticipado = params.penalizacion;
    }

    @Override
    public String describir() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Cuenta: " + getNumeroCuenta() + "\n" +
                "Titular: " + getTitular() + "\n" +
                "Saldo: $" + df.format(getSaldo()) + "\n" +
                "Plazo: " + plazoMeses + " meses\n" +
                "Tasa anual: " + tasaAnual + "%";
    }

    @Override
    public double calcularComision() {
        return penalizacionRetiroAnticipado;
    }

    @Override
    public void realizarRetiro(double monto) {
        super.realizarRetiro(monto);
        setSaldo(getSaldo() - penalizacionRetiroAnticipado);
    }
}


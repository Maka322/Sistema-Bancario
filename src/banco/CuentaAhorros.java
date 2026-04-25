package banco;

import java.text.DecimalFormat;

public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, ParametrosAhorros params) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = params.tasaInteresMensual;
        this.saldoMinimo = params.saldoMinimo;
    }

    @Override
    public String describir() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Cuenta: " + getNumeroCuenta() + "\n" +
                "Titular: " + getTitular() + "\n" +
                "Saldo: $" + df.format(getSaldo()) + "\n" +
                "Tasa mensual: " + tasaInteresMensual + "%";
    }

    @Override
    public double calcularComision() {
        return getSaldo() < saldoMinimo ? 12000.0 : 0.0;
    }

    @Override
    public void realizarRetiro(double monto) {
        super.realizarRetiro(monto);
        if (getSaldo() < saldoMinimo) {
            setSaldo(getSaldo() - 12000.0);
        }
    }
}


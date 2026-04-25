package banco;

import java.text.DecimalFormat;

public class CuentaCorriente extends CuentaBancaria {
    private double comisionPorTransaccion;
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, ParametrosCorriente params) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = params.comisionPorTransaccion;
        this.limiteSobregiro = params.limiteSobregiro;
    }

    @Override
    public String describir() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Cuenta: " + getNumeroCuenta() + "\n" +
                "Titular: " + getTitular() + "\n" +
                "Saldo: $" + df.format(getSaldo()) + "\n" +
                "Comisión por transacción: $" + df.format(comisionPorTransaccion);
    }

    @Override
    public double calcularComision() {
        return comisionPorTransaccion;
    }

    @Override
    public void realizarRetiro(double monto) {
        double nuevoSaldo = getSaldo() - monto - comisionPorTransaccion;
        if (nuevoSaldo < limiteSobregiro) {
            System.out.println("Retiro no permitido: excede el límite de sobregiro.");
        } else {
            setSaldo(nuevoSaldo);
        }
    }
}


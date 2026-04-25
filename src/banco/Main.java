package banco;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#,###.00");

        CuentaBancaria[] cuentas = {
                new CuentaAhorros("Code1", "Cesar Alvarez", 2000000,
                        new ParametrosAhorros(1.5, 500000)),

                new CuentaCorriente("Code2", "Alpina S.A", 100000000,
                        new ParametrosCorriente(25000, -200000)),

                new CuentaInversion("Code3", "Andrés Ospina", 5000000,
                        new ParametrosInversion(8.0, 12, 100000))
        };

        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta.describir());
            System.out.println("Comisión: $" + df.format(cuenta.calcularComision()));
            cuenta.realizarRetiro(500000);
            System.out.println("Saldo final: $" + df.format(cuenta.getSaldo()));
            System.out.println("----------------------------");
        }
    }
}



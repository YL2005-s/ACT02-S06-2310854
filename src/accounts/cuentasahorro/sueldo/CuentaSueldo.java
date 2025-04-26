package accounts.cuentasahorro.sueldo;

import accounts.core.CuentaAhorro;

public class CuentaSueldo extends CuentaAhorro {

    public CuentaSueldo(double monto) {
        super(monto);
        this.tipo = "Ahorro Sueldo";
        this.tasaInteres = 2.5;
        this.retirosPermitidosATM = 5;
        this.plazoMeses = 0;
    }
}

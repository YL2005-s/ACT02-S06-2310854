package accounts.cuentasahorro.plazo;

import accounts.core.CuentaAhorro;

public class CuentaPlazoFijo extends CuentaAhorro {

    public CuentaPlazoFijo(double monto) {
        super(monto);
        this.tipo = "Plazo Fijo";
        this.tasaInteres = 6.0;
        this.retirosPermitidosATM = 0;
        this.plazoMeses = 6;
    }
}

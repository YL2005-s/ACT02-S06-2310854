package accounts.cuentasahorro.plazo;

import accounts.core.CuentaAhorro;

public class PlazoFijo extends CuentaAhorro {

    public PlazoFijo(double monto) {
        super(monto);
        this.tipo = "Plazo Fijo";
        this.tasaInteres = 6.0;
        this.retirosPermitidosATM = 0;
        this.plazoMeses = 6;
    }
}

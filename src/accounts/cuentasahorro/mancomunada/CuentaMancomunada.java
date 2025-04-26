package accounts.cuentasahorro.mancomunada;

import accounts.core.CuentaAhorro;

public class CuentaMancomunada extends CuentaAhorro {

    public CuentaMancomunada(double monto) {
        super(monto);
        this.tipo = "Ahorro Mancomunada";
        this.tasaInteres = 4.0;
        this.retirosPermitidosATM = 5;
        this.cantidadTitulares = 2;
        this.plazoMeses = 0;
    }
}

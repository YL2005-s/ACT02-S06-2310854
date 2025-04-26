package accounts.cuentasahorro.digital;

import accounts.core.CuentaAhorro;

public class CuentaDigital extends CuentaAhorro {

    public CuentaDigital(double monto) {
        super(monto);
        this.tipo = "Ahorro Digital";
        this.tasaInteres = 3.0;
        this.pagaMantenimiento = true;
        this.retirosPermitidosATM = 3;
        this.esDigital = true;
        this.plazoMeses = 0;
    }
}

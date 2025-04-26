package accounts.cuentasahorro.digital;

import accounts.core.CuentaAhorro;

public class CuentaDigital extends CuentaAhorro {
    private boolean esDigital = true;

    public CuentaDigital(double monto) {
        super(monto);
        this.tipo = "Ahorro Digital";
        this.tasaInteres = 3.0;
        this.pagaMantenimiento = true;
        this.retirosPermitidosATM = 3;
        this.plazoMeses = 0;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    @Override
    public String getDetalles() {
        String detalles = super.getDetalles();
        return detalles + "\nCuenta 100% Digital.";
    }
}

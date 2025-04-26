package accounts.cuentasahorro.menores;

import accounts.core.CuentaAhorro;

public class CuentaMenores extends CuentaAhorro {
    private final boolean requiereTutor = true;

    public CuentaMenores(double monto) {
        super(monto);
        this.tipo = "Ahorro para Menores";
        this.tasaInteres = 0.5;
        this.retirosPermitidosATM = 0;
        this.cantidadTitulares = 2;
    }

    public boolean isRequiereTutor() {
        return requiereTutor;
    }

    @Override
    public String getDetalles() {
        String detallesBase = super.getDetalles();
        return detallesBase + "\nCuenta requiere presencia de un Tutor.";
    }
}

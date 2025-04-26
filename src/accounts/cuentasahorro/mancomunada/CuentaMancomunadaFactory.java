package accounts.cuentasahorro.mancomunada;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;

public class CuentaMancomunadaFactory implements CuentaFactory {

    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new CuentaMancomunada(monto);
    }
}

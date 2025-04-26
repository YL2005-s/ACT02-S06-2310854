package accounts.cuentasahorro.plazo;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;

public class CuentaPlazoFijoFactory implements CuentaFactory {

    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new CuentaPlazoFijo(monto);
    }
}

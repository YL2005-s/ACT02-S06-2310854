package accounts.cuentasahorro.plazo;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;

public class PlazoFijoFactory implements CuentaFactory {

    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new PlazoFijo(monto);
    }
}

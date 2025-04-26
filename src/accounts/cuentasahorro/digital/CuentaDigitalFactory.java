package accounts.cuentasahorro.digital;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;

public class CuentaDigitalFactory implements CuentaFactory {

    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new CuentaDigital(monto);
    }
}

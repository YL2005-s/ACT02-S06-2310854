package accounts.cuentasahorro.sueldo;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;
import accounts.cuentasahorro.plazo.CuentaPlazoFijo;

public class CuentaSueldoFactory implements CuentaFactory {

    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new CuentaSueldo(monto);
    }
}

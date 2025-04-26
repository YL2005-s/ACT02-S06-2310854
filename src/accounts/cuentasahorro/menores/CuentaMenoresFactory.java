package accounts.cuentasahorro.menores;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;

public class CuentaMenoresFactory implements CuentaFactory {
    @Override
    public CuentaAhorro crearCuenta(double monto) {
        return new CuentaMenores(monto);
    }
}

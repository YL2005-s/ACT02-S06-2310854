package accounts.core;

public abstract class CuentaAhorro {
    protected double tasaInteres;
    protected double monto;
    protected boolean pagaMantenimiento = false;
    protected int retirosPermitidosATM;
    protected boolean esDigital = false;
    protected int cantidadTitulares = 1;
    protected int plazoMeses;
    protected String tipo;

    public CuentaAhorro(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isPagaMantenimiento() {
        return pagaMantenimiento;
    }

    public int getRetirosPermitidosATM() {
        return retirosPermitidosATM;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    public int getCantidadTitulares() {
        return cantidadTitulares;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public String getDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("=== Detalles de la Cuenta ===\n");
        detalles.append("Tipo: ").append(tipo).append("\n");
        detalles.append("Tasa: ").append(tasaInteres).append("%\n");
        detalles.append("Saldo: $").append(monto).append("\n");
        detalles.append("Cantidad de titulares: ").append(cantidadTitulares).append("\n");
        detalles.append("Mantenimiento: ").append(pagaMantenimiento ? "Sí" : "No").append("\n");
        detalles.append("Retiros ATM: ").append(retirosPermitidosATM).append("/mes");

        if (plazoMeses > 0) {
            detalles.append("\nPlazo: ").append(plazoMeses).append(" meses");
        }

        return detalles.toString();
    }

}

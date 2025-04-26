package controllers;

import accounts.core.CuentaAhorro;
import accounts.core.CuentaFactory;
import accounts.cuentasahorro.digital.CuentaDigitalFactory;
import accounts.cuentasahorro.mancomunada.CuentaMancomunadaFactory;
import accounts.cuentasahorro.plazo.PlazoFijoFactory;
import accounts.cuentasahorro.sueldo.CuentaSueldoFactory;
import core.Controller;
import models.BancoModel;
import view.BancoView;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class BancoController extends Controller {
    private BancoView bancoView;
    private final Map<String, CuentaFactory> accountFactories = new HashMap<>();

    @Override
    public void run() {
        bancoView = new BancoView(this, mainFrame);
        addView("BancoView", bancoView);
        mainFrame.setVisible(true);

        innitAccounts();
    }

    private void innitAccounts() {
        accountFactories.put("Ahorro Sueldo", new CuentaSueldoFactory());
        accountFactories.put("Ahorro Digital", new CuentaDigitalFactory());
        accountFactories.put("Ahorro Mancomunada", new CuentaMancomunadaFactory());
        accountFactories.put("Plazo Fijo", new PlazoFijoFactory());
    }

    public CuentaAhorro saveAccount(String tipoCuenta, double monto) {
        CuentaFactory factory = accountFactories.get(tipoCuenta);
        if (factory == null) throw new IllegalArgumentException("Tipo de cuenta no registrado: " + tipoCuenta);

        CuentaAhorro cuenta = factory.crearCuenta(monto);
        try {
            BancoModel bancoModel = new BancoModel();
            bancoModel.attach(bancoView);
            bancoModel.saveAccount(cuenta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return cuenta;
    }
}

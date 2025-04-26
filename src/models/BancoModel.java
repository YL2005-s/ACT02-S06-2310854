package models;

import accounts.core.CuentaAhorro;
import core.Model;
import core.View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoModel implements Model {
    private static final String FILE = "cuentas.txt";
    private final List<View> views = new ArrayList<>();
    private String notice;

    @Override
    public void attach(View view) {
        views.add(view);
    }

    @Override
    public void detach(View view) {
        views.remove(view);
    }

    @Override
    public void notifyViews() {
        for (View v : views) {
            v.update(this, notice);
        }
    }

    public void saveAccount(CuentaAhorro cuenta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(cuenta.getDetalles());
            writer.newLine();
            writer.write("-------------------------------");
            writer.newLine();
            notice = "Cuenta guardada con éxito.";
        } catch (IOException e) {
            notice = "Error al guardar la cuenta.";
        }
        notifyViews();
    }
}

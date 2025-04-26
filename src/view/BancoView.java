package view;

import accounts.core.CuentaAhorro;
import controllers.BancoController;
import core.Model;
import core.View;

import javax.swing.*;
import java.awt.*;

public class BancoView extends JPanel implements View {
    private final BancoController bancoController;
    private final JFrame mainFrame;
    private final static int MAIN_FRAME_WIDTH = 450;
    private final static int MAIN_FRAME_HEIGHT = 350;
    private final static int MAIN_FRAME_X = 100;
    private final static int MAIN_FRAME_Y = 100;

    private JPanel panelSuperior;
    private JComboBox<String> cbx_tipoCuenta;
    private JTextArea ta_detalles;
    private JTextField tf_monto;

    public BancoView(BancoController bancoController, JFrame mainFrame) {
        this.bancoController = bancoController;
        this.mainFrame = mainFrame;

        make_mainFrame();
        make_panel_superior();
        make_combo_accountType();
        make_area_detailsText();
        make_field_amount();
        make_btn_create();
    }

    @Override
    public void update(Model model, Object data) {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(this, notice);
        }
    }

    private void make_mainFrame() {
        mainFrame.setTitle("Sistema Bancario");
        mainFrame.setBounds(MAIN_FRAME_X, MAIN_FRAME_Y, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        mainFrame.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));
    }

    private void make_panel_superior() {
        panelSuperior = new JPanel(new GridLayout(3, 2, 5, 5));
        add(panelSuperior, BorderLayout.NORTH);
    }

    private void make_combo_accountType() {
        panelSuperior.add(new JLabel("Tipo de Cuenta:"));
        cbx_tipoCuenta = new JComboBox<>(new String[]{
                "Ahorro Sueldo",
                "Ahorro Digital",
                "Ahorro Mancomunada",
                "Plazo Fijo",
                "Ahorro para Menores"
        });
        panelSuperior.add(cbx_tipoCuenta);
    }

    private void make_area_detailsText() {
        ta_detalles = new JTextArea();
        ta_detalles.setEditable(false);
        add(new JScrollPane(ta_detalles), BorderLayout.CENTER);
    }

    private void make_field_amount() {
        panelSuperior.add(new JLabel("Monto Inicial:"));
        tf_monto = new JTextField("100.00");
        panelSuperior.add(tf_monto);
    }

    private void make_btn_create() {
        JButton btn_create = new JButton("Crear Cuenta");
        panelSuperior.add(btn_create);

        btn_create.addActionListener(arg0 -> {
            try {
                String tipo = (String) cbx_tipoCuenta.getSelectedItem();
                double monto = Double.parseDouble(tf_monto.getText());
                CuentaAhorro cuenta = bancoController.saveAccount(tipo, monto);

                if (cuenta != null) {
                    ta_detalles.setText(cuenta.getDetalles());
                } else {
                    ta_detalles.setText("Error al crear la cuenta.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

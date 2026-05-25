import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BurgerMenuFrame extends JFrame {

    // Precios base
    private static final double PRECIO_BASE = 8.0;
    private static final double PRECIO_HAMBURGUESA_TERNERA = 3.0;
    private static final double PRECIO_HAMBURGUESA_VEGANA = 4.7;
    private static final double PRECIO_PATATAS_CASERAS = 4.0;
    private static final double PRECIO_HAMBURGUESA_DOBLE = 3.0;
    private static final double PRECIO_EXTRA_QUESO = 0.5;
    private static final double PRECIO_EXTRA_PATATAS = 2.0;
    private static final double PRECIO_SALSA = 0.5;
    private static final double IVA = 0.21;
    private static final double DESCUENTO_RECOGIDA = 0.20;

    // Componentes
    private JRadioButton pollo, cerdo, ternera, vegana;
    private JRadioButton normal, integral, centeno;
    private JRadioButton fritas, gajo, caseras;
    private JRadioButton cola, naranja, limon, agua, cerveza;
    private JCheckBox hamburguesaDoble, extraQueso, extraPatatas;
    private JSpinner ketchup, mostaza, barbacoa, thai;
    private JRadioButton reparto, recogida;
    private JTextField precioTotal, iva, pvp;

    public BurgerMenuFrame() {
        setTitle("Burger Menu APP");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1, 12, 12));

        ((JPanel) getContentPane())
                .setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        initUI();
    }

    private void initUI() {
        JPanel panelHamburguesa = new JPanel(new GridLayout(1, 4, 10, 10));
        panelHamburguesa.setBorder(BorderFactory.createTitledBorder("Hamburguesa"));

        ButtonGroup grupoHamburguesa = new ButtonGroup();

        pollo = new JRadioButton("Pollo (0€)");
        cerdo = new JRadioButton("Cerdo (0€)");
        ternera = new JRadioButton("Ternera (+3.0€)");
        vegana = new JRadioButton("Vegana (+4.7€)");

        grupoHamburguesa.add(pollo);
        grupoHamburguesa.add(cerdo);
        grupoHamburguesa.add(ternera);
        grupoHamburguesa.add(vegana);

        panelHamburguesa.add(pollo);
        panelHamburguesa.add(cerdo);
        panelHamburguesa.add(ternera);
        panelHamburguesa.add(vegana);

        add(panelHamburguesa);

        JPanel panelPan = new JPanel(new GridLayout(1, 3, 10, 10));
        panelPan.setBorder(BorderFactory.createTitledBorder("Pan"));

        ButtonGroup grupoPan = new ButtonGroup();
        normal = new JRadioButton("Normal");
        integral = new JRadioButton("Integral");
        centeno = new JRadioButton("Centeno");

        grupoPan.add(normal);
        grupoPan.add(integral);
        grupoPan.add(centeno);

        panelPan.add(normal);
        panelPan.add(integral);
        panelPan.add(centeno);

        add(panelPan);

        JPanel panelPatatas = new JPanel(new GridLayout(1, 3, 10, 10));
        panelPatatas.setBorder(BorderFactory.createTitledBorder("Patatas"));

        ButtonGroup grupoPatatas = new ButtonGroup();
        fritas = new JRadioButton("Fritas (0€)");
        gajo = new JRadioButton("Gajo (0€)");
        caseras = new JRadioButton("Caseras (+4.0€)");

        grupoPatatas.add(fritas);
        grupoPatatas.add(gajo);
        grupoPatatas.add(caseras);

        panelPatatas.add(fritas);
        panelPatatas.add(gajo);
        panelPatatas.add(caseras);

        add(panelPatatas);

        JPanel panelBebida = new JPanel(new GridLayout(1, 5, 10, 10));
        panelBebida.setBorder(BorderFactory.createTitledBorder("Bebida"));

        ButtonGroup grupoBebida = new ButtonGroup();
        cola = new JRadioButton("Cola");
        naranja = new JRadioButton("Naranja");
        limon = new JRadioButton("Limón");
        agua = new JRadioButton("Agua");
        cerveza = new JRadioButton("Cerveza");

        grupoBebida.add(cola);
        grupoBebida.add(naranja);
        grupoBebida.add(limon);
        grupoBebida.add(agua);
        grupoBebida.add(cerveza);

        panelBebida.add(cola);
        panelBebida.add(naranja);
        panelBebida.add(limon);
        panelBebida.add(agua);
        panelBebida.add(cerveza);

        add(panelBebida);

        JPanel panelExtras = new JPanel(new GridLayout(1, 3, 10, 10));
        panelExtras.setBorder(BorderFactory.createTitledBorder("Extras"));

        hamburguesaDoble = new JCheckBox("Hamburguesa doble (+3.0€)");
        extraQueso = new JCheckBox("Extra de queso (+0.5€)");
        extraPatatas = new JCheckBox("Extra de patatas (+2.0€)");

        panelExtras.add(hamburguesaDoble);
        panelExtras.add(extraQueso);
        panelExtras.add(extraPatatas);

        add(panelExtras);

        JPanel panelSalsas = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSalsas.setBorder(BorderFactory.createTitledBorder("Salsas (+0.5€ cada una)"));

        ketchup = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        mostaza = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        barbacoa = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        thai = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        panelSalsas.add(new JLabel("Ketchup (+0.5€)"));
        panelSalsas.add(ketchup);
        panelSalsas.add(new JLabel("Mostaza (+0.5€)"));
        panelSalsas.add(mostaza);
        panelSalsas.add(new JLabel("Barbacoa (+0.5€)"));
        panelSalsas.add(barbacoa);
        panelSalsas.add(new JLabel("Thai (+0.5€)"));
        panelSalsas.add(thai);

        add(panelSalsas);

        JPanel panelEntrega = new JPanel(new GridLayout(1, 2, 10, 10));

        reparto = new JRadioButton("Reparto a domicilio");
        recogida = new JRadioButton("Recogida (-20%)");

        ButtonGroup grupoEntrega = new ButtonGroup();
        grupoEntrega.add(reparto);
        grupoEntrega.add(recogida);

        panelEntrega.add(reparto);
        panelEntrega.add(recogida);

        add(panelEntrega);

        JButton calcular = new JButton("CALCULAR");
        calcular.addActionListener(e -> calcularPrecio());

        add(calcular);

        JPanel panelResultados = new JPanel(new GridLayout(1, 3, 10, 10));

        precioTotal = new JTextField();
        iva = new JTextField();
        pvp = new JTextField();

        panelResultados.add(precioTotal);
        panelResultados.add(iva);
        panelResultados.add(pvp);

        add(panelResultados);
    }

    private void calcularPrecio() {
        double total = PRECIO_BASE;

        if (ternera.isSelected()) total += PRECIO_HAMBURGUESA_TERNERA;
        if (vegana.isSelected()) total += PRECIO_HAMBURGUESA_VEGANA;
        if (caseras.isSelected()) total += PRECIO_PATATAS_CASERAS;
        if (hamburguesaDoble.isSelected()) total += PRECIO_HAMBURGUESA_DOBLE;
        if (extraQueso.isSelected()) total += PRECIO_EXTRA_QUESO;
        if (extraPatatas.isSelected()) total += PRECIO_EXTRA_PATATAS;

        int numSalsas =
                (int) ketchup.getValue() +
                (int) mostaza.getValue() +
                (int) barbacoa.getValue() +
                (int) thai.getValue();

        total += numSalsas * PRECIO_SALSA;

        if (recogida.isSelected()) {
            total *= (1 - DESCUENTO_RECOGIDA);
        }

        double ivaCalc = total * IVA;
        double pvpFinal = total + ivaCalc;

        precioTotal.setText(String.format("%.2f €", total));
        iva.setText(String.format("%.2f €", ivaCalc));
        pvp.setText(String.format("%.2f €", pvpFinal));
    }
}
//Alberto Conde Fernández
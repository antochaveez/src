package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Config;
import session.SessionConfiguracion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Configuracion extends JFrame {

    private JPanel contentPane;
    private JLabel lblOrganizacion;
    private JLabel lblDeumor;
    private JTextField txtOrga;
    private JTextField txtDeumor;
    private JLabel lblDiamor;
    private JTextField txtDiamor;
    private JLabel lblDiapre;
    private JTextField txtDiapre;
    private JButton btnGuardar;
    private JButton btnCancelar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Configuracion frame = new Configuracion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Configuracion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblOrganizacion = new JLabel("Organizacion");
        lblOrganizacion.setBounds(51, 25, 101, 15);
        contentPane.add(lblOrganizacion);

        txtOrga = new JTextField();
        txtOrga.setBounds(291, 25, 114, 19);
        contentPane.add(txtOrga);
        txtOrga.setColumns(10);

        lblDeumor = new JLabel("Monto por mora");
        lblDeumor.setBounds(51, 75, 127, 15);
        contentPane.add(lblDeumor);

        txtDeumor = new JTextField();
        txtDeumor.setBounds(291, 75, 114, 19);
        txtDeumor.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDeumor);
        txtDeumor.setColumns(10);
        
        lblDiamor = new JLabel("Dias para considerar moroso");
        lblDiamor.setBounds(27, 130, 246, 15);
        contentPane.add(lblDiamor);
        
        txtDiamor = new JTextField();
        txtDiamor.setBounds(291, 132, 114, 19);

        txtDiamor.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDiamor);
        txtDiamor.setColumns(10);
        
        lblDiapre = new JLabel("Cantidad de dias a prestar");
        lblDiapre.setBounds(51, 199, 198, 15);
        contentPane.add(lblDiapre);
        
        txtDiapre = new JTextField();
        txtDiapre.setBounds(291, 199, 114, 19);
        txtDiapre.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDiapre);
        txtDiapre.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtDeumor.getText().trim().isEmpty() ||
                    txtDiamor.getText().trim().isEmpty() ||
                    txtDiapre.getText().trim().isEmpty() ||
                    txtOrga.getText().trim().isEmpty() ){
                   JOptionPane.showMessageDialog(null, "Existen campos vacíos, complete antes de guardar"); 
                   if (txtOrga.getText().trim().isEmpty()){
                       txtOrga.requestFocus();
                   } else {
                       
                       if (txtDeumor.getText().trim().isEmpty()){
                           txtDeumor.requestFocus();
                       } else {

                           if (txtDiamor.getText().trim().isEmpty()){
                               txtDiamor.requestFocus();
                           } else {

                               if (txtDiapre.getText().trim().isEmpty()){
                                   txtDiapre.requestFocus();
                               } 
                           }

                       }
                   }

                } else{
                    Config config = new Config();
                    config.setCfgOrga(txtOrga.getText());
                    config.setCfgDeumor(Integer.parseInt( txtDeumor.getText() ));
                    config.setCfgDiamor(Integer.parseInt( txtDiamor.getText() ));
                    config.setCfgDiapre(Integer.parseInt( txtDiapre.getText() ));
                    // Cerrar la ventana de configuracion despues de guardar los datos
                    dispose();
                }
            }
        });
        btnGuardar.setBounds(132, 262, 117, 25);
        contentPane.add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(291, 262, 117, 25);
        contentPane.add(btnCancelar);
        
        // Al abrir la ventana, colocar los valores de
        //la configuracion en los textbox
        if (SessionConfiguracion.existeConfiguracion()){
            Config config = SessionConfiguracion.obtenerConfiguracion();
            txtOrga.setText(config.getCfgOrga());
            txtDeumor.setText(config.getCfgDeumor().toString());
            txtDiamor.setText(config.getCfgDiamor().toString());
            txtDiapre.setText(config.getCfgDiapre().toString());
        }
        
        
        
    }
}

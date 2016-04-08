package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import entidad.Config;
import session.SessionConfiguracion;
import session.SessionInicializacion;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Inicializacion extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JButton btnParcial;
    private JButton btnTotal;
    private String password;
    private JButton btnGuardar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inicializacion frame = new Inicializacion();
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
    public Inicializacion() {
        //Si no existe una configuracion
        if (!SessionConfiguracion.existeConfiguracion()){
            JOptionPane.showMessageDialog(null,
                    "Primero debe ingresar un password en Configuracion");
            this.dispose();
        } else{

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 450, 270);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
        
         
            Config config = new Config();
            config = SessionConfiguracion.obtenerConfiguracion();
            password = config.getCfgPass();

            
            lblPassword = new JLabel("Password");
            lblPassword.setBounds(40, 92, 70, 15);
            contentPane.add(lblPassword);
            
            txtPassword = new JTextField();
            txtPassword.setBounds(172, 90, 114, 19);
            txtPassword.addKeyListener(new KeyAdapter() {
                            
                @Override
                public void keyReleased(KeyEvent e) {
                    boolean passwordCorrecto = txtPassword.getText().equals(password);
                    if (passwordCorrecto){
                        btnParcial.setEnabled(true);
                        btnTotal.setEnabled(true);
                    }

                    
                }
            });
            contentPane.add(txtPassword);
            txtPassword.setColumns(10);
            
            btnParcial = new JButton("Inicializacion parcial");
            btnParcial.setBounds(49, 205, 177, 25);
            btnParcial.setEnabled(false);
            btnParcial.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    int resp = JOptionPane.showConfirmDialog(
                                btnParcial,
                                "Desea vaciar las tablas Prestamos y Deudas?", "Confirmacion",
                                JOptionPane.OK_CANCEL_OPTION);

                    if (resp == 0) {
                        try {
                            SessionInicializacion.truncadoParcial();
                            JOptionPane.showMessageDialog(null, "Tablas vaciadas");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }

                    
                }
            });
            contentPane.add(btnParcial);
            
            btnTotal = new JButton("Inicializacion total");
            btnTotal.setBounds(240, 205, 167, 25);
            btnTotal.setEnabled(false);
            btnTotal.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    int resp = JOptionPane.showConfirmDialog(
                                btnTotal,
                                "Desea vaciar TODAS las tablas?", "ATENCION",
                                JOptionPane.OK_CANCEL_OPTION);

                    if (resp == 0) {
                        try {
                            SessionInicializacion.truncadoTotal();
                            JOptionPane.showMessageDialog(null, "Tablas vaciadas. Introduzca un nuevo password");
                            txtPassword.setText("");
                            txtPassword.requestFocus();
                            crearBotonDeGuardar();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }

                    
                }
            });
            contentPane.add(btnTotal);
     
        }

    }
    
    public void crearBotonDeGuardar(){
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 150, 177, 25);
        btnGuardar.setEnabled(true);
        btnGuardar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Config config = new Config();
                    config.setCfgPass(txtPassword.getText());
                    SessionConfiguracion.cambiarConfiguracion(config);
                    JOptionPane.showMessageDialog(null, "Password guardado.");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(btnGuardar);
        this.repaint();
    }
}

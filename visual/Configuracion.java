package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import session.SessionConfiguracion;
import entidad.Config;
import session.SessionConfiguracion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configuracion extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel lblOrganizacion;
    private JLabel lblDeumor;
    private JTextField txtOrga;
    private JTextField txtDeumor;
    private JLabel lblDiamor;
    private JTextField txtDiamor;
    private JLabel lblDiapre;
    private JTextField txtDiapre;
    private JLabel lblPass;
    private JTextField txtPass;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblOrganizacion = new JLabel("Organizacion");
        lblOrganizacion.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblOrganizacion.setBounds(40, 27, 117, 15);
        contentPane.add(lblOrganizacion);
        
        txtOrga = new JTextField();
        txtOrga.setBounds(224, 25, 300, 19);
        contentPane.add(txtOrga);
        txtOrga.setColumns(10);

        lblDeumor = new JLabel("Monto por mora");
        lblDeumor.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDeumor.setBounds(40, 77, 129, 15);
        contentPane.add(lblDeumor);
        
        txtDeumor = new JTextField();
        txtDeumor.setBounds(224, 75, 300, 19);
        txtDeumor.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDeumor);
        txtDeumor.setColumns(10);
        
        lblDiamor = new JLabel("Dias para considerar moroso");
        lblDiamor.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDiamor.setBounds(40, 134, 185, 15);
        contentPane.add(lblDiamor);
        
        txtDiamor = new JTextField();
        txtDiamor.setBounds(224, 132, 300, 19);

        txtDiamor.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDiamor);
        txtDiamor.setColumns(10);
        
        lblDiapre = new JLabel("Cantidad de dias a prestar");
        lblDiapre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDiapre.setBounds(40, 201, 174, 15);
        contentPane.add(lblDiapre);
        
        txtDiapre = new JTextField();
        txtDiapre.setBounds(224, 199, 300, 19);
        txtDiapre.addKeyListener(new InputDeNumeros());
        contentPane.add(txtDiapre);
        txtDiapre.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(Color.GRAY);
        btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGuardar.setIcon(new ImageIcon(Configuracion.class.getResource("/imagen/glyphicons-194-ok-sign.png")));
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
                    try {
                        SessionConfiguracion.cambiarConfiguracion(config);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    // Cerrar la ventana de configuracion despues de guardar los datos
                    dispose();
                  
                }
            }
        });
        btnGuardar.setBounds(198, 254, 117, 46);
        contentPane.add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.GRAY);
        btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCancelar.setIcon(new ImageIcon(Configuracion.class.getResource("/imagen/glyphicons-193-remove-sign.png")));
        btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                
            }
        });
        btnCancelar.setBounds(357, 254, 117, 46);
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

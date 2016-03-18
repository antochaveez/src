package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import session.SessionLector;
import tableModale.LectorTableModel;

public class AbmLector extends JFrame {

	
	private LectorTableModel modelo = new LectorTableModel();
	private JTextField tCodigo;
	private int fila;
	private JTextField tDescri;
	private JTextField tObse;
	private JTextField tBusqueda;
	private JButton bNuevo;
	private JButton bModificar;
	private JButton bEliminar;
	private JButton bSalir;
	private JButton bCancelar;
	private JButton bGuardar;
	private JTable table;
	private Fondito contentPane;
	
	private JTextField tBusqueda_1;
	private JTextField tCodigo_1;
	private JTextField tNombre;
	private JTextField tCedula;
	private JTextField tDireccion;
	private JTextField tTelefono;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbmLector frame = new AbmLector();
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
	public AbmLector() {
		setTitle("Registrar Lector");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AbmEditor.class.getResource("/imagen/libros1.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new Fondito("/imagen/images.jpg");
		contentPane.setBorder(new  EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		table = new JTable();
		table.setOpaque(false);
		table.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if (bNuevo.getLabel().equals("Nuevo")) {
					
					if (arg0.getKeyCode()== 38 || arg0.getKeyCode()== 40) {
						
						fila = table.getSelectedRow();
						
						tCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						tNombre.setText(String.valueOf(table.getValueAt(fila, 1))
								.trim());
						tCedula.setText(String.valueOf(table.getValueAt(fila, 2)));
						tDireccion.setText(String.valueOf(table.getValueAt(fila, 3)).trim());
						tTelefono.setText(String.valueOf(table.getValueAt(fila, 4)).trim());
						
						
					}
					
				}
			}
		});
		contentPane.setLayout(null);

		
		JButton bNuevo_1 = new JButton("Nuevo");
		bNuevo_1.setBounds(406, 104, 91, 50);
		bNuevo_1.setBackground(Color.LIGHT_GRAY);
		bNuevo_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo_1.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bNuevo_1);
		
		JButton bModificar_1 = new JButton("Modificar");
		bModificar_1.setBounds(406, 197, 91, 50);
		bModificar_1.setBackground(Color.LIGHT_GRAY);
		bModificar_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bModificar_1);
		
		JButton bEliminar_1 = new JButton("Eliminar");
		bEliminar_1.setBounds(406, 289, 91, 50);
		bEliminar_1.setBackground(Color.LIGHT_GRAY);
		bEliminar_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bEliminar_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(510, 70, 352, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setBounds(10, 54, 43, 14);
		panel.add(lblCdigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 122, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblDireccin = new JLabel("C\u00E9dula");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccin.setBounds(10, 190, 46, 14);
		panel.add(lblDireccin);
		
		tCodigo_1 = new JTextField();
		tCodigo_1.setBounds(72, 52, 273, 20);
		panel.add(tCodigo_1);
		tCodigo_1.setColumns(10);
		
		tNombre = new JTextField();
		tNombre.setBounds(72, 119, 273, 20);
		panel.add(tNombre);
		tNombre.setColumns(10);
		
		tCedula = new JTextField();
		tCedula.setBounds(75, 187, 270, 20);
		panel.add(tCedula);
		tCedula.setColumns(10);
		
		JLabel lblDireccin_1 = new JLabel("Direcci\u00F3n");
		lblDireccin_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccin_1.setBounds(10, 258, 60, 14);
		panel.add(lblDireccin_1);
		
		tDireccion = new JTextField();
		tDireccion.setBounds(72, 255, 273, 20);
		panel.add(tDireccion);
		tDireccion.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelfono.setBounds(10, 326, 60, 14);
		panel.add(lblTelfono);
		
		tTelefono = new JTextField();
		tTelefono.setBounds(72, 323, 273, 20);
		panel.add(tTelefono);
		tTelefono.setColumns(10);
		
		JButton bGuardar_1 = new JButton("Guardar");
		bGuardar_1.setBounds(649, 440, 91, 43);
		bGuardar_1.setBackground(Color.LIGHT_GRAY);
		bGuardar_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar_1.setEnabled(false);
		contentPane.add(bGuardar_1);
		
		JButton bCancelar_1 = new JButton("Cancelar");
		bCancelar_1.setBounds(771, 440, 91, 43);
		bCancelar_1.setBackground(Color.LIGHT_GRAY);
		bCancelar_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar_1.setEnabled(false);
		contentPane.add(bCancelar_1);
		
		JButton bSalir_1 = new JButton("SALIR");
		bSalir_1.setBounds(771, 507, 91, 43);
		bSalir_1.setBackground(Color.LIGHT_GRAY);
		bSalir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		bSalir_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir_1.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bSalir_1);
		
		tBusqueda_1 = new JTextField();
		tBusqueda_1.setBounds(170, 455, 230, 23);
		tBusqueda_1.setColumns(10);
		contentPane.add(tBusqueda_1);
		
		JLabel label = new JLabel("Buscar");
		label.setBounds(105, 453, 55, 23);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 70, 361, 359);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		table = new JTable();
		table.setOpaque(false);
		table.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if (bNuevo.getLabel().equals("Nuevo")) {
					
					if (arg0.getKeyCode()== 38 || arg0.getKeyCode()== 40) {
						
						fila = table.getSelectedRow();
						
						tCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						tDescri.setText(String.valueOf(table.getValueAt(fila, 1))
								.trim());
						tObse.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());
						
					}
					
				}
			}
		});
		mostrarDatos();
	}
	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(150);
		columModel.getColumn(2).setPreferredWidth(100);
		columModel.getColumn(3).setPreferredWidth(150);
		columModel.getColumn(4).setPreferredWidth(100);

		modelo.setLecList(SessionLector.obtenerListaLector());
	}
}

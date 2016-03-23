package visual;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

import session.SessionLector;
import tableModale.LectorTableModel;
import entidad.Lector;

public class AbmLector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LectorTableModel modelo = new LectorTableModel();
	private JTextField tCodigo;
	private int fila;


	private Fondito contentPane;

	private JTextField tBusqueda;
	private JTextField tCedula;
	private JTable table;
	private JTextArea tDireccion;
	private JTextArea tNombre;
	private JButton bSalir;
	private JTextArea tTelefo;
	private JButton bEliminar;
	private JButton bGuardar;
	private JButton bModificar;
	private JButton bCancelar;
	private JButton bNuevo;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AbmEditor.class.getResource("/imagen/libros1.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new Fondito("/imagen/fondo3.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bNuevo = new JButton("Nuevo");
		bNuevo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {


				try {

					Lector lector = SessionLector.irAlUltimo();
					tCodigo.setText(lector.getLecCodigo() + 1 + "");

				} catch (Exception epp) {

					JOptionPane.showMessageDialog(null, epp.getMessage());

				}

				tNombre.setText("");
				tCedula.setText("");
				tDireccion.setText("");
				tTelefo.setText("");
				

				tCodigo.setEditable(false);
				tNombre.setEditable(true);
				tNombre.requestFocus();
				tCedula.setEditable(true);
				tDireccion.setEditable(true);
				tTelefo.setEditable(true);
				

				bModificar.setEnabled(false);
				bNuevo.setEnabled(false);
				bNuevo.setLabel("Agregar");
				bEliminar.setEnabled(false);
				bCancelar.setEnabled(true);
				bGuardar.setEnabled(true);
				
				tBusqueda.setEnabled(false);
				
				
			

				// table.setVisible(false);

			
			}
		});
		bNuevo.setBounds(404, 47, 91, 50);
		bNuevo.setBackground(Color.LIGHT_GRAY);
		bNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bNuevo);
			

		bModificar = new JButton("Modificar");
		bModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {


				bEliminar.setEnabled(false);
				bNuevo.setLabel("Agregar");
				bNuevo.setEnabled(false);
				bModificar.setEnabled(false);
				bGuardar.setLabel("Actualizar");
				bGuardar.setEnabled(true);
				bCancelar.setEnabled(true);

				String compara = tCodigo.getText();

				if (compara.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Seleccione un registro para modificar ");
					bCancelar.doClick();
				} else {

					tCodigo.setEditable(false);
					tNombre.setEditable(true);
					tCedula.setEditable(true);
					tDireccion.setEditable(true);
					tTelefo.setEditable(true);
					

				}
				
				tBusqueda.setEnabled(false);
				

			
			}
		});
		bModificar.setBounds(406, 142, 91, 50);
		bModificar.setBackground(Color.LIGHT_GRAY);
		bModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bModificar);	

		bEliminar = new JButton("Eliminar");
		bEliminar.setBounds(406, 234, 91, 50);
		bEliminar.setBackground(Color.LIGHT_GRAY);
		bEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bEliminar);	

		JPanel panel = new JPanel();
		panel.setBounds(505, 21, 352, 319);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 11, 43, 14);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblCdigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 62, 46, 14);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNombre);

		JLabel lblDireccin = new JLabel("C\u00E9dula");
		lblDireccin.setBounds(10, 127, 46, 14);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblDireccin);

		tCodigo = new JTextField();
		tCodigo.setEditable(false);
		tCodigo.setBounds(63, 9, 273, 20);
		panel.add(tCodigo);
		tCodigo.setColumns(10);

		tCedula = new JTextField();
		tCedula.setEditable(false);
		tCedula.setBounds(63, 125, 273, 20);
		tCedula.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tCedula.getToolTipText();
		panel.add(tCedula);
		tCedula.setColumns(10);

		JLabel lblDireccin_1 = new JLabel("Direcci\u00F3n");
		lblDireccin_1.setBounds(10, 173, 60, 14);
		lblDireccin_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblDireccin_1);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 235, 60, 14);
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblTelfono);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(63, 57, 273, 35);
		panel.add(scrollPane_1);

		tNombre = new JTextArea();
		tNombre.setEditable(false);
		tNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 9) {
					tCedula.requestFocus();
				}
			}
		});
		tNombre.setLocation(63, 0);
		tNombre.setLineWrap(true);
		scrollPane_1.setViewportView(tNombre);
		

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(63, 173, 273, 35);
		panel.add(scrollPane_2);

		tDireccion = new JTextArea();
		tDireccion.setEditable(false);
		tDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 9) {
					tTelefo.requestFocus();
				}
			}
		});
		tDireccion.setLocation(63, 0);
		tDireccion.setLineWrap(true);
		scrollPane_2.setViewportView(tDireccion);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(63, 235, 273, 35);
		panel.add(scrollPane_3);

		tTelefo = new JTextArea();
		tTelefo.setEditable(false);
		tTelefo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 9) {
					bGuardar.requestFocus();
				}
			}
		});
		tTelefo.setLocation(63, 0);
		tTelefo.setLineWrap(true);
		scrollPane_3.setViewportView(tTelefo);
			
		bGuardar = new JButton("Guardar");
		bGuardar.setBounds(649, 351, 91, 43);
		bGuardar.setBackground(Color.LIGHT_GRAY);
		bGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar.setEnabled(false);
		contentPane.add(bGuardar);

		bCancelar = new JButton("Cancelar");
		bCancelar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				
				bNuevo.setEnabled(true);
				bModificar.setEnabled(true);
				bEliminar.setEnabled(true);
				
				bGuardar.setEnabled(false);
				bCancelar.setEnabled(false);
				
				tCodigo.setText("");
				tNombre.setText("");
				tCedula.setText("");
				tDireccion.setText("");
				tTelefo.setText("");
				
				
				tNombre.setEditable(false);
				tCedula.setEditable(false);
				tDireccion.setEditable(false);
				tTelefo.setEditable(false);
				
				
				table.clearSelection();
				table.setVisible(true);
				
				bNuevo.setLabel("Nuevo");
				bGuardar.setLabel("Guardar");
				
				tBusqueda.setEnabled(true);
				
				
				
				table.repaint();
				mostrarDatos();
				
			
			}
		});
		bCancelar.setBounds(771, 351, 91, 43);
		bCancelar.setBackground(Color.LIGHT_GRAY);
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setEnabled(false);
		contentPane.add(bCancelar);	

		bSalir = new JButton("SALIR");
		bSalir.setBounds(771, 405, 91, 43);
		bSalir.setBackground(Color.LIGHT_GRAY);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	

			}
		});
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bSalir);

		tBusqueda = new JTextField();
		tBusqueda.setBounds(72, 381, 322, 23);
		tBusqueda.setColumns(10);
		contentPane.add(tBusqueda);

		JLabel label = new JLabel("Buscar");
		label.setBounds(21, 379, 55, 23);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 372, 347);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setOpaque(false);
		table.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent arg0) {

				if (bNuevo.getLabel().equals("Nuevo")) {

					if (arg0.getKeyCode() == 38 || arg0.getKeyCode() == 40) {

						fila = table.getSelectedRow();

						tCodigo.setText(String.valueOf(table
								.getValueAt(fila, 0)));
						tNombre.setText(String.valueOf(
								table.getValueAt(fila, 1)).trim());
						tCedula.setText(String.valueOf(
								table.getValueAt(fila, 2)).trim());
						tDireccion.setText(String.valueOf(
								table.getValueAt(fila, 3)).trim());
						tTelefo.setText(String.valueOf(
								table.getValueAt(fila, 4)).trim());

					}

				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (bNuevo.getLabel().equals("Nuevo")) {
					fila = table.rowAtPoint(arg0.getPoint());
					if (fila > -1) {
						tCodigo.setText(String.valueOf(table
								.getValueAt(fila, 0)));
						tNombre.setText(String.valueOf(
								table.getValueAt(fila, 1)).trim());
						tCedula.setText(String.valueOf(
								table.getValueAt(fila, 2)).trim());
						tDireccion.setText(String.valueOf(
								table.getValueAt(fila, 3)).trim());
						tTelefo.setText(String.valueOf(
								table.getValueAt(fila, 4)).trim());

					}
				}

			}
		});
		scrollPane.setViewportView(table);

		mostrarDatos();
	}

	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(60);
		columModel.getColumn(1).setPreferredWidth(230);
		columModel.getColumn(2).setPreferredWidth(80);
		columModel.getColumn(3).setPreferredWidth(230);
		columModel.getColumn(4).setPreferredWidth(100);

		modelo.setLecList(SessionLector.obtenerListaLector());
	}
	public JTextArea getTDireccion() {
		return tDireccion;
	}
	public JTextField getTCodigo() {
		return tCodigo;
	}
	public JTextArea getTNombre() {
		return tNombre;
	}
	public JTextField getTBusqueda() {
		return tBusqueda;
	}
	public JButton getBSalir() {
		return bSalir;
	}
	public JTextArea getTTelefo() {
		return tTelefo;
	}
	public JButton getBEliminar() {
		return bEliminar;
	}
	public JButton getBGuardar() {
		return bGuardar;
	}
	public JButton getBModificar() {
		return bModificar;
	}
	public JTextField getTCedula() {
		return tCedula;
	}
	public JButton getBCancelar() {
		return bCancelar;
	}
	public JButton getBNuevo() {
		return bNuevo;
	}
}

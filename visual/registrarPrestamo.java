package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

import session.SessionLibros;
import session.SessionPrestamo;
import tableModale.PrestamoTableModel;
import entidad.Editor;
import entidad.Libro;
import entidad.Prestamo;

public class RegistrarPrestamo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tBusqueda;
	private JTextField tNroPrestamo;
	private JTextField tFechaPre;
	private JTextField tNroEjemplar;
	private JTextField tFechaDevolucion;
	private JTextField tFechaRecuperacion;
	private JTextField tMora;
	private int fila;
	public static int auxCodLector;
	public static int auxCodLibro;

	public static String auxLibroDescri;
	public static JButton bBusquedaLector;
	public static JButton bBusquedaLibro;
	private PrestamoTableModel modelo = new PrestamoTableModel();
	public static JTextField tLector;
	public static JTextField tLibro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPrestamo frame = new RegistrarPrestamo();
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
	public RegistrarPrestamo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 412, 418);
		contentPane.add(scrollPane);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 433, 48, 27);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBuscar);
		final JButton bModificar = new JButton("Modificar");
		bModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		bModificar.setForeground(Color.BLACK);
		bModificar.setBackground(Color.GRAY);
		bModificar.setBounds(432, 134, 91, 50);
		contentPane.add(bModificar);

		final JButton bEliminar = new JButton("Eliminar");
		bEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		bEliminar.setForeground(Color.BLACK);
		bEliminar.setBackground(Color.GRAY);
		bEliminar.setBounds(432, 226, 91, 50);
		contentPane.add(bEliminar);

		final JButton bDevolver = new JButton("Devolver");
		bDevolver.setVerticalTextPosition(SwingConstants.BOTTOM);
		bDevolver.setHorizontalTextPosition(SwingConstants.CENTER);
		bDevolver.setForeground(Color.BLACK);
		bDevolver.setBackground(Color.GRAY);
		bDevolver.setBounds(432, 319, 91, 50);
		contentPane.add(bDevolver);
		
		final JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				




				if (tFechaPre.getText().trim().isEmpty() || tNroEjemplar.getText().trim().isEmpty() 
					|| tFechaDevolucion.getText().trim().isEmpty()) {
					JOptionPane
							.showMessageDialog(null,
									"Existen campos vacios. Complete antes de continuar");

					if (tFechaPre.getText().trim().isEmpty()) {

						tFechaPre.requestFocus();

					} else {
						
						if (tNroEjemplar.getText().trim().isEmpty()) {
							tNroEjemplar.requestFocus();
						}else {
							if (tFechaDevolucion.getText().trim().isEmpty()) {
								tFechaDevolucion.requestFocus();
							}
								
							
						}
					}
				}else {
					
					Prestamo prestamo = new Prestamo();
					Editor editor = new Editor();
					Libro libro = new Libro();
										
					
					
					if (bGuardar.getLabel().equals("Actualizar")) {
						prestamo.setPreNumero(table.set)
						
					}else {
						editor.setEdiNumero(auxCodEditorial);
					}
						
					
					
					//auxCodEditorial2 = modelo.getLibList().get(table.getSelectedRow()).getEdiNumero();
					
							//modeloDeuda.getDeudaList().get(tableDeuda.getSelectedRow()).getCodigoCliente();
					
					libro.setLibDescri(tDescri.getText().trim());
					
					libro.setEditor(editor);
					libro.setLibAutor(tAutor.getText().trim());
					libro.setLibIsbn(tIsbn.getText().trim());
					libro.setLibObse(tObse.getText().trim());
					
					auxCodEditorial2 = (int) table.getValueAt(fila, 6);
					//JOptionPane.showMessageDialog(null, auxCodEditorial2);
					
					//JOptionPane.showMessageDialog(null, auxCodEditorial);
					//JOptionPane.showMessageDialog(null, auxCodEditorial2);
					//JOptionPane.showMessageDialog(null,"" + tObse.getText().trim());

					if (bGuardar.getLabel().equals("Actualizar")) {
						
						libro.setLibCodigo(Integer.valueOf(tCodigo.getText()));

							try {
								Libro libroBuscar = SessionLibros.obtenerLibro(libro);
								
								if (libroBuscar != null) {
									SessionLibros.editar(libro);
									JOptionPane.showMessageDialog(null,"Libro actualizado");
									
									/*MensajeModificar mensaje = new MensajeModificar();
									
									mensaje.setResizable(false);
									mensaje.setLocationRelativeTo(null);
									mensaje.setVisible(true);*/
									
									
								}					
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					if (bNuevo.getLabel().equals("Agregar") && bGuardar.getLabel().equals("Guardar")) {
						try { 
							SessionLibros.insertar(libro);
							JOptionPane.showMessageDialog(null,"Libro creado. Codigo = " + libro.getLibCodigo());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
				}
					bCancelar.doClick();
					table.repaint();
					mostrarDatos();
					
					
					
				}
			
			
			
			}
		});
		bGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar.setForeground(Color.BLACK);
		bGuardar.setEnabled(false);
		bGuardar.setBackground(Color.GRAY);
		bGuardar.setBounds(717, 439, 91, 46);
		contentPane.add(bGuardar);

		final JButton bCancelar = new JButton("Cancelar");
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setForeground(Color.BLACK);
		bCancelar.setEnabled(false);
		bCancelar.setBackground(Color.GRAY);
		bCancelar.setBounds(839, 439, 91, 46);
		contentPane.add(bCancelar);

		final JButton bSalir = new JButton("SALIR");
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		bSalir.setForeground(Color.BLACK);
		bSalir.setBackground(Color.GRAY);
		bSalir.setBounds(839, 493, 91, 46);
		contentPane.add(bSalir);

		tBusqueda = new JTextField();
		tBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				modelo.setPreList(SessionPrestamo.obtenerListaPrestamoPorFiltro(tBusqueda.getText()
						.toUpperCase()));
				table.repaint();

			}
		});
		tBusqueda.setBounds(57, 434, 365, 27);
		contentPane.add(tBusqueda);
		tBusqueda.setColumns(10);

		final JButton bNuevo = new JButton("Nuevo");
		bNuevo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				
				//JOptionPane.showMessageDialog(null, auxLibroDescri);
				//JOptionPane.showMessageDialog(null, auxCodLibro);

				try {

					Prestamo prestamo = SessionPrestamo.irAlUltimo();
					tNroPrestamo.setText(prestamo.getPreNumero() + 1 + "");

				} catch (Exception epp) {

					JOptionPane.showMessageDialog(null, epp.getMessage());

				}
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				Date hoy = new Date();
				
				tFechaPre.setText(sdf.format(hoy));
				tLector.setText("");
				tLibro.setText("");
				tNroEjemplar.setText("");
				tFechaDevolucion.setText(sdf.format(hoy));

				
				tNroPrestamo.setEditable(false);
				tFechaPre.setEditable(true);
				tFechaPre.requestFocus();
				tLector.setEditable(false);
				tLibro.setEditable(false);
				tNroEjemplar.setEditable(true);
				tFechaDevolucion.setEditable(true);
				bBusquedaLector.setEnabled(true);
				bBusquedaLibro.setEnabled(true);
				
				
								

				bModificar.setEnabled(false);
				bNuevo.setEnabled(false);
				bNuevo.setLabel("Agregar");
				bEliminar.setEnabled(false);
				bDevolver.setEnabled(false);
				
				bCancelar.setEnabled(true);
				bGuardar.setEnabled(true);
				
				tBusqueda.setEnabled(false);
				
				
			

				// table.setVisible(false);

			
			
			
			}
		});
		bNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		bNuevo.setForeground(Color.BLACK);
		bNuevo.setBackground(Color.GRAY);
		bNuevo.setBounds(432, 41, 91, 50);
		contentPane.add(bNuevo);



		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(531, 10, 399, 418);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nro. Pr\u00E9stamo");
		lblNewLabel.setBounds(10, 11, 95, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel);

		tNroPrestamo = new JTextField();
		tNroPrestamo.setEditable(false);
		tNroPrestamo.setBounds(132, 11, 200, 25);
		panel.add(tNroPrestamo);
		tNroPrestamo.setColumns(10);

		JLabel lblFechaDePrstamo = new JLabel("Fecha de Pr\u00E9stamo");
		lblFechaDePrstamo.setBounds(10, 55, 120, 32);
		lblFechaDePrstamo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblFechaDePrstamo);

		tFechaPre = new JTextField();
		tFechaPre.setBounds(132, 55, 200, 25);
		panel.add(tFechaPre);
		tFechaPre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Lector");
		lblNewLabel_1.setBounds(10, 102, 70, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_1);

		final JButton bBusquedaLector = new JButton("");
		bBusquedaLector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InterfazTablaLector ite = new InterfazTablaLector();
				
				ite.setResizable(false);
				ite.setLocationRelativeTo(null);
				ite.setVisible(true);
				
			
			}
		});
		bBusquedaLector.setIcon(new ImageIcon(RegistrarPrestamo.class
				.getResource("/imagen/glyphicons-28-search.png")));
		bBusquedaLector.setBounds(344, 102, 46, 31);
		panel.add(bBusquedaLector);

		JLabel lblLibro = new JLabel("Libro");
		lblLibro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLibro.setBounds(10, 162, 79, 32);
		panel.add(lblLibro);

		final JButton bBusquedaLibro = new JButton("");
		bBusquedaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InterfazTablaLibro ite = new InterfazTablaLibro();
				
				ite.setResizable(false);
				ite.setLocationRelativeTo(null);
				ite.setVisible(true);
			}
		});
		bBusquedaLibro.setIcon(new ImageIcon(RegistrarPrestamo.class
				.getResource("/imagen/glyphicons-28-search.png")));
		bBusquedaLibro.setBounds(344, 162, 46, 31);
		panel.add(bBusquedaLibro);

		JLabel lblNroEjemplar = new JLabel("Nro. de Ejemplar");
		lblNroEjemplar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNroEjemplar.setBounds(10, 216, 109, 32);
		panel.add(lblNroEjemplar);

		tNroEjemplar = new JTextField();
		tNroEjemplar.setBounds(134, 216, 200, 25);
		panel.add(tNroEjemplar);
		tNroEjemplar.setColumns(10);

		JLabel lblFechaDe = new JLabel("Fecha de Devoluci\u00F3n");
		lblFechaDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDe.setBounds(10, 259, 131, 55);
		panel.add(lblFechaDe);

		tFechaDevolucion = new JTextField();
		tFechaDevolucion.setBounds(134, 275, 200, 25);
		panel.add(tFechaDevolucion);
		tFechaDevolucion.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 325, 380, 2);
		panel.add(separator);

		JLabel lblFechaDeRecuperacin = new JLabel("Fecha de Recuperaci\u00F3n");
		lblFechaDeRecuperacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDeRecuperacin.setBounds(10, 333, 149, 32);
		panel.add(lblFechaDeRecuperacin);

		tFechaRecuperacion = new JTextField();
		tFechaRecuperacion.setEditable(false);
		tFechaRecuperacion.setBounds(153, 333, 139, 25);
		panel.add(tFechaRecuperacion);
		tFechaRecuperacion.setColumns(10);

		JLabel lblCargoPorMora = new JLabel("Cargo por Mora");
		lblCargoPorMora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargoPorMora.setBounds(10, 376, 120, 25);
		panel.add(lblCargoPorMora);

		tMora = new JTextField();
		tMora.setEditable(false);
		tMora.setBounds(153, 371, 139, 25);
		panel.add(tMora);
		tMora.setColumns(10);
		
		tLector = new JTextField();
		tLector.setColumns(10);
		tLector.setBounds(132, 109, 200, 25);
		panel.add(tLector);
		
		tLibro = new JTextField();
		tLibro.setColumns(10);
		tLibro.setBounds(132, 167, 200, 25);
		panel.add(tLibro);



		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (bNuevo.getLabel().equals("Nuevo")) {
					fila = table.rowAtPoint(arg0.getPoint());
					if (fila > -1) {
									
						tNroPrestamo.setText(String.valueOf(table.getValueAt(fila, 0)));
						tFechaPre.setText(String.valueOf(table.getValueAt(fila, 1))
								.trim());
						tLector.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());
						tLibro.setText(String.valueOf(table.getValueAt(fila, 3)).trim());
						tNroEjemplar.setText(String.valueOf(table.getValueAt(fila, 4)));
						tFechaDevolucion.setText(String.valueOf(table.getValueAt(fila, 5))
								.trim());
					}
				}
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent arg0) {

				if (bNuevo.getLabel().equals("Nuevo")) {

					if (arg0.getKeyCode() == KeyEvent.VK_UP
							|| arg0.getKeyCode() == KeyEvent.VK_DOWN) {

						fila = table.getSelectedRow();

						tNroPrestamo.setText(String.valueOf(table.getValueAt(
								fila, 0)));
						tFechaPre.setText(String.valueOf(
								table.getValueAt(fila, 1)).trim());
						tLector.setText(String.valueOf(
								table.getValueAt(fila, 2)).trim());
						tLibro.setText(String
								.valueOf(table.getValueAt(fila, 3)).trim());
						tNroEjemplar.setText(String.valueOf(table.getValueAt(
								fila, 4)));
						tFechaDevolucion.setText(String.valueOf(
								table.getValueAt(fila, 5)).trim());

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

		columModel.getColumn(0).setPreferredWidth(100);
		columModel.getColumn(1).setPreferredWidth(105);
		columModel.getColumn(2).setPreferredWidth(150);
		columModel.getColumn(3).setPreferredWidth(150);
		columModel.getColumn(4).setPreferredWidth(80);
		columModel.getColumn(5).setPreferredWidth(120);
		columModel.getColumn(6).setPreferredWidth(120);

		modelo.setPreList(SessionPrestamo.obtenerListaPrestamo());

	}
	public JTextField getTLibro() {
		return tLibro;
	}
	public JTextField getTLector() {
		return tLector;
	}
}

package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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

import session.SessionLibros;
import tableModale.LibroTableModel;
import entidad.Editor;
import entidad.Libro;

public class AbmLibros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LibroTableModel modelo = new LibroTableModel();
	private int fila;
	private JButton bNuevo;
	private JButton bModificar;
	private JButton bEliminar;
	private JButton bCancelar;
	private JButton bGuardar;
	private JButton bSalir;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JLabel lblNewLabel_3;
	private JTextField tCodigo;
	public static JTextField tEditorial;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField tBusqueda;
	private JTextArea tObse;
	private JTextArea tDescri;
	private JTextArea tAutor;
	private JTextArea tIsbn;
	public static int auxCodEditorial;
	private JButton bBusqueda;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbmLibros frame = new AbmLibros();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AbmLibros() {
		setTitle("Registrar Libros");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AbmLibros.class.getResource("/imagen/libros1.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 560);
		//contentPane = new JPanel();
		contentPane = new Fondito("/imagen/fondo3.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		
		
		
		bNuevo = new JButton("Nuevo");
		bNuevo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				



				try {

					Libro libro= SessionLibros.irAlUltimo();
					tCodigo.setText(libro.getLibCodigo() + 1 + "");

				} catch (Exception epp) {

					JOptionPane.showMessageDialog(null, epp.getMessage());

				}

				tDescri.setText("");
				tEditorial.setText("");
				tAutor.setText("");
				tIsbn.setText("");
				tObse.setText("");

				tCodigo.setEditable(false);
				tDescri.setEditable(true);
				tDescri.requestFocus();
				tEditorial.setEditable(true);
				tAutor.setEditable(true);
				tIsbn.setEditable(true);
				tObse.setEditable(true);
								

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
		bNuevo.setBounds(410, 58, 91, 50);
		bNuevo.setBackground(Color.GRAY);
		bNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bNuevo);
		
		bModificar = new JButton("Modificar");
		bModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {



				bEliminar.setEnabled(false);
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
					tDescri.setEditable(true);
					tEditorial.setEditable(true);
					tAutor.setEditable(true);
					tIsbn.setEditable(true);
					tObse.setEditable(true);
					tDescri.requestFocus();
					

				}
				
				tBusqueda.setEnabled(false);
				

			
			
			}
		});
		bModificar.setBackground(Color.GRAY);
		bModificar.setBounds(410, 151, 91, 50);
		bModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bModificar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBackground(Color.GRAY);
		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				bEliminar.setEnabled(false);
				//bNuevo.setLabel("Agregar");
				bNuevo.setEnabled(false);
				bModificar.setEnabled(false);
				bCancelar.setEnabled(true);
				tBusqueda.setEnabled(false);

				String compara = tCodigo.getText();

				if (compara.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Seleccione un registro para eliminar ");
					bCancelar.doClick();
				} else {
					Libro libro = new Libro();

					libro.setLibCodigo(Integer.valueOf(tCodigo.getText()));

					int resp = JOptionPane.showConfirmDialog(
							bEliminar,
							"Desea eliminar el libro? " + "Codigo: "
									+ libro.getLibCodigo() + " "
									+ libro.getLibDescri(), "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION );
						
					if (resp == 0) {
						try {
							SessionLibros.eliminar(libro);
							JOptionPane.showMessageDialog(null,
									"Libro eliminado satisfactoriamente "
											+ libro.getLibDescri());

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
		bEliminar.setBounds(410, 243, 91, 50);
		bEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bEliminar);
		
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
				tDescri.setText("");
				tEditorial.setText("");
				tAutor.setText("");
				tIsbn.setText("");
				tObse.setText("");
				
				
				tDescri.setEditable(false);
				tEditorial.setEditable(false);
				tAutor.setEditable(false);
				tIsbn.setEditable(false);
				tObse.setEditable(false);
				
				
				table.clearSelection();
				table.setVisible(true);
				
				bNuevo.setLabel("Nuevo");
				bGuardar.setLabel("Guardar");
				
				tBusqueda.setEnabled(true);
				
				
				
				table.repaint();
				mostrarDatos();
				
			
			
			}
		});
		bCancelar.setBounds(783, 411, 91, 43);
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setEnabled(false);
		contentPane.add(bCancelar);
		
		bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {



				if (tDescri.getText().trim().isEmpty() || tEditorial.getText().isEmpty() 
					|| tAutor.getText().trim().isEmpty() || tIsbn.getText().trim().isEmpty() 
					|| tObse.getText().trim().isEmpty()) {
					JOptionPane
							.showMessageDialog(null,
									"Existen campos vacios. Complete antes de continuar");

					if (tDescri.getText().trim().isEmpty()) {

						tDescri.requestFocus();

					} else {
						
						if (tEditorial.getText().trim().isEmpty()) {
							bBusqueda.requestFocus();
						}else {
							if (tAutor.getText().trim().isEmpty()) {
								tAutor.requestFocus();
							}else {
								if (tIsbn.getText().trim().isEmpty()) {
									tIsbn.requestFocus();
								}else {
									if (tObse.getText().trim().isEmpty()) {
										tObse.requestFocus();
									}
								}
							}
						}
					}
				}else {
					
					Libro libro = new Libro();
					Editor editor = new Editor();
					editor.setEdiNumero(auxCodEditorial);
					
					
					libro.setLibDescri(tDescri.getText().trim());
					
					libro.setEditor(editor);
					libro.setLibAutor(tAutor.getText().trim());
					libro.setLibIsbn(tIsbn.getText().trim());
					libro.setLibObse(tObse.getText().trim());
					
					
					
					//JOptionPane.showMessageDialog(null,"" + tDescri.getText().trim());
					//JOptionPane.showMessageDialog(null,"" + tObse.getText().trim());

					if (bGuardar.getLabel().equals("Actualizar")) {

						libro.setLibCodigo(Integer.valueOf(tCodigo.getText()));

							try {
								Libro libroBuscar = SessionLibros.obtenerLibro(libro);
								
								if (libroBuscar != null) {
									SessionLibros.editar(libro);
									JOptionPane.showMessageDialog(null,"Libro actualizado");
								}					
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					if (bNuevo.getLabel().equals("Agregar")) {
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
		bGuardar.setBounds(661, 411, 91, 43);
		bGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar.setEnabled(false);
		contentPane.add(bGuardar);
		
		bSalir = new JButton("SALIR");
		bSalir.setBounds(783, 465, 91, 43);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(511, 22, 363, 378);
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(Color.GRAY, 2));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 36, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(10, 70, 71, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Editorial");
		lblNewLabel_2.setBounds(10, 131, 46, 14);
		panel.add(lblNewLabel_2);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 166, 46, 14);
		panel.add(lblAutor);
		
		lblIsbn = new JLabel("Isbn");
		lblIsbn.setBounds(10, 229, 46, 14);
		panel.add(lblIsbn);
		
		lblNewLabel_3 = new JLabel("Observaci\u00F3n");
		lblNewLabel_3.setBounds(10, 296, 79, 14);
		panel.add(lblNewLabel_3);
		
		tCodigo = new JTextField();
		tCodigo.setEditable(false);
		tCodigo.setBounds(91, 36, 216, 20);
		tCodigo.setBorder(null);
		panel.add(tCodigo);
		tCodigo.setColumns(10);
		
		tEditorial = new JTextField();
		tEditorial.setEditable(false);
		tEditorial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_F3) {
					
					bBusqueda.doClick();
				}
			}
		});
		tEditorial.setBounds(91, 131, 216, 20);
		tEditorial.setBorder(null);
		panel.add(tEditorial);
		tEditorial.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(91, 67, 216, 53);
		panel.add(scrollPane_1);
		
		tDescri = new JTextArea();
		tDescri.setEditable(false);
		tDescri.setLineWrap(true);
		scrollPane_1.setViewportView(tDescri);
		
		bBusqueda = new JButton("");
		bBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazTablaEditorial ite = new InterfazTablaEditorial();
				
				ite.setResizable(false);
				ite.setLocationRelativeTo(null);
				ite.setVisible(true);
				
			}
		});
		bBusqueda.setBounds(307, 127, 46, 31);
		bBusqueda.setIcon(new ImageIcon(AbmLibros.class.getResource("/imagen/glyphicons-28-search.png")));
		panel.add(bBusqueda);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(91, 166, 216, 50);
		panel.add(scrollPane_2);
		
		tAutor = new JTextArea();
		tAutor.setEditable(false);
		tAutor.setLineWrap(true);
		scrollPane_2.setViewportView(tAutor);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(91, 229, 216, 50);
		panel.add(scrollPane_3);
		
		tIsbn = new JTextArea();
		tIsbn.setEditable(false);
		tIsbn.setLineWrap(true);
		scrollPane_3.setViewportView(tIsbn);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(91, 296, 216, 53);
		panel.add(scrollPane_4);
		
		tObse = new JTextArea();
		tObse.setEditable(false);
		tObse.setLineWrap(true);
		scrollPane_4.setViewportView(tObse);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar.setBounds(22, 411, 46, 14);
		contentPane.add(lblBuscar);
		
		tBusqueda = new JTextField();
		tBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				modelo.setLibList(SessionLibros.obtenerListaLibroPorFiltro(tBusqueda.getText()
						.toUpperCase()));
				table.repaint();
			}
		});
		tBusqueda.setBounds(77, 408, 323, 23);
		contentPane.add(tBusqueda);
		tBusqueda.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 22, 378, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (bNuevo.getLabel().equals("Nuevo")) {
					fila = table.rowAtPoint(arg0.getPoint());
					if (fila > -1) {
						
						tCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						tDescri.setText(String.valueOf(table.getValueAt(fila, 1))
								.trim());
						tEditorial.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());
						tAutor.setText(String.valueOf(table.getValueAt(fila, 3)).trim());
						tIsbn.setText(String.valueOf(table.getValueAt(fila, 4)));
						tObse.setText(String.valueOf(table.getValueAt(fila, 5))
								.trim());
					}
				}
			}
		});
		table.setOpaque(false);
		table.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if (bNuevo.getLabel().equals("Nuevo")) {
					
					if (arg0.getKeyCode()== KeyEvent.VK_UP || arg0.getKeyCode()== KeyEvent.VK_DOWN) {
						
						fila = table.getSelectedRow();
						
						tCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						tDescri.setText(String.valueOf(table.getValueAt(fila, 1))
								.trim());
						tEditorial.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());
						tAutor.setText(String.valueOf(table.getValueAt(fila, 3)).trim());
						tIsbn.setText(String.valueOf(table.getValueAt(fila, 4)));
						tObse.setText(String.valueOf(table.getValueAt(fila, 5))
								.trim());
						
					}
					
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
					bNuevo.requestFocus();
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

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(150);
		columModel.getColumn(2).setPreferredWidth(80);
		columModel.getColumn(3).setPreferredWidth(150);
		columModel.getColumn(4).setPreferredWidth(80);
		columModel.getColumn(5).setPreferredWidth(150);

		modelo.setLibList(SessionLibros.obtenerListaLibro());
		
		
	}
	public JTextField getTEditorial() {
		return tEditorial;
	}
	public JTextArea getTObse() {
		return tObse;
	}
	public JTextArea getTDescri() {
		return tDescri;
	}
	public JTextField getTCodigo() {
		return tCodigo;
	}
	public JTextArea getTAutor() {
		return tAutor;
	}
	public JTextArea getTIsbn() {
		return tIsbn;
	}
	public JButton getBBusqueda() {
		return bBusqueda;
	}
}

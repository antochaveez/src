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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import session.SessionEditor;
import tableModale.EditorTableModel;
import entidad.Editor;

public class AbmEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;
	private EditorTableModel modelo = new EditorTableModel();
	private JTextField tCodigo;
	private int fila;
	private JTextField tBusqueda;
	private JButton bNuevo;
	private JButton bModificar;
	private JButton bEliminar;
	private JButton bSalir;
	private JButton bCancelar;
	private JButton bGuardar;

	private Fondito contentPane;
	private JScrollPane scrollPane_2;
	private JTextArea tDescri;
	private JTextArea tObse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbmEditor frame = new AbmEditor();
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
	public AbmEditor() {
		setTitle("Registrar Editorial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AbmEditor.class.getResource("/imagen/libros1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 452);
		contentPane = new Fondito("/imagen/fondo3.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 378, 359);
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
						tDescri.setText(String.valueOf(
								table.getValueAt(fila, 1)).trim());
						tObse.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());

					}
					if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
						bNuevo.requestFocus();
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
						tDescri.setText(String.valueOf(
								table.getValueAt(fila, 1)).trim());
						tObse.setText(String.valueOf(table.getValueAt(fila, 2))
								.trim());

					}
				}

			}
		});
		scrollPane.setViewportView(table);

		bSalir = new JButton("SALIR");
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		bSalir.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-389-exit.png")));
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		bSalir.setBounds(771, 364, 91, 43);
		contentPane.add(bSalir);

		tCodigo = new JTextField();
		tCodigo.setDisabledTextColor(Color.BLACK);
		tCodigo.setOpaque(false);
		tCodigo.setEnabled(false);
		tCodigo.setBounds(624, 21, 86, 23);
		contentPane.add(tCodigo);
		tCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigo.setBounds(525, 21, 46, 14);
		contentPane.add(lblCodigo);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(525, 83, 89, 14);
		contentPane.add(lblNewLabel);

		JLabel lblObservacin = new JLabel("Observaci\u00F3n");
		lblObservacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservacin.setBounds(525, 196, 89, 14);
		contentPane.add(lblObservacin);

		bNuevo = new JButton("Nuevo");
		bNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					bModificar.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bNuevo.doClick();
				}
			
			}
		});
		bNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		bNuevo.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-146-folder-plus.png")));
		bNuevo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				try {

					Editor editor = SessionEditor.irAlUltimo();
					tCodigo.setText(editor.getEdiNumero() + 1 + "");

				} catch (Exception epp) {

					JOptionPane.showMessageDialog(null, epp.getMessage());

				}

				tDescri.setText("");
				tObse.setText("");

				tCodigo.setEditable(false);
				tDescri.setEditable(true);
				tDescri.requestFocus();
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
		bNuevo.setBounds(410, 36, 91, 50);
		contentPane.add(bNuevo);

		bModificar = new JButton("Modificar");
		bModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				if (e.getKeyCode() == KeyEvent.VK_UP) {
					bNuevo.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					bEliminar.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bModificar.doClick();

				}
			
			}
		});
		bModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		bModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-149-folder-flag.png")));
		bModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				bEliminar.setEnabled(false);
				//bNuevo.setLabel("Agregar");
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
					tObse.setEditable(true);
					tDescri.requestFocus();
				}

				tBusqueda.setEnabled(false);

			}
		});
		bModificar.setBounds(410, 129, 91, 50);
		contentPane.add(bModificar);

		bEliminar = new JButton("Eliminar");
		bEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				if (e.getKeyCode() == KeyEvent.VK_UP) {
					bModificar.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					tBusqueda.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bEliminar.doClick();
				}
			
			}
		});
		bEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		bEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-147-folder-minus.png")));
		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				bEliminar.setEnabled(false);
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
					Editor editor = new Editor();

					editor.setEdiDescri(tDescri.getText().trim());
					editor.setEdiObse(tObse.getText().trim());

					editor.setEdiNumero(Integer.valueOf(tCodigo.getText()));

					int resp = JOptionPane.showConfirmDialog(
							bEliminar,
							"Desea eliminar la editorial? " + "Codigo: "
									+ editor.getEdiNumero() + " "
									+ editor.getEdiDescri(), "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION);

					if (resp == 0) {
						try {
							SessionEditor.eliminar(editor);
							JOptionPane.showMessageDialog(null,
									"Editorial ha sido eliminado satisfactoriamente"
											+ editor.getEdiNumero());

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Este registro no puede ser eliminado por"
									+ "\n que esta siendo utilizado por otra tabla");
					}

					}
					bCancelar.doClick();
					table.repaint();
					mostrarDatos();

				}
			}
		});
		bEliminar.setBounds(410, 221, 91, 50);
		contentPane.add(bEliminar);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar.setBounds(22, 384, 378, 23);
		contentPane.add(lblBuscar);

		tBusqueda = new JTextField();
		tBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				modelo.setEdList(SessionEditor
						.obtenerListaEditorPorFiltro(tBusqueda.getText()
								.toUpperCase()));
				table.repaint();

			}
		});
		tBusqueda.setBounds(87, 386, 313, 23);
		contentPane.add(tBusqueda);
		tBusqueda.setColumns(10);

		bCancelar = new JButton("Cancelar");
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-193-remove-sign.png")));
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
				tObse.setText("");

				tDescri.setEditable(false);
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
		bCancelar.setEnabled(false);
		bCancelar.setBounds(771, 304, 91, 43);
		contentPane.add(bCancelar);

		bGuardar = new JButton("Guardar");
		bGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar.setIcon(new ImageIcon(AbmEditor.class
				.getResource("/imagen/glyphicons-194-ok-sign.png")));
		bGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if (tDescri.getText().trim().isEmpty() || tObse.getText().trim().isEmpty()) {
					JOptionPane
							.showMessageDialog(null,
									"Existen campos vacios. Complete antes de continuar");

					if (tDescri.getText().trim().isEmpty()) {

						tDescri.requestFocus();

					} else {
						
						if (tObse.getText().trim().isEmpty()) {
							tObse.requestFocus();
						}
					}
				}else {
					
					Editor editor = new Editor();

					editor.setEdiDescri(tDescri.getText().trim());
					editor.setEdiObse(tObse.getText().trim());
					
					//JOptionPane.showMessageDialog(null,"" + tDescri.getText().trim());
					//JOptionPane.showMessageDialog(null,"" + tObse.getText().trim());

					if (bGuardar.getLabel().equals("Actualizar")) {

						editor.setEdiNumero(Integer.valueOf(tCodigo.getText()));

							try {
								Editor editorBuscar = SessionEditor.obtenerEditor(editor);
								
								if (editorBuscar != null) {
									SessionEditor.editar(editor);
									JOptionPane.showMessageDialog(null,"Editor actualizado");
								}					
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					if (bNuevo.getLabel().equals("Agregar")) {
						try {
							SessionEditor.insertar(editor);
							JOptionPane.showMessageDialog(null,"Editorial creado. Codigo = " + editor.getEdiNumero());
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

		bSalir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					bCancelar.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tObse.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bSalir.doClick();
				}
			}
		});
		bCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					bSalir.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					bGuardar.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tObse.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					bCancelar.doClick();
				}

			}
		});

		bGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					bCancelar.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tObse.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					bGuardar.doClick();
				}
			}
		});
		bGuardar.setEnabled(false);

		bGuardar.setBounds(649, 304, 91, 43);
		contentPane.add(bGuardar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(624, 83, 238, 83);
		contentPane.add(scrollPane_1);

		tDescri = new JTextArea();
		tDescri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
					tObse.requestFocus();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
					tObse.requestFocus();

				}

				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					if (tDescri.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Ingrese Descripci�n, campo obligatorio");
						tDescri.requestFocus();

					} else {
						tObse.setEnabled(true);
						tObse.requestFocus();
					}

				}
			
			}
		});
		tDescri.setEditable(false);
		tDescri.setLineWrap(true);
		scrollPane_1.setViewportView(tDescri);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(624, 196, 238, 83);
		contentPane.add(scrollPane_2);

		tObse = new JTextArea();
		tObse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tDescri.requestFocus();

				}
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					bGuardar.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					bGuardar.requestFocus();

				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (tObse.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Ingrese Observaci�n, campo obligatorio");
						tObse.requestFocus();

					} else {
						bGuardar.setEnabled(true);
						bGuardar.requestFocus();
					}

				}
			
			}
		});
		tObse.setEditable(false);
		tObse.setLineWrap(true);
		scrollPane_2.setViewportView(tObse);
		mostrarDatos();
	}

	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(150);
		columModel.getColumn(2).setPreferredWidth(150);

		modelo.setEdList(SessionEditor.obtenerListaEditor());
	}

	public JButton getBNuevo() {
		return bNuevo;
	}

	public JButton getBModificar() {
		return bModificar;
	}

	public JButton getBEliminar() {
		return bEliminar;
	}

	public JButton getBSalir() {
		return bSalir;
	}

	public JTextField getTCodigo() {
		return tCodigo;
	}

	public JTextField getTBusqueda() {
		return tBusqueda;
	}

	public JButton getBCancelar() {
		return bCancelar;
	}

	public JButton getBGuardar() {
		return bGuardar;
	}

	public JTextArea getTDescri() {
		return tDescri;
	}

	public JTextArea getTObse() {
		return tObse;
	}
}

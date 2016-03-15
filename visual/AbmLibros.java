package visual;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

import session.SessionLibros;
import tableModale.LibroTableModel;

public class AbmLibros extends JFrame {

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
	private JTextField tEditorial;
	private JTextField tAutor;
	private JEditorPane tObse;
	private JTable table;
	private JEditorPane tDescri;
	private JEditorPane tIsbn;
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 70, 378, 359);
		contentPane.add(scrollPane);
		
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
		
		scrollPane.setViewportView(table);
		mostrarDatos();
		
		
		bNuevo = new JButton("Nuevo");
		bNuevo.setBounds(410, 109, 91, 50);
		bNuevo.setBackground(Color.RED);
		bNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bNuevo);
		
		bModificar = new JButton("Modificar");
		bModificar.setBounds(410, 202, 91, 50);
		bModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bModificar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBounds(410, 294, 91, 50);
		bEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bEliminar);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(769, 454, 91, 43);
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setEnabled(false);
		contentPane.add(bCancelar);
		
		bGuardar = new JButton("Guardar");
		bGuardar.setBounds(647, 454, 91, 43);
		bGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		bGuardar.setEnabled(false);
		contentPane.add(bGuardar);
		
		bSalir = new JButton("SALIR");
		bSalir.setBounds(769, 508, 91, 43);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(bSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(511, 70, 363, 359);
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
		lblIsbn.setBounds(10, 200, 46, 14);
		panel.add(lblIsbn);
		
		lblNewLabel_3 = new JLabel("Observaci\u00F3n");
		lblNewLabel_3.setBounds(10, 264, 79, 14);
		panel.add(lblNewLabel_3);
		
		tCodigo = new JTextField();
		tCodigo.setBorder(null);
		tCodigo.setBounds(96, 36, 257, 20);
		panel.add(tCodigo);
		tCodigo.setColumns(10);
		
		tEditorial = new JTextField();
		tEditorial.setBorder(null);
		tEditorial.setBounds(96, 131, 257, 20);
		panel.add(tEditorial);
		tEditorial.setColumns(10);
		
		tAutor = new JTextField();
		tAutor.setBorder(null);
		tAutor.setBounds(96, 166, 257, 20);
		panel.add(tAutor);
		tAutor.setColumns(10);
		
		tDescri = new JEditorPane();
		tDescri.setBorder(null);
		tDescri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()== 9) {
					tEditorial.requestFocus();
				}
			}
		});
		tDescri.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tDescri.setBounds(95, 67, 258, 53);
		panel.add(tDescri);
		
		tIsbn = new JEditorPane();
		tIsbn.setBorder(null);
		tIsbn.setBounds(96, 197, 257, 53);
		panel.add(tIsbn);
		
		tObse = new JEditorPane();
		tObse.setBorder(null);
		tObse.setBounds(95, 261, 258, 53);
		panel.add(tObse);
	}
	
	@SuppressWarnings("unused")
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
	public JEditorPane getTDescri() {
		return tDescri;
	}
	public JTextField getTEditorial() {
		return tEditorial;
	}
	public JTextField getTAutor() {
		return tAutor;
	}
	public JEditorPane getTIsbn() {
		return tIsbn;
	}
	public JEditorPane getTObse() {
		return tObse;
	}
}

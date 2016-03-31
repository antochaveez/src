package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import session.SessionEditor;
import tableModale.EditorTableModel;

public class InterfazTablaEditorial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private EditorTableModel modelo = new EditorTableModel();
	private JTextField tBusqueda;
	private int fila;
	static InterfazTablaEditorial dialogTablaEditorial;
	private JButton bOk;
	private JButton bCancel;
	private JButton bRegistrarEditorial;
	private JButton bActualizar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialogTablaEditorial = new InterfazTablaEditorial();
			dialogTablaEditorial.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialogTablaEditorial.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InterfazTablaEditorial() {
		setTitle("Editoriales");
		setBounds(100, 100, 537, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBuscar.setBounds(10, 396, 54, 14);
			contentPanel.add(lblBuscar);
		}
		{
			tBusqueda = new JTextField();
			tBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					modelo.setEdList(SessionEditor.obtenerListaEditorPorFiltro(tBusqueda.getText()
									.toUpperCase()));
					table.repaint();

				}
			});
			tBusqueda.setBounds(59, 394, 285, 23);
			contentPanel.add(tBusqueda);
			tBusqueda.setColumns(10);
		}
		{
			bActualizar = new JButton("Actualizar Tabla");
			bActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table.repaint();
					mostrarDatos();
					
				}
			});
			bActualizar.setBounds(372, 392, 139, 24);
			contentPanel.add(bActualizar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				bOk = new JButton("OK");
				bOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				bOk.setActionCommand("OK");
				buttonPane.add(bOk);
				getRootPane().setDefaultButton(bOk);
			}
			{
				bCancel = new JButton("Cancel");
				bCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AbmLibros.tEditorial.setText("");
					
						dispose();
						
					}
				});
				bCancel.setActionCommand("Cancel");
				buttonPane.add(bCancel);
			}
			{
				bRegistrarEditorial = new JButton("Registrar Editorial");
				bRegistrarEditorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						AbmEditor abmEditor = new AbmEditor();
						abmEditor.setSize(900, 452);
						abmEditor.setResizable(false);
						abmEditor.setLocationRelativeTo(null);
						//abmEditor.setAlwaysOnTop(true);
						abmEditor.setVisible(true);
					
					}
				});
				buttonPane.add(bRegistrarEditorial);
			}
		}
		{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 521, 381);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					fila = table.rowAtPoint(arg0.getPoint());

					if (fila > -1) {
						
							AbmLibros.auxCodEditorial = (int) table.getValueAt(fila, 0);
							AbmLibros.tEditorial.setText(String.valueOf(table.getValueAt(fila, 1)));

					}
					if (arg0.getClickCount() == 2) {
						bOk.doClick();
					}
					
				}
			});
			table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					try {
						if ((arg0.getKeyCode() == 38) || (arg0.getKeyCode() == 40)) {

							fila = table.getSelectedRow();
							
							AbmLibros.auxCodEditorial = (int) table.getValueAt(fila, 0);
							AbmLibros.tEditorial.setText(String.valueOf(table.getValueAt(fila, 1)));
							
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						bOk.doClick();
					}
				}
			});
			
			mostrarDatos();
			scrollPane.setViewportView(table);
		}
		}
	
	}
	
	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(200);
		columModel.getColumn(2).setPreferredWidth(200);

		modelo.setEdList(SessionEditor.obtenerListaEditor());
	}
	public JButton getBOk() {
		return bOk;
	}
	public JButton getBCancel() {
		return bCancel;
	}
	public JButton getBRegistrarEditorial() {
		return bRegistrarEditorial;
	}
	public JButton getBActualizar() {
		return bActualizar;
	}
	public JTextField getTBusqueda() {
		return tBusqueda;
	}
}

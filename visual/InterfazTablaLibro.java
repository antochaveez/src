package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import visual.RegistrarPrestamo;

import session.SessionLibros;
import tableModale.LibroTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class InterfazTablaLibro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private LibroTableModel modelo = new LibroTableModel();
	private JTextField tBusqueda;
	private JButton cancelButton;
	private JButton bOk;
	private int fila;
	private int codigo;
	private String descri;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InterfazTablaLibro dialog = new InterfazTablaLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InterfazTablaLibro() {
		setBounds(100, 100, 800, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 774, 332);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					fila = table.rowAtPoint(arg0.getPoint());

					if (fila > -1) {
						
							RegistrarPrestamo.auxCodLibro =((int) table.getValueAt(fila, 0));
							RegistrarPrestamo.tLibro.setText(String.valueOf(table.getValueAt(fila, 1)));
							//JOptionPane.showMessageDialog(null, RegistrarPrestamo.getAuxCodLector());
							
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
							
							RegistrarPrestamo.auxCodLibro = (int) table.getValueAt(fila, 0);
							//RegistrarPrestamo.auxLibroDescri = (String) table.getValueAt(fila, 1);
							//RegistrarPrestamo.tLibro.setText(RegistrarPrestamo.auxLibroDescri);
							RegistrarPrestamo.tLibro.setText(String.valueOf(table.getValueAt(fila, 1)));
							//JOptionPane.showMessageDialog(null, RegistrarPrestamo.auxCodLibro);
							//JOptionPane.showMessageDialog(null, RegistrarPrestamo.tLibro.getText().trim());
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
		{
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBuscar.setBounds(10, 354, 53, 22);
			contentPanel.add(lblBuscar);
		}
		{
			tBusqueda = new JTextField();
			tBusqueda.setBounds(55, 354, 380, 22);
			contentPanel.add(tBusqueda);
			tBusqueda.setColumns(10);
		}
		{
			JButton bActualizar = new JButton("Actualizar Tabla");
			bActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table.repaint();
					mostrarDatos();
				}
			});
			bActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			bActualizar.setBounds(553, 354, 139, 26);
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
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegistrarPrestamo.tLibro.setText("");
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	
	}
	
	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(150);
		columModel.getColumn(2).setPreferredWidth(150);
		columModel.getColumn(3).setPreferredWidth(150);
		columModel.getColumn(4).setPreferredWidth(80);
		columModel.getColumn(5).setPreferredWidth(150);
		//columModel.getColumn(6).setPreferredWidth(80);

		modelo.setLibList(SessionLibros.obtenerListaLibro());
		
		
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public JTextField getTBusqueda() {
		return tBusqueda;
	}
	public JButton getOkButton() {
		return bOk;
	}
}

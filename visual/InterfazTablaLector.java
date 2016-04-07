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

import session.SessionLector;
import tableModale.LectorTableModel;

public class InterfazTablaLector extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField tBusqueda;
	private int fila;
	private JButton cancelButton;
	private JButton bOk;
	private JButton bActualizar;
	private JButton bRegistrarLector;
	private LectorTableModel modelo = new LectorTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InterfazTablaLector dialog = new InterfazTablaLector();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InterfazTablaLector() {
		setBounds(100, 100, 756, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		
		{
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBuscar.setBounds(10, 369, 52, 27);
			contentPanel.add(lblBuscar);
		}
		{
			tBusqueda = new JTextField();
			tBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					modelo.setLecList(SessionLector.obtenerListaLectorPorFiltro(tBusqueda.getText()
							.toUpperCase()));
					table.repaint();
				}
			});
			tBusqueda.setBounds(56, 370, 386, 27);
			contentPanel.add(tBusqueda);
			tBusqueda.setColumns(10);
		}
		{
			bActualizar = new JButton("Actualizar Tabla");
			bActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					table.repaint();
					mostrarDatos();
				}
			});
			bActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			bActualizar.setBounds(530, 370, 139, 26);
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
						//RegistrarPrestamo.bBusquedaLibro.requestFocus();
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
					public void actionPerformed(ActionEvent e) {
						RegistrarPrestamo.tLector.setText("");
						
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				bRegistrarLector = new JButton("Registrar Lector");
				bRegistrarLector.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						
						AbmLector abmLector= new AbmLector();
						abmLector.setSize(900, 500);
						abmLector.setResizable(false);
						abmLector.setLocationRelativeTo(null);
						//abmEditor.setAlwaysOnTop(true);
						abmLector.setVisible(true);
					
					
					}
				});
				buttonPane.add(bRegistrarLector);
			}
	
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 730, 358);
		contentPanel.add(scrollPane);
		{
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				
				try {
					if ((arg0.getKeyCode() == 38) || (arg0.getKeyCode() == 40)) {

						fila = table.getSelectedRow();
						RegistrarPrestamo.auxCodLector = (int) table.getValueAt(fila, 0);
						//visual.RegistrarPrestamo.setAuxCodLector((int) table.getValueAt(fila, 0));
						RegistrarPrestamo.tLector.setText(String.valueOf(table.getValueAt(fila, 1)));
						//JOptionPane.showMessageDialog(null, RegistrarPrestamo.getAuxCodLector());
						
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					bOk.doClick();
				}
			 
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				
				fila = table.rowAtPoint(arg0.getPoint());

				if (fila > -1) {
					
						RegistrarPrestamo.auxCodLector =((int) table.getValueAt(fila, 0));
						RegistrarPrestamo.tLector.setText(String.valueOf(table.getValueAt(fila, 1)));
						//JOptionPane.showMessageDialog(null, RegistrarPrestamo.getAuxCodLector());
						
				}
				if (arg0.getClickCount() == 2) {
					bOk.doClick();
				}
				
			
			}
		});
		mostrarDatos();
		scrollPane.setViewportView(table);
		}
		
	}
	private void mostrarDatos() {

		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columModel = table.getColumnModel();

		columModel.getColumn(0).setPreferredWidth(80);
		columModel.getColumn(1).setPreferredWidth(230);
		columModel.getColumn(2).setPreferredWidth(80);
		columModel.getColumn(3).setPreferredWidth(230);
		columModel.getColumn(4).setPreferredWidth(100);

		modelo.setLecList(SessionLector.obtenerListaLector());
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
	public JButton getBOk() {
		return bOk;
	}
	public JTextField getTBusqueda() {
		return tBusqueda;
	}
	public JButton getBActualizar() {
		return bActualizar;
	}
	public JButton getBRegistrarLector() {
		return bRegistrarLector;
	}
}

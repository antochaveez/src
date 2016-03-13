package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

public class MenuPrincipal extends JFrame {

	private Fondito contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					Dimension screanSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					// muestra en pantalla la resolucion actual
					//JOptionPane.showMessageDialog(null, screanSize);
					// Dimensiona la pantalla a la resolucion actual
					frame.setSize(screanSize);
					// para centrar la pantalla
					frame.setLocationRelativeTo(null);
					// para la barra de titlulo
					frame.setUndecorated(false);// true no muestra, false muestra
					frame.setEnabled(true);
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagen/libros1.png")));
		setTitle("BIBLIOTECA");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new Fondito("/imagen/images.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 21);
		contentPane.add(menuBar);
		
		JMenu mnPr = new JMenu("Pr\u00E9stamo");
		menuBar.add(mnPr);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Pr\u00E9stamos");
		mnPr.add(mntmRegistrar);
		
		JMenu mnTablas = new JMenu("Tablas");
		menuBar.add(mnTablas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Libros");
		mnTablas.add(mntmNewMenuItem);
		
		JMenuItem mntmLector = new JMenuItem("Lector");
		mnTablas.add(mntmLector);
		
		JMenuItem mntmEditorial = new JMenuItem("Editorial");
		mntmEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbmEditor abmEditor = new AbmEditor();
				abmEditor.setSize(800, 600);
				abmEditor.setResizable(false);
				abmEditor.setLocationRelativeTo(null);
				//abmEditor.setAlwaysOnTop(true);
				abmEditor.setVisible(true);
			}
		});
		mnTablas.add(mntmEditorial);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmInformes = new JMenuItem("Listado de Libros");
		mnInformes.add(mntmInformes);
		
		JMenuItem mntmListadoDeLector = new JMenuItem("Listado de Lector");
		mnInformes.add(mntmListadoDeLector);
		
		JMenuItem mntmListadoDeEditorial = new JMenuItem("Listado de Editorial");
		mnInformes.add(mntmListadoDeEditorial);
		
		JMenuItem mntmInformeDePrestamos = new JMenuItem("Informe de Pr\u00E9stamos");
		mnInformes.add(mntmInformeDePrestamos);
		
		JMenuItem mntmInformeDeDeudas = new JMenuItem("Informe de Deudas");
		mnInformes.add(mntmInformeDeDeudas);
		
		JMenu mnUtilidades = new JMenu("Utilidades");
		menuBar.add(mnUtilidades);
		
		JMenuItem mntmInicializacionDeDatos = new JMenuItem("Inicializaci\u00F3n de Datos");
		mnUtilidades.add(mntmInicializacionDeDatos);
		
		JMenuItem mntmConfiguraciones = new JMenuItem("Configuraciones");
		mnUtilidades.add(mntmConfiguraciones);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorderPainted(false);
		toolBar.setOpaque(false);
		toolBar.setBounds(0, 25, 1350, 60);
		contentPane.add(toolBar);
		
		JButton button = new JButton("Pr\u00E9stamo");
		toolBar.add(button);
		button.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-319-more-items.png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton button_2 = new JButton("Lector");
		button_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-527-user-conversation.png")));
		button_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(button_2);
		
		JButton button_1 = new JButton("Libros");
		button_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-72-book.png")));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(button_1);
		
		JButton button_3 = new JButton("Salir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-389-exit.png")));
		button_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(button_3);
	}
}

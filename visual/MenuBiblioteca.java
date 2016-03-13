package visual;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuBiblioteca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fondito contentPane;
	

	
	private JFrame frmBibliotecaUneVersion;
	private JButton btnSalir;
	private JButton btnLector;
	private JButton btnLibro;
	private JButton btnPrestamo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBiblioteca window = new MenuBiblioteca();
					window.frmBibliotecaUneVersion.setResizable(false);
					window.frmBibliotecaUneVersion.setLocationRelativeTo(null);
		
					window.frmBibliotecaUneVersion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuBiblioteca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaUneVersion = new JFrame();
		frmBibliotecaUneVersion.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuBiblioteca.class.getResource("/imagen/images.jpg")));
		frmBibliotecaUneVersion.setType(Type.POPUP);
		frmBibliotecaUneVersion.setTitle("BIBLIOTECA UNE");
		frmBibliotecaUneVersion.setBounds(100, 100, 1366, 768);
		frmBibliotecaUneVersion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new Fondito("/imagen/images.jpg");
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmBibliotecaUneVersion.setJMenuBar(menuBar);
		
		JMenu mnProceso = new JMenu("Proceso");
		menuBar.add(mnProceso);
		
		JMenuItem mntmRegistrarPrstamos = new JMenuItem("Registrar Pr\u00E9stamos");
		mnProceso.add(mntmRegistrarPrstamos);
		
		JMenu mnTabla = new JMenu("Tablas");
		menuBar.add(mnTabla);
		
		JMenuItem mntmLibros = new JMenuItem("Libros");
		mnTabla.add(mntmLibros);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lector");
		mnTabla.add(mntmNewMenuItem);
		
		JMenuItem mntmEditorial = new JMenuItem("Editorial");
		mntmEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbmEditor abmEditor = new AbmEditor();
				abmEditor.setSize(800, 600);
				abmEditor.setResizable(false);
				abmEditor.setLocationRelativeTo(null);
				abmEditor.setAlwaysOnTop(true);
				abmEditor.setVisible(true);
				
				//frmBibliotecaUneVersion.setEnabled(false);
				
			}
		});
		mnTabla.add(mntmEditorial);
		
		JMenu mnNewMenu = new JMenu("Informes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Libros");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmListadoDeLector = new JMenuItem("Listado de Lector");
		mnNewMenu.add(mntmListadoDeLector);
		
		JMenuItem mntmListado = new JMenuItem("Listado de Editorial");
		mnNewMenu.add(mntmListado);
		
		JMenuItem mntmInformes = new JMenuItem("Informes de Pr\u00E9stamos");
		mnNewMenu.add(mntmInformes);
		
		JMenuItem mntmInformesDeDeudas = new JMenuItem("Informes de Deudas");
		mnNewMenu.add(mntmInformesDeDeudas);
		
		JMenu mnUtilidades = new JMenu("Utilidades");
		menuBar.add(mnUtilidades);
		
		JMenuItem mntmInicializ = new JMenuItem("Inicializaci\u00F3n de Datos");
		mnUtilidades.add(mntmInicializ);
		
		JMenuItem mntmConfiguraciones = new JMenuItem("Configuraciones");
		mnUtilidades.add(mntmConfiguraciones);
		
	;
		frmBibliotecaUneVersion.getContentPane().setLayout(null);
		
		btnPrestamo = new JButton("Pr\u00E9stamo");
		btnPrestamo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPrestamo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrestamo.setIcon(new ImageIcon(MenuBiblioteca.class.getResource("/imagen/glyphicons-319-more-items.png")));
		btnPrestamo.setBounds(0, 0, 95, 60);
		frmBibliotecaUneVersion.getContentPane().add(btnPrestamo);
		
		btnLibro = new JButton("Libros");
		btnLibro.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLibro.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLibro.setIcon(new ImageIcon(MenuBiblioteca.class.getResource("/imagen/glyphicons-72-book.png")));
		btnLibro.setBounds(101, 0, 95, 60);
		frmBibliotecaUneVersion.getContentPane().add(btnLibro);
		
		btnLector = new JButton("Lector");
		btnLector.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLector.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLector.setIcon(new ImageIcon(MenuBiblioteca.class.getResource("/imagen/glyphicons-527-user-conversation.png")));
		btnLector.setBounds(202, 0, 95, 60);
		frmBibliotecaUneVersion.getContentPane().add(btnLector);
		
		btnSalir = new JButton("Salir");
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setIcon(new ImageIcon(MenuBiblioteca.class.getResource("/imagen/glyphicons-389-exit.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnSalir.setBounds(301, 0, 95, 60);
		frmBibliotecaUneVersion.getContentPane().add(btnSalir);
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JButton getBtnLector() {
		return btnLector;
	}
	public JButton getBtnLibro() {
		return btnLibro;
	}
	public JButton getBtnPrestamo() {
		return btnPrestamo;
	}
}

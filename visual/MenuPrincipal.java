package visual;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setTitle("BIBLIOTECA    V. 1.5");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new Fondito("/imagen/fondo2.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 21);
		contentPane.add(menuBar);
		
		JMenu mnPr = new JMenu("Pr\u00E9stamo");
		mnPr.setMnemonic('P');
		menuBar.add(mnPr);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Pr\u00E9stamos");
		mnPr.add(mntmRegistrar);
		
		JMenu mnTablas = new JMenu("Tablas");
		mnTablas.setMnemonic('T');
		menuBar.add(mnTablas);
		
		final JMenuItem mntmNewMenuItem = new JMenuItem("Libros");
		mntmNewMenuItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mntmNewMenuItem.doClick();
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbmLibros abmLibro = new AbmLibros();
				abmLibro.setSize(900, 560);
				abmLibro.setResizable(false);
				abmLibro.setLocationRelativeTo(null);
				abmLibro.setVisible(true);
			}
		});
		mntmNewMenuItem.setMnemonic('L');
		mnTablas.add(mntmNewMenuItem);
		
		final JMenuItem mntmLector = new JMenuItem("Lector");
		mntmLector.setMnemonic('e');
		mntmLector.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					mntmLector.doClick();
					
				}
			}
		});
		mntmLector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbmLector abmLector = new AbmLector();
				abmLector.setSize(900, 500);
				abmLector.setResizable(false);
				abmLector.setLocationRelativeTo(null);
				abmLector.setVisible(true);
				
			}
		});
		mnTablas.add(mntmLector);
		
		JMenuItem mntmEditorial = new JMenuItem("Editorial");
		mntmEditorial.setMnemonic('d');
		mntmEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbmEditor abmEditor = new AbmEditor();
				abmEditor.setSize(900, 452);
				abmEditor.setResizable(false);
				abmEditor.setLocationRelativeTo(null);
				//abmEditor.setAlwaysOnTop(true);
				abmEditor.setVisible(true);
			}
		});
		mnTablas.add(mntmEditorial);
		
		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setMnemonic('I');
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
		mnUtilidades.setMnemonic('U');
		menuBar.add(mnUtilidades);
		
		JMenuItem mntmInicializacionDeDatos = new JMenuItem("Inicializaci\u00F3n de Datos");
		mnUtilidades.add(mntmInicializacionDeDatos);
		
		JMenuItem mntmConfiguraciones = new JMenuItem("Configuraciones");
		mntmConfiguraciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				Configuracion config = new Configuracion();
				config.setSize(550, 350);
				config.setResizable(false);
				config.setLocationRelativeTo(null);
				config.setVisible(true);
            }
        });
		mnUtilidades.add(mntmConfiguraciones);
		
		JButton bPrestamo = new JButton("Pr\u00E9stamo");
		bPrestamo.setBackground(Color.GRAY);
		bPrestamo.setForeground(Color.BLACK);
		bPrestamo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bPrestamo.setBorder(new EmptyBorder(0, 0, 0, 0));
		bPrestamo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bPrestamo.setHorizontalTextPosition(SwingConstants.CENTER);
		bPrestamo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-319-more-items.png")));
		bPrestamo.setBounds(0, 25, 125, 71);
		contentPane.add(bPrestamo);
		
		final JButton bLibros = new JButton("Libros");
		bLibros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					bLibros.doClick();
				}
				
			}
		});
		bLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbmLibros abmLibro = new AbmLibros();
				abmLibro.setSize(900, 560);
				abmLibro.setResizable(false);
				abmLibro.setLocationRelativeTo(null);
				abmLibro.setVisible(true);
			}
		});
		bLibros.setBackground(Color.GRAY);
		bLibros.setForeground(Color.BLACK);
		bLibros.setHorizontalTextPosition(SwingConstants.CENTER);
		bLibros.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLibros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-72-book.png")));
		bLibros.setBounds(0, 94, 125, 71);
		contentPane.add(bLibros);
		
		final JButton bLector = new JButton("Lector");
		bLector.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					bLector.doClick();
				}
			}
		});
		bLector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbmLector abmLector = new AbmLector();
				abmLector.setSize(900, 500);
				abmLector.setResizable(false);
				abmLector.setLocationRelativeTo(null);
				abmLector.setVisible(true);
			}
		});
		bLector.setBackground(Color.GRAY);
		bLector.setForeground(Color.BLACK);
		bLector.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLector.setHorizontalTextPosition(SwingConstants.CENTER);
		bLector.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-527-user-conversation.png")));
		bLector.setBounds(0, 164, 125, 71);
		contentPane.add(bLector);
		
		JButton bSalir = new JButton("Salir");
		bSalir.setBackground(Color.GRAY);
		bSalir.setForeground(Color.BLACK);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-389-exit.png")));
		bSalir.setBounds(0, 234, 125, 71);
		contentPane.add(bSalir);
	}
}

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
import java.awt.Rectangle;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;

import entidad.Config;

import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

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
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new Fondito("/imagen/fondo.jpg");
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
				abmEditor.setSize(900, 600);
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
		mntmConfiguraciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				Configuracion config = new Configuracion();
				config.setSize(900, 600);
				config.setResizable(false);
				config.setLocationRelativeTo(null);
				config.setVisible(true);
            }
        });
		mnUtilidades.add(mntmConfiguraciones);
		
		JButton bPrestamo = new JButton("Pr\u00E9stamo");
		bPrestamo.setForeground(Color.LIGHT_GRAY);
		bPrestamo.setBorderPainted(false);
		bPrestamo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bPrestamo.setBorder(new EmptyBorder(0, 0, 0, 0));
		bPrestamo.setVerticalTextPosition(SwingConstants.BOTTOM);
		bPrestamo.setHorizontalTextPosition(SwingConstants.CENTER);
		bPrestamo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-319-more-items.png")));
		bPrestamo.setBounds(0, 25, 125, 71);
		contentPane.add(bPrestamo);
		
		JButton bLibros = new JButton("Libros");
		bLibros.setForeground(Color.LIGHT_GRAY);
		bLibros.setBorderPainted(false);
		bLibros.setHorizontalTextPosition(SwingConstants.CENTER);
		bLibros.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLibros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-72-book.png")));
		bLibros.setBounds(0, 94, 125, 71);
		contentPane.add(bLibros);
		
		JButton bLector = new JButton("Lector");
		bLector.setForeground(Color.LIGHT_GRAY);
		bLector.setBorderPainted(false);
		bLector.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLector.setHorizontalTextPosition(SwingConstants.CENTER);
		bLector.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-527-user-conversation.png")));
		bLector.setBounds(0, 164, 125, 71);
		contentPane.add(bLector);
		
		JButton bSalir = new JButton("Salir");
		bSalir.setForeground(Color.LIGHT_GRAY);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bSalir.setBorderPainted(false);
		bSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		bSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagen/glyphicons-389-exit.png")));
		bSalir.setBounds(0, 234, 125, 71);
		contentPane.add(bSalir);
	}
}

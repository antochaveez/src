package test;

import entidad.Config;
import session.SessionInicializacion;
import session.SessionConfiguracion;

public class PruebaConfiguracion {

    public static void main(String[] args) throws Exception {
        
        //pruebaInsertar();
        //pruebaModificar();
        //pruebaObtener();
        //pruebaCambiarConfiguracion();
        //pruebaObtener();
        //pruebaTruncadoParcial();
        pruebaTruncadoTotal();
    }
    
    @SuppressWarnings("unused")
    private static void pruebaInsertar() throws Exception {
        Config config = new Config();
        
        config.setCfgDeumor(500);
        config.setCfgDiamor(9);
        config.setCfgDiapre(5);
        config.setCfgOrga("UNE");
        
        
        SessionConfiguracion.insertar(config);
        
    }
    
        
    @SuppressWarnings("unused")
    private static void pruebaModificar() throws Exception {
        
        Config config = new Config("UNE", 6000, 5, 9);
         
    
        SessionConfiguracion.editar(config);
    }
    
    @SuppressWarnings("unused")
    private static void pruebaObtener() throws Exception {
        
        // Si existe la confifuracion
        if (SessionConfiguracion.existeConfiguracion()){
            Config config = SessionConfiguracion.obtenerConfiguracion();
            System.out.println(config.getCfgOrga());
        }else{
            System.out.println("No existe configuracion");
        }

        
    }
    
    @SuppressWarnings("unused")
    private static void pruebaCambiarConfiguracion() throws Exception{
        Config config = new Config();
        config.setCfgOrga("Poli");
        config.setCfgDeumor(5);
        config.setCfgDiamor(5);
        config.setCfgDiapre(8);
        SessionConfiguracion.cambiarConfiguracion(config);
    }

    @SuppressWarnings("unused")
    private static void pruebaTruncadoParcial() throws Exception{
        SessionInicializacion.truncadoParcial();
    }
    
    private static void pruebaTruncadoTotal() throws Exception{
        SessionInicializacion.truncadoTotal();
    }

    
}

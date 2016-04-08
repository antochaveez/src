package test;

import entidad.Config;
import entidad.Editor;
import entidad.Lector;
import entidad.Libro;
import session.SessionConfiguracion;
import session.SessionEditor;
import session.SessionLector;

public class CargaDeTablas {

    static private Editor[] editoriales = {
            new Editor(null, "edi_aaa", "Editorial1"),
            new Editor(null, "edi_bbb", "Editorial2"),
            new Editor(null, "edi_ccc", "Editorial3"),
            new Editor(null, "edi_ddd", "Editorial4"),
            new Editor(null, "edi_eee", "Editorial5"),
            new Editor(null, "edi_fff", "Editorial6"),
            new Editor(null, "edi_ggg", "Editorial7"),
            new Editor(null, "edi_hhh", "Editorial8"),
            new Editor(null, "edi_iii", "Editorial9"),
            new Editor(null, "edi_jjj", "Editorial10"),
            new Editor(null, "edi_kkk", "Editorial11"),
            new Editor(null, "edi_lll", "Editorial12"),
            new Editor(null, "edi_mmm", "Editorial13"),
            new Editor(null, "edi_nnn", "Editorial14"),
            new Editor(null, "edi_ooo", "Editorial15"),
            new Editor(null, "edi_ppp", "Editorial16"),
            new Editor(null, "edi_qqq", "Editorial17"),
            new Editor(null, "edi_rrr", "Editorial18"),
    };

    static private Lector[] lectores = {
            new Lector(null, "lec_aaa", 1548987, "direccion1", "000"),
            new Lector(null, "lec_bbb", 1256487, "direccion2", "111"),
            new Lector(null, "lec_ccc", 2458921, "direccion3", "222"),
            new Lector(null, "lec_ddd", 5879531, "direccion4", "333"),
            new Lector(null, "lec_eee", 3254861, "direccion5", "444"),
            new Lector(null, "lec_fff", 543897, "direccion6", "555"),
            new Lector(null, "lec_ggg", 154893, "direccion7", "000"),
            new Lector(null, "lec_hhh", 589348, "direccion8", "666"),
            new Lector(null, "lec_iii", 3438755, "direccion9", "777"),
            new Lector(null, "lec_jjj", 1258744, "direccion10", "888"),
            new Lector(null, "lec_kkk", 6257822, "direccion11", "999"),
            new Lector(null, "lec_lll", 4657895, "direccion12", "1111"),
            new Lector(null, "lec_mmm", 4823897, "direccion13", "2222"),
            new Lector(null, "lec_nnn", 2587957, "direccion14", "3333"),
            new Lector(null, "lec_ooo", 6549846, "direccion15", "44444"),
            new Lector(null, "lec_ppp", 3484951, "direccion16", "5555"),
            new Lector(null, "lec_qqq", 3216565, "direccion17", "6666"),
            new Lector(null, "lec_rrr", 1654654, "direccion18", "7777")
    };
    
    static private Libro[] libros = {
            new Libro(null, "lib_aaa", new Editor(), "autor1", "01235", "observacion1")
    };

    public static void main(String args[]) throws Exception{
        poblarLector(lectores.length);
    }

    public static void poblarLector(int cantidadDeRegistros) throws Exception{
        for (int registroNro = 0; registroNro < cantidadDeRegistros; registroNro++){
            SessionLector.insertar(lectores[registroNro]);
        }
    }

    public static void poblarEditor(int cantidadDeRegistros) throws Exception{

        for (int registroNro = 0; registroNro < cantidadDeRegistros; registroNro++){
            SessionEditor.insertar(editoriales[registroNro]);
        }
    }

    public static void poblarConfiguracion() throws Exception{
        Config config = new Config("Politecnica", 5000, 2, 7, "pass");
        SessionConfiguracion.cambiarConfiguracion(config);
        System.out.println("Configuracion creada.");
    }
    
    public static void poblarLibro(int cantidadDeRegistros){
        
        
    }
}

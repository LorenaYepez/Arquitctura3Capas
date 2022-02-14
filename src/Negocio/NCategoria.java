/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DCategoria;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johny
 */
public class NCategoria {
    private DCategoria dCategoria;

    public NCategoria() {
        dCategoria = new DCategoria();
    }

    public void listar (JTable tabla) {
        
        try {
            ( ( DefaultTableModel ) tabla.getModel() ).setRowCount( 0 ); // limpiamos la tabla
                ArrayList< Object > list = (ArrayList< Object >) (Object) dCategoria.listar();
                Object[] tupla = new Object[ 2 ];
                for ( Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                    DCategoria dCat = ( DCategoria ) it.next();
                    tupla[ 0 ] = dCat.getId();
                    tupla[ 1 ] = dCat.getNombre();
                    ( ( DefaultTableModel ) tabla.getModel() ).addRow( tupla );
                }
        } catch (Exception e) {
            System.out.println( "error listar categorias - NCategoria..." + e.getMessage() );
        }
    }
}

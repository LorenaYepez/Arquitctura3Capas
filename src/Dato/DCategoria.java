package Dato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johny
 */
public class DCategoria {
    
    private int id;
    private String nombre;
    
    public DCategoria() {
    }

    public DCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<DCategoria> listar(){
        ArrayList<DCategoria> lista = new ArrayList<>();
        String sql = "SELECT idCategoria, Nombre FROM categoria ORDER BY idCategoria";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                DCategoria cate = new DCategoria();
                cate.id = rs.getInt("idCategoria");
                cate.nombre = rs.getString("Nombre");
                lista.add(cate);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println("DCategoria - Lista " + ex.getMessage());
            return new ArrayList<>();
        }        
    }
    
    

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lumia
 */
public class Farmacia {
    private DataAccess dataAccess = DataAccess.Instance();
    private int idFarmacia;
    private String nombreF;
    private String direccion;
    private String telefono;

    public Farmacia(){
        
    }

    public Farmacia(int idFarmacia, String nombreF, String direccion, String telefono) {
        this.idFarmacia = idFarmacia;
        this.nombreF = nombreF;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM farmacias";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM farmacias WHERE idFarmacia = " + idFarmacia;
        DefaultTableModel res = dataAccess.Query(query);
        idFarmacia = (int) res.getValueAt(0, 0);
        nombreF = (String) res.getValueAt(0, 1);
        direccion = (String) res.getValueAt(0, 2);
        telefono = (String) res.getValueAt(0, 3);
    }
    
    public boolean Add(){
        String query = "INSERT INTO farmacias(nombreF, direccion, telefono) " 
                + "VALUES('" + nombreF + "','" + direccion + "','" + telefono + "');";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE farmacias SET " + 
                "nombreF = '" + nombreF + "'," +
                "direccion = '" + direccion + "'," +
                "telefono = '" + telefono + "'" +
                "WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author student
 */
public class Employee {
    private int id;
    private String name;
    private String job;
    private int age;
    private int sex;
    private int salary;
    DBHelper dataBase;
    
    Employee(  ) {
        dataBase = new DBHelper();
    }
       
    
    Employee( int id ) {
        this.id = id;
        dataBase = new DBHelper();
        
    }
    
    public void getFromDB( int id ) {
        dataBase.printRow(id);
        
    }
    
    public void insert() {
        dataBase.insertDefaultRow();
    }
    
    public int delete() {
        
        return dataBase.deleteRow(this.id);
    }
    
    
    public int update() {
        
        return dataBase.updateRow(this.id);
    }
    
}

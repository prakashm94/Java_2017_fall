/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.EcoSystem;

/**
 *
 * @author sonal
 */
public class Employee {
    
    private String name;
    private int id;
    private static int count = 1;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();

    public Employee() {
        if(eCount==0){
            eCount=system.employeeidCount;
        }
        id = ++eCount;
        system.employeeidCount= eCount;
        
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

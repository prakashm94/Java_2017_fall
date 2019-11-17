/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Country.OpioidMedication;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class SupplierDirectory {
    private ArrayList<Supplier> supplierList;
    private String name;
    
    public SupplierDirectory(){
        supplierList= new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
     public Supplier addSupplier() {
        Supplier supplier = new Supplier();
        supplierList.add(supplier);
        return supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Removing an Employee from the Directory
    public void removeSupplier(Supplier supplier) {
        supplierList.remove(supplier);
    }
    
}

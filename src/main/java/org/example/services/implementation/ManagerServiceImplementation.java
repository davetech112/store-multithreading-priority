package org.example.services.implementation;

import org.example.Exceptions.CriteriaException;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.enums.Roles;
import org.example.services.ManagerService;

import java.util.Random;

public class ManagerServiceImplementation implements ManagerService {
//    @Override
//    public void hireApplicant(User manager, User applicant, Store store) throws CriteriaException {
//        if(manager.getRole() == Roles.MANAGER && applicant.getRole() == Roles.APPLICANT){
//            for(User a : store.getApplicantList()){
//                if(a.getId().equals(applicant.getId())){
//                    Random random = new Random();
//                    int x = random.nextInt(900) + 100;
//                    User cashier = new User(a.getName(), Roles.CASHIER, "CASH" + x, store);
//                    store.setCashierList(cashier);
//                    store.getApplicantList().remove(applicant);
//                    System.out.println("You have successfully hired " + a.getName() + " to your store "
//                            + store.getName() + " with staffID " + cashier.getId());
//                    return;
//                }
//            }
//            System.out.println(applicant.getName() + " is not an applicant");
//        } else{
//            throw new CriteriaException("Unauthorized operation");
////            System.out.println("unauthorized operation");
//        }
//    }
@Override
public void hireApplicant(User manager, User applicant, Store store)  {
    if(manager.getRole() == Roles.MANAGER && applicant.getRole() == Roles.APPLICANT){
        for(User a : store.getApplicantList()){
            if(a.getId().equals(applicant.getId())){
                Random random = new Random();
                int x = random.nextInt(900) + 100;
                User cashier = new User(a.getName(), Roles.CASHIER, "CASH" + x, store);
                store.setCashierList(cashier);
                store.getApplicantList().remove(applicant);
                System.out.println("You have successfully hired " + a.getName() + " to your store "
                        + store.getName() + " with staffID " + cashier.getId());
                return;
            }
        }
        System.out.println(applicant.getName() + " is not an applicant");
    } else{

           System.out.println("unauthorized operation");
    }
}
    public void fireCashier(User manager, String name, Store store){
        if(manager.getRole() == Roles.MANAGER){
            for(User a : store.getCashierList()){
                if(a.getName().equals(name)){
                    store.getCashierList().remove(a);
                    System.out.println("You have successfully sacked " + a.getName() + " as a cashier.");
                return;
                }
            }
            System.out.println("No staff with name "+ name);
        } else {
            System.out.println("Unauthorized access");
        }
    }
    public void setApplicantList(User applicant, Store store){
        store.getApplicantList().add(applicant);
    }
    public void setCashierList(User cashier, Store store){
        store.getCashierList().add(cashier);
    }
    public void setStoreProduct(User manager, Product product, Store store){
        if(manager.getRole() == Roles.MANAGER) {
            store.getProductList().add(product);

        } else {
            System.out.println("Unauthorized access");
        }
    }
}

package org.example.services;

import org.example.Exceptions.CriteriaException;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;

public interface ManagerService {
    void hireApplicant(User manager, User applicant, Store store) throws CriteriaException;
    //void hireApplicant(User manager, User applicant, Store store) throws CriteriaException;
    void fireCashier(User manager, String id, Store store);
    void setApplicantList(User applicant, Store store);
    void setStoreProduct(User manager, Product product, Store store);
    void setCashierList(User cashier, Store store);

}

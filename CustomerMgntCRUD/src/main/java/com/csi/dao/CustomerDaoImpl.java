package com.csi.dao;

import com.csi.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void save(Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
    }

    @Override
    public List<Customer> findAll() {

        Session session = factory.openSession();
        return session.createQuery("from Customer").list();
    }

    @Override
    public Customer findById(int custId) {

        Session session = factory.openSession();


        return (Customer) session.get(Customer.class, custId);
    }

    @Override
    public void update(int custId, Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        Customer customer1 = findById(custId);

        customer1.setCustName(customer.getCustName());

        customer1.setCustAddress(customer.getCustAddress());

        customer1.setCustContactNumber(customer.getCustContactNumber());

        customer1.setCustAccountBalance(customer.getCustAccountBalance());

        customer1.setCustEmailId(customer.getCustEmailId());

        customer1.setCustPassword(customer.getCustPassword());

        customer1.setCustDOB(customer.getCustDOB());

        session.update(customer1);

        transaction.commit();

    }

    @Override
    public void deleteById(int custId) {
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        Customer customer1 = findById(custId);

        session.delete(customer1);

        transaction.commit();
    }
}

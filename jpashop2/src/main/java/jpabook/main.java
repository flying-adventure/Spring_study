package jpabook;
import java.util.List;
import jakarta.persistence.*;
import jpabook.jpashop.domain.*;


public class main
{
   public static void main(String[] args){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       tx.begin();

       try{
           Order order = new Order();
           em.persist(order);

           OrderItem orderItem = new OrderItem();
           orderItem.setOrder(order);
           em.persist(orderItem);
           
           tx.commit();
       }catch(Exception e){
           tx.rollback();
       }finally{
           em.close();
       }
       emf.close();
   }
}

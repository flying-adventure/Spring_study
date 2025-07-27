package hellojpa;

import jakarta.persistence.*;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Member member = new Member();
            member.setId(1L);
            member.setUsername("A");
            member.setRoleType(RoleType.ADMIN);
            em.persist(member);


            Member member2 = new Member();
            member2.setId(2L);
            member2.setUsername("B");
            member2.setRoleType(RoleType.USER);
            em.persist(member2);

            Member member3 = new Member();
            member3.setId(3L);
            member3.setUsername("C");
            member3.setRoleType(RoleType.GUEST);
            em.persist(member3);



            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}

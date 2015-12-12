package co.hodler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.hodler.model.Sample;

public class Example {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("sample");
    EntityManager em = factory.createEntityManager();

    em.getTransaction().begin();
    Sample s = new Sample();
    s.setText("foo");
    em.persist(s);
    em.getTransaction().commit();

    Sample sample = em.find(Sample.class, 1);
    System.out.println(sample.getText());

    em.close();
  }
}

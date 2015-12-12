package co.hodler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import co.hodler.model.App;
import co.hodler.model.AppVersion;

public class PersistenceTest {
  @Test
  public void testName() throws Exception {
    EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("sample");
    EntityManager em = factory.createEntityManager();

    AppVersion appVersion = new AppVersion();
    App app = new App();
    app.addToVersions(appVersion);
    app.setText("asdf");

    em.getTransaction().begin();
    em.persist(app);
    em.getTransaction().commit();

    em.getTransaction().begin();
    App storedApp = em.find(App.class, 1);
    em.remove(storedApp);
    em.getTransaction().commit();

    AppVersion storedAppVersion = em.find(AppVersion.class, 1);
    assertThat(storedAppVersion, is(nullValue()));

    em.close();
  }

}

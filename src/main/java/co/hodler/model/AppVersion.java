package co.hodler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AppVersion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "app_id")
  private App app;

  public App getApp() {
    return app;
  }

  public void setApp(final App app) {
    this.app = app;
    if (!app.getVersions().contains(this)) {
      app.getVersions().add(this);
    }
  }
}

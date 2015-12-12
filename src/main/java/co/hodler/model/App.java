package co.hodler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class App {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String text;

  @OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
  private Set<AppVersion> versions = new HashSet<>();

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Set<AppVersion> getVersions() {
    return versions;
  }

  public void addToVersions(final AppVersion version) {
    versions.add(version);
    if (version.getApp() != this) {
      version.setApp(this);
    }
  }

}

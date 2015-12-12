package co.hodler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}

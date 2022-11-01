package org.acme;

import javax.persistence.*;

@Entity(name = "slaves")
@Table(name = "slaves")
public class Slave {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @OneToOne(fetch = FetchType.LAZY)
  Master master;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Master getMaster() {
    return master;
  }

  public void setMaster(Master master) {
    this.master = master;
  }
}

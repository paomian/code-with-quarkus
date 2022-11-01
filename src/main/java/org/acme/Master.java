package org.acme;


import javax.persistence.*;

@Entity(name = "masters")
@Table(name = "masters")
public class Master {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @OneToOne(fetch = FetchType.LAZY,mappedBy = "master",cascade=CascadeType.ALL)
  Slave slave;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Slave getSlave() {
    return slave;
  }

  public void setSlave(Slave slave) {
    this.slave = slave;
  }
}

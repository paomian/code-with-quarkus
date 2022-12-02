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
  
  @Enumerated
  @Column(name = "credential_type")
  private CredentialType credentialType;
  
  public enum CredentialType {
    USERNAME,
    APP_KEY,
  }

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

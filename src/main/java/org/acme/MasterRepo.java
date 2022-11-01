package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MasterRepo implements PanacheRepository<Master> {
}

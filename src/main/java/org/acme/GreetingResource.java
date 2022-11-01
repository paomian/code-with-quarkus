package org.acme;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
  @Inject
  MasterRepo masterRepo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
      var master = new Master();
      var slave = new Slave();
      master.slave = slave;
      slave.master = master;
      return masterRepo.persistAndFlush(master).
        map(master1 -> master1.getId().toString());
    }

    @GET
  @Path("/world/{masterId}")
  public Uni<String> world(@PathParam("masterId") Long masterId) {
      return masterRepo.findById(masterId).flatMap(master ->
          Mutiny.fetch(master.getSlave())
        )
        .map(slave ->
          slave.getId().toString()
        );
    }
}

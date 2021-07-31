package com.github.juandiii;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.SseElementType;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ServerEventResource {

  Store store = new Store();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<Set<String>> getUni() {
    return Multi.createFrom()
        .iterable(Arrays.asList("Coffee", "Coffee from Colombia"))
        .collect()
        .asList()
        .map(HashSet::new);
  }

  @GET
  @Path("/test")
  @Produces(MediaType.SERVER_SENT_EVENTS)
  @SseElementType(MediaType.APPLICATION_JSON)
  public Multi<String> stream() {

    Random random = new Random();

    return Multi.createFrom()
        .ticks()
        .every(Duration.ofSeconds(1L))
        .flatMap(u -> Multi.createFrom()
            .iterable(store.getCoffees()))
        .onItem()
        .call(i -> Uni.createFrom()
            .nullItem()
            .onItem()
            .delayIt()
            .by(Duration.ofMillis(500L)))
        .onItem()
        .transform(e -> {
          int rnd = random.ints(0, store.getShops()
              .size())
              .findFirst()
              .getAsInt();
          return String.format("Entregando el café de %s al lugar %s", e.name, store.getShops()
              .get(rnd).name);
        });

  }
}

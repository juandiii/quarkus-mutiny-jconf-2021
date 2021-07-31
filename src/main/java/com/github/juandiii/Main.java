package com.github.juandiii;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

  public static void main(String... args) {

    Store store = new Store();

    System.out.println("Running main method");
    Quarkus.run(args);

//    Multi.createFrom().ticks()
//      .every(Duration.ofMillis(500L))
//      .flatMap(u -> Uni.createFrom().item(store.getCoffees())
//        .onItem()
//        .transformToMulti(l -> Multi.createFrom().iterable(l))
//        .onItem()
//        .transform(e -> e.name))
//       .collect()
//      .asList()
//      .map(HashSet::new)
//      .subscribe()
//      .with(e -> System.out.println(e));
  }
}

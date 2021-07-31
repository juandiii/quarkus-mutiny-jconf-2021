package com.github.juandiii;

import java.util.ArrayList;
import java.util.List;

import com.github.juandiii.models.Coffee;
import com.github.juandiii.models.Shop;

public class Store {

  private List<Coffee> coffees = new ArrayList<>();
  private List<Shop> shops = new ArrayList<>();

  public Store() {
    Coffee coffee1 = new Coffee();
    coffee1.name = "Coffee Regular";
    coffee1.place = "Colombia";
    coffees.add(coffee1);

    Coffee coffee2 = new Coffee();
    coffee2.name = "Coffee Puro Colombiano";
    coffee2.place = "Colombia";
    coffees.add(coffee2);

    Shop shop1 = new Shop();
    shop1.name = "Café Santo Domingo";
    shops.add(shop1);

    Shop shop2 = new Shop();
    shop2.name = "Juan Valdéz Café";
    shops.add(shop2);

  }

  public List<Coffee> getCoffees() {
    return coffees;
  }

  public Store setCoffees(List<Coffee> coffees) {
    this.coffees = coffees;
    return this;
  }

  public List<Shop> getShops() {
    return shops;
  }
}

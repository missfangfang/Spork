<img src="https://scontent-sjc3-1.xx.fbcdn.net/v/t39.30808-6/301635369_463436085796753_3762222909261700207_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=UkaRt_ysAL4AX_17kAT&_nc_ht=scontent-sjc3-1.xx&oh=00_AfCUj53IXoDaV9a-lnk3ifLm2M5UkkMSbYFErBTqx_MUUQ&oe=640867F9" width="100" height="100" align="top"> 

# Spork

```mermaid
---
title: Project Structure
---
flowchart LR
  id1{{Client}} 
  id2(Register)
  id3(Login)
  id4{Decision}
  id5(Home Page)
  id6(Menus)
  id7(Add item to cart)
  id8(Checkout)
  id9[(Database)]
  id1-->id2
  id1-->id3
  id3-->id4-->|Yes|id5
  id4-->|No|id3
  id5-->id6 & id7 & id8--> id9
  id2------>id9
```


```mermaid
---
title: Entity Relationship Diagram
---
classDiagram
  class Authorities {
    email
    authorities
  }
  class Customer {
    email
    firstName
    lastName
    password
    enabled
    cartId(FK)
  }
  class Cart {
    id
    totalPrice
  }
  class OrderItem {
    id
    quantity
    price
    menuItem_id(FK)
    cart_id(FK)
  }
  class MenuItem {
    id
    name
    price
    description
    restaurant_id(FK)
  }
  class Restaurant {
    id
    address
    name
    phone
    imageUrl
  }  
  Cart -- "1 : n" OrderItem
  Restaurant -- "1 : n" MenuItem
  Customer -- "1 : 1" Cart 
  OrderItem -- "n : 1" MenuItem
```


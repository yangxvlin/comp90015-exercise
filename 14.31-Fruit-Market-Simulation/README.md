# fruit market simulation

## how to run
1. args: 5 5 5 5

or


2. no args

## example
### example input
```java
FruitMarket fruitMarket = new FruitMarket(capacity);
CustomerTransaction c1 = new CustomerTransaction(new Apple(1), fruitMarket);
CustomerTransaction c2 = new CustomerTransaction(new Grape(3), fruitMarket);
CustomerTransaction c3 = new CustomerTransaction(new Orange(3), fruitMarket);
FarmerTransaction f1 = new FarmerTransaction(new Apple(2), fruitMarket);
FarmerTransaction f2 = new FarmerTransaction(new Orange(1), fruitMarket);
```

### example output
```
Using default capacity: [5, 5, 5, 5]
Farmer sell Apple (2)
Before: Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (0), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (0)}
After : Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (2), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (0)}
Customer buy Apple (1)
Before: Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (2), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (0)}
After : Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (1), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (0)}
Farmer sell Orange (1)
Before: Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (1), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (0)}
After : Fruit Market::{Apple=5, Watermelon=5, Grape=5, Orange=5}::{Apple=Apple (1), Watermelon=Watermelon (0), Grape=Grape (0), Orange=Orange (1)}

Process finished with exit code -1
```
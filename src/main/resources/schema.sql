drop table if exists orders;
CREATE TABLE orders (
  id INTEGER PRIMARY KEY,
  user_id INTEGER NOT NULL);


drop table if exists product;
CREATE TABLE product (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL ,
  price  INTEGER  ,
  product_type VARCHAR(64) ,
  order_id INTEGER REFERENCES orders(id));
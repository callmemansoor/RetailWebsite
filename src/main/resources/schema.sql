drop table if exists customer;
CREATE TABLE customer (
  id INTEGER PRIMARY KEY ,
  name VARCHAR(64) NOT NULL ,
  reg_date date,
  role VARCHAR(64) NOT NULL
  );


drop table if exists orders;
CREATE TABLE orders (
  id INTEGER PRIMARY KEY,
  order_price DOUBLE NOT NULL,
  order_date date,
  customer_id INTEGER REFERENCES customer(id)
  );


drop table if exists product;
CREATE TABLE product (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL ,
  price  INTEGER  ,
  product_type VARCHAR(64) ,
  order_id INTEGER REFERENCES orders(id)
  );
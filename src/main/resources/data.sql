INSERT INTO brands (name)
VALUES ('ZARA');

INSERT INTO products (id)
VALUES (35455);

INSERT INTO prices (currency,end_date,price,priority,start_date,brand_id,product_id)
VALUES ('EUR','2020-12-31 23:59:59',35.50,0,'2020-06-14',1,35455),
       ('EUR','2020-06-14 18:30:00',25.45,1,'2020-06-14 15:00:00',1,35455),
       ('EUR','2020-06-15 11:00:00',35.50,1,'2020-06-15 00:00:00',1,35455),
       ('EUR','2020-12-31 23:59:59',38.95,1,'2020-06-15 16:00:00',1,35455);
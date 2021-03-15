-- Query1
select OrderID,Order_date,Amount from orders order by order_date desc ;

-- Query2
select * from orders order by Amount desc limit 5;

-- Query3
select * from orders where Order_date<'2021-3-5' && Order_status="not shipped";

-- Query4
select Shopper.ShopperID,Name,Order_date from Shopper,orders where Order_date>'2021-2-01' && Shopper.ShopperID=orders.ShopperID group by ShopperID;

-- Query5
select Shopper.ShopperID,Name,Order_date from Shopper,orders where Order_date>'2021-3-01' && Shopper.ShopperID=orders.ShopperID group by Shopper.ShopperID;

-- Query6
select * from orders where OrderID=1020 && Order_status="shipped";

-- Query7
select * from orders where Amount between 20 and 50;
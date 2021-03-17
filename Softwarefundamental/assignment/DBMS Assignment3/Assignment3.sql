-- Query1
select Name,Age,MobileNo ,count(s.Name) as 'No. of orders' from shopper as s,orders as o where s.ShopperID=o.ShopperID and o.Order_date>'2021-2-10' group by s.Name;

-- Query2
select Name,Amount from shopper as s, orders as o where s.ShopperID=o.ShopperID order by Amount desc limit 10;

-- Query3
select p.ProductID, p.Title ,o.OrderNumber ,count(p.ProductID) as 'No. of product' from product as p,orders as o where p.ProductID=o.ProductID and o.Order_date>'2021-1-1' group by p.ProductID order by count(p.ProductID) desc;

-- Query4
select Order_date,sum(Amount) from orders where Order_date>'2020-8-1'  group by (Order_date) ;

-- Query5
update orders set Order_status="Inactive" where Order_date>'2021-1-1'; 

-- Query6
select Name from categories where Name like 'E%';

-- Query7
select p.ProductID,p.Title from product as p , orders as o where p.ProductID=o.ProductID and o.Order_status="canceled" order by count(o.order_status="canceled") limit 10;
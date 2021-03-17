use storefront;

-- Query1
create view Order_info as select p.ProductID,p.Title,p.Price,
                                s.Name,s.MobileNo,
                                o.Order_date,o.Order_status 
                                from product as p ,
                                    shopper as s,
                                    orders as o
                                where s.ShopperID=o.ShopperID and o.ProductID=p.ProductID and o.order_date>'2021-2-1';
-- Query2                                    
select Title from order_info where order_status="shipped";

-- Query3
select Title,count(ProductID)  from order_info group by ProductID order by count(ProductID) desc; 

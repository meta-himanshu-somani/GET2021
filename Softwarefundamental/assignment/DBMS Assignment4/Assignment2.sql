-- Query1
delimiter //
create procedure avgSalesOfProduct(month int , year int)
Begin
    select avg(Amount),ProductID from orders where order_date like '2021-02%' group by ProductID; 
End//

delimiter ;

call avgSalesOfProduct(02,2021);

-- Query2
delimiter //

create procedure orderStatus(Start_date date , End_date date)
Begin

if  (Start_date<=End_date)  

    select Order_status from orders where Order_date between Start_date and End_date;

else
    
    select Order_status from orders where Order_date between '2021-2-1' and End_date;
End//
delimiter ;
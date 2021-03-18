-- Query1
select Order_date from orders where order_date like "2021%01%";
delimiter //

Create procedure orderByMonth @month int , @year int

BEGIN
select Order_date from orders where Order_date like "@year%@month%";
End
//
delimiter ;
call orderByMonth(01,2021);
-- Query2

delimiter //

Create procedure maxOrderInMonth( year int)
Begin
    Declare maxMonthOrder int(4);
    select  order_date,count(ProductID) from orders where order_date like '2021%'  group by order_date ;
End//
delimiter ;

call maxOrderInMonth(2021);

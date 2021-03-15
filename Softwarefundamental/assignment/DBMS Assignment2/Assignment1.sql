create database StoreFront;
use StoreFront;
create table Product(ProductID int(5),
                    Name varchar(100),
                    Price float8 ,
                    Type varchar(10)
                    );
create table Shopper(ShopperID int(5) primary key not null,
                    Name varchar(100),
                    Age int(5),
                    MobileNo int(10),
                    Address longtext
                    );
                    
create table Orders(OrderID int(10) primary key not null,
                    OrderNumber int(10) not null,
                    ShopperID int(5),
                    Order_date date,
                    Amount float8,
                    Order_status varchar(20),
                    Total_item int(5),
                    foreign key(ShopperID) references Shopper(ShopperID)
                    );
                    
show tables;

drop table Orders;

create table Product(ProductID int(5),
                    Title varchar(100),
                    Quantity int(5),
                    Price float8 ,
                    Parent_category_title varchar(100),
                    Category_title varchar(10),
                    Images longtext,
                    Product_info longtext
                    );
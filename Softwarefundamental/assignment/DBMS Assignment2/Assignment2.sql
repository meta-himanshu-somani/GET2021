-- Query1
insert into product values(1,"Oppo f1",20,20000,"Mobiles","Oppo",1,"best amera phone");
insert into product values(2,"Oppo f19 pro",32,21400,"Mobiles","Oppo",1,"8 GB RAM,fluid black");
insert into product values(3,"Oppo A31",10,12000,"Mobiles","Oppo",1,"Mystery black,6GB RAM");
insert into product values(4,"Oppo A52",43,14990,"Mobiles","Oppo",1,"Twilight black, 6GB RAM, 128GB Storage");
insert into product values(5,"Redmi 9 power",45,10200,"Mobiles","Xiome",1,"Mighty black 4GB RAM, 64GB storage");
insert into product values(6,"Redmi 9",20,8800,"Mobiles","Xiome",1,"Carbon black 4GB RAM, 64GB storage");
insert into product values(7,"Redmi 9 pro",50,12999,"Mobiles","Xiome",1,"Installer black 4GB RAM, 64GB storage");
insert into product values(8,"MI Redmi 6A",55,6999,"Mobiles","Xiome",1,"Black 2GB RAM, 16GB storage");
insert into product values(9,"Xevier T-shirt",8,699,"T-shirt","Clothing",0,"white with circles at center of T-shirt");
insert into product values(10,"Xento T-shirt",10,599,"T-shirt","Clothing",0,"blue with white horizontal strips at top of T-shirt");

insert into shopper values(1,"Aakash Sinha",22,90123456,"delhi prtapnagar"),
                            (2,"Ajay sinMobileNogh",35,87054632,"Kota"),
                            (3,"Bikash vendar",56,78690531,"Madhya pradesh"),
                            (4,"Cheteshwar pujara",26,79987697,"Delhi"),
                            (5,"Dinesh kartik",28,89067976,"Mumbai"),
                            (6,"Elesh mishra",34,79805969,"Gujrat");
                            
insert into orders values(1,1011,2,'2020-5-12',20000,"shipped",1),
                            (2,1023,2,'2020-6-12',50,"shipped",1),
                            (3,1020,4,'2021-3-12',25,"not shipped",1),
                            (4,1014,4,'2021-2-10',3000,"shipped",2),
                            (5,1015,1,'2021-2-14',25,"shipped",1),
                            (6,1016,1,'2021-2-15',10,"shipped",1),
                            (7,1025,6,'2021-3-15',20112,"not shipped",1),
                            (8,1001,6,'2021-1-13',19,"canceled",1);
insert into orders values(9,1022,3,'2021-1-26',45,"not shipped",1);
-- Query2

select ProductID,Title,Category_title,Price from product order by ProductID desc limit 4;

-- Query3

select Title from product where Images=1;

-- Query4

select ProductID,Title,Parent_category_title from product order by Parent_category_title,Category_title; 

-- Query6

select Title,Price,Product_info from product where Parent_category_title="Mobiles";

-- Query7

select * from product where Quantity<50;
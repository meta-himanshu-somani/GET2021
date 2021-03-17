create database Map;
use Map;

create table ZipCode(Zipcode int(10) primary key not null,
                     City_name varchar(10),
                     StateID int(10) ,
                     foreign key (StateID) references States(StateID));

create table States(StateID int(10) primary key not null,
                    Name varchar(15));
                    
insert into States values (1,"Andhra"),(2,"Delhi"),(3,"Punjab"),
                            (4,"Maharashtra"),(5,"Rajasthan");
                            
insert into ZipCode values (1121,"abc",1),(1122,"abcd",1),(1123,"abcde",1),
                            (1124,"efg",2),(1125,"hij",3),(1129,"jkl",2),
                            (1126,"abcd",3),(1127,"abcdd",4),(1128,"abcdde",5);
                            
select Zipcode,City_name,Name from ZipCode as z,States as s where s.StateID=z.StateID order by Name , City_name;
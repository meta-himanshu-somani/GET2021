-- Query1
select ProductID,Title,Count(c.ID) from product as p,categories as c where c.Name=p.Parent_category_title;

-- Query2
select Price as 'Range in Rs', Count(ProductID) as Count from product where Price between 0 and 100;
select Price as 'Range in Rs', Count(ProductID) as Count from product where Price between 101 and 500;
select Price as 'Range in Rs', Count(ProductID) as Count from product where Price >500;

-- Query3
select Parent_category_title as 'Category' ,count(ProductID) as 'NO. of products' from product Group by Parent_category_title;
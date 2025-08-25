# Write your MySQL query statement below
Select product_id from Products 
WHERE (low_fats ="Y") AND (recyclable = "Y")
GROUP BY product_id
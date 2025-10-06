# Write your MySQL query statement below
SELECT euni.unique_id,e.name from Employees e
Left join EmployeeUNI euni
ON e.id=euni.id ;

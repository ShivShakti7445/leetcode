# Write your MySQL query statement below
-- select unique_id,name  from Employees inner join EmployeeUNI on Employees.id= EmployeeUNI.id 
SELECT  COALESCE(EmployeeUNI.unique_id, NULL)AS unique_id ,name
FROM Employees
LEFT JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id;

# 8/17/2021
# Write your MySQL query statement below

# Use IFNULL and LIMIT clause
SELECT
    IFNULL(
        (SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
                LIMIT 1 OFFSET 1),
        NULL
    ) AS SecondHighestSalary
# Write your MySQL query statement below

# join 2 tables
# There might not be an address info for every person, use outer join

select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;
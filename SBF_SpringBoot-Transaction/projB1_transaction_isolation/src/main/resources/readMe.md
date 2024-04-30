

# To Test SQL Queries

```
use practice;

show tables;

create table product(pid int primary key, price decimal(50,2), quantity int );

describe product;

insert into product values (1,50,2), (2,25,7);

select * from product;

update product set price=5 where pid = 2;

 select pid, price*quantity as cost from product where pid =2;

set session transaction isolation level repeatable read;

set session transaction isolation level serializable;
```


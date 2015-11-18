select *
from product p
inner join (
	select product_id, SUM(quantity) AS num_sold
	from orders
	where dispatch_date > DATE_SUB(NOW(), interval 1 YEAR)
	group by product_id
) s
on s.product_id = p.product_id
where p.available_from < DATE_SUB(NOW(), interval 1 MONTH) and num_sold < 10;
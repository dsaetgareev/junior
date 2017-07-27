--select all roles where role_name  = 'admin';
SELECT roles.role_id, roles.role_name, rights.right_name, users.login, users.password, users.create_date
FROM roles JOIN rights ON roles.role_id = rights.role_id
JOIN users ON roles.role_id = users.role_id
WHERE roles.role_name = 'admin';

--select all item in JULE 2017;
SELECT items.item_id, items.date, category.cat_name, statuses.status_name, users.login
FROM items JOIN category ON items.cat_id = category.cat_id
JOIN statuses ON items.status_id = statuses.status_id
JOIN users ON items.user_id = users.user_id
WHERE items.date BETWEEN '2017-07-01 00:00:00' AND '2017-08-01 00:00:00';

--select all items where cat_name LIKE '%task%';
SELECT * FROM items JOIN category ON items.cat_id = category.cat_id
WHERE cat_name LIKE '%task%';
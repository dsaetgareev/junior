INSERT INTO roles(role_name) VALUES('admin');
INSERT INTO rights(right_name, role_id) VALUES('full', 1);
INSERT INTO users(login, password, create_date, role_id) VALUES('admin', '123', '2017-07-21 02:32:22', 1);
INSERT INTO category(cat_name) VALUES('task');
INSERT INTO statuses(status_name) VALUES('new');
INSERT INTO items(date, status_id, user_id, cat_id) VALUES('2017-07-21 13:23:12', 1, 1, 1);
INSERT INTO comments(comment, item_id) VALUES('new comment', 1);
INSERT INTO att_files(file_path, item_id) VALUES ('/home', 1);


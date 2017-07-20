CREATE TABLE roles (
  role_id SERIAL PRIMARY KEY,
  role_name VARCHAR(100)
);

CREATE TABLE rights (
  right_id SERIAL PRIMARY KEY,
  right_name VARCHAR(100),
  role_id INTEGER REFERENCES roles(role_id)
);

CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  login VARCHAR(100),
  password VARCHAR(100),
  create_date TIMESTAMP,
  role_id INTEGER REFERENCES roles(role_id)
);

CREATE TABLE statuses (
  status_id SERIAL PRIMARY KEY,
  status_name VARCHAR(100)
);

CREATE TABLE category (
  cat_id SERIAL PRIMARY KEY,
  cat_name VARCHAR(100)
);

CREATE TABLE items (
  item_id SERIAL PRIMARY KEY,
  date TIMESTAMP,
  status_id INTEGER REFERENCES statuses(status_id),
  user_id INTEGER REFERENCES users(user_id),
  cat_id INTEGER REFERENCES category(cat_id)
);

CREATE TABLE att_files (
  file_id SERIAL PRIMARY KEY,
  file_path VARCHAR(100),
  item_id INTEGER REFERENCES items(item_id)
);

CREATE TABLE comments (
  comment_id SERIAL PRIMARY KEY,
  comment VARCHAR(100),
  item_id INTEGER REFERENCES items(item_id)
);


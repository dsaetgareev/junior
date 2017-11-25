CREATE TABLE items (
  item_id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  description TEXT,
  create_date TIMESTAMP
);

CREATE TABLE comments (
  comment_id SERIAL PRIMARY KEY,
  comment TEXT,
  item_id INTEGER REFERENCES items(item_id)
);

CREATE TABLE delitems (
  delitem_id SERIAL PRIMARY KEY,
  item_id INTEGER,
  name VARCHAR(100),
  description TEXT,
  create_date TIMESTAMP
);
CREATE TABLE engine (
  en_id SERIAL PRIMARY KEY,
  brand VARCHAR(100),
  type VARCHAR(100)
);

CREATE TABLE transmission (
  trans_id SERIAL PRIMARY KEY,
  brand VARCHAR(100),
  type VARCHAR(100)
);

CREATE TABLE carBody (
  cb_id SERIAL PRIMARY KEY,
  brand VARCHAR(100),
  type VARCHAR(100)
);

CREATE TABLE car (
  car_id SERIAL PRIMARY KEY,
  brand VARCHAR(100),
  en_id INTEGER REFERENCES engine(en_id),
  trans_id INTEGER REFERENCES transmission(trans_id),
  cb_id INTEGER REFERENCES carBody(cb_id)
);
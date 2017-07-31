INSERT INTO engine(brand, type) VALUES ('BMW', 'diesel');
INSERT INTO engine(brand, type) VALUES ('KIA', 'injector');
INSERT INTO engine(brand, type) VALUES ('VAZ', 'carburetor');

INSERT INTO transmission(brand, type) VALUES ('BMW', 'automatic');
INSERT INTO transmission(brand, type) VALUES ('KIA','CVT');
INSERT INTO transmission(brand, type) VALUES ('VAZ', 'mechanic');

INSERT INTO carbody(brand, type) VALUES ('BMW', 'sedan');
INSERT INTO carbody(brand, type) VALUES ('KIA', 'cross');
INSERT INTO carbody(brand, type) VALUES ('VAZ', 'hatchback');

INSERT INTO car(brand, en_id, trans_id, cb_id) VALUES ('BMW', 1, 1, 1);
INSERT INTO car(brand, en_id, trans_id, cb_id) VALUES ('VAZ', 3, 3, 3);
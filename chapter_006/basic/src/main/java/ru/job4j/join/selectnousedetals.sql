SELECT engine.brand, engine.type FROM engine LEFT OUTER JOIN car
ON engine.en_id = car.en_id
WHERE car.car_id IS NULL;

SELECT transmission.brand, transmission.type FROM transmission
LEFT OUTER JOIN car ON transmission.trans_id = car.trans_id
WHERE car.car_id IS NULL;

SELECT carbody.brand, carbody.type FROM carbody LEFT OUTER JOIN car
ON carbody.cb_id = car.cb_id
WHERE car.car_id IS NULL;
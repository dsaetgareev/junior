SELECT car.brand, engine.type, transmission.type, carbody.type FROM car
LEFT OUTER JOIN engine ON car.en_id = engine.en_id
LEFT OUTER JOIN transmission ON car.trans_id = transmission.trans_id
LEFT OUTER JOIN carbody ON car.cb_id = carbody.cb_id;


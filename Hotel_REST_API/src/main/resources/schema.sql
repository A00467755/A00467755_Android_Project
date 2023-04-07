CREATE TABLE hotel (
  hotel_id INTEGER PRIMARY KEY,
  hotel_name VARCHAR(255) NOT NULL,
  price NUMERIC(15,2) NOT NULL,
  availability VARCHAR(20) NOT NULL
);


CREATE SEQUENCE Hotel_SEQ_ID START WITH (select max(hotel_id) + 1 from hotel);

INSERT into hotel (hotel_id,hotel_name,price,availability) values (1,'Hotel Halifax',100,'Yes');
INSERT into hotel (hotel_id,hotel_name,price,availability) values (2,'Halifax Tower Hotel',150,'Yes');
INSERT into hotel (hotel_id,hotel_name,price,availability) values (3,'Atlantica Hotel Halifax',80,'No');
INSERT into hotel (hotel_id,hotel_name,price,availability) values (4,'The Barrington Hotel',100,'No');
INSERT into hotel (hotel_id,hotel_name,price,availability) values (5,'Sutton Place Hotel Halifax',200,'Yes');
INSERT into hotel (hotel_id,hotel_name,price,availability) values (6,'The Prince George Hotel Halifax',110,'Yes');


CREATE TABLE reservation (
  reservation_id INTEGER PRIMARY KEY,
  hotel_name VARCHAR(255) NOT NULL,
  checkin VARCHAR(20) NOT NULL,
  checkout VARCHAR(20) NOT NULL
);

CREATE SEQUENCE Reservation_SEQ_ID START WITH (select max(reservation_id) + 1 from reservation);

CREATE TABLE guest (
  guest_id INTEGER PRIMARY KEY,
  reservation_id INTEGER,
  guest_name VARCHAR(255) NOT NULL,
  gender VARCHAR(10) NOT NULL
);

CREATE SEQUENCE Guest_SEQ_ID START WITH (select max(guest_id) + 1 from guest);


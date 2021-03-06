﻿
CREATE SEQUENCE IF NOT EXISTS edge_id_seq;

CREATE TABLE IF NOT EXISTS EDGES (
                ID INTEGER NOT NULL DEFAULT nextval('edge_id_seq'),
                CREATION_DATE TIMESTAMP NOT NULL,
                START_POINT POINT NOT NULL,
                DESTINATION_POINT POINT NOT NULL,
                TRANSPORT_TYPE SMALLINT NOT NULL,
                DURATION INTERVAL NOT NULL,
                COST INTEGER NOT NULL,
                DISTANCE INTEGER NOT NULL,
                START_DATE TIMESTAMP NOT NULL,
                END_DATE TIMESTAMP NOT NULL,
                CONSTRAINT edges_pk PRIMARY KEY (ID)
);


ALTER SEQUENCE edge_id_seq OWNED BY EDGES.ID;

CREATE SEQUENCE IF NOT EXISTS user_id_seq;

CREATE TABLE IF NOT EXISTS USERS (
                ID INTEGER NOT NULL DEFAULT nextval('user_id_seq'),
                EMAIL VARCHAR(255) NOT NULL UNIQUE,
                LAST_NAME VARCHAR(50) NOT NULL,
                FIRST_NAME VARCHAR(50) NOT NULL,
                BIRTH_DATE DATE,
                IS_ADMIN BOOLEAN NOT NULL,
                REGISTRATION_DATE TIMESTAMP NOT NULL,
                PASSWORD VARCHAR(255) NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (ID)
);


ALTER SEQUENCE user_id_seq OWNED BY USERS.ID;

CREATE SEQUENCE IF NOT EXISTS route_id_seq;

CREATE TABLE IF NOT EXISTS ROUTES (
                ID INTEGER NOT NULL DEFAULT nextval('route_id_seq'),
                USER_ID INTEGER NOT NULL,
                CREATION_DATE TIMESTAMP NOT NULL,
                START_POINT POINT NOT NULL,
                DESTINATION_POINT POINT NOT NULL,
                ROUTE_TYPE SMALLINT NOT NULL,
                CONSTRAINT routes_pk PRIMARY KEY (ID)
);


ALTER SEQUENCE route_id_seq OWNED BY ROUTES.ID;

CREATE TABLE IF NOT EXISTS ROUTE_EDGES (
                ROUTE_ID INTEGER NOT NULL,
                EDGE_ID INTEGER NOT NULL,
                EDGE_ORDER SMALLINT NOT NULL,
                CONSTRAINT route_edges_pk PRIMARY KEY (ROUTE_ID, EDGE_ID)
);


ALTER TABLE ROUTE_EDGES ADD CONSTRAINT edges_route_edges_fk
FOREIGN KEY (EDGE_ID)
REFERENCES EDGES (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ROUTES ADD CONSTRAINT users_routes_fk
FOREIGN KEY (USER_ID)
REFERENCES USERS (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ROUTE_EDGES ADD CONSTRAINT routes_route_edges_fk
FOREIGN KEY (ROUTE_ID)
REFERENCES ROUTES (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

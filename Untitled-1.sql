CREATE TABLE grocery_list
(
    grocery_list_id serial,
    PRIMARY KEY (grocery_list_id)
);

CREATE TABLE grocery_items
(
     item_id serial,
     item_name character varying(70) NOT NULL,
     item_quantity double precision NOT NULL,
     grocery_list_id integer,
     item_type character varying(120) NOT NULL,
     PRIMARY KEY (item_id),
     FOREIGN KEY (grocery_list_id)
        REFERENCES grocery_list (grocery_list_id)
);

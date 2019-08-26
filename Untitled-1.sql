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

INSERT INTO grocery_list (grocery_list_id) VALUES (1);
INSERT INTO grocery_list (grocery_list_id) VALUES (2);
INSERT INTO grocery_list (grocery_list_id) VALUES (3);

INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (1, 'Orange', 4, 1, 'Food');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (2, 'Bread', 1, 1, 'Food');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (3, 'Eggs', 12, 1, 'Food
');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (4, 'USB cable', 1, 2, 'Electronics');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (5, 'Laptop', 1, 2, 'Electronics');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (6, 'Pants', 2, 3, 'Clothing');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (7, 'Salad', 1, 3, 'Food');
INSERT INTO grocery_items (item_id, item_name, item_quantity, grocery_list_id, item_type) VALUES (8, 'Earphones', 2, 3, 'Electronics');
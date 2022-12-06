DROP DATABASE IF EXISTS catalog;
CREATE DATABASE catalog;
USE catalog;

CREATE TABLE Author (
                        id int NOT NULL AUTO_INCREMENT,
                        last_name  varchar(60),
                        first_name varchar(60),

                        CONSTRAINT author_id_pk PRIMARY KEY (id)
);
INSERT INTO Author (last_name, first_name) VALUES
                                                  ('Federer','Aldo'),
                                                  ('Adel','Ghrieb'),
                                                  ('Tom','Jerry'),
                                                  ('Ronaldo','Luis');
select * from Author;

select * from Author where id = 5;
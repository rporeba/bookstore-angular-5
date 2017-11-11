INSERT INTO userr ( email, password_hash, role) VALUES ( 'admin@localhost', '$2a$04$Q4pEU8VHNgRYOIve2cEJneyx02Ep9tkiJWyUipdVfaKkjq9UJPebC', 'ADMIN');
INSERT INTO userr ( email, password_hash, role) VALUES ( 'user1@localhost', '$2a$04$D.vf8X.h0Y0dRxWfVUAtheU/GBWRV3rSCLqTWyl8FkR/BKjuHbxOy', 'USER');
INSERT INTO userr ( email, password_hash, role) VALUES ( 'dba@localhost', '$2a$04$NtPF/YLblQpuzPlBvwiIQO5M8Cz/J2TFNMnyAhAPNKH4/ORogHfIu', 'DBA');

INSERT INTO borrower( borrower_id, first_name, last_name) VALUES (100, 'Anna', 'Piotrowska');
INSERT INTO borrower( borrower_id, first_name, last_name) VALUES (101, 'Edward', 'Nowakowski');
INSERT INTO borrower( borrower_id, first_name, last_name) VALUES (102, 'Paulina', 'Kowalska');
INSERT INTO borrower( borrower_id, first_name, last_name) VALUES (103, 'Paweł', 'Kowalczyk');

INSERT INTO author( id, first_name, last_name) VALUES (101, 'Czesław', 'Miłosz');
INSERT INTO author( id, first_name, last_name) VALUES (102, 'Julian', 'Tuwim');
INSERT INTO author( id, first_name, last_name) VALUES (103, 'Stanisław', 'Lem');
INSERT INTO author( id, first_name, last_name) VALUES (104, 'Wanda', 'Chotomska');

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, id )
VALUES (101, 'Dalsze okolice', FALSE , '9788974210503', 155, '1995-08-23', 'ADVENTAGE', 101);

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, id )
VALUES (102, 'Abecadło', FALSE , '4387528550503', 239, '1997-08-23', 'SCI', 102);

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, id )
VALUES (103, 'Astronauci', FALSE , '4288375273503', 200, '2000-08-23', 'ADVENTAGE', 103);

/*
INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, id )
VALUES (104, 'Bajki robotów', FALSE , '9788846100503', 239, '2004-08-26', 'SCI', 103);

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, id )
VALUES (105, 'Ala ma kota', FALSE , '9788376274503', 245, '2016-07-23', 'SCI', 104);

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, author_id )
VALUES (106, 'Bocianek', FALSE , '9617377850503', 354, '2006-03-23', 'ADVENTAGE', 104);

INSERT INTO book( item_id, book_title, is_book_borrowed, isbn, number_of_page, published, type_of_book, author_id )
VALUES (107, 'Choinkowe wierszyki', FALSE , '9788377263503', 155, '1998-01-23', 'OTHER', 104);

*/

--Svärd:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Eksvärd', 'SWORD', 2, 1.5, 4, NOW(), 'SHOP', false),
       ('Kotlettklyvare', 'SWORD', 4, 4.0, 8, NOW(), 'SHOP', false),
       ('Pingvinklinga', 'SWORD', 5, 6.0, 10, NOW(), 'SHOP', false),
       ('Ljussabel', 'SWORD', 6, 2.0, 12, NOW(), 'SHOP', false),
       ('Kanadensisk sabel', 'SWORD', 10, 7.5, 20, NOW(), 'SHOP', false),
       ('Piratvärja', 'SWORD', 11, 5.5, 22, NOW(), 'SHOP', false),
       ('Stenkross', 'SWORD', 16, 6.5, 32, NOW(), 'SHOP', false),
       ('Tigerkatana', 'SWORD', 20, 6.5, 40, NOW(), 'SHOP', false);

--Dolkar:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Smörkniv', 'DAGGER', 1, 0.1, 2, NOW(), 'SHOP', false),
       ('Brödkniv', 'DAGGER', 2, 0.3, 4, NOW(), 'SHOP', false),
       ('Morakniv', 'DAGGER', 3, 0.2, 6, NOW(), 'SHOP', false),
       ('Fjärilskniv', 'DAGGER', 5, 0.2, 10, NOW(), 'SHOP', false);

--Stavar:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Buttrix revansch', 'STAFF', 4, 0.4, 8, NOW(), 'SHOP', false),
       ('Björkstav', 'STAFF', 5, 2.5, 10, NOW(), 'SHOP', false);
--Bågar:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Kaninjagarbåge', 'BOW', 3, 3.0, 6, NOW(), 'SHOP', false);

--Rustning:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Lövkamoflage', 'ARMOR', 0, 3.0, 5, NOW(), 'SHOP', false);

--Elixir:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Ingefärshot', 'POTION', 0, 0.1, 1, NOW(), 'SHOP', false),
       ('Vargtass', 'POTION', 0, 0.2, 8, NOW(), 'SHOP', false);

--Smycken:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Ankamulett', 'JEWELRY', 0, 0.1, 5, NOW(), 'SHOP', false);

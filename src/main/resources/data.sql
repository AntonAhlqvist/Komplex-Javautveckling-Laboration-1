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
VALUES
    ('Smörkniv', 'DAGGER', 1, 0.1, 2, NOW(), 'SHOP', false),
    ('Brödkniv', 'DAGGER', 2, 0.3, 4, NOW(), 'SHOP', false),
    ('Morakniv', 'DAGGER', 3, 0.2, 6, NOW(), 'SHOP', false),
    ('Fjärilskniv', 'DAGGER', 5, 0.2, 10, NOW(), 'SHOP', false),
    ('Skuggdolk', 'DAGGER', 7, 0.2, 14, NOW(), 'SHOP', false),
    ('Giftspets', 'DAGGER', 9, 0.2, 18, NOW(), 'SHOP', false),
    ('Nattens klinga', 'DAGGER', 10, 0.3, 20, NOW(), 'SHOP', false),
    ('Assassindolk', 'DAGGER', 15, 0.4, 30, NOW(), 'SHOP', false);

--Stavar:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Buttrix revansch', 'STAFF', 4, 0.4, 8, NOW(), 'SHOP', false),
       ('Björkstav', 'STAFF', 5, 2.5, 10, NOW(), 'SHOP', false),
       ('Eldstav', 'STAFF', 6, 1.2, 12, NOW(), 'SHOP', false),
       ('Froststav', 'STAFF', 8, 1.8, 16, NOW(), 'SHOP', false),
       ('Stormstav', 'STAFF', 10, 2.0, 20, NOW(), 'SHOP', false),
       ('Skuggstav', 'STAFF', 12, 2.2, 24, NOW(), 'SHOP', false),
       ('Drakstav', 'STAFF', 14, 2.5, 28, NOW(), 'SHOP', false),
       ('Mystisk ekstav', 'STAFF', 16, 3.0, 32, NOW(), 'SHOP', false);

--Bågar:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Kaninjagarbåge', 'BOW', 3, 3.0, 6, NOW(), 'SHOP', false),
       ('Skogsbåge', 'BOW', 4, 2.5, 8, NOW(), 'SHOP', false),
       ('Jaktbåge', 'BOW', 6, 3.0, 12, NOW(), 'SHOP', false),
       ('Vindbåge', 'BOW', 8, 2.8, 16, NOW(), 'SHOP', false),
       ('Snabbskyttebåge', 'BOW', 10, 3.2, 20, NOW(), 'SHOP', false),
       ('Rovbåge', 'BOW', 12, 3.5, 24, NOW(), 'SHOP', false),
       ('Legendarisk långbåge', 'BOW', 18, 4.5, 36, NOW(), 'SHOP', false);

--Rustning:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES
    ('Lövkamoflage', 'ARMOR', 0, 3.0, 5, NOW(), 'SHOP', false),
    ('Tygvantar', 'ARMOR', 0, 0.3, 8, NOW(), 'SHOP', false),
    ('Rostig hjälm', 'ARMOR', 0, 1.5, 12, NOW(), 'SHOP', false),
    ('Läderhjälm', 'ARMOR', 0, 1.0, 18, NOW(), 'SHOP', false),
    ('Läderrustning', 'ARMOR', 0, 6.0, 35, NOW(), 'SHOP', false),
    ('Stålhjälm', 'ARMOR', 0, 2.0, 45, NOW(), 'SHOP', false),
    ('Förstärkt sköld', 'ARMOR', 0, 6.0, 60, NOW(), 'SHOP', false),
    ('Magisk kåpa', 'ARMOR', 0, 3.0, 65, NOW(), 'SHOP', false),
    ('Runrustning', 'ARMOR', 0, 12.0, 70, NOW(), 'SHOP', false),
    ('Aegis-sköld', 'ARMOR', 0, 8.0, 70, NOW(), 'SHOP', false);

--Elixir:

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES ('Ingefärshot', 'POTION', 0, 0.1, 1, NOW(), 'SHOP', false),
       ('Vargtass', 'POTION', 0, 0.2, 8, NOW(), 'SHOP', false),
       ('Bärbrus', 'POTION', 0, 0.3, 5, NOW(), 'SHOP', false),
       ('Skogsglögg', 'POTION', 0, 0.4, 12, NOW(), 'SHOP', false),
       ('Midsommarsnaps', 'POTION', 0, 0.2, 15, NOW(), 'SHOP', false),
       ('Apotekets Blandning', 'POTION', 0, 0.1, 18, NOW(), 'SHOP', false),
       ('Smärtstillande Tinktur', 'POTION', 0, 0.1, 20, NOW(), 'SHOP', false),
       ('Bedövningsbrygd', 'POTION', 0, 0.2, 35, NOW(), 'SHOP', false),
       ('Sovgrogg', 'POTION', 0, 0.3, 25, NOW(), 'SHOP', false),
       ('Revbensvärmare', 'POTION', 0, 0.3, 30, NOW(), 'SHOP', false);

--Smycken

INSERT INTO item (name, type, damage, weight, price, created_date, status, created_by_user)
VALUES
    ('Ankamulett', 'JEWELRY', 0, 0.1, 6, NOW(), 'SHOP', false),
    ('Järnring', 'JEWELRY', 0, 0.1, 12, NOW(), 'SHOP', false),
    ('Silversring', 'JEWELRY', 0, 0.1, 18, NOW(), 'SHOP', false),
    ('Diadem av koppar', 'JEWELRY', 0, 0.3, 25, NOW(), 'SHOP', false),
    ('Runarmband', 'JEWELRY', 0, 0.2, 35, NOW(), 'SHOP', false),
    ('Kungligt halsband', 'JEWELRY', 0, 0.2, 55, NOW(), 'SHOP', false),
    ('Månring', 'JEWELRY', 0, 0.1, 65, NOW(), 'SHOP', false);

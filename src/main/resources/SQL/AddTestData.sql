INSERT INTO user_info (FIRST_NAME, LAST_NAME, MAIL, DATE_OF_BIRTH, SEX) VALUES ('Артем', 'Луньков', 'mmmoonnn@mail.ru', '1988-04-10', 'Мужской');

INSERT INTO HOTEL (NAME, DESCRIPTION, COUNTRY, CITY, STAR, WEBSITE) VALUES ('zZooMm', 'well yes zZooMm', 'Russia', 'Bryansk', 6, ' https://www.jetbrains.com/');
INSERT INTO HOTEL (NAME, DESCRIPTION, COUNTRY, CITY, STAR, WEBSITE) VALUES ('zZooMm 2', 'well yes zZooMm 2', 'Russia', 'Bryansk', 5, 'zZooMm2.ru');
INSERT INTO HOTEL (NAME, DESCRIPTION, COUNTRY, CITY, STAR, WEBSITE) VALUES ('zZooMm 3', 'A nu da', 'Russia', 'Bryansk 123', 4, 'https://freemarker.apache.org/');
INSERT INTO HOTEL (NAME, DESCRIPTION, COUNTRY, CITY, STAR, WEBSITE) VALUES ('zZooMm 4', 'Test description', 'Russia', 'Bryansk 2', 3, 'zZooMm2.ru');
INSERT INTO HOTEL (NAME, DESCRIPTION, COUNTRY, CITY, STAR, WEBSITE) VALUES ('zZooMm 5', 'well yes zZooMm 2', 'Russia', 'Bryansk 4', 1, 'https://stackoverflow.com/');

INSERT INTO HOTEL_REVIEW (ID_USER, ID_HOTEL, DATE_OF_VISIT, RATING, DESCRIPTION) VALUES (1, 1, '2019-04-10', 10, 'Top');
INSERT INTO HOTEL_REVIEW (ID_USER, ID_HOTEL, DATE_OF_VISIT, RATING, DESCRIPTION) VALUES (1, 1, '2016-04-10', 9, 'Comment');
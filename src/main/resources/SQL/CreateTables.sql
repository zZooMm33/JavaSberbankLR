CREATE TABLE if not exists USER_INFO(ID SERIAL PRIMARY KEY, FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255), MAIL VARCHAR(255), DATE_OF_BIRTH DATE, SEX VARCHAR(64));
CREATE UNIQUE INDEX if not exists UI_USER_INFO_ID ON USER_INFO(ID);
CREATE UNIQUE INDEX if not exists UI_USER_INFO_MAIL ON USER_INFO(MAIL);

CREATE TABLE if not exists USER_PASS(ID SERIAL PRIMARY KEY, ID_USER INT references USER_INFO(ID),PASS VARCHAR(255));
CREATE UNIQUE INDEX if not exists UT_USER_PASS_ID_USER ON USER_PASS(ID_USER);

CREATE TABLE if not exists USER_TOKEN(ID SERIAL PRIMARY KEY, ID_USER INT references USER_INFO(ID), TOKEN VARCHAR(255));
CREATE UNIQUE INDEX if not exists UT_USER_TOKEN_ID_USER ON USER_TOKEN(ID_USER);
CREATE UNIQUE INDEX if not exists UT_USER_TOKEN_TOKEN ON USER_TOKEN(TOKEN);

CREATE TABLE if not exists HOTEL(ID SERIAL PRIMARY KEY, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), COUNTRY VARCHAR(255), CITY VARCHAR(255), STAR INT, WEBSITE VARCHAR(255));
CREATE UNIQUE INDEX if not exists UI_HOTEL_ID ON HOTEL(ID);
CREATE UNIQUE INDEX if not exists UI_HOTEL_NAME ON HOTEL(NAME);

CREATE TABLE if not exists HOTEL_REVIEW(ID SERIAL PRIMARY KEY, ID_USER SERIAL constraint ID_USER references USER_INFO(ID) on update cascade on delete cascade, ID_HOTEL SERIAL constraint ID_HOTEL references HOTEL(ID) on update cascade on delete cascade, DATE_OF_VISIT DATE, RATING INT, DESCRIPTION VARCHAR(255));
CREATE UNIQUE INDEX if not exists UI_HOTEL_REVIEW_ID_USER ON HOTEL_REVIEW(ID_USER);
CREATE UNIQUE INDEX if not exists UI_HOTEL_REVIEW_ID_HOTEL ON HOTEL_REVIEW(ID_HOTEL);
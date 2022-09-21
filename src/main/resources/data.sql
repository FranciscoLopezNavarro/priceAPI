-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE PRICES AS SELECT * FROM CSVREAD('classpath:prices.csv');
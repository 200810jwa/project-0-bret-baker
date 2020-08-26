DROP TABLE IF EXISTS project0.applications CASCADE;
CREATE TABLE project0.applications (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (250) NOT NULL,
	last_name VARCHAR (250) NOT NULL,
	email VARCHAR (250) NOT NULL UNIQUE,
	password VARCHAR (250) NOT NULL,
	role INTEGER NOT NULL,
	credit_score INTEGER NOT NULL,
	annual_income INTEGER NOT NULL
);

INSERT INTO applications (first_name, last_name, email, password, role, credit_score, annual_income) VALUES ('dummy', 'application', 'dapp@mail.com', '1111', 2, 690, 55000);

SELECT * FROM project0.applications;

DROP TABLE IF EXISTS project0.users CASCADE;
CREATE TABLE project0.users (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (250) NOT NULL,
	last_name VARCHAR (250) NOT NULL,
	email VARCHAR (250) NOT NULL UNIQUE,
	username VARCHAR (250) NOT NULL UNIQUE,
	password VARCHAR (250) NOT NULL,
	role INTEGER NOT NULL,
	checking_balance DECIMAL(10, 2) DEFAULT 0,
	savings_balance DECIMAL(10, 2) DEFAULT 0
);

INSERT INTO users (first_name, last_name, email, username, password, role, checking_balance, savings_balance) VALUES ('dummy', 'user', 'duser@mail.com', 'duser@mail.com', '1111', 2, 1000, 2000);

SELECT * FROM project0.users;

DROP TABLE IF EXISTS project0.admins CASCADE;
CREATE TABLE project0.admins (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (250) NOT NULL,
	last_name VARCHAR (250) NOT NULL,
	email VARCHAR (250) NOT NULL UNIQUE,
	username VARCHAR (250) NOT NULL UNIQUE,
	password VARCHAR (250) NOT NULL,
	role INTEGER NOT NULL
);

INSERT INTO admins (first_name, last_name, email, username, password, role) VALUES ('dummy', 'admin', 'dadmin@mail.com', 'dadmin@mail.com', '1111', 1);

SELECT * FROM project0.admins;
CREATE DATABASE HealthVisAppDB

USE HealthVisAppDB
CREATE TABLE address (
	id INT IDENTITY,
	street NVARCHAR(50),
	streetNr INT,
	zip INT,
	city NVARCHAR(50),
	CONSTRAINT PK_address PRIMARY KEY(id))

USE HealthVisAppDB
CREATE TABLE person (
	id INT IDENTITY,
	name NVARCHAR(50),
	firstName NVARCHAR(50),
	birthDate DATE,
	phone NVARCHAR(20),
	addressID INT,
	CONSTRAINT PK_person PRIMARY KEY(id),
	CONSTRAINT FK_person_address FOREIGN KEY(addressID) REFERENCES address)

USE HealthVisAppDB
CREATE TABLE healthVisitor (
	id INT,
	username NVARCHAR(20),
	password VARCHAR(88),
	CONSTRAINT PK_hv PRIMARY KEY(id),
	CONSTRAINT FK_hv_person FOREIGN KEY(id) REFERENCES person)

USE HealthVisAppDB
CREATE TABLE note (
	id INT IDENTITY,
	comment NVARCHAR(1000),
	CONSTRAINT PK_comment PRIMARY KEY(id))

USE HealthVisAppDB
CREATE TABLE state (
	id INT,
	name NVARCHAR(50),
	description NVARCHAR(200),
	colourCode NVARCHAR(30),
	CONSTRAINT PK_state PRIMARY KEY(id))

USE HealthVisAppDB
CREATE TABLE stateNew (
	id INT,
	name NVARCHAR(50),
	description NVARCHAR(200),
	colourCode NVARCHAR(30),
	CONSTRAINT PK_stateNew PRIMARY KEY(id),
	CONSTRAINT FK_state_new FOREIGN KEY(id) REFERENCES state)

USE HealthVisAppDB
CREATE TABLE stateAmbulant (
	id INT,
	name NVARCHAR(50),
	description NVARCHAR(200),
	colourCode NVARCHAR(30),
	CONSTRAINT PK_stateAmbulant PRIMARY KEY(id),
	CONSTRAINT FK_state_ambulant FOREIGN KEY(id) REFERENCES state)

USE HealthVisAppDB
CREATE TABLE stateStationary (
	id INT,
	name NVARCHAR(50),
	description NVARCHAR(200),
	colourCode NVARCHAR(30),
	CONSTRAINT PK_stateStationary PRIMARY KEY(id),
	CONSTRAINT FK_state_stationary FOREIGN KEY(id) REFERENCES state)

USE HealthVisAppDB
CREATE TABLE stateArchived (
	id INT,
	name NVARCHAR(50),
	description NVARCHAR(200),
	colourCode NVARCHAR(30),
	CONSTRAINT PK_stateArchived PRIMARY KEY(id),
	CONSTRAINT FK_state_Archived FOREIGN KEY(id) REFERENCES state)

USE HealthVisAppDB
CREATE TABLE patient (
	id INT,
	noteId INT,
	healthVisitorId INT,
	stateId INT,
	CONSTRAINT PK_patient PRIMARY KEY(id),
	CONSTRAINT FK_patient_person FOREIGN KEY(id) REFERENCES person,
	CONSTRAINT FK_patient_note FOREIGN KEY(noteId) REFERENCES note,
	CONSTRAINT FK_patient_hv FOREIGN KEY(healthVisitorId) REFERENCES healthVisitor,
	CONSTRAINT FK_patient_state FOREIGN KEY(stateId) REFERENCES state)

USE HealthVisAppDB
CREATE TABLE treatment (
	id INT IDENTITY,
	doctor NVARCHAR(50),
	description NVARCHAR(200),
	date DATE,
	patientId INT,
	CONSTRAINT PK_treatment PRIMARY KEY(id),
	CONSTRAINT FK_treatment_patient FOREIGN KEY(patientId) REFERENCES patient)

USE HealthVisAppDB
CREATE TABLE appointment (
	id INT IDENTITY,
	startTime DATETIME,
	endTime DATETIME,
	location NVARCHAR(50),
	healthVisitorId INT,
	patientId INT,
	noteId INT,
	CONSTRAINT PK_appointment PRIMARY KEY(id),
	CONSTRAINT FK_appointment_hv FOREIGN KEY(healthVisitorId) REFERENCES healthVisitor,
	CONSTRAINT FK_appointment_patient FOREIGN KEY(patientId) REFERENCES patient,
	CONSTRAINT FK_appointment_note FOREIGN KEY(noteId) REFERENCES note)
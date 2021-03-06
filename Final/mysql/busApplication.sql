CREATE DATABASE BusApplication;
USE BusApplication;

CREATE TABLE JadwalBus (
    BusID INT NOT NULL UNIQUE PRIMARY KEY,
    NamaBus VARCHAR(50) NOT NULL,
    Kapasitas INT NOT NULL,
    Tanggal DATE NOT NULL,
    Harga INT NOT NULL,
    Asal VARCHAR(50) NOT NULL,
    Tujuan VARCHAR(50) NOT NULL,
    Waktu  varchar(8) NOT NULL
);

CREATE TABLE Contact (
    ContactID INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    Nama VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Phone VARCHAR(15) NOT NULL,
    Message VARCHAR(100) NOT NULL
);

CREATE TABLE Transaksi (
    TransaksiID INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    BusID INT,
    UserID INT,
    Quantity INT,
    TotalHarga INT,
    TanggalTransaksi DATE NOT NULL,
    MetodePembayaran VARCHAR(15)
);

CREATE TABLE User (
    UserID INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL ,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(30) NOT NULL,
    ConfirmPassword VARCHAR(30) NOT NULL,
    UserStatus CHAR(1) NOT NULL
);
CREATE TABLE Seat (
    SeatID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    TransaksiID INT NOT NULL,
    BusID INT NOT NULL,
    SeatName CHAR(2) NOT NULL,
    Status INT NOT NULL
);

ALTER TABLE Contact ADD CONSTRAINT FK_Contact_UserID FOREIGN KEY (UserID) REFERENCES User(UserID);

ALTER TABLE Transaksi ADD CONSTRAINT FK_Transaksi_userID FOREIGN KEY (UserID) REFERENCES User(UserID), 
						ADD CONSTRAINT FK_Transaksi_BusID FOREIGN KEY (BusID) REFERENCES jadwalBus(BusID);
ALTER TABLE Seat ADD CONSTRAINT FK_Seat_TransaksiID FOREIGN KEY (TransaksiID) REFERENCES Transaksi(TransaksiID), 
				 ADD CONSTRAINT FK_Seat_BusID FOREIGN KEY (BusID) REFERENCES JadwalBus(BusID);

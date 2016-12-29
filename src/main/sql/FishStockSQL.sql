/*
Create Database
*/
DROP DATABASE IF EXISTS FishStock;

CREATE DATABASE FishStock;

USE FishStock;

/*
Create User
*/
DROP USER IF EXISTS 'FishStockUser'@'%';
CREATE USER 'FishStockUser'@'%' IDENTIFIED BY '6t7PDuNYqF';

/*
Create tables
*/
CREATE TABLE Fish_Users 
(
        UserId    INT NOT NULL AUTO_INCREMENT,
        FirstName NVARCHAR(50) NOT NULL,
        LastName  NVARCHAR(50) NOT NULL,
        Email     NVARCHAR(100) NOT NULL,
        Username  NVARCHAR(20) NOT NULL,
        Password  NVARCHAR(150) NOT NULL,
        CONSTRAINT PK_Fish_Users PRIMARY KEY (UserId)
);

CREATE TABLE Fish_Companies
(
        CompanyId       INT NOT NULL AUTO_INCREMENT,
        Name            NVARCHAR(100) NOT NULL,
        Symbol          NVARCHAR(10) NOT NULL,
        TotalRating     INT,
        TotalUsersRated INT,
        CONSTRAINT PK_Fish_Companies PRIMARY KEY (CompanyId)
);

CREATE TABLE Fish_Watchlist
(
        UserId    INT NOT NULL,
        CompanyId INT NOT NULL
);

/**
Setting up autoincrement
*/
ALTER TABLE Fish_Users AUTO_INCREMENT=1;
ALTER TABLE Fish_Companies AUTO_INCREMENT=1;

/*
FK Constraints
*/
ALTER TABLE Fish_Watchlist ADD CONSTRAINT FK_Watchlist_User
    FOREIGN KEY (UserId) REFERENCES Fish_Users (UserId) ON DELETE CASCADE ON UPDATE NO ACTION;

CREATE INDEX IFK_Watchlist_User ON Fish_Watchlist (UserId);

ALTER TABLE Fish_Watchlist ADD CONSTRAINT FK_Watchlist_Company
    FOREIGN KEY (CompanyId) REFERENCES Fish_Companies (CompanyId) ON DELETE CASCADE ON UPDATE NO ACTION;

CREATE INDEX IFK_Watchlist_Company ON Fish_Watchlist (CompanyId);

/*
Populate tables
*/

INSERT INTO Fish_Users (FirstName, LastName, Email, Username, Password) VALUES (N'Tom', N'Hanks', N'thankstome@gmail.com', N'thanks', N'$2a$10$.s0V3YztaliCRk4845cRW.IUx7ZLfZO1ZeHAD07vGUY/JK74itOPi');
INSERT INTO Fish_Users (FirstName, LastName, Email, Username, Password) VALUES (N'Jade', N'Fisher', N'jfisher@mail.com', N'jfisher', N'$2a$10$RQddjCPzzGs.Vz2dYCEMXOsMDG/T9bObKD4jWFH1.57HBX6G58Qe6');

INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Apple, Inc.', N'AAPL');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Baidu, Inc.', N'BIDU');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Cisco Systems, Inc.', N'CSCO');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Facebook, Inc.', N'FB');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Intel Corporation', N'INTC');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Microsoft Corporation', N'MSFT');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Oracle Corporation', N'ORCL');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Red Hat, Inc.', N'RHT');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Syntel, Inc.', N'SYNT');
INSERT INTO Fish_Companies (Name, Symbol) VALUES (N'Texas Instruments Incorporated', N'TXN');

INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (1, 9);
INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (1, 5);
INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (2, 3);
INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (2, 5);
INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (2, 10);
INSERT INTO Fish_Watchlist (UserId, CompanyId) VALUES (2, 1);


GRANT SELECT ON FishStock.Fish_Users TO 'FishStockUser'@'%';

GRANT SELECT ON FishStock.Fish_Companies TO 'FishStockUser'@'%';
GRANT UPDATE ON FishStock.Fish_Companies TO 'FishStockUser'@'%';
GRANT INSERT ON FishStock.Fish_Companies TO 'FishStockUser'@'%';
GRANT DELETE ON FishStock.Fish_Companies TO 'FishStockUser'@'%';

GRANT SELECT ON FishStock.Fish_Watchlist TO 'FishStockUser'@'%';
GRANT UPDATE ON FishStock.Fish_Watchlist TO 'FishStockUser'@'%';
GRANT INSERT ON FishStock.Fish_Watchlist TO 'FishStockUser'@'%';
GRANT DELETE ON FishStock.Fish_Watchlist TO 'FishStockUser'@'%';

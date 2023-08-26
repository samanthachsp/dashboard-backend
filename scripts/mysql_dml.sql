delete from Production;
delete from requisition;

INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (1, 'Test','2023-12-02T00:00:01','111',2500);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (2, 'Test1','2023-01-12T00:00:01','221',4500);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (3, 'Test1','2023-01-12T00:00:01','121',5400);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (4, 'Test1','2023-11-12T00:00:01','151',300);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (5, 'Test1','2023-03-12T00:00:01','121',1200);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (6, 'Test1','2023-02-12T00:00:01','221',20);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (7, 'Test1','2023-01-12T00:00:01','111',3100);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (8, 'Test1','2023-11-12T00:00:01','221',4300);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (9, 'Test1','2023-02-12T00:00:01','151',9400);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (10, 'Test1','2023-11-12T00:00:01','221',28500);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (11, 'Test1','2023-07-12T00:00:01','121',6500);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (12, 'Test1','2023-05-12T00:00:01','111',95500);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (13, 'Test1','2023-12-12T00:00:01','121',700);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (14, 'Test1','2023-01-12T00:00:01','121',70);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (15, 'Test1','2023-02-12T00:00:01','151',8600);
INSERT INTO Requisition (Id,Description,DateCreated,SkNo,Amount) VALUES (16, 'Test1','2023-01-12T00:00:01','111',500);

//users
//password - 1
INSERT INTO user (id,password,username,name) VALUES (1,'$2a$12$Du0cMp83X2xbMUQnzzVPE.ybHAG9B0/7EtTL9s55bbncP4PwFExNC','sk','sk');

INSERT INTO groups (id,name) VALUES (1,'SK');


INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (1, 'Test','2023-12-02T00:00:01','Table',2500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (2, 'Test1','2023-01-12T00:00:01','Chair',4500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (3, 'Test1','2023-01-12T00:00:01','Cupboard',5400);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (4, 'Test1','2023-11-12T00:00:01','Cupboard',300);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (5, 'Test1','2023-03-12T00:00:01','Chair',1200);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (6, 'Test1','2023-02-12T00:00:01','Table',20);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (7, 'Test1','2023-01-12T00:00:01','Mirror',3100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (8, 'Test1','2023-11-12T00:00:01','Mirror',4300);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (9, 'Test1','2023-02-12T00:00:01','Table',9400);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (10, 'Test1','2023-11-12T00:00:01','Chair',28500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (11, 'Test1','2023-07-12T00:00:01','Chair',6500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (12, 'Test1','2023-05-12T00:00:01','Table',95500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (13, 'Test1','2023-12-12T00:00:01','Bed',700);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (14, 'Test1','2023-01-12T00:00:01','Table',70);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (15, 'Test1','2023-02-12T00:00:01','Cupboard',8600);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (16, 'Test1','2023-01-12T00:00:01','Mirror',500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (17, 'Test1','2023-11-12T00:00:01','Bed',1700);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (18, 'Test1','2023-11-12T00:00:01','Bed',7100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (19, 'Test1','2023-01-12T00:00:01','Bed',3100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (20, 'Test1','2023-01-12T00:00:01','Bed',5300);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (21, 'Test','2022-01-02T00:00:01','Table',2500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (22, 'Test1','2022-03-12T00:00:01','Chair',4500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (23, 'Test1','2022-02-12T00:00:01','Cupboard',5400);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (24, 'Test1','2022-06-12T00:00:01','Cupboard',300);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (25, 'Test1','2022-03-12T00:00:01','Chair',1200);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (26, 'Test1','2022-02-12T00:00:01','Table',20);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (27, 'Test1','2022-01-12T00:00:01','Mirror',3100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (28, 'Test1','2022-07-12T00:00:01','Mirror',4300);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (29, 'Test1','2022-02-12T00:00:01','Table',9400);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (30, 'Test1','2022-11-12T00:00:01','Chair',28500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (31, 'Test1','2022-09-12T00:00:01','Chair',6500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (32, 'Test1','2022-05-12T00:00:01','Table',95500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (33, 'Test1','2022-10-12T00:00:01','Bed',700);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (34, 'Test1','2022-01-12T00:00:01','Table',70);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (35, 'Test1','2022-02-12T00:00:01','Cupboard',8600);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (36, 'Test1','2022-01-12T00:00:01','Mirror',500);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (37, 'Test1','2022-11-12T00:00:01','Bed',1700);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (38, 'Test1','2022-11-12T00:00:01','Bed',7100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (39, 'Test1','2022-12-12T00:00:01','Bed',3100);
INSERT INTO Production (Id,Description,DateCreated,Item,Amount) VALUES (40, 'Test1','2022-12-12T00:00:01','Bed',5300);
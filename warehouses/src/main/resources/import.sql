INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('1238653',  'Client A', 'EST',   50);
INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('234545',  'Client A', 'ROB',   10);
INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('1234545',  'Client B', 'EST',   15);
INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('0987118',  'Client C', 'ROB',   8);
INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('098723',  'Client C', 'ROB',   60);
INSERT INTO Warehouses  (uuid,   client,  family,  size) VALUES ('123433',  'Client D', 'EST',   23);

INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('123433',  'A', 1);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('109853',  'C', 1);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('183656',  'B', 1);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('214569',  'D', 2);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('642311',  'A', 3);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('975221',  'A', 4);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('752580',  'D', 4);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('092343',  'A', 5);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('092341',  'C', 5);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('642317',  'D', 5);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('123431',  'C', 6);
INSERT INTO Racks  (uuid,   type,  warehouse_id) VALUES ('123432',  'B', 6);

INSERT INTO racks_type  (family,  type) VALUES ('EST',  'A');
INSERT INTO racks_type  (family,  type) VALUES ('EST',  'B');
INSERT INTO racks_type  (family,  type) VALUES ('EST',  'C');

INSERT INTO racks_type  (family,  type) VALUES ('ROB',  'A');
INSERT INTO racks_type  (family,  type) VALUES ('ROB',  'C');
INSERT INTO racks_type  (family,  type) VALUES ('ROB',  'D');

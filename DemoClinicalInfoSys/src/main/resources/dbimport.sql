INSERT INTO cis.drug VALUES (7680491560226, "IRFEN Lactabs 200 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680465190350, "OLFEN Lactabs 50 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680577870027, "MEPHADOLOR Neo Filmtabl 500 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680531630179, "XEFO Filmtabl 4 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680489910330, "AULIN Tabl 100 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680547520167, "KETESSE Filmtabl 25 mg", true, false, false);
INSERT INTO cis.drug VALUES (7680527100570, "PANTOZOL Filmtabl 20 mg", false, true, false);
INSERT INTO cis.drug VALUES (7680293490103, "PREDNISON Streuli Tabl 1 mg", false, false, true);
INSERT INTO cis.drug VALUES (7680388400291, "SPIRICORT Filmtabl 20 mg", false, false, true);
INSERT INTO cis.drug VALUES (7680261770145, "KENACORT A 10 Inj Susp 10 mg/ml", false, false, true);

INSERT INTO cis.patient VALUES(1, "Gregory", "House");
INSERT INTO cis.patient VALUES(2, "Reid", "Elliot");
INSERT INTO cis.patient VALUES(3, "James", "Wilson");
INSERT INTO cis.patient VALUES(4, "John", "Dorian");
INSERT INTO cis.patient VALUES(5, "Christopher", "Turk");
 
INSERT INTO cis.labresult VALUES(1,"G/l","Thrombozyten", 120, 1);
INSERT INTO cis.labresult VALUES(2,"ml/min/1.73m2","Creatinin Clearance", 20, 1);
INSERT INTO cis.labresult VALUES(3,"","INR", 1.5, 1);
INSERT INTO cis.labresult VALUES(4,"ml/min/1.73m2","Creatinin Clearance", 100, 2);
INSERT INTO cis.labresult VALUES(5,"G/l","Thrombozyten", 170, 2);
INSERT INTO cis.labresult VALUES(6,"ml/min/1.73m2","Creatinin Clearance", 55, 3);
INSERT INTO cis.labresult VALUES(7,"G/l","Thrombozyten", 150, 3);
INSERT INTO cis.labresult VALUES(8,"ml/min/1.73m2","Creatinin Clearance", 90, 4);
INSERT INTO cis.labresult VALUES(9,"","INR", 1.02, 5);
 
INSERT INTO cis.medication VALUES(1, "medication1", 1);
INSERT INTO cis.medication VALUES(2, "medication2", 1);
INSERT INTO cis.medication VALUES(3, "medication3", 1);
INSERT INTO cis.medication VALUES(4, "medication4", 2);
INSERT INTO cis.medication VALUES(5, "medication5", 2);
INSERT INTO cis.medication VALUES(6, "medication6", 3);
INSERT INTO cis.medication VALUES(7, "medication7", 4);
INSERT INTO cis.medication VALUES(8, "medication8", 4);
INSERT INTO cis.medication VALUES(9, "medication9", 5);

INSERT INTO cis.medication_drug VALUES (1,7680491560226);
INSERT INTO cis.medication_drug VALUES (2,7680465190350);
INSERT INTO cis.medication_drug VALUES (2,7680577870027);
INSERT INTO cis.medication_drug VALUES (3,7680531630179);
INSERT INTO cis.medication_drug VALUES (4,7680489910330);
INSERT INTO cis.medication_drug VALUES (4,7680527100570);
INSERT INTO cis.medication_drug VALUES (5,7680388400291);
INSERT INTO cis.medication_drug VALUES (6,7680577870027);
INSERT INTO cis.medication_drug VALUES (6,7680531630179);
INSERT INTO cis.medication_drug VALUES (6,7680489910330);
INSERT INTO cis.medication_drug VALUES (7,7680527100570);
INSERT INTO cis.medication_drug VALUES (8,7680531630179);
INSERT INTO cis.medication_drug VALUES (9,7680491560226);


/*DELETE FROM cis.medication_drug WHERE drugId > 0;
DELETE FROM cis.medication WHERE medicationId > 0;
DELETE FROM cis.labresult WHERE labresultId > 0;
DELETE FROM cis.patient WHERE patientId > 0;
DELETE FROM cis.drug WHERE drugId > 0;*/


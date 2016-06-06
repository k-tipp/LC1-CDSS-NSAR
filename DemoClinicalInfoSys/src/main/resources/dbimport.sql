/* DELETE FROM cis.drug WHERE drugId < 999999; */

INSERT INTO cis.drug VALUES (1, "med1", false, false, false);
INSERT INTO cis.drug VALUES (2, "med2", true, false, false);
INSERT INTO cis.drug VALUES (3, "med3", false, true, false);
INSERT INTO cis.drug VALUES (4, "med4", false, false, true);
INSERT INTO cis.drug VALUES (5, "med5", true, false, true);
INSERT INTO cis.drug VALUES (6, "med6", true, true, false);
INSERT INTO cis.drug VALUES (7, "med7", false, true, true);

INSERT INTO cis.patient VALUES(1, "vorname1", "nachname1");
INSERT INTO cis.patient VALUES(2, "vorname2", "nachname2");
INSERT INTO cis.patient VALUES(3, "vorname3", "nachname3");
INSERT INTO cis.patient VALUES(4, "vorname4", "nachname4");
INSERT INTO cis.patient VALUES(5, "vorname5", "nachname5");

INSERT INTO cis.labresult VALUES(1,"mm","test1", 68, 1);
INSERT INTO cis.labresult VALUES(2,"cm","test2", 68, 1);
INSERT INTO cis.labresult VALUES(3,"m2","test3", 68, 1);
INSERT INTO cis.labresult VALUES(4,"m3","test4", 68, 1);

INSERT INTO cis.labresult VALUES(5,"ml","test5", 5, 2);
INSERT INTO cis.labresult VALUES(6,"cml","test6", 19, 2);

INSERT INTO cis.labresult VALUES(7,"ml","test7", 100, 3);
INSERT INTO cis.labresult VALUES(8,"cl","test8", 19, 3);

INSERT INTO cis.labresult VALUES(9,"u/ml","test9", 9, 4);
INSERT INTO cis.labresult VALUES(10,"units","test10", 10, 5);

INSERT INTO cis.medication VALUES(1, "medication1", 1);
INSERT INTO cis.medication VALUES(2, "medication2", 1);
INSERT INTO cis.medication VALUES(3, "medication3", 1);

INSERT INTO cis.medication VALUES(4, "medication4", 2);
INSERT INTO cis.medication VALUES(5, "medication5", 2);

INSERT INTO cis.medication VALUES(6, "medication6", 3);

INSERT INTO cis.medication VALUES(7, "medication7", 4);
INSERT INTO cis.medication VALUES(8, "medication8", 4);

INSERT INTO cis.medication VALUES(9, "medication9", 5);
INSERT INTO cis.medication VALUES(10, "medication10", 5);
INSERT INTO cis.medication VALUES(11, "medication11", 5);

INSERT INTO cis.medication_drug VALUES (1,1);

INSERT INTO cis.medication_drug VALUES (2,1);
INSERT INTO cis.medication_drug VALUES (2,2);
INSERT INTO cis.medication_drug VALUES (3,3);

INSERT INTO cis.medication_drug VALUES (4,7);
INSERT INTO cis.medication_drug VALUES (4,6);
INSERT INTO cis.medication_drug VALUES (5,5);


INSERT INTO cis.medication_drug VALUES (6,3);
INSERT INTO cis.medication_drug VALUES (6,4);
INSERT INTO cis.medication_drug VALUES (6,5);

INSERT INTO cis.medication_drug VALUES (7,1);
INSERT INTO cis.medication_drug VALUES (7,2);
INSERT INTO cis.medication_drug VALUES (7,3);
INSERT INTO cis.medication_drug VALUES (8,4);

INSERT INTO cis.medication_drug VALUES (9,7);
INSERT INTO cis.medication_drug VALUES (10,2);
INSERT INTO cis.medication_drug VALUES (11,6);


/*----------------------------------------------*/

INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680491560226, "IRFEN Lactabs 200 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680465190350, "OLFEN Lactabs 50 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680577870027, "MEPHADOLOR Neo Filmtabl 500 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680531630179, "XEFO Filmtabl 4 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680489910330, "AULIN Tabl 100 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680547520167, "KETESSE Filmtabl 25 mg", true, false, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680527100570, "PANTOZOL Filmtabl 20 mg", false, true, false);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680293490103, "PREDNISON Streuli Tabl 1 mg", false, false, true);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680388400291, "SPIRICORT Filmtabl 20 mg", false, false, true);
INSERT INTO `cis`.`drug` (`drugId`, `name`, `isNsar`, `isPPI`, `isStereoidal`) VALUES (7680261770145, "KENACORT A 10 Inj Susp 10 mg/ml", false, false, true);


INSERT INTO cis.patient VALUES(1, "vorname1", "nachname1");
INSERT INTO cis.patient VALUES(2, "vorname2", "nachname2");
INSERT INTO cis.patient VALUES(3, "vorname3", "nachname3");
INSERT INTO cis.patient VALUES(4, "vorname4", "nachname4");
INSERT INTO cis.patient VALUES(5, "vorname5", "nachname5");

INSERT INTO cis.labresult VALUES(1,"mm","test1", 68, 1);
INSERT INTO cis.labresult VALUES(2,"cm","test2", 68, 1);
INSERT INTO cis.labresult VALUES(3,"m2","test3", 68, 1);
INSERT INTO cis.labresult VALUES(4,"m3","test4", 68, 1);

INSERT INTO cis.labresult VALUES(5,"ml","test5", 5, 2);
INSERT INTO cis.labresult VALUES(6,"cml","test6", 19, 2);

INSERT INTO cis.labresult VALUES(7,"ml","test7", 100, 3);
INSERT INTO cis.labresult VALUES(8,"cl","test8", 19, 3);

INSERT INTO cis.labresult VALUES(9,"u/ml","test9", 9, 4);
INSERT INTO cis.labresult VALUES(10,"units","test10", 10, 5);

INSERT INTO cis.medication VALUES(1, "medication1", 1);
INSERT INTO cis.medication VALUES(2, "medication2", 1);
INSERT INTO cis.medication VALUES(3, "medication3", 1);

INSERT INTO cis.medication VALUES(4, "medication4", 2);
INSERT INTO cis.medication VALUES(5, "medication5", 2);

INSERT INTO cis.medication VALUES(6, "medication6", 3);

INSERT INTO cis.medication VALUES(7, "medication7", 4);
INSERT INTO cis.medication VALUES(8, "medication8", 4);

INSERT INTO cis.medication VALUES(9, "medication9", 5);
INSERT INTO cis.medication VALUES(10, "medication10", 5);
INSERT INTO cis.medication VALUES(11, "medication11", 5);

INSERT INTO cis.medication_drug VALUES (1,1);

INSERT INTO cis.medication_drug VALUES (2,1);
INSERT INTO cis.medication_drug VALUES (2,2);
INSERT INTO cis.medication_drug VALUES (3,3);

INSERT INTO cis.medication_drug VALUES (4,7);
INSERT INTO cis.medication_drug VALUES (4,6);
INSERT INTO cis.medication_drug VALUES (5,5);


INSERT INTO cis.medication_drug VALUES (6,3);
INSERT INTO cis.medication_drug VALUES (6,4);
INSERT INTO cis.medication_drug VALUES (6,5);

INSERT INTO cis.medication_drug VALUES (7,1);
INSERT INTO cis.medication_drug VALUES (7,2);
INSERT INTO cis.medication_drug VALUES (7,3);
INSERT INTO cis.medication_drug VALUES (8,4);

INSERT INTO cis.medication_drug VALUES (9,7);
INSERT INTO cis.medication_drug VALUES (10,2);
INSERT INTO cis.medication_drug VALUES (11,6);


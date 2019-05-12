-- Begin with these two first:
-- Populate an Admin User:
INSERT INTO `CheckPay`.`user`(username, password, fname, lname, email)
VALUES ('marsel','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'marsel','Proust','marsel@proust.io');
UPDATE user SET username = 'marsel' where id=1;

-- Populate user_role table */
INSERT INTO `CheckPay`.`user_role` (user_id, role_id)
  SELECT u.id, profile.id FROM user as u, role as profile
  where u.username='marsel' and profile.name='admin';

-- Populate Admin table:
INSERT INTO `CheckPay`.`admin` (fname, lname, profession, email, passHashed) VALUES ('Marsel', 'Proust', 'The Dude', 'marsel@gmail.com', 'frenchWriter');

-- Populate Employee table:
INSERT INTO `CheckPay`.`employee` (fname, lname, profession, email, passHashed) VALUES ('Pikos', 'Apikos', 'Barista', 'pikos@froutopia.com', 'froutopia');
INSERT INTO `CheckPay`.`employee` (fname, lname, profession, email, passHashed) VALUES ('Emilios', 'Tomilo', 'Grocery Helper', 'emilios@froutopia.com', 'manavis');
INSERT INTO `CheckPay`.`employee` (fname, lname, profession, email, passHashed) VALUES ('Chara', 'Mita', 'Freelancer', 'giwmita@hotmail.com', '123');
INSERT INTO `CheckPay`.`employee` (fname, lname, profession, email, passHashed) VALUES ('Ioannis', 'Efthymiou', 'Developer', 'efthioa@gmail.com', '1234');

-- Populate History table:
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (1, '2019-04-21', 8.00, 0.00, 0.00, 80.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (1, '2019-04-22', 8.00, 0.00, 0.00, 60.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (2, '2019-04-21', 8.00, 0.00, 0.00, 30.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (2, '2019-04-22', 8.00, 0.00, 0.00, 50.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (3, '2019-04-20', 8.00, 0.00, 0.00, 80.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (3, '2019-04-23', 8.00, 0.00, 0.00, 60.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (4, '2019-04-22', 8.00, 0.00, 0.00, 80.00, 80.00);
INSERT INTO `CheckPay`.`history` (fk_empl_id, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary) VALUES (4, '2019-04-24', 8.00, 0.00, 0.00, 50.00, 80.00);

/*
-- Populate HistoryEmployees table:
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (1,1);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (1,2);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (2,3);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (2,4);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (3,5);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (3,6);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (4,7);
INSERT INTO `CheckPay`.`historyEmployees` (fk_empl_id, fk_hist_id) VALUES (4,8);
*/

-- Populate Role table:
INSERT INTO `CheckPay`.`role` (name) VALUES ('admin');
INSERT INTO `CheckPay`.`role` (name) VALUES ('employee');
INSERT INTO `CheckPay`.`role` (name) VALUES ('volunteer');

-- Populate User table:
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Pikos', 'Apikos', 'pikos@froutopia.com', '$2y$12$KkKuIsRE95vwVgInrvAlUO9fKTWhG/yqJbxWTR1LGXNrRMyy3teLO');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Emilios', 'Tomilo', 'emilios@froutopia.com', '$2y$12$j21OieNj9rI3gU/fQSPwRunUahy.kzE8PD1whayo4fCCo2c69ZkW.');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Chara', 'Mita', 'giwmita@hotmail.com', '$2y$12$A7jrvtNHHaRcWOLrPP.pouOaTnkcGV2dsoLT/uaAYtVIe4yVXQn9G');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Ioannis', 'Efthymiou', 'efthioa@gmail.com', '$2y$12$/rfYDW7iGRmPZaa04kZLQeHVMugQ77Uz8h6ir0/z8Rr46HlF2K81W');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Salvador', 'Dali', 'bla@hotmail.com', '$2y$12$1TjqeywUqbTq.k427vfDG.A1YQy4cPO1QRxjY14FcW5E7WsgVbAt6');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Edward', 'Munch', 'blabla@gmail.com', '$2y$12$NGSHmiU.ggOFoG4cbPXyh.iYCN5Gh1B3ixg5.iLkHTpToOlDN7Yaq');
INSERT INTO `CheckPay`.`user` (fname, lname, email, password) VALUES ('Marsel', 'Proust', 'marsel@gmail.com', '$2y$10$dRnKjy0HcsLEcynq8h3Qm.nPiKMRsNwLLJAYNMcR9toZfhvUGEFYS');

-- Populate Users_roles table:
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (1, 2);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (2, 2);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (3, 2);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (4, 2);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (5, 3);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (6, 3);
INSERT INTO `CheckPay`.`user_role` (fk_user_id, fk_role_id) VALUES (7, 1);

-- Populate Volunteer table:
INSERT INTO `CheckPay`.`volunteer` (fname, lname, profession, email, passHashed) VALUES ('Salvador', 'Dali', 'Lawyer', 'bla@hotmail.com', 'spanishPainter');
INSERT INTO `CheckPay`.`volunteer` (fname, lname, profession, email, passHashed) VALUES ('Edward', 'Munch', 'Social Worker', 'blabla@gmail.com', 'swedishPainter');

-- Populate Wallet table:
INSERT INTO `CheckPay`.`wallet` (fk_vol_id, balance) VALUES (1, 100);
INSERT INTO `CheckPay`.`wallet` (fk_vol_id, balance) VALUES (2, 150);

/*
ManyToMany:
SELECT fname, lname, dateOfWork, hoursWorked, overtime, hoursSunday, salary FROM history AS H
INNER JOIN historyEmployees AS HE ON HE.fk_hist_id = H.id
INNER JOIN employee AS E ON E.id = HE.fk_empl_id
WHERE E.id = 1;

or OneToMany:
SELECT fname, lname, dateOfWork, hoursWorked, overtime, hoursSunday, salary, entitledSalary from HISTORY AS H
INNER JOIN employee AS E on E.id = H.fk_empl_id ;

*/

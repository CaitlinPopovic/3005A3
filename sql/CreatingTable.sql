-- creating the table: 

CREATE TABLE Students (

student_id SERIAL PRIMARY KEY, 
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE,
enrollment_date DATE

);


-- inserting values:

INSERT INTO Students (first_name, last_name, email, enrollment_date) 
VALUES ('John', 'Doe', 'john.doe@example.com', '2023-09-01'), 
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'), 
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');


-- testing:
SELECT * 
FROM Students
ORDER BY student_id ASC;


-- deleting tests:
DELETE FROM Students WHERE first_name = 'Jenn';

UPDATE Students SET email = 'john.doe@example.com' WHERE student_id = 1;

INSERT INTO Students (first_name, last_name, email, enrollment_date) 
VALUES ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'); 


-- resetting the table: 
UPDATE Students SET student_id = 2 WHERE first_name = 'Jane';


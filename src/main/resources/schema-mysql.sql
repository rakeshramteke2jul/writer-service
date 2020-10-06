DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id VARCHAR(10) NOT NULL,
  employee_name VARCHAR(100),
  employee_salary INT,
  employee_age INT,
  profile_image VARCHAR(100)
);
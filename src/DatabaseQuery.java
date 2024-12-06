public class DatabaseQuery {

    /*
    SELECT * From employee;
    SELECT * FROM address;
    SELECT * FROM experience;
    SELECT * FROM department;

    SELECT * FROM employee WHERE id = 3;

    CREATE TABLE employee (
        id INT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) UNIQUE NOT NULL,
        age INT NOT NULL,
        salary DECIMAL(10, 2) NOT NULL,
        department VARCHAR(50) NOT NULL,
        designation VARCHAR(50) NOT NULL,
        birthdate DATE NOT NULL
     );

    CREATE TABLE address (
            id INT AUTO_INCREMENT PRIMARY KEY,
            employee_id INT NOT NULL,
            phoneNo VARCHAR(15) NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(100) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE
);

    CREATE TABLE experience (
            id INT AUTO_INCREMENT PRIMARY KEY,
            employee_id INT NOT NULL,
            techName VARCHAR(100) NOT NULL,
    position VARCHAR(50) NOT NULL,
    years INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE
);

    CREATE TABLE department (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(100) NOT NULL
);

    CREATE TABLE departmentEmployee (
            department_id INT NOT NULL,
            employee_id INT NOT NULL,
            PRIMARY KEY (department_id, employee_id),
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

-- INNER JOIN
    SELECT e.id, e.name, a.phoneNo
    From employee e
    INNER JOIN address a ON e.id = a.employee_id;

-- Right Join
    SELECT e.id, e.name, a.phoneNo, a.city, ex.position
    From employee e
    Right JOIN address a ON e.id = a.employee_id
    Right JOIN experience ex ON e.id = ex.employee_id;

-- Left Join (ALL Left + right common)
   SELECT e.id, e.name, e.email, e.age, e.salary,e.department,
   e.birthdate, a.phoneNo, a.state, a.city
   FROM employee e
   LEFT JOIN address a ON e.id = a.employee_id;

-- Full Outer Join
-- SELECT e.id, e.name, a.city
-- FROM employee e
-- FULL OUTER JOIN address a ON e.id = a.employee_id;

-- Select column from table
    SELECT name FROM employee;
    SELECT employee_id, phoneNo FROM address;

-- Distinct or Different
    SELECT DISTINCT city FROM address;

-- Where query
    SELECT * FROM employee
    where age < 30;

    SELECT * FROM employee
    where id = 1;

-- ORDER BY Accending
    SELECT * FROM employee
    ORDER BY age;

-- Order BY Decending
    SELECT * FROM employee
    ORDER BY age DESC;

-- Order BY Name
    SELECT * FROM employee
    ORDER BY name;

-- Both ASC and DEC
    SELECT * FROM employee
    ORDER BY name ASC, age DESC;

-- AND (used for multi conditions, ALL values must true)
    SELECT * FROM employee
    WHERE age = 33 AND name LIKE "a%" ;

-- OR used with AND
    SELECT * FROM employee
    WHERE age = 33 AND name LIKE "a%" OR name LIKE "u%";

-- OR (any value must true)
    SELECT * FROM employee
    WHERE age = 23 OR name LIKE "a%";

-- Not (used for negative result)
    SELECT * FROM employee
    WHERE NOT department = "cs";

    SELECT * FROM employee
    WHERE name NOT LIKE "a%";

    SELECT * FROM employee
    WHERE age NOT IN (23, 30);

-- To check value is Null or NOt
    SELECT age FROM employee
    WHERE age IS NOT NULL;

-- INSERT QUERY
    INSERT INTO employee (
            id, name, email, age, salary, department, designation, birthdate
            ) VALUES(
            "4", "hadi", "hadi@gmail.com", "30", "50000.00", "se", "pm", "2000-10-06"
            );

-- UPDATE QUERY
    UPDATE employee
    SET name = 'Ubaid ur rehman', age= '28'
    WHERE id = 1;

-- DELETE QUERY
    DELETE FROM employee
    WHERE name = "ali";

    DROP TABLE employee;

-- LIMIT is 2
    SELECT * FROM employee
    LIMIT 2;

    SELECT name
    FROM employee
    WHERE age > 27
    LIMIT 3;

-- MIN & MAX
    SELECT MIN(age)
    FROM employee;

    SELECT MAX(age)
    FROM employee;

    SELECT MIN(age) AS SmallestAge
    FROM employee;

-- GROUP BY
    SELECT MIN(age) AS SmallestAge, id
    FROM employee
    GROUP BY id;

-- Count
    SELECT COUNT(id)
    FROM employee
    WHERE age > 30;

-- SUM
    SELECT SUM(age)
    FROM employee;

    SELECT SUM(age) AS Total
    FROM employee
    WHERE age > 28;

-- Sum with group by
    SELECT id, SUM(age) AS Total
    FROM employee
    GROUP BY id;

-- Sum with Expression
    SELECT SUM(age * 10) AS Total
    FROM employee;

-- Average
    SELECT AVG(age)
    FROM employee;

-- AVG with Condition
    SELECT * FROM employee
    WHERE age > (SELECT AVG(age) FROM employee);

--  Wild Card ------------------------
    SELECT * FROM address
    WHERE city LIKE "l_r";

    SELECT * FROM address
    WHERE city LIKE "%l";

-- Wild Card used for range
    SELECT * FROM address
    WHERE city LIKE '[a-z]%';

-- Wild Card used for any match
    SELECT * FROM employee
    WHERE name LIKE '[ubaid]%';

-- SQL IN -----------------------------------
            -- 1- NOT IN
    SELECT * FROM address
    WHERE city NOT IN ('karachi', 'Murree', 'lhr');

-- 2- IN SELECT
    SELECT * FROM employee
    WHERE id IN (SELECT employee_id FROM address);

-- 3- NOT IN SELECT
    SELECT * FROM employee
    WHERE id NOT IN (SELECT employee_id FROM address);

-- SQL Between -----------------------------------
            -- 1-  Between Range
    SELECT * FROM employee
    WHERE age BETWEEN 10 AND 40;

-- 2- Between IN
    SELECT * FROM employee
    WHERE age BETWEEN 10 AND 40
    AND id IN (1,2,3);

-- Union
    SELECT city FROM address
    UNION ALL
    SELECT name FROM employee
    ORDER BY city;

-- Group By
    SELECT COUNT(age), name
    FROM employee
    GROUP BY name;

-- Having
    SELECT SUM(age), name
    FROM employee
    GROUP BY name
    HAVING SUM(age) > 0;

-- ALL
    SELECT name
    FROM employee
    WHERE id = ALL (SELECT employee_id FROM address WHERE age > 0);

-- ANY
    SELECT name
    FROM employee
    WHERE id = ANY (SELECT id FROM address WHERE age > 0);

-- Case
    SELECT name, age,
            CASE
    WHEN age > 30 THEN 'The age is greater than 30'
    WHEN age = 30 THEN 'The age is 30'
    ELSE 'The age is under 30'
    END AS UpdatedAge
    FROM employee;

-- Alter
    ALTER TABLE experience
    ADD email varchar(255);

    ALTER TABLE experience
    DROP email;

    ALTER TABLE experience
    RENAME COLUMN email to Email;

    SELECT * INTO age
    FROM employee;
     */
}

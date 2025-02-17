DROP database nuclearfission;
create database nuclearfission;




use nuclearfission;
SHOW TABLES;





SELECT * FROM reactor INNER JOIN chemical_element WHERE chemical_element.id LIKE 1;
SELECT * FROM chemical_element WHERE chemical_element.chemical_name LIKE "Uranite-235";


desc reactor;


select * from reactor;
select * from reactor_size;
SELECT * FROM chemical_element;
truncate chemical_element;

SELECT * FROM eventlog;
SELECT * FROM reactor;
SELECT * FROM reactor_size;
SELECT * FROM reactorstate;
SELECT * FROM simulation_log;
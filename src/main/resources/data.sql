insert into course(id, name, last_updated_time, created_time) values(10001, 'History', sysdate(), sysdate());
insert into course(id, name, last_updated_time, created_time) values(10002, 'Chemistry', sysdate(), sysdate());
insert into course(id, name, last_updated_time, created_time) values(10003, 'Maths', sysdate(), sysdate());
insert into course(id, name, last_updated_time, created_time) values(10004, 'Physics', sysdate(), sysdate());
insert into course(id, name, last_updated_time, created_time) values(10005, 'English', sysdate(), sysdate());

insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description)
values(50001,'5', 'Great Course');
insert into review(id,rating,description)
values(50002,'4', 'Wonderful Course');
insert into review(id,rating,description)
values(50003,'5', 'Awesome Course');
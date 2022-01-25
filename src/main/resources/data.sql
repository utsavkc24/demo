insert into course(id, name, last_updated_time, created_time, is_deleted) values(10001, 'History', sysdate(), sysdate(), false);
insert into course(id, name, last_updated_time, created_time, is_deleted) values(10002, 'Chemistry', sysdate(), sysdate(), false);
insert into course(id, name, last_updated_time, created_time, is_deleted) values(10003, 'Maths', sysdate(), sysdate(), false);
insert into course(id, name, last_updated_time, created_time, is_deleted) values(10004, 'Physics', sysdate(), sysdate(), false);
insert into course(id, name, last_updated_time, created_time, is_deleted) values(10005, 'English', sysdate(), sysdate(), false);

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

--Now we need send int value not string value
insert into review(id,rating,description,course_id)
values(50001,5, 'Great Course', 10001);
insert into review(id,rating,description,course_id)
values(50002,4, 'Wonderful Course', 10001);
insert into review(id,rating,description,course_id)
values(50003,5, 'Awesome Course', 10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10005);
-- db관련


create table departments(
    department_id   int auto_increment primary key,
	department_name   varchar(20),
    manager_id   int
);

select * from departments;

-- 인사 / 관리 / 영업 / 개발
insert into departments
values(1, '인사', 4)
;

insert into departments
values(null, '관리', 1)
;

insert into departments
values(null, '영업', 7)
;

insert into departments
values(null, '개발', 10)
;



create table members(
   member_id   int  auto_increment primary key,
    id   varchar(20) not null,
    pw   varchar(20) not null,
    name   varchar(20) not null,
    hp   varchar(20),
    birth   varchar(20),
    department_id   int,
    hire_date   varchar(20) not null,
    manager_id   int,
    position   varchar(20), 
   CONSTRAINT members_fk FOREIGN KEY (department_id)
   REFERENCES departments(department_id)
);

ALTER TABLE members MODIFY hp VARCHAR(20) not null;

create table history(
   member_id   int,
    date   varchar(20),
    state   varchar(20),
    primary key (member_id, date),
   CONSTRAINT history_fk FOREIGN KEY (member_id)
   REFERENCES members(member_id)
);

select *
from departments d
left join members m
	   on d.department_id = m.department_id
left join history h
			   on m.member_id = h.member_id
;

-- 총13명
insert into members 
values(1, 'member1', '1234', '김철수', '010-1234-1234', '2000-01-01', 2, '2020-01-01', null, '부서장'  )
;

insert into members 
values(null, 'member2', '5784', '김철세', '010-8745-9874', '1995-02-01', 2, '2018-02-01', 1, '대리'  )
;

insert into members 
values(null, 'member3', '785714', '김철성', '010-8744-3947', '1998-03-05', 2, '2017-03-06', 1, '팀원'  )
;

insert into members 
values(null, 'member4', '844118', '박수호', '010-9478-5478', '1997-05-15', 1, '2019-07-15', null, '부서장'  )
;

insert into members 
values(null, 'member5', '65431', '박수현', '010-1542-6543', '2001-04-30', 1, '2019-10-28', 4, '대리'  )
;

insert into members 
values(null, 'member6', '124124', '박철호', '010-9981-1231', '2003-06-22', 1, '2021-08-16', 4, '팀원'  )
;

insert into members 
values(null, 'member7', '54612', '이선호', '010-1245-3438', '2000-05-12', 3, '2018-03-13', null, '부서장'  )
;

insert into members 
values(null, 'member8', '12312312', '이호준', '010-1355-1241', '1999-07-24', 3, '2020-09-14', 7 , '대리'  )
;

insert into members 
values(null, 'member9', '184165', '이경호', '010-1113-4423', '2001-01-28', 3, '2021-04-03', 7, '팀원'  )
;

insert into members 
values(null, 'member10', '135353', '최신오', '010-1353-0056', '2000-09-05', 4, '2019-02-25', null, '부서장')
;

insert into members
values(null, 'member11', '35353', '최서희', '010-4536-3432', '1998-11-10', 4, '2022-05-09', 10, '팀원')
;

insert into members
values(null, 'member12', '19685', '최순자', '010-3355-9891', '1997-10-23', 4, '2023-02-05', 10, '팀원')
;

insert into members
values(null, 'member13', '17985', '김사장', '010-4457-1232', '1995-08-25', null, '2016-09-13', null, '팀원')
;

select * from members;

show tables;
select * from departments;
select * from members;
select * from history;

insert into history
values(1, '2024-01-17', '근무');

insert into history
values(2, '2024-01-17', '병가');
insert into history
values(2, '2024-01-18', '병가');
insert into history
values(2, '2024-01-19', '근무');
insert into history
values(2, '2024-01-20', '근무');
insert into history
values(2, '2024-01-21', '근무');
insert into history
values(2, '2024-01-22', '출장');
insert into history
values(2, '2024-01-23', '근무');
insert into history
values(2, '2024-01-24', '근무');
insert into history
values(2, '2024-01-25', '근무');
insert into history
values(2, '2024-01-26', '근무');
insert into history
values(2, '2024-01-27', '근무');
insert into history
values(2, '2024-01-28', '근무');
insert into history
values(2, '2024-01-29', '휴가');
insert into history
values(2, '2024-01-30', '휴가');
insert into history
values(2, '2024-01-31', '휴가');

insert into history
values(3, '2024-01-17', '근무');

insert into history
values(4, '2024-01-17', '근무');

insert into history
values(5, '2024-01-17', '근무');

insert into history
values(6, '2024-01-17', '출장');

insert into history
values(7, '2024-01-17', '출장');

insert into history
values(8, '2024-01-17', '근무');

insert into history
values(9, '2024-01-17', '병가');

insert into history
values(10, '2024-01-17', '근무');

insert into history
values(11, '2024-01-17', '휴가');

insert into history
values(12, '2024-01-17', '근무');

insert into history
values(13, '2024-01-17', '근무');




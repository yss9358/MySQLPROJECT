-- ----------------------------------------------------
-- 관리자 프로그램 - 회원관리

-- members, departments 출력
select	m.member_id,
		m.id,
        m.name,
        m.hp,
        m.birth,
        m.hire_date,
        m.department_id,
        d.department_name,
        m.position,
        h.date,
        h.state
from members m
	left join departments d
		   on m.department_id = d.department_id
	left join history h
		   on m.member_id = h.member_id
;

-- 수정할 직원번호 선택
select	m.member_id,
		m.id,
        m.pw,
        m.name,
        m.hp,
        m.birth,
        m.hire_date,
        m.department_id,
        d.department_name,
        m.position
from members m
	left join departments d
		   on m.department_id = d.department_id
where m.member_id = 1
;

-- 아이디 수정
update members
set id = ?
where member_id = ?
;

-- 비밀번호 수정
update members
set pw = ?
where member_id = ?
;

-- 이름 수정
update members
set name = ?
where member_id = ?
;

-- 전화번호 수정
update members
set hp = ?
where member_id = ?
;

-- 생년월일 수정
update members
set birth = ?
where member_id = ?
;

-- 입사일 수정
update members
set hire_date = ?
where member_id = ?
;

-- 부서번호 수정
update members
set department_id = ?
where member_id = ?
;

-- 부서명 수정
update departments
set department_name = ?
where member_id = ?
;

-- 직급 수정
update members
set position = ?
where member_id = ?
;


-- 회원관리 끝
-- -------------------------------------------------------------------------------

-- -------------------------------------------------------------------------------
-- 부서관리


select count(state)
from history
where state='근무'
;

select count(state)
from history
where state='휴가'
;

select count(state)
from history
where state='병가'
;

select  m.member_id,
      name,
      date,
        state
from members m, history h
where m.member_id=h.member_id
;

select concat(state, ' ', count(*),'명') '현재 근무 상태'
from history
where date='2017.01.17'
group by state
;

show tables;

insert into members
values(null, id, pw, name, hp, birth, null, hire_date, null, position)
;


create table employees
(
    id number(10) not null,
    first_name varchar2(50),
    last_name varchar2(50),
    company varchar2(50),
    empl_number varchar2(50),
    salary number(10, 2)
);

alter table employees add 
(constraint empl_pk primary key(id));

create sequence empl_seq;

create trigger empl_bir
before insert on employees
for each row
begin
    :new.id := empl_seq.nextval;
end;

insert all
    into employees(first_name, last_name, company, empl_number, salary) values('John', 'Kennedy', 'US President', 'USP035', 55000.5)
    into employees(first_name, last_name, company, empl_number, salary) values('Jay', 'Gatsby', 'New York C', 'HLW013', 120000.55)
select * from dual;

select * from employees


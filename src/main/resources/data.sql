--create table trade_store (
--                trade_id VARCHAR(10),version INTEGER,country_party_id VARCHAR(10),
--                book_id VARCHAR(10),maturity_date DATE,created_date DATE,expired CHAR(1)
--);

insert into trade_store (trade_id,version,country_party_id,book_id,maturity_date,created_date,expired)
    values ('T1',1,'CP-1','B1', parsedatetime('20/05/2020', 'dd/MM/yyyy'),CURRENT_DATE(),'N');

insert into trade_store (trade_id,version,country_party_id,book_id,maturity_date,created_date,expired)
    values ('T2',2,'CP-2','B1',parsedatetime('20/05/2020', 'dd/MM/yyyy'),CURRENT_DATE(),'N');

insert into trade_store (trade_id,version,country_party_id,book_id,maturity_date,created_date,expired)
    values ('T2',1,'CP-1','B1',parsedatetime('20/05/2020', 'dd/MM/yyyy'),parsedatetime('14/03/2020', 'dd/MM/yyyy'),'N');

insert into trade_store (trade_id,version,country_party_id,book_id,maturity_date,created_date,expired)
    values ('T3',3,'CP-3','B2',parsedatetime('20/05/2020', 'dd/MM/yyyy'),CURRENT_DATE(),'Y');
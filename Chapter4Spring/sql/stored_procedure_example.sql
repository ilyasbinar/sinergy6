create or replace procedure tutup_fajar_cafe()
language plpgsql
as $$
begin
update merchant set open=false where name='Fajar Cafe';
commit;
end;$$

call tutupfajarcafe();


create or replace procedure editmerchant(merchant_name varchar)
language plpgsql
as $$
begin
update merchant set open=false where name=merchant_name;
commit;
end;$$

call editmerchant('Ren Coffee')


create or replace procedure edit_merchant_status(merchant_name varchar, is_open bool)
language plpgsql
as $$
begin
update merchant set open=is_open where name=merchant_name;
commit;
end;$$

call edit_merchant_status('Ren Coffee', true);



SELECT
    routine_schema,
    routine_name
FROM
    information_schema.routines
WHERE
        routine_type = 'PROCEDURE';
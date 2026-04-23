CREATE TABLE public.products (
    id serial NOT NULL,
    nombre varchar(255) NOT NULL,
    precio numeric(38, 2) NOT NULL,
    stock int4 NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id),
    CONSTRAINT products_stock_check CHECK ((stock >= 0))
);
CREATE TABLE public.users (
    id serial PRIMARY KEY,
    identityCard varchar(15) NOT NULL,
    lastName varchar(255) NOT NULL,
    name varchar(255) NOT NULL
);
CREATE TABLE public.purchase (
    id serial PRIMARY KEY,
    product_id integer NOT NULL,
    users_id integer NOT NULL,
    amount int4 NOT NULL,
    price numeric(38, 2) NOT NULL
);

ALTER TABLE public.purchase add CONSTRAINT fk_purchase_user
foreign key (users_id) references public.users(id)

drop TABLE public.purchase;
insert into public.users (identityCard, lastName, name)
values ('1720281979', 'Vivero', 'Javier')
select *
from public.purchase;

update public.products set stock = 50;

delete from public.purchase
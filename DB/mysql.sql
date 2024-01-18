create table clientes
(
    id                int auto_increment
        primary key,
    dpi               varchar(30)  null,
    fecha_nacimiento  date         null,
    direccion         varchar(100) null,
    telefono          varchar(30)  null,
    estado_civil      varchar(3)   null,
    fecha_de_registro datetime     null,
    nombre_completo   varchar(150) null,
    estado            tinyint(1)   null,
    constraint u_clientes_dpi
        unique (dpi)
);

create table prestamos
(
    id                 int auto_increment
        primary key,
    codigo_de_prestamo varchar(100) not null,
    codigo_de_cliente  varchar(100) null,
    monto              double       null,
    cantidad_de_cuotas smallint     null,
    fecha_de_registro  datetime     null,
    constraint `u_prestamos_codigo-de_cliente`
        unique (codigo_de_cliente),
    constraint u_prestamos_codigo_de_prestamo
        unique (codigo_de_prestamo)
);


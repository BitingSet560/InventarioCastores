create database ExamenCastores;

create table ExamenCastores.dbo.roles(
	idRol tinyint identity(1,1) primary key,
	nombre varchar(50) not null,
	estatus bit not null default 1
);

create table ExamenCastores.dbo.usuarios(
	idUsuario int identity (1,1) primary key,
	nombre varchar(100) not null,
	correo varchar(50) not null,
	contrasena varchar(25)not null,
	idRol tinyint not null,
	estatus bit not null default 1,
	foreign key (idRol) references ExamenCastores.dbo.roles (idRol)
);

create table ExamenCastores.dbo.productos(
	idProducto int identity(1,1) primary key,
	nombre varchar(50) not null,
	cantidad int not null default 0,
	estatus bit default 1
);

create table ExamenCastores.dbo.Movimientos(
	idMovimiento tinyint identity(1,1) primary key,
	Nombre varchar(30),
	estatus bit default 1
);

create table ExamenCastores.dbo.historico(
	idHistorico int identity primary key,
	idUsuario int,
	idMovimiento tinyint,
	idProducto int,
	cantidad int,
	fecha datetime default GETDATE(), 
	foreign key (idUsuario) references ExamenCastores.dbo.usuarios (idUsuario),
	foreign key (idMovimiento) references ExamenCastores.dbo.Movimientos (idMovimiento),
	foreign key (idProducto) references ExamenCastores.dbo.productos (idProducto),
);

insert into ExamenCastores.dbo.roles (nombre) values ('Administrador');
insert into ExamenCastores.dbo.roles (nombre) values ('Almacenista');

insert into ExamenCastores.dbo.usuarios (nombre, correo, contrasena, idRol) values ('Angel Eduardo Hern�ndez L�pez', 'ahernandezlopez44@gmail.com', 'password', 1);
insert into ExamenCastores.dbo.usuarios (nombre, correo, contrasena, idRol) values ('Juanito P�rez G�mez', 'juanitoPG@gmail.com', 'contrasena', 2);
insert into ExamenCastores.dbo.usuarios (nombre, correo, contrasena, idRol) values ('Alberto Gutierrez L�pez', 'agutierrez@gmail.com', 'credencial', 2);

insert into ExamenCastores.dbo.productos (nombre, cantidad) values ('Laptop ASUS', 10);
insert into ExamenCastores.dbo.productos (nombre, cantidad) values ('Mouse', 10);
insert into ExamenCastores.dbo.productos (nombre, cantidad) values ('Pantalla', 10);
insert into ExamenCastores.dbo.productos (nombre, cantidad) values ('Telefono', 10);

insert into ExamenCastores.dbo.Movimientos(Nombre) values ('Entrada');
insert into ExamenCastores.dbo.Movimientos(Nombre) values ('Salida');


    create table categorie (
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table question (
        categorie_id bigint,
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table reponse (
        est_correct bit,
        id bigint not null auto_increment,
        question_id bigint,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table if exists question 
       add constraint FKhypxqpoa7acb0qqwrv57nifsn 
       foreign key (categorie_id) 
       references categorie (id);

    alter table if exists reponse 
       add constraint FKp0yq2hox7fyw8rpbhx9t514rt 
       foreign key (question_id) 
       references question (id);

    create table categorie (
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table question (
        categorie_id bigint,
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table reponse (
        est_correct bit,
        id bigint not null auto_increment,
        question_id bigint,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table if exists question 
       add constraint FKhypxqpoa7acb0qqwrv57nifsn 
       foreign key (categorie_id) 
       references categorie (id);

    alter table if exists reponse 
       add constraint FKp0yq2hox7fyw8rpbhx9t514rt 
       foreign key (question_id) 
       references question (id);

    create table categorie (
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table question (
        categorie_id bigint,
        id bigint not null auto_increment,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table reponse (
        est_correct bit,
        id bigint not null auto_increment,
        question_id bigint,
        libelle varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table if exists question 
       add constraint FKhypxqpoa7acb0qqwrv57nifsn 
       foreign key (categorie_id) 
       references categorie (id);

    alter table if exists reponse 
       add constraint FKp0yq2hox7fyw8rpbhx9t514rt 
       foreign key (question_id) 
       references question (id);

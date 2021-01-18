package com.example.demo.cmm.enm;

public enum Sql {
    CREATE_MANAGERS, CREATE_STUDENTS, CREATE_TEACHERS,
    CREATE_GRADES, CREATE_SUBJECTS, CREATE_ARTICLES, CREATE_REPLIES,
    TRUNCATE, TOTAL_COUNT, DROP_TABLE, TABLE_COUNT;
    @Override
    public String toString() {
        String query = "";
        switch(this) {
            case CREATE_MANAGERS:
                query = "create table managers(\n" +
                        "	mgr_num int primary key auto_increment,\n" +
                        "	email varchar(20),\n" +
                        "	password varchar(20),\n" +
                        "	name varchar(20),\n" +
                        "	profile_img varchar(200)\n" +
                        "	)";
                break;
            case CREATE_SUBJECTS:
                query = "create table subjects ("
                        + " sub_num int primary key auto_increment,"
                        + " subject varchar(100),"
                        + " description varchar(200))";
                break;
            case CREATE_STUDENTS:
                query = "create table students(\n" +
                        "	stu_num int primary key auto_increment,\n" +
                        "	userid varchar(20),\n" +
                        "	password varchar(20),\n" +
                        "	name varchar(20),\n" +
                        "	birthday varchar(20),\n" +
                        "	gender varchar(20),\n" +
                        "	reg_date varchar(20),\n" +
                        "	profile_img varchar(200),\n" +
                        "	mgr_num int,\n" +
                        "	constraint mgr_stu_fk foreign key(mgr_num) references managers(mgr_num)\n" +
                        "	)";
                break;
            case CREATE_TEACHERS:
                query = "create table teachers(\n" +
                        "	tea_num int primary key auto_increment,\n" +
                        "	name varchar(20),\n" +
                        "	email varchar(20),\n" +
                        "	password varchar(20),\n" +
                        "	profile_img varchar(200),\n" +
                        "	sub_num int\n," +
                        "	constraint sub_tea_fk foreign key(sub_num) references subjects(sub_num)\n" +
                        "	)";
                break;
            case CREATE_GRADES:
                query = "create table grades(\n" +
                        "	grd_num int primary key auto_increment,\n" +
                        "	score varchar(20),\n" +
                        "	grade varchar(20) default '미정',\n" +
                        "	exam_date varchar(20),\n" +
                        "	stu_num int,\n" +
                        "	sub_num int,\n" +
                        "	constraint stu_grd_fk foreign key(stu_num) references students(stu_num),\n" +
                        "   constraint sub_grd_fk foreign key(sub_num) references subjects(sub_num)\n" +
                        "	)";
                break;
            case CREATE_ARTICLES:
                query = "create table articles(\n" +
                        "	art_num int primary key auto_increment,\n" +
                        "	title varchar(20),\n" +
                        "	content varchar(20)\n," +
                        "	count varchar(20),\n" +
                        "	reg_date varchar(20),\n" +
                        "	mgr_num int,\n" +
                        "	stu_num int,\n" +
                        "	tea_num int,\n" +
                        "	constraint mgr_art_fk foreign key(mgr_num) references managers(mgr_num),\n" +
                        "	constraint stu_art_fk foreign key(stu_num) references students(stu_num),\n" +
                        "   constraint tea_art_fk foreign key(tea_num) references teachers(tea_num)\n" +
                        "	)";
                break;
            case CREATE_REPLIES:
                query = "create table replies(\n" +
                        "	rep_num int primary key auto_increment,\n" +
                        "	content varchar(20),\n" +
                        "	reg_date varchar(20),\n" +
                        "	art_num int,\n" +
                        "	mgr_num int,\n" +
                        "	stu_num int,\n" +
                        "	tea_num int,\n" +
                        "	constraint mgr_rep_fk foreign key(mgr_num) references managers(mgr_num),\n" +
                        "	constraint stu_rep_fk foreign key(stu_num) references students(stu_num),\n" +
                        "   constraint tea_rep_fk foreign key(tea_num) references teachers(tea_num),\n" +
                        "	constraint art_rep_fk foreign key(art_num) references articles(art_num)\n" +
                        "	)";
                break;
            case TRUNCATE:
                query = "truncate table ";
                break;
            case TOTAL_COUNT:
                query = "select count(*) count from ";
                break;
            case DROP_TABLE:
                query = "drop table if exists ";
                break;
            case TABLE_COUNT:
                query = "select count(*) from information_schema.tables where table_schema = \'mariadb\' ";
                break;
        }
        return query;
    }
}
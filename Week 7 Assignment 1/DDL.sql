create database if not exists twitter_db;
use twitter_db;

create table if not exists twitter_user (
	user_name varchar(30),
    user_id int unsigned primary key auto_increment,
    user_handle varchar(20),
    following_ int unsigned,
    followers int unsigned,
    user_password varchar(30),
    user_email_address varchar(30)
);

create table user_relationship (
	user_following int unsigned,
    user_followers int unsigned,
    constraint foreign key(user_following) references twitter_user(user_id),
    constraint foreign key(user_followers) references twitter_user(user_id)
);

create table if not exists tweet_data (
	tweet_id int unsigned primary key auto_increment,
    tweet_content varchar(280),
    tweet_likes int,
    tweet_comment varchar(280),
    constraint foreign key(tweet_id) references twitter_user(user_id)
);

create table if not exists tweet_to_user_relationship (
	tweet_id int unsigned,
    user_id int unsigned,
    constraint foreign key(tweet_id) references tweet_data(tweet_id),
    constraint foreign key(user_id) references twitter_user(user_id)
);
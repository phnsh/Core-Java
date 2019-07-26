use twitter_db;

-- insert data for twitter users
insert into twitter_user(user_name, user_id, user_handle, following_, followers)
	values('username', 0, '@userhandle', 83, 120);
insert into twitter_user(user_name, user_id, user_handle, following_, followers)
	values('username2', 0, '@userhandle2', 23, 10);
insert into twitter_user(user_name, user_id, user_handle, following_, followers)
	values('username3', 0, '@userhandle3', 3, 14);
insert into twitter_user(user_name, user_id, user_handle, following_, followers)
	values('username4', 0, '@userhandle4', 12, 67);
    
-- insert data for user relationship
insert into user_relationship (user_following, user_followers)
	values(1,4);
insert into user_relationship (user_following, user_followers)
	values(3,1);
insert into user_relationship (user_following, user_followers)
	values(2,3);
insert into user_relationship (user_following, user_followers)
	values(1,3);
    
-- insert tweets
insert into tweet_data(tweet_id, tweet_content, tweet_likes, tweet_comment)
	values(0, "First tweet", 12, "First comment");
insert into tweet_data(tweet_id, tweet_content, tweet_likes, tweet_comment)
	values(0, "Hello world", 5, null);
insert into tweet_data(tweet_id, tweet_content, tweet_likes, tweet_comment)
	values(0, "Good morning", 2, "Hello");
insert into tweet_data(tweet_id, tweet_content, tweet_likes, tweet_comment)
	values(0, "My first tweet", 10, null);

    
-- tweet to user_id relationship
insert into tweet_to_user_relationship(tweet_id, user_id)
	values(2, 1);
insert into tweet_to_user_relationship(tweet_id, user_id)
	values(1, 3);
insert into tweet_to_user_relationship(tweet_id, user_id)
	values(4, 2);
insert into tweet_to_user_relationship(tweet_id, user_id)
	values(3, 3);
package com.greatlearning.fsd.twitter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Comparable<User>, Serializable {

    public enum Role {
        REGULAR_USER,
        ADMIN
    }

    private final long id;
    private final String userName;
    private String profileImgUrl;
    private String coverUrl;
    private String password;
    private String firstName;
    private String lastName;
    private final Role userRole;
    private final String email;
    //initial value
    private static int userIdCount = 100;
    private final Date createdDt;
    private Date updatedDt;
    private Set<Tweet> tweets = new HashSet<>();
    private Set<User> followers = new HashSet<>();
    private Set<User> following = new HashSet<>();

    public User(String userName, String firstName, String lastName, String email){
        this.id = ++ userIdCount;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = Role.REGULAR_USER;
        this.createdDt = new Date();
        this.updatedDt = new Date();

    }
    public User(String userName, String firstName, String lastName, String email, String profileImgUrl, String coverUrl){
        this.id = ++ userIdCount;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.coverUrl = coverUrl;
        this.profileImgUrl = profileImgUrl;
        this.createdDt = new Date();
        this.updatedDt = new Date();
        this.userRole = Role.REGULAR_USER;
    }


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getUserRole() {
        return userRole;
    }

    public String getEmail() {
        return email;
    }
    public Date getCreatedDt() {
        return createdDt;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Tweet tweet){
        this.tweets.add(tweet);
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user){
        this.followers.add(user);
    }

    public Set<User> getFollowing() {
        return following;
    }

    @Override
    public int compareTo(User user) {
        return Long.valueOf(this.id).compareTo(user.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", profileImgUrl='" + profileImgUrl + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userRole=" + userRole +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(createdDt, user.createdDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, createdDt);
    }
}
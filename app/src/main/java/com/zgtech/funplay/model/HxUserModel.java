package com.zgtech.funplay.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/11.
 */

@Entity
public class HxUserModel {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "IMUSER")@Unique
    private String imUser;
    @Property(nameInDb = "USERID")
    private String userId;
    @Property(nameInDb = "HXNICKNAME")
    private String hxNickname;
    @Property(nameInDb = "HXAVATAR")
    private String hxAvatar;
    @Generated(hash = 253537063)
    public HxUserModel(Long id, String imUser, String userId, String hxNickname,
            String hxAvatar) {
        this.id = id;
        this.imUser = imUser;
        this.userId = userId;
        this.hxNickname = hxNickname;
        this.hxAvatar = hxAvatar;
    }
    @Generated(hash = 1236933987)
    public HxUserModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImUser() {
        return this.imUser;
    }
    public void setImUser(String imUser) {
        this.imUser = imUser;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getHxNickname() {
        return this.hxNickname;
    }
    public void setHxNickname(String hxNickname) {
        this.hxNickname = hxNickname;
    }
    public String getHxAvatar() {
        return this.hxAvatar;
    }
    public void setHxAvatar(String hxAvatar) {
        this.hxAvatar = hxAvatar;
    }
}

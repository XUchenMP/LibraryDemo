package com.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "用户信息",description = "用户信息")
public class User implements Serializable{

    private Integer id ;
    /** 用户名称 */
    @ApiModelProperty(name = "用户名称",notes = "用户名称")
    private String nickname ;
    /** 用户名 */
    @ApiModelProperty(name = "username",notes = "用户名")
    private String username ;
    /** 密码 */
    @ApiModelProperty(name = "password",notes = "密码")
    private String password ;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id=id;
    }
    /** 用户名称 */
    public String getNickname(){
        return this.nickname;
    }
    /** 用户名称 */
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    /** 用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名 */
    public void setUsername(String username){
        this.username=username;
    }
    /** 密码 */
    public String getPassword(){
        return this.password;
    }
    /** 密码 */
    public void setPassword(String password){
        this.password=password;
    }
}
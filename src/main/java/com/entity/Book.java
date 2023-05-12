package com.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


@ApiModel(value = "图书信息",description = "图书信息")
public class Book implements Serializable{

    private Integer id ;
    /** 书籍名称 */
    @ApiModelProperty(name = "bookName",notes = "书籍名称")
    private String bookName ;
    /** 书籍描述 */
    @ApiModelProperty(name = "bookDescribe",notes = "书籍描述")
    private String bookDescribe ;
    /** 创建人用户名 */
    @ApiModelProperty(hidden = true)
    private String creatUsername ;

    /**  */
    public Integer getId(){
        return this.id;
    }
    /**  */
    public void setId(Integer id){
        this.id=id;
    }
    /** 书籍名称 */
    public String getBookName(){
        return this.bookName;
    }
    /** 书籍名称 */
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
    /** 书籍描述 */
    public String getBookDescribe(){
        return this.bookDescribe;
    }
    /** 书籍描述 */
    public void setBookDescribe(String bookDescribe){
        this.bookDescribe=bookDescribe;
    }
    /** 创建人 */
    public String getCreatUsername(){
        return this.creatUsername;
    }
    /** 创建人 */
    public void setCreatUsername(String creatUsername){
        this.creatUsername=creatUsername;
    }
}
package com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.entity.Book;

import java.util.List;


public interface BookService{
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Book queryById(Integer id);
    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @return 查询结果
     */
    List<Book> paginQuery(Book book, Integer pageNum, Integer pageSize);
    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book insert(Book book);
    /**
     * 更新数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book update(Book book);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
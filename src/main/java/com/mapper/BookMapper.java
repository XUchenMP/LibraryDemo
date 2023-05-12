package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import com.entity.Book;


@Mapper
public interface BookMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Book queryById(Integer id);
    /**
     * 分页查询指定行数据
     *
     * @param book 查询条件
     * @return 对象列表
     */
    List<Book> queryAllByLimit(Book book);
    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int insert(Book book);
    /**
     * 更新数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int update(Book book);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
}
package com.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.entity.Book;
import com.mapper.BookMapper;
import com.service.BookService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Book queryById(Integer id){
        return bookMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @return 查询结果
     */
    public List<Book> paginQuery(Book book, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return bookMapper.queryAllByLimit(book);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    public Book insert(Book book){
        bookMapper.insert(book);
        return book;
    }

    /**
     * 更新数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    public Book update(Book book){
        bookMapper.update(book);
        return queryById(book.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id){
        int total = bookMapper.deleteById(id);
        return total > 0;
    }
}
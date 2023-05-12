package com.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.common.ResultCode;
import com.common.ResultVO;
import com.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.Book;
import com.service.BookService;


@Api(tags = "图书信息对象功能接口")
@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    private BookService bookService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{id}")
    @SaCheckPermission("book.get")
    public ResultVO<Book> queryById(Integer id){
        return ResultVO.newInstance(bookService.queryById(id));
    }

    @ApiOperation("分页查询")
    @GetMapping("/pageQuery")
    @SaCheckPermission("book.get")
    public ResultVO paginQuery(Book book, Integer pageNum, Integer pageSize){
        if (pageNum == null || pageSize == null || pageNum <= 0 || pageSize <= 0){
            return ResultVO.newInstance(ResultCode.PARAM_IS_INVALID);
        }
        return ResultVO.newInstance(bookService.paginQuery(book, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping("/add")
    @SaCheckPermission("book.add")
    public ResultVO<Book> add(Book book){
        String username = (String)StpUtil.getLoginId();
        book.setCreatUsername(username);
        return ResultVO.newInstance(bookService.insert(book));
    }

    /**
     * 更新数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PostMapping("/update")
    @SaCheckPermission("book.update")
    public ResultVO<Book> edit(Book book){
        return ResultVO.newInstance(bookService.update(book));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @PostMapping("/del")
    @SaCheckPermission("book.del")
    public ResultVO<Boolean> deleteById(Integer id){
        return ResultVO.newInstance(bookService.deleteById(id));
    }
}
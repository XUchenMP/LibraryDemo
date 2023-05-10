package com.common;

import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public class ResultVO<T> implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(ResultVO.class);
    private static final long serialVersionUID = -6956654385648512880L;
    @ApiModelProperty("是否成功")
    private boolean isSuccess;
    @ApiModelProperty("成功标识码。0成功，其他为异常")
    private String resultCode;
    @ApiModelProperty("结果说明")
    private String resultMessage;
    @ApiModelProperty("集合操作结果")
    private List<T> list;
    @ApiModelProperty("实体操作结果")
    private T object;

    public ResultVO() {
    }

    public static <T> ResultVO<T> newInstance() {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(true);
        return resultVO;
    }

    public static <T> ResultVO<T> newFailInstance() {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        return resultVO;
    }

    public static <T> ResultVO<T> newFailInstance(String resultCode, String resultMessage) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setResultCode(resultCode);
        resultVO.setResultMessage(resultMessage);
        return resultVO;
    }

    public static <T> ResultVO<T> newFailInstance(ResultCode resultCode) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setResultCode(resultCode.getCode());
        resultVO.setResultMessage(resultCode.getMessage());
        return resultVO;
    }

    public static <T> ResultVO<T> newFailInstance(String resultCode, Exception e) {
        logger.error(ResultCode.BUSINESS_EXCEPTION.getMessage(), e);
        return newFailInstance(resultCode, e.getMessage());
    }

    public static <T> ResultVO<T> newFailInstance(Exception e) {
        return newFailInstance("0", e);
    }

    public static <T> ResultVO<T> newInstance(List<T> list) {
        ResultVO<T> resultVO = new ResultVO<>();
        if (list != null) {
            resultVO.setSuccess(true);
            resultVO.setResultCode("0");
            resultVO.setList(list);
        }

        return resultVO;
    }

    public static <T> ResultVO<T> newInstance(T object) {
        ResultVO<T> resultVO = new ResultVO<>();
        if (object != null) {
            resultVO.setObject(object);
            resultVO.setSuccess(true);
        }

        return resultVO;
    }


    public static <T> ResultVO<T> newInstance(List<T> list, String resultMessage) {
        ResultVO<T> resultVO = new ResultVO<>();
        if (list != null) {
            resultVO.setSuccess(true);
            resultVO.setList(list);
            resultVO.setResultMessage(resultMessage);
        }

        return resultVO;
    }

    public static <T> ResultVO<T> newInstance(ResultCode resultCode) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(resultCode.isSuccess());
        resultVO.setResultCode(resultCode.getCode());
        resultVO.setResultMessage(resultCode.getMessage());
        return resultVO;
    }

    public static <T> ResultVO<T> newInstance(T object, String resultMessage) {
        ResultVO<T> resultVO = new ResultVO<>();
        if (object != null) {
            resultVO.setObject(object);
            resultVO.setSuccess(true);
            resultVO.setResultMessage(resultMessage);
        }

        return resultVO;
    }

    public static <T> ResultVO<T> newInstance(T object, String resultCode, String resultMessage) {
        ResultVO<T> resultVO = new ResultVO<>();
        if (object != null) {
            resultVO.setObject(object);
            resultVO.setSuccess(true);
            resultVO.setResultMessage(resultMessage);
            resultVO.setResultCode(resultCode);
        }

        return resultVO;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObject() {
        return this.object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}

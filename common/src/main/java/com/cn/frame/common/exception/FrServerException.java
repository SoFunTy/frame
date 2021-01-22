package com.cn.frame.common.exception;


import com.cn.frame.common.result.IResultCode;
import com.cn.frame.common.result.ResultCode;
import lombok.Data;

/**
 * 自定义异常类
 * @Auther yechangliang
 * @Date 2020-10-15 14:20
 */
@Data
public class FrServerException extends RuntimeException {
    private static final long serialVersionUID = -8630885345081149106L;
    private int code;
    private String msg;

    public FrServerException(IResultCode IResultCode) {
        this.code = IResultCode.getCode();
        this.msg = IResultCode.getMessage();
    }

    public FrServerException(IResultCode IResultCode, String message) {
        this.code = IResultCode.getCode();
        this.msg = message;
    }

    public FrServerException(String message) {
        super(ResultCode.ERROR.getMessage() + ":" + message);
        this.code = ResultCode.ERROR.getCode();
        this.msg = message;
    }

    public FrServerException(String message, Throwable cause) {
        super(ResultCode.ERROR.getMessage() + ":" + message, cause);
        this.code = ResultCode.ERROR.getCode();
        this.msg = message;
    }

    public FrServerException(int code, String message) {
        super(code + ":" + message);
        this.code = code;
        this.msg = message;
    }

    public FrServerException(int code, String message, Throwable cause) {
        super(code + ":" + message, cause);
        this.code = code;
        this.msg = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FrServerException)) {
            return false;
        } else {
            FrServerException other = (FrServerException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof FrServerException;
    }


    @Override
    public String toString() {
        return "FrServerException(code=" + this.getCode() + ", msg=" + this.getMsg() + ")";
    }

}

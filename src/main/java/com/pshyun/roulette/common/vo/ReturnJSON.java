package com.pshyun.roulette.common.vo;

import java.io.Serializable;

/**
 * API에서 리턴되는 JSON
 * 
 * @author ykkim
 * 
 */
@SuppressWarnings("serial")
public class ReturnJSON implements Serializable {
	private String code;		// 결과코드 api에서 사용
	private String msg;		// 리턴 메시지(실패)
	private Object data;	// 단일 객체

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

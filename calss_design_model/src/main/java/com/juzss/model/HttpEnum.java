package com.juzss.model;

// 枚举本身就是单列的,一般用于项目中定义变量
public enum HttpEnum {
   
	Http_200(200,"请求成功"),HTTP_500(500,"请求失败");
	private Integer code;
	private String msg;
	
	HttpEnum(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public static void main(String[] args) {
       System.out.println(HttpEnum.Http_200.getCode());
       System.out.println(HttpEnum.Http_200.getCode());
       System.out.println(HttpEnum.Http_200.getCode());
	}
}

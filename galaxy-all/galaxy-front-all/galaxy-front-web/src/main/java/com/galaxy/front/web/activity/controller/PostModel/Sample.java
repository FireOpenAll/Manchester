package com.galaxy.front.web.activity.controller.PostModel;

public enum Sample {

	OK("2000","message ...."),
	Failure("40000","message2 ....");

	private final String code;
	private final String message;

	private Sample(String code,String message) {
		this.code = code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	public static void main(String args[]){ 
		System.out.println(Sample.OK.getCode());
		System.out.println(Sample.Failure.getCode());
		System.out.println(Sample.OK.getMessage());
		System.out.println(Sample.Failure.getMessage());
		 
	}

	
	

}

package com.tampro.dsggraphql01.utils;

import com.tampro.dsggraphql01.model.APIResponse;
import com.tampro.response.APIStatus;

public class ResponseUtil {
	public static APIResponse responseSuccess(Object data) {
		return new APIResponse(data, APIStatus.OK);
	}
	

}

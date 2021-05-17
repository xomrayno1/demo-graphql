package com.tampro.dsggraphql01.utils;

import com.tampro.dsggraphql01.model.APIResponse;
import com.tampro.dsggraphql01.response.APIStatus;

public class ResponseUtil {
	public static APIResponse responseSuccess(Object data) {
		return buildResponse(APIStatus.OK, data);
	}
	
	public static APIResponse buildResponse(APIStatus apiStatus, Object data) {
		return new APIResponse(data, apiStatus);
	}

}

package com.tampro.dsggraphql01.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.netflix.graphql.dgs.exceptions.DefaultDataFetcherExceptionHandler;
import com.netflix.graphql.types.errors.TypedGraphQLError;

import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;

@Component
public class CustomDataFetchingExceptionHandler  implements DataFetcherExceptionHandler{

	private final DefaultDataFetcherExceptionHandler defaultHandler = new DefaultDataFetcherExceptionHandler();
	private TypedGraphQLError graphqlError = null;
	private Map<String, Object> ext = null;
	
	//handle exxception
	@Override
	public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters handlerParameters) {
		// TODO Auto-generated method stub
		if(handlerParameters.getException() instanceof StudentNotFoundException) {
			Map<String, Object> debugInfo = new HashMap<>();
            debugInfo.put("somefield", "somevalue");
			graphqlError = TypedGraphQLError.NOT_FOUND.message(((StudentNotFoundException) handlerParameters.getException()).getMsg())
                    .debugInfo(debugInfo)
                    .path(handlerParameters.getPath()).build();
            return DataFetcherExceptionHandlerResult.newResult()
                    .error(graphqlError)
                    .build();
		}else if (handlerParameters.getException() instanceof ApplicationException) {
			String msg = ((ApplicationException)handlerParameters.getException()).getMsg();
			int status = ((ApplicationException)handlerParameters.getException()).getStatus();
			
			ErrorDetail errorDetail = new ErrorDetail(new Date(), msg,status);			
			ext = new HashMap<String, Object>();
			ext.put("error", errorDetail);
			
			graphqlError = TypedGraphQLError.newBuilder().message(msg).extensions(ext).build();
			return DataFetcherExceptionHandlerResult
					.newResult()
					.error(graphqlError)
					.build();
			
		}else {
			return defaultHandler.onException(handlerParameters);
		}
		 
	}

}

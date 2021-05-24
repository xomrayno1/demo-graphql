package com.tampro.dsggraphql01.scalar;

import com.netflix.graphql.dgs.DgsScalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

@DgsScalar(name = "scalarDemo")
public class ScalarDemo  implements Coercing<Object, String>{

	@Override
	public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseValue(Object input) throws CoercingParseValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseLiteral(Object input) throws CoercingParseLiteralException {
		// TODO Auto-generated method stub
		return null;
	}

}

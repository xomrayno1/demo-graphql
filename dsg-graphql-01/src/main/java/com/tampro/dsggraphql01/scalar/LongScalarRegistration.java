package com.tampro.dsggraphql01.scalar;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;

import graphql.Scalars;
import graphql.schema.idl.RuntimeWiring;

@DgsComponent
public class LongScalarRegistration {
	@DgsRuntimeWiring
	public RuntimeWiring.Builder addScalar(RuntimeWiring.Builder builder) {
        return builder.scalar(Scalars.GraphQLLong);
    }
}

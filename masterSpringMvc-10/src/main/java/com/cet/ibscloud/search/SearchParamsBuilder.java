package com.cet.ibscloud.search;

import com.cet.ibscloud.search.SearchParameters.ResultType;

public class SearchParamsBuilder {
	public static SearchParameters createSearchParam(String searchType, String taste) {
		SearchParameters.ResultType resultType = getResultType(searchType);
		SearchParameters searchParameters = new SearchParameters(taste);
		searchParameters.setResultType(resultType);
		searchParameters.count(3);
		return searchParameters;
	}

	private static SearchParameters.ResultType getResultType(String searchType) {
		for (SearchParameters.ResultType knownType : SearchParameters.ResultType.values()) {
			if (knownType.getName().equalsIgnoreCase(searchType)) {
				return knownType;
			}
		}
		return ResultType.RECENT;
	}

}

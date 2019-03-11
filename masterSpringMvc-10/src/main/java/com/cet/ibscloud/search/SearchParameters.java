package com.cet.ibscloud.search;

public class SearchParameters {

	private ResultType resultType;
	
	private String tastes;
	
	public String getTastes() {
		return tastes;
	}

	public void setTastes(String tastes) {
		this.tastes = tastes;
	}

	public SearchParameters(String tastes) {
		
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public void count(Integer num) {
		
	}
	
	public static class ResultType {

		public ResultType() {

		}

		public ResultType(String name) {
			this.name = name;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static final ResultType RECENT = new ResultType("RECENT");

		public static ResultType[] values() {
			ResultType[] resultTypes = new ResultType[10];
			for (Integer i = 0; i < 10; i++) {
				resultTypes[i] = new ResultType("type" + i);
			}
			return resultTypes;
		}

	}

}

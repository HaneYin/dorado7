package com.bstek.dorado.sample.standardlesson.utils;

public class StringUtils {
	
	public static String createAutoIncrementStr(String tableName, String idName, String sequenceName, String triggerName) {
		String sequence = "create sequence " + sequenceName + "\nminvalue 1\n"
				+ "maxvalue 9999999999999999999999999999\n"
				+ "start with 1 \nincrement by 1 \nnocache;";
		System.out.println("序列：\n" + sequence);
		String trigger = "create or replace trigger " + triggerName + "\nbefore insert on " + tableName + "\n"
				+ "for each row\n"
				+ "declare\n"
				+ "begin\n"
				+ "select " + sequenceName + ".nextval into :new." + idName + " from dual;\n"
				+ "end " + triggerName + ";";
		System.out.println("\n触发器：\n" + trigger);
		return null;
	}
	
	public static void main(String[] args) {
		createAutoIncrementStr("sl_company", "company_id", "company_autoinc", "company_trigger");
	}
	
}

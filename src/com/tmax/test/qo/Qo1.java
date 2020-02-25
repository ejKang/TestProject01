package com.tmax.test.qo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.tmax.proobject.dataobject.factory.DBDataObjectFactory.DBType;
import com.tmax.proobject.dataobject.factory.QueryInfo;
import com.tmax.proobject.dataobject.model.Parameter;
import com.tmax.proobject.dataobject.model.Parameter.ParameterBuilder;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.test.data.Do1;

public enum Qo1 implements QueryInfo
{
	QWEQ("select * from dev_rsc")
	;
	
	private final String value;
	private Map<String, Parameter> parameters = new LinkedHashMap<String, Parameter>();
	private List<String> tables = new ArrayList<String>();
	
	Qo1(String value) {
		this.value = value;
	}
	
	@Override
	public String value() {
		return value;
	}
	
	public static Qo1 fromValue(String alias) {
		return valueOf(alias);
	}
	
	@Override
	public DBType getType() {
		switch(this) {
			case QWEQ : return DBType.SELECT;
			default : return null;
		}
	}
	
	@Override
	public boolean isDynamicQuery() {
		switch(this) {
			default : return false;
		}
	}
	
	@Override
	public int getDynamicKeywordCount() {
		switch(this) {
			default : return 0;
		}
	}
	
	@Override
	public Class<? extends DataObject> getResultType() {
		switch(this) {
			case QWEQ : return Do1.class;
			default : return null;
		}
	}
	
	@Override
	public Map<String, Parameter> getParameterInfo() {
		switch(this) {
			default : return null;
		}
	}
	
	
	@Override
	public List<String> getTableList() {
		switch(this) {
			case QWEQ : return getQWEQTableList();
			default : return null;
		}
	}
	
	protected List<String> getQWEQTableList() {
		if(tables.isEmpty()) {
			tables.add("dev_rsc");
			tables = Collections.unmodifiableList(tables);
		}
		
		return tables;
	}
	
}


package com.tmax.test.dof;


import com.tmax.proobject.dataobject.factory.FileDataObjectFactory;
import com.tmax.proobject.model.dataobjectfactory.RecordFormatType;

import com.tmax.test.data.Do1;

import com.tmax.proobject.model.exception.FieldNotFoundException;

public class DofFile1 extends FileDataObjectFactory<Do1>
{
	
	public DofFile1() {
		super(RecordFormatType.DELIMITER);
	}
	
	public DofFile1(String filePath, boolean isAppend) {
		super(RecordFormatType.DELIMITER, filePath, isAppend);
	}
	
	private Do1 _do1 = new Do1();
	
	
	@Override
	public void init() {
		_do1 = new Do1();
		super.init();
	}
	
	
	@Override
	protected String getDelimiter() {
	    return ",";
	}
	
	@Override
	protected void onPrepareDataObject(Do1 dataObject) {
		_do1 = (Do1) dataObject;
	}
	
	
	
	@Override
	public Object getField(String fieldName) throws FieldNotFoundException {
		return _do1.get(fieldName);
	}
	
	@Override
	public void setField(String fieldName, Object value) throws FieldNotFoundException {
		_do1.set(fieldName, value);
	}
	
	
	@Override
	protected void onWrite() {
	    setValue(String.class, _do1.get("class_name"), false);
	}
	
	@Override
	protected Do1 onRead() {
		Do1 result = new Do1();
	    result.set("class_name", read(String.class, 512));
	    
	    return result;
	}
	
	@Override
	public String toString() {
	    return "DofFile1 [" + super.toString()
	        + "]";
	}
}


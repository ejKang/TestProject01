package com.tmax.proobject.devserver.dof.util;

        
import java.sql.PreparedStatement;
import com.tmax.proobject.model.dataobject.Session;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.devserver.dto.DeployStatDTO;
import com.tmax.proobject.dataobject.factory.Query;
import com.tmax.proobject.dataobject.factory.DBDataObjectFactory;
import com.tmax.proobject.dataobject.model.MetaField;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import com.tmax.proobject.model.exception.FieldNotFoundException;

public class TestDof extends DBDataObjectFactory<DeployStatDTO>
{
	public TestDof(){
		super();
	}
	
	public TestDof(Session session){
		super(session);
	}
	
	public TestDof(String datasource){
		super(datasource);
	}
	
	public TestDof(String datasource, boolean autocommit){
			super(datasource, autocommit);
	}
	
	private String _node_id;
	private String _resource_id;
	
	
	public static enum FULLQUERY  implements Query {
		SELECT_DEPLOY_HISTORY_NODE("select * from  \n"
		                                  + "dev_rsc_deploy_stat \n"
		                                  + "where resource_id =? \n"
		                                  + "and node_id=?")
	;
		private final String value;
	
		FULLQUERY(String v) {
			value = v;
		}
	
		public String value() {
			return value;
		}
	
		public static FULLQUERY fromValue(String v) {
			return valueOf(v);
		}
		
		public static Query getDefaultQuery(DBType type) {
			switch(type) {
				case SELECT :
					return FULLQUERY.SELECT_DEPLOY_HISTORY_NODE;
				default :
					return null;
			}
		}
	}
	
	
	 	
	private static String[] _QUERY_TABLES = {"dev_rsc_deploy_stat"};
	private static List<MetaField> _FACTORY_FIELDS = new ArrayList<MetaField>();
	
	@Override
	public void init() {
		_node_id = null;
		_resource_id = null;
		super.init();
	}
	
	@Override
	public String[] getQueryTables() {
	    return _QUERY_TABLES.clone();
	}      
	
	@Override
	public Query getDefaultQuery(DBType type) {
		return FULLQUERY.getDefaultQuery(type);
	}
	
	@Override
	public DeployStatDTO getDataObject() {
		return new DeployStatDTO();
	}
	
	public void setFullQuery(TestDof.FULLQUERY query) {
		useFullQuery = true;
		this.query = query;
	}
	
	public void setFullQuery(String name) {
		TestDof.FULLQUERY query = TestDof.FULLQUERY.valueOf(name);
		setFullQuery(query);
	}
	
	@Override
	public List<MetaField> getFactoryFields() {
		return _FACTORY_FIELDS;
	}
	
	public String getNode_id() {
	    return _node_id;
	}
	
	public void setNode_id(String _node_id) {
	    this._node_id = _node_id;
	}
	
	
	public String getResource_id() {
	    return _resource_id;
	}
	
	public void setResource_id(String _resource_id) {
	    this._resource_id = _resource_id;
	}
	
	
	
	@Override
	public Object getField(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
		case "node_id" : return _node_id;
		case "resource_id" : return _resource_id;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}    
	
	@Override
	public void setField(String fieldName, Object value) throws FieldNotFoundException {
		switch(fieldName) {
		case "node_id" : this._node_id = ((String)value); break;
		case "resource_id" : this._resource_id = ((String)value); break;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	@Override
	public Class<?> getFieldClassType(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "node_id" :
				return String.class;
			case "resource_id" :
				return String.class;
			default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	
	
	
	@Override
	public void onPrepareFullQuery(PreparedStatement ps, DataObject dataObject) {
		if(useFullQuery && query == TestDof.FULLQUERY.SELECT_DEPLOY_HISTORY_NODE) {
			onPrepareFullQuerySelect_deploy_history_node(ps, (DeployStatDTO)dataObject);
		}
	}
	
	public void onPrepareFullQuerySelect_deploy_history_node (PreparedStatement ps, DeployStatDTO dataObject) {
		set(index++, String.class, this._resource_id, ps);
		set(index++, String.class, this._node_id, ps);
	}
	
	static {
		_FACTORY_FIELDS.add(new MetaField("node_id",String.class,"","","",false,false));
		_FACTORY_FIELDS.add(new MetaField("resource_id",String.class,"","","",false,false));
	
		_FACTORY_FIELDS = Collections.unmodifiableList(_FACTORY_FIELDS);
	}
	
	@Override
	public int add(DataObject insert, boolean immediate) {
		return super.add(insert, immediate);
	}
	@Override
	public int add(DeployStatDTO insert, String... autoIncreasedFields) {
		return super.add(insert, autoIncreasedFields);
	}
	@Override
	public int update(DataObject update, boolean immediate) {
		return super.update(update, immediate);
	}
	@Override
	public int update(DataObject update, String... autoIncreasedColumns) {
		return super.update(update, autoIncreasedColumns);
	}
	    
	
	@Override
	public String toString() {
	    return "TestDof [" + super.toString()
	        + ", node_id=" + _node_id
	        + ", resource_id=" + _resource_id
	        + "]";
	}
}


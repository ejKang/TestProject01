package com.tmax.test.dof;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import java.util.HashMap;
import java.util.Map;
import com.tmax.proobject.dataobject.factory.DynamicQuery;
import com.tmax.proobject.dataobject.dynamic.util.DynamicQueryUtil;
        
import java.sql.PreparedStatement;
import com.tmax.proobject.model.dataobject.Session;
import java.math.BigDecimal;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.test.data.DDD2;
import com.tmax.proobject.dataobject.factory.Query;
import com.tmax.proobject.dataobject.factory.DBDataObjectFactory;
import com.tmax.proobject.dataobject.model.MetaField;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import com.tmax.proobject.model.exception.FieldNotFoundException;

public class Dof1 extends DBDataObjectFactory<DDD2>
{
	public Dof1(){
		super();
	}
	
	public Dof1(Session session){
		super(session);
	}
	
	public Dof1(String datasource){
		super(datasource);
	}
	
	public Dof1(String datasource, boolean autocommit){
			super(datasource, autocommit);
	}
	
	private String _node_id;
	private BigDecimal _qwe;
	private String _resource_id;
	
	
	public static enum FULLQUERY  implements Query {
		ABC("select physical_name from dev_rsc    "),
		TTT("select * from dev_rsc_prop"),
		SDFSDF("select * from dev_rsc where resource_id=? and node_id=?")
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
					return FULLQUERY.SDFSDF;
				default :
					return null;
			}
		}
	}
	
	
	public static enum DynamicQueryImple  implements DynamicQuery<Dof1> {
		
			DYNAMICTEST("select * from dev_${qwe}"){
				@Override
				public String getDynamicQuery(Dof1 factory) {
					Map<String,Object> varMap = factory.getMybatisdynamicVariableTempMap();
					for(MetaField meta: factory.getFactoryFields()){
					varMap.put( meta.getFieldName(), factory.getField(meta.getFieldName()));
					}
					ExpressionEvaluator evaluator = new ExpressionEvaluator();
					StringBuilder sqlSrcBuilder = new StringBuilder();
					{
					  sqlSrcBuilder.append("select * from dev_${qwe}\n");
					}
					String query = sqlSrcBuilder.toString();
					query = DynamicQueryUtil.getInstance().replaceConstVariable(query, varMap);
					return query;
				}
			}
			
	;	DynamicQueryImple(String script){
		            this.script = script;
		        }
		public final String script;
	
		public String getScript(){
			return script;
		}
		
		public String value(){
					return script;
				}
	
		public static DynamicQueryImple fromValue(String v) {
			return valueOf(v);
		}
		
		public static Query getDefaultQuery(DBType type) {
			switch(type) {
				case SELECT :
					return FULLQUERY.SDFSDF;
				default :
					return null;
			}
		}
	}
	 	
	private static String[] _QUERY_TABLES = {"dev_rsc", "dev_rsc_prop"};
	private static List<MetaField> _FACTORY_FIELDS = new ArrayList<MetaField>();
	
	@Override
	public void init() {
		_node_id = null;
		_qwe = null;
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
	public DDD2 getDataObject() {
		return new DDD2();
	}
	
	public void setFullQuery(Dof1.FULLQUERY query) {
		useFullQuery = true;
		this.query = query;
	}
	
	public void setFullQuery(String name) {
		Dof1.FULLQUERY query = Dof1.FULLQUERY.valueOf(name);
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
	
	
	public BigDecimal getQwe() {
	    return _qwe;
	}
	
	public void setQwe(BigDecimal _qwe) {
	    this._qwe = _qwe;
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
		case "qwe" : return _qwe;
		case "resource_id" : return _resource_id;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}    
	
	@Override
	public void setField(String fieldName, Object value) throws FieldNotFoundException {
		switch(fieldName) {
		case "node_id" : this._node_id = ((String)value); break;
		case "qwe" : this._qwe = ((BigDecimal)value); break;
		case "resource_id" : this._resource_id = ((String)value); break;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	@Override
	public Class<?> getFieldClassType(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "node_id" :
				return String.class;
			case "qwe" :
				return BigDecimal.class;
			case "resource_id" :
				return String.class;
			default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	
	
	
	@Override
	public void onPrepareFullQuery(PreparedStatement ps, DataObject dataObject) {
		if(useFullQuery && query == Dof1.FULLQUERY.SDFSDF) {
			onPrepareFullQuerySdfsdf(ps, (DDD2)dataObject);
		}
	}
	
	
	
	public void onPrepareFullQuerySdfsdf (PreparedStatement ps, DDD2 dataObject) {
		set(index++, String.class, this._resource_id, ps);
		set(index++, String.class, this._node_id, ps);
	}
	
	static {
		_FACTORY_FIELDS.add(new MetaField("node_id",String.class,"","","",false,false));
		_FACTORY_FIELDS.add(new MetaField("qwe",BigDecimal.class,"","","",false,false));
		_FACTORY_FIELDS.add(new MetaField("resource_id",String.class,"","","",false,false));
	
		_FACTORY_FIELDS = Collections.unmodifiableList(_FACTORY_FIELDS);
	}
	
	@Override
	public int add(DataObject insert, boolean immediate) {
		return super.add(insert, immediate);
	}
	@Override
	public int add(DDD2 insert, String... autoIncreasedFields) {
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
	    return "Dof1 [" + super.toString()
	        + ", node_id=" + _node_id
	        + ", qwe=" + _qwe
	        + ", resource_id=" + _resource_id
	        + "]";
	}
}


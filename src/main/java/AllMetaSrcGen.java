import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.google.common.base.Throwables;
import com.tmax.proobject.codegen.CodeGeneratorFactory;
import com.tmax.proobject.codegen.IGenerator;
import com.tmax.proobject.codegen.impl.DecoratedGenerator;
import com.tmax.proobject.codegen.impl.FilePrefixGenerator;
import com.tmax.proobject.codegen.util.TestSourceGenContext;
import com.tmax.proobject.model.ProObjectResource;
import com.tmax.proobject.model.bizobject.BizObjectType;
import com.tmax.proobject.model.dataobjectfactory.DataObjectfactoryType;
import com.tmax.proobject.model.jobobject.JobObjectType;
import com.tmax.proobject.model.serviceobject.ServiceObjectType;
import com.tmax.proobject.model.taskobject.BlockType;
import com.tmax.proobject.model.util.JaxbUtil;
import com.tmax.proobject.model.util.JobObjectTypeConverter;
import com.tmax.proobject.srcgen.dataobjectfactory.DataObjectFactorySrcGenerator;
import com.tmax.proobject.srcgen.jobobject.JobBlockExecGenerator;
import com.tmax.proobject.srcgen.jobobject.JobBlockGenerator;
import com.tmax.proobject.srcgen.jobobject.JobExecGenerator;
import com.tmax.proobject.srcgen.jobobject.JobObjectGenerator;
import com.tmax.proobject.srcgen.sobo.BizObjectGenerator;
import com.tmax.proobject.srcgen.sobo.ServiceObjectGenerator;
import com.tmax.proobject.srcgen.template.CommentHistoryType;
import com.tmax.proobject.srcgen.template.CommentTemplateType;

public class AllMetaSrcGen {
	 
    private static final String KEY_FILENAME = "fileName";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_EXTENSION = "ext";
	private static final Logger logger = Logger.getLogger(AllMetaSrcGen.class.getName());
	private static FileHandler fileHandler;

	public static void main(String[] args){
		
		logger.info("--------main() start--------");
//		addFileHandler(logger);
		
		String sgName =  args[0];
		logger.info("---------------args[0]-:  " + sgName);
        ArrayList<String> metaPathArray = null;
		
		try{
        	
			logger.info("--------AllMetaSrcGen start--------");
			
			metaPathArray = new ArrayList<String>();

            searchInfo(sgName + "/meta", metaPathArray);
            generateSrc(metaPathArray, sgName);
       
        }catch(Throwable e){
        	logger.info("stack : " + Throwables.getStackTraceAsString(e));
            logger.info(e.getMessage());
            System.exit(1);
        }
		
		logger.info("--------AllMetaSrcGen end--------");
		
		System.exit(0);
		
	}
	
	private static void generateSrc(List<String> fileList, String sgName) throws Exception{

		deleteFile(sgName + "/" + ".gen_src");
		
        for (String filePath : fileList) {
            logger.info(filePath + " is on process");
            
            Map<String, String> fileNameInfoMap = checkOranizeFilePath(filePath);
            
            if(fileNameInfoMap == null)
                continue;
                                    
            File gen_src = new File(sgName + "/" + ".gen_src");
                                  
            if(!gen_src.exists()){
                logger.info("create .gen_src : " + gen_src.getPath());
                gen_src.mkdirs();
                gen_src.setExecutable(true, false);
                gen_src.setReadable(true, false);
                gen_src.setWritable(true, false);
            }
                      
            gen_src = null;
            
            String metaReplace="";
            if(fileNameInfoMap.get(KEY_EXTENSION).equals("dto") || fileNameInfoMap.get(KEY_EXTENSION).equals("msg")){
                metaReplace=".gen_src/dto";
            }else{
                metaReplace=".gen_src";
            }
            
            String srcDirPath = sgName + "/" 
                    + metaReplace + "/"
                    + fileNameInfoMap.get(KEY_PACKAGE);
            
            String srcPath = srcDirPath + "/" 
                    + fileNameInfoMap.get(KEY_FILENAME) + "." 
                    + "java";
                                   
            File metaFile = new File(filePath);
            File srcFile = new File(srcPath);
                               
            logger.info(filePath +" in on Source Generation");
            //srcgen을 한다.
            ProObjectResource model;
//            MemoryCalculatorAjGenerator memoryCalcGenerator;
            StringBuilder sb = new StringBuilder();
            StringBuilder esb = new StringBuilder();
//            StringBuilder aj = new StringBuilder();
//            
//            String ajName = "";
            
            if(fileNameInfoMap.get(KEY_EXTENSION).equals("dto") || fileNameInfoMap.get(KEY_EXTENSION).equals("msg")){
                model = com.tmax.proobject.codegen.util.JaxbUtil.unmarshalDto(metaFile);
                TestSourceGenContext context = new TestSourceGenContext();
                context.setResource(model);

                
                CommentTemplateType commTemplateType = new CommentTemplateType();
                commTemplateType.setClassTemplate("");
                commTemplateType.setHistoryTemplate("");
                commTemplateType.setLicenseTemplate("");
                commTemplateType.setMethodTemplate("");
                
                CommentHistoryType commHistoryType = new CommentHistoryType();
                
                context.setProperty("commentTemplateType", commTemplateType);
                context.setProperty("commentHistoryType", commHistoryType);
                IGenerator dtoGen = new DecoratedGenerator(new FilePrefixGenerator(), CodeGeneratorFactory.getGenerator(model), null);                
                sb.append(dtoGen.generate(context, model));

            }else if(fileNameInfoMap.get(KEY_EXTENSION).equals("so")){
                model = JaxbUtil.unmarshalServiceObject(metaFile);
//                ServiceObjectType sm = (ServiceObjectType)model;        
//                memoryCalcGenerator = new MemoryCalculatorAjGenerator((ServiceObjectType)model);
                
//                SoGenerator so = new SoGenerator((ServiceObjectType)model);
                
                sb.append(ServiceObjectGenerator.generateByString((ServiceObjectType) model));
                esb.append(ServiceObjectGenerator.generateExecutorByString((ServiceObjectType)model));
//                aj.append(memoryCalcGenerator.generate());
//                ajName = sm.getOutputDo().getPhysicalName();
                
            }else if(fileNameInfoMap.get(KEY_EXTENSION).equals("bo")){
                model = JaxbUtil.unmarshalBizObject(metaFile);
                
//                BoGenerator bo = new BoGenerator((BizObjectType)model);
                sb.append(BizObjectGenerator.generateByString((BizObjectType)model));
                
            }else if(fileNameInfoMap.get(KEY_EXTENSION).equals("factory")){
                model = JaxbUtil.unmarshalDataObjectFactory(metaFile);
                sb.append(DataObjectFactorySrcGenerator.generate((DataObjectfactoryType)model));
            }else if(fileNameInfoMap.get(KEY_EXTENSION).equals("jo")){
            	
            	StringBuilder js = new StringBuilder();
            	StringBuilder je = new StringBuilder();
            	
            	JobObjectType jmodel;
            	
            	jmodel = JaxbUtil.unmarshalJobObject(metaFile);
            	JobObjectTypeConverter.setFileType(jmodel);
            	
            	JobObjectGenerator srcGen = new JobObjectGenerator(jmodel);
            	JobExecGenerator exeGen = new JobExecGenerator(jmodel);
            	
            	js.append(srcGen.generate());
            	je.append(exeGen.generate());
            	
            	srcFile.setExecutable(true, false);
                srcFile.setReadable(true, false);
                srcFile.setWritable(true, false);
                                             
                if(!srcFile.exists()){
                    File srcDirPathFile = new File(srcDirPath);
                    if(!srcDirPathFile.exists()){
                        logger.info(srcDirPath + " create dirs");
                        srcDirPathFile.mkdirs();
                        srcDirPathFile.setExecutable(true, false);
                        srcDirPathFile.setReadable(true, false);
                        srcDirPathFile.setWritable(true, false);
                    }
                    
                    logger.info(srcFile + " create file");
                    srcFile.createNewFile();
                }
                  
                BufferedWriter bwf = new BufferedWriter(new FileWriter(srcFile));
                bwf.write(js.toString());
                logger.info(srcPath + " write .java");
                
                bwf.close();
                
                //for JO Executor
                if(je.toString().length() > 0){
                    String executorPath = srcDirPath + "/" 
                            + fileNameInfoMap.get(KEY_FILENAME) + "Executor" + "." 
                            + "java";
                    File executorFile = new File(executorPath);
                    
                    executorFile.setExecutable(true, false);
                    executorFile.setReadable(true, false);
                    executorFile.setWritable(true, false);
                    
                    executorFile.createNewFile();
                    logger.info(executorPath + " create file");
                                        
                    BufferedWriter bwf2 = new BufferedWriter(new FileWriter(executorFile));
                    bwf2.write(je.toString());
                    logger.info(executorPath + " write .java");
                    bwf2.close();
                    
                }
                
                for(BlockType taskType : jmodel.getTaskList().getBlock()){
                	if(taskType.getFileType()==null) continue;
                	
                	StringBuilder jbs = new StringBuilder();
                	StringBuilder jbe = new StringBuilder();
                	
                	JobBlockGenerator blockGen = new JobBlockGenerator(taskType);
                	JobBlockExecGenerator blockExecGen = new JobBlockExecGenerator(taskType);
                	
                	jbs.append(blockGen.generate());
                	jbe.append(blockExecGen.generate());
                	
                	srcFile.setExecutable(true, false);
                    srcFile.setReadable(true, false);
                    srcFile.setWritable(true, false);
                    
                    //for JO Block
                    if(jbs.toString().length() > 0){
                        String blockPath = srcDirPath + "/" 
                                + taskType.getFileType().getPhysicalName() + "." 
                                + "java";
                        File blockFile = new File(blockPath);
                        
                        blockFile.setExecutable(true, false);
                        blockFile.setReadable(true, false);
                        blockFile.setWritable(true, false);
                        
                        blockFile.createNewFile();
                        logger.info(blockPath + " create file");
                                            
                        BufferedWriter bwe = new BufferedWriter(new FileWriter(blockFile));
                        bwe.write(jbs.toString());
                        logger.info(blockPath + " write .java");
                        bwe.close();
                        
                    }
                    
                    //for JO Block Executor
                    if(jbe.toString().length() > 0){
                        String executorPath = srcDirPath + "/" 
                                + taskType.getFileType().getPhysicalName() + "Executor" + "." 
                                + "java";
                        File executorFile = new File(executorPath);
                        
                        executorFile.setExecutable(true, false);
                        executorFile.setReadable(true, false);
                        executorFile.setWritable(true, false);
                        
                        executorFile.createNewFile();
                        logger.info(executorPath + " create file");
                                            
                        BufferedWriter bwe2 = new BufferedWriter(new FileWriter(executorFile));
                        bwe2.write(jbe.toString());
                        logger.info(executorPath + " write .java");
                        bwe2.close();
                        
                    }
                	
                }
            }
            
            
            if(!fileNameInfoMap.get(KEY_EXTENSION).equals("jo")){
            	
	            //file 쓰기
	            srcFile.setExecutable(true, false);
	            srcFile.setReadable(true, false);
	            srcFile.setWritable(true, false);
	            
	          	            
	            if(!srcFile.exists()){
	                File srcDirPathFile = new File(srcDirPath);
	                if(!srcDirPathFile.exists()){
	                    logger.info(srcDirPath + " create dirs");
	                    srcDirPathFile.mkdirs();
	                    srcDirPathFile.setExecutable(true, false);
	                    srcDirPathFile.setReadable(true, false);
	                    srcDirPathFile.setWritable(true, false);
	                }
	                
	                logger.info(srcFile + " create file");
	                srcFile.createNewFile();
	            }
	            
	            
	            BufferedWriter bw = new BufferedWriter(new FileWriter(srcFile));
	            bw.write(sb.toString());
	            logger.info(srcPath + " write .java");
	            
	            bw.close();
	            
	            //for SO Executor
	            if(esb.toString().length() > 0){
	                String executorPath = srcDirPath + "/" 
	                        + fileNameInfoMap.get(KEY_FILENAME) + "Executor" + "." 
	                        + "java";
	                File executorFile = new File(executorPath);
	                
	                executorFile.setExecutable(true, false);
	                executorFile.setReadable(true, false);
	                executorFile.setWritable(true, false);
	                
	                executorFile.createNewFile();
	                logger.info(executorPath + " create file");
	                
	                
	                BufferedWriter bw2 = new BufferedWriter(new FileWriter(executorFile));
	                bw2.write(esb.toString());
	                logger.info(executorPath + " write .java");
	                bw2.close();
	                
	            }
	            
	//            // for aj
	//            if(aj.toString().length() > 0){
	//                String ajPath = ajDirPath + "/" 
	//                        + ajName + "MemoryCalc" + "." 
	//                        + "aj";
	//                File ajFile = new File(ajPath);
	//                
	//                ajFile.setExecutable(true, false);
	//                ajFile.setReadable(true, false);
	//                ajFile.setWritable(true, false);
	//                
	//                ajFile.createNewFile();              
	//                
	//                BufferedWriter bw3 = new BufferedWriter(new FileWriter(ajFile));
	//                bw3.write(aj.toString());
	//                bw3.close();
	//                
	//            }
            }
        }
    }
	
	private static Map<String, String> checkOranizeFilePath(String filePath){
        String[] a = filePath.split("/");        
                
        String fileNameOnlyWithExt = a[a.length-1];
        String fileNameOnly = fileNameOnlyWithExt.substring(0, fileNameOnlyWithExt.lastIndexOf("."));
        String ext = fileNameOnlyWithExt.substring(fileNameOnlyWithExt.lastIndexOf(".")+1);
        
        if(!ext.equals("dto") &&
                !ext.equals("bo")&&
                !ext.equals("so")&&
                !ext.equals("factory")&&
                !ext.equals("msg")&&
                !ext.equals("jo")){//not source generation target
            logger.info(filePath + " is not source generation target");
            return null;
        }
        
        String packageName="";
        for(int i=2; i<a.length-1; i++){
            if(i > 2)
                packageName = packageName + "/" + a[i];
            else
                packageName = packageName + a[i];
        }
              
        Map<String, String>pathMap = new HashMap<>();
                
        pathMap.put(KEY_PACKAGE, packageName);
        pathMap.put(KEY_FILENAME, fileNameOnly);
        pathMap.put(KEY_EXTENSION, ext);
        
        
        return pathMap;
    }
	
	public static void searchInfo(String dirName, ArrayList<String> srcPathArray)
			throws IOException {

		File dir = new File(dirName);
		logger.info("2---------------dir-:  " + dir.toString());
		File[] fileList = dir.listFiles();

		if (fileList.length == 0 || fileList == null) {
			// end
			logger.info("3---------------fileList = 0-:  " );
		}

		for (File file : fileList) {//1. number of module
			if (file.isFile()) {// find java file

				String fileName = file.getName();
				int index = fileName.lastIndexOf(".");
				String ext = fileName.substring(index + 1);

				if (ext.equals("dto") ||
		                ext.equals("bo") ||
		                ext.equals("so") ||
		                ext.equals("factory")||
		                ext.equals("msg") ||
		                ext.equals("jo")) {
					srcPathArray.add(file.getPath());
					logger.info("find meta file! : " + file.getCanonicalPath());
				}

			} else {// 폴더면 들어가기
				String folderName = file.getName();
				String newDir = dirName + File.separatorChar + folderName;
				
				searchInfo(newDir, srcPathArray);

			}
		}
	}
	
	private static void addFileHandler(Logger logger){
        try {
            // 파일저장
            fileHandler = new FileHandler(".git/tmax/AllMetaSrcGen.log");
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        logger.addHandler(fileHandler);
    }
	
	public static void deleteFile(String path) {
		File deleteFolder = new File(path);

		if(deleteFolder.exists()){
			File[] deleteFolderList = deleteFolder.listFiles();
			
			for (int i = 0; i < deleteFolderList.length; i++) {
				if(deleteFolderList[i].isFile()) {
					deleteFolderList[i].delete();
				}else {
					deleteFile(deleteFolderList[i].getPath());
				}
				deleteFolderList[i].delete(); 
			}
			deleteFolder.delete();
		}
	}


}

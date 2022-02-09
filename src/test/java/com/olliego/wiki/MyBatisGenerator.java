package com.olliego.wiki;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

/**
 *  运行此方法生成mybatis代码
 *  生成代码自动放入对应目录
 * @author wangshu
 * @create 2019/10/18
 */
public class MyBatisGenerator {
    //数据库类型
    private final DbType dbType = DbType.MYSQL;
    //数据库连结信息
    private final String dbUrl = "jdbc:mysql://localhost:3306/wiki?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String userName = "wiki";
    private final String password = "1234";

    //项目名
    private final String projectName = "wiki";
    //指定包名
    private final String packageName = "com.olliego.wiki";

    //作者名
    private final String author = "admin";
    //指定生成的表名
    private final String[] tableNames = new String[]{"test"};

    //输出的目录
    public static final String OUT_DIR = "/src/main/java/";

    @Test
    public void generateCode() {
        //serviceNameStartWithI：user -> UserService, 设置成true: user -> IUserService
        generateByTables(false, packageName, tableNames);
    }
    /**
     * 根据表自动生成
     * @param serviceNameStartWithI 默认为false
     * @param packageName      包名
     * @param tableNames      表名
     * @author Terry
     */
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        //包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }
    /**
     * 集成
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig  策略配置
     * @param config      全局变量配置
     * @param packageConfig  包名配置
     * @author Terry
     */
    private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
    /**
     * 设置包名
     * @param packageName 父路径包名
     * @param packageName 模块名
     * @return PackageConfig 包名配置
     * @author Terry
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setXml("mapper.xml")
                .setMapper("mapper")
                .setController("controller")
                //.setEntity("entity");
                .setEntity("model");
    }
    /**
     * 全局配置
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     * @author Terry
     */
    private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        //获取工程的根目录
        String projectPath = System.getProperty("user.dir");//得到当前项目的路径

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setActiveRecord(false)
                //作者
                .setAuthor(author)
                //设置输出路径

                //"E:/repository/git-repository/project/" + projectName + "/src/main/java/";
                .setOutputDir(projectPath + OUT_DIR)
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            //设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }

    /**
     * 策略配置
     * @param tableNames 表名
     * @return StrategyConfig
     * @author Terry
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
//                .setCapitalMode(true)
//                //从数据库表到文件的命名策略
//                .setNaming(NamingStrategy.underline_to_camel)
//                //需要生成的的表名，多个表名传数组
//                .setInclude(tableNames)
//                //公共父类
//                //.setSuperControllerClass(superControllerClass)
//                //.setSuperEntityClass(superEntityClass)
//                // 写于父类中的公共字段
//                //.setSuperEntityColumns("id")
//                //使用lombok
//                .setEntityLombokModel(true)
//                //rest风格
//                .setRestControllerStyle(true);

                //全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                //从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityTableFieldAnnotationEnable(true)
                .setControllerMappingHyphenStyle(true)
                //需要生成的的表名，多个表名传数组
                .setInclude(tableNames)
                //rest风格
                .setRestControllerStyle(true);
    }
    /**
     * 配置数据源
     * @return 数据源配置 DataSourceConfig
     * @author Terry
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(dbType)
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(password)
                .setDriverName(driver);
    }
    /**
     * 根据表自动生成
     * @param packageName 包名
     * @param tableNames 表名
     * @author Terry
     */
    @SuppressWarnings("unused")
    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}

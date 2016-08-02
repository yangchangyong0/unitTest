package test.dbunit;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.FileInputStream;

/**
 * Created by ycy on 16/8/1.
 */
public class SampleTest extends DBTestCase
{


    private static String _testDir = "/";
    private static String _dbFile =
            "/Users/ycy/IdeaProjects/mystudy/logbackTest/src/test/resources/dbDump.xml";
    private static String _driverClass = "com.mysql.jdbc.Driver";
    private static String _jdbcConnection_url =
            "jdbc:mysql://127.0.0.1:3306/ycydb?characterEncoding=utf8";
    private static String _jdbcConnection_user = "ycy";
    private static String _jdbcConnection_pwd = "123456";

    private static String _testTableName = "ycy_table";

    public SampleTest(String name)
    {
        super( name );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, _driverClass);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, _jdbcConnection_url );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,_jdbcConnection_user );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, _jdbcConnection_pwd);
        // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "" );
    }

    protected IDataSet getDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(_dbFile));
    }

    public static void main(String[] args) {
        SampleTest sampleTest=new SampleTest("ycy_table");
        try {
            IDataSet iDataSet=  sampleTest.getDataSet();
            System.out.println(iDataSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

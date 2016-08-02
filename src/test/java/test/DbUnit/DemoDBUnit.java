package test.dbunit;

/**
 * Created by ycy on 16/8/1.
 */

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoDBUnit {
  private static String _testDir = "/";
  private static String _dbFile =
      "/Users/ycy/IdeaProjects/mystudy/logbackTest/src/test/resources/dbDump.xml";
  private static String _driverClass = "com.mysql.jdbc.Driver";
  private static String _jdbcConnection_url =
      "jdbc:mysql://127.0.0.1:3306/ycydb?characterEncoding=utf8";
  private static String _jdbcConnection_user = "ycy";
  private static String _jdbcConnection_pwd = "123456";

  private static String _testTableName = "ycy_table";

  public static void main(String[] args)
      throws ClassNotFoundException, DatabaseUnitException, IOException, SQLException {

    fullDatabaseExport(new File(_testDir, _dbFile));
  }

  /**
   * 全库导出
   * @param file
   * @throws ClassNotFoundException
   * @throws DatabaseUnitException
   * @throws DataSetException
   * @throws IOException
     * @throws SQLException
     */
  public static void fullDatabaseExport(File file) throws ClassNotFoundException,
      DatabaseUnitException, DataSetException, IOException, SQLException {
    IDatabaseConnection connection = getConnection();
    ITableFilter filter = new DatabaseSequenceFilter(connection);
    IDataSet dataset = new FilteredDataSet(filter, connection.createDataSet());
    FlatXmlDataSet.write(dataset, new FileOutputStream(file));
  }

  /**
   * 测试导入数据与数据库对比
   * 
   * @throws ClassNotFoundException
   * @throws DatabaseUnitException
   * @throws IOException
   * @throws SQLException
   */
  @Test
  public void test5_Test()
      throws ClassNotFoundException, DatabaseUnitException, IOException, SQLException {
    fullDatabaseImport(new File(_testDir, _dbFile));
    ITable actualTable = getConnection().createDataSet().getTable(_testTableName);
    FlatXmlDataSetBuilder flatXmlDataSetBuilder=new FlatXmlDataSetBuilder();
    IDataSet expectedDataSet = flatXmlDataSetBuilder.build(new File(_testDir, _dbFile));
    ITable expectedTable = expectedDataSet.getTable(_testTableName);
    Assertion.assertEquals(expectedTable, actualTable);
  }

  /**
   * 全部数据库导入文件
   * 
   * @param file
   * @throws ClassNotFoundException
   * @throws DatabaseUnitException
   * @throws IOException
   * @throws SQLException
   */
  public static void fullDatabaseImport(File file)
      throws ClassNotFoundException, DatabaseUnitException, IOException, SQLException {
    IDatabaseConnection connection = getConnection();
    FlatXmlDataSetBuilder flatXmlDataSetBuilder=new FlatXmlDataSetBuilder();
    IDataSet dataSet = flatXmlDataSetBuilder.build(file);
    DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
  }

  /**
   * 获取jdbc连接
   * 
   * @return
   * @throws ClassNotFoundException
   * @throws DatabaseUnitException
   * @throws SQLException
   */
  public static IDatabaseConnection getConnection()
      throws ClassNotFoundException, DatabaseUnitException, SQLException {
    // database connection
    Class driverClass = Class.forName(_driverClass);
    Connection jdbcConnection =
        DriverManager.getConnection(_jdbcConnection_url, _jdbcConnection_user, _jdbcConnection_pwd);
    return new DatabaseConnection(jdbcConnection);
  }
}

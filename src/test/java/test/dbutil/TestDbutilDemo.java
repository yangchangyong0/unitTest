package test.dbutil;


import com.alibaba.druid.pool.DruidDataSource;
import com.ycy.center.dao.entity.YcyTable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ycy on 16/7/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-test.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class})
@Transactional
public class TestDbutilDemo {
  @Autowired
  private DruidDataSource dataSource;



  /**
   * 获取object对象
   */
  @Test
  public void testObject() {
    AdDbUtil adDbUtilManager = new AdDbUtil();
    String sql = "SELECT * FROM ycy_table WHERE name=?";
    Object[] result = adDbUtilManager.queryObjs(dataSource, sql, "0姓名");
    System.out.println(result);
  }

  /**
   * 获取javabean对象
   */
  @Test
  public void testqueryJavaBeanList() {
    AdDbUtil adDbUtilManager = new AdDbUtil();
    String sql = "SELECT * FROM ycy_table WHERE name=?";
    List<YcyTable> list =
        adDbUtilManager.queryJavaBeanList(dataSource, YcyTable.class, sql, "我是新增语句");
    System.out.println(list);
  }

  /**
   * 获取javabean对象List
   */
  @Test
  public void testqueryJavaBean() {
    AdDbUtil adDbUtilManager = new AdDbUtil();
    String sql = "SELECT * FROM ycy_table WHERE id=?";
    YcyTable ycyTable =
        (YcyTable) adDbUtilManager.queryJavaBean(dataSource, YcyTable.class, sql, 6);
    System.out.println(ycyTable);
  }

  /**
   * 执行更新语句
   */
  @Test
  public void testupdate() {
    AdDbUtil adDbUtilManager = new AdDbUtil();
    String sql = "update ycy_table set name=? where `id`=?";
    int i = adDbUtilManager.update(dataSource, sql, "我是更新后的名字", 46);
    System.out.println(i);
  }

  /**
   * 执行新增语句
   */
  @Test
  public void testInsert() {
    for (int i = 0; i < 8; i++) {
      AdDbUtil adDbUtilManager = new AdDbUtil();
      String sql = "insert into ycy_table (name,num) values (?,?)";
      Object[] objects = adDbUtilManager.insert(dataSource, sql, "我是新增语句", i);
      System.out.println(objects);
    }

  }
}

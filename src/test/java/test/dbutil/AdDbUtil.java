package test.dbutil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * Created by ycy on 16/7/30.
 */
public class AdDbUtil<T> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 获取obj[]对象
   *
   * @param sql
   * @param params
   * @return
   */
  public Object[] queryObjs(DataSource ds, String sql, Object... params) {
    AdDbutilHandler adDbUtil = new AdDbutilHandler();
    ResultSetHandler<Object[]> objHandel = adDbUtil.getObjHandel();
    QueryRunner run = new QueryRunner(ds);
    try {
      Object[] result = run.query(sql, objHandel, params);
      return result;
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    }
    return null;
  }

  /**
   *获取Map<String,Object> 对象
   * @param ds
   * @param sql
   * @param params
     * @return
     */
  public Map<String,Object> queryMaps(DataSource ds, String sql, Object... params) {
    AdDbutilHandler adDbUtil = new AdDbutilHandler();
    ResultSetHandler<Object[]> objHandel = adDbUtil.getObjHandel();
    QueryRunner run = new QueryRunner(ds);
    try {
      Map<String,Object>  result = run.query(sql, new MapHandler(), params);
      return result;
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    }
    return null;
  }
  /**
   * 获取javabean对象List
   * 
   * @param ds
   * @param clazz
   * @param sql
   * @param params
   * @return
   */
  public List<T> queryJavaBeanList(DataSource ds, Class clazz, String sql, Object... params) {
    try {
      ResultSetHandler<List<T>> handelClass = null;
      handelClass = new BeanListHandler<T>((Class<T>) clazz.newInstance().getClass());
      QueryRunner run = new QueryRunner(ds);
      List<T> list = run.query(sql, handelClass, params);
      return list;
    } catch (InstantiationException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    } catch (IllegalAccessException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    }
    return null;
  }


  /**
   * 获取javabean对象
   * @param ds
   * @param clazz
   * @param sql
   * @param params
     * @return
     */
  public T queryJavaBean(DataSource ds, Class clazz, String sql, Object... params) {
    try {
      ResultSetHandler<List<T>> handelClass = null;
      handelClass = new BeanListHandler<T>((Class<T>) clazz.newInstance().getClass());
      QueryRunner run = new QueryRunner(ds);
      T bean =  run.query(sql, new BeanHandler<T>((Class<T>) clazz.newInstance().getClass()), params);
      return bean;
    } catch (InstantiationException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    } catch (IllegalAccessException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    }
    return null;
  }
  /**
   *更新数据
   * @param ds
   * @param sql
   * @param params
     * @return
     */
  public int update(DataSource ds, String sql, Object... params) {
    try {
      QueryRunner run = new QueryRunner(ds);
      int num = run.update(sql, params);
      return num;
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
    }
    return 0;
  }

  /**
   * 插入数据
   * @param ds
   * @param sql
   * @param params
     * @return
     */
  public Object[] insert(DataSource ds, String sql, Object... params){
    try {
      AdDbutilHandler adDbUtil = new AdDbutilHandler();
      ResultSetHandler<Object[]> objHandel = adDbUtil.getObjHandel();
      QueryRunner run = new QueryRunner(ds);
      Object[] result  = run.insert(sql,objHandel ,params);
      return result;
    } catch (SQLException e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getMessage());
      StackTraceElement[] stackTraceElements = e.getStackTrace();
      for (StackTraceElement sta : stackTraceElements) {
        sb.append(sta);
      }
      logger.error(sb.toString());
      e.getStackTrace();
    }
    return null;
  }

}

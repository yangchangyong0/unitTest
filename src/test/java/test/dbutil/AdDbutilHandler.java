package test.dbutil;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ycy on 16/7/30.
 */
  public class AdDbutilHandler<T> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 获取obj[]类型ResultSetHandler.
   */
  public ResultSetHandler<Object[]> getObjHandel() {
    ResultSetHandler<Object[]> handel = new ResultSetHandler<Object[]>() {
      public Object[] handle(ResultSet rs) throws SQLException {
        if (!rs.next()) {
          return null;
        }

        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();
        Object[] result = new Object[cols];

        for (int i = 0; i < cols; i++) {
          result[i] = rs.getObject(i + 1);
        }

        return result;
      }
    };
    return handel;
  }

  /**
   * 获取obj[]类型ResultSetHandler.
   */
  public ResultSetHandler<Object[]> getMapHandel() {
    ResultSetHandler<Object[]> handel = new ResultSetHandler<Object[]>() {
      public Object[] handle(ResultSet rs) throws SQLException {
        if (!rs.next()) {
          return null;
        }

        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();
        Object[] result = new Object[cols];

        for (int i = 0; i < cols; i++) {
          result[i] = rs.getObject(i + 1);
        }

        return result;
      }
    };
    return handel;
  }

  /**
   * 获取javabean类型的ResultSetHandler.
   */
  public ResultSetHandler<List<T>> getJavaBeanHandel(Class clazz) {

    ResultSetHandler<List<T>> handelClass = null;
    try {
      handelClass = new BeanListHandler<T>((Class<T>) clazz.newInstance().getClass());
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
      e.getStackTrace();
    }
    return handelClass;
  }


}

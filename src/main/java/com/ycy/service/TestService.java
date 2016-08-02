package com.ycy.service;

import com.ycy.center.dao.entity.YcyTable;

/**
 * Created by ycy on 16/7/19.
 */
public interface TestService {

     void testInsert(int num,String name) throws Exception;

     YcyTable getYcyTable(Integer id);
}

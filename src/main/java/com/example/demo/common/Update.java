package com.example.demo.common;

import com.example.demo.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Package : com.example.demo.common
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/9 09:23 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Update {
    private boolean ok = false;

    public Update(Object object) {
        MyUpdate myUpdate = new MyUpdate(object);

        Connection connection = DBUtil.getConnection();

        String sql = myUpdate.getSql();

        int length = myUpdate.getLength();

        Object[] resultArray = myUpdate.getResultArray();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setObject(length, resultArray[0]);

            for (int i = 1; i < length; i++) {
                prepareStatement.setObject(i, resultArray[i]);
            }

            int executeUpdate = prepareStatement.executeUpdate();

            if (executeUpdate > 0) {
                ok = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public boolean isOk() {
        return ok;
    }

}

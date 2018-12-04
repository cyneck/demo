package com.example.demo.service.impl;

import com.example.demo.common.Update;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Package : com.example.demo.service.impl
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/8 09:30 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    @Transactional
    public Person update(Person person) {

        // some database options
        /*if (true) {
            throw new BusinessException("异常testing");
        }*/
        // update database dog info
        Update update = new Update(person);
        update.isOk();

        return person;
    }
}

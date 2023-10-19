package online.weiyin.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.entity.Teachers;
import online.weiyin.mapper.TeachersMapper;
import online.weiyin.service.TeachersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName TeachersControllerTest
 * @Description 测试类
 * @Version 1.0.0
 * @Time 2023/10/18 下午 09:21
 * @Author 卢子昂
 */
@SpringBootTest
class TeachersControllerTest {

    @Autowired
    TeachersMapper mapper;
    @Autowired
    TeachersService teachersService;

    @Test
    void getTeachersList() {
        Page<Teachers> page = new Page<Teachers>(1,5);
//        Page<Teachers> page1 = mapper.selectPage(page, null);
//        System.out.println(JSONUtil.toJsonPrettyStr(page1));

        Page<Teachers> page2 = teachersService.page(page);
        System.out.println(JSONUtil.toJsonPrettyStr(page2.getRecords()));
    }
}
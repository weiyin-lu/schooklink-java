package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.entity.Parents;
import online.weiyin.entity.Students;
import online.weiyin.entity.Teachers;
import online.weiyin.entity.Users;
import online.weiyin.service.ParentsService;
import online.weiyin.service.StudentsService;
import online.weiyin.service.TeachersService;
import online.weiyin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

/**
 * @ClassName AdminController
 * @Description 学校管理员业务功能
 * @Version 1.0.0
 * @Time 2023/10/22 下午 07:30
 * @Author 卢子昂
 */
@RestController
@RequestMapping("/schoollink/admins")
public class AdminController {
    @Autowired
    UsersService usersService;
    @Autowired
    TeachersService teachersService;
    @Autowired
    ParentsService parentsService;
    @Autowired
    StudentsService studentsService;

    /**
     * 为学生添加班级
     * @return
     */
    public Result addGrade() {
        return Result.fail(ResultCode.NOT_FOUND);
    }

    /**
     * 根据唯一标识删除教师信息（逻辑删除）
     * @param id 业务角度唯一性id
     * @return
     */
    @GetMapping("/removeTeacher/{id}")
    @SaCheckLogin
    @Transactional
    public Result removeTeacher(@PathVariable String id) {
//        构造更新条件和字段
        UpdateWrapper<Users> userWrapper = new UpdateWrapper<Users>()
                .set("is_delete", 1)
                .eq("username",id);
        UpdateWrapper<Teachers> teacherWrapper = new UpdateWrapper<Teachers>()
                .set("is_delete", 1)
                .eq("teacher_unique_id",id);
//        执行语法修改逻辑删除字段
        usersService.update(userWrapper);
        teachersService.update(teacherWrapper);
        return Result.success();
    }

    /**
     * 删除学生信息（逻辑删除）
     * @param id 业务角度唯一性id
     * @return
     */
    @GetMapping("/removeStudent/{id}")
    @SaCheckLogin
    @Transactional
    public Result removeStudent(@PathVariable String id) {
//        构造更新条件和字段
        UpdateWrapper<Users> userWrapper = new UpdateWrapper<Users>()
                .set("is_delete", 1)
                .eq("username",id);
        UpdateWrapper<Students> studentWrapper = new UpdateWrapper<Students>()
                .set("is_delete", 1)
                .eq("student_unique_id",id);
//        执行语法修改逻辑删除字段
        usersService.update(userWrapper);
        studentsService.update(studentWrapper);
        return Result.success();
    }

    /**
     * 删除家长信息（逻辑删除）
     * @param id 业务角度唯一性id
     * @return
     */
    @GetMapping("/removeParent/{id}")
    @SaCheckLogin
    @Transactional
    public Result removeParent(@PathVariable String id) {
//        构造更新条件和字段
        UpdateWrapper<Users> userWrapper = new UpdateWrapper<Users>()
                .set("is_delete", 1)
                .eq("username",id);
        UpdateWrapper<Parents> parentsWrapper = new UpdateWrapper<Parents>()
                .set("is_delete", 1)
                .eq("parent_unique_id",id);
//        执行语法修改逻辑删除字段
        usersService.update(userWrapper);
        parentsService.update(parentsWrapper);
        return Result.success();
    }
}

package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.StudentInfo;
import online.weiyin.entity.Students;
import online.weiyin.entity.Teachers;
import online.weiyin.service.StudentsService;
import online.weiyin.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  学生管理
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/students")
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    /**
     * 管理功能-按照班级查找学生列表
     * @return
     */
    @GetMapping("/getStudentsList/{grade}")
    @SaCheckLogin
    public Result getStudentsList(@PathVariable String grade) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("grade",grade);
        List<Students> list = studentsService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 管理功能-获取某个id的学生信息
     * @param id 业务角度唯一性id
     * @return
     */
    @GetMapping("/getTeachersByUnique/{id}")
    @SaCheckLogin
    public Result getStudentsByUnique(@PathVariable String id) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("student_unique_id", id);
        Students one = studentsService.getOne(wrapper);
        return Result.success(one);
    }

    /**
     * 更新特定学生的个人信息（生日、邮箱、手机号、性别）
     * @param info
     * @return
     */
    @PostMapping("/updateStudent")
    @SaCheckLogin
    public Result updateStudent(@RequestBody StudentInfo info) {
//        构造查询条件
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("student_unique_id", info.getStudentUniqueId());
//        构造更新对象
        Students students = new Students();
        students.setGender(info.getGender());
        students.setContactPhone(info.getContactPhone());
        students.setContactEmail(info.getContactEmail());
        students.setBirthdate(info.getBirthdate());
//        执行更新
        boolean update = studentsService.update(students, wrapper);
        if(update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}

package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.entity.Students;
import online.weiyin.entity.Teachers;
import online.weiyin.service.StudentsService;
import online.weiyin.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 管理功能-按照班级查找学生列表(分页)
     * @return
     */
    @GetMapping("/getStudentsList/{grade}/{page}")
    @SaCheckLogin
    public Result getStudentsList(@PathVariable String grade, @PathVariable Integer page) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("grade",grade);
        Page<Students> pageIns = new Page<>(page, 10);
        Page<Students> pageResult = studentsService.page(pageIns,wrapper);
        return Result.success(pageResult);
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
     * 更新特定教师的信息
     * @param student
     * @return
     */
    @PostMapping("/updateStudent")
    @SaCheckLogin
    public Result updateInfo(@RequestBody Students student) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("student_unique_id", student.getStudentUniqueId());
        boolean update = studentsService.update(student, wrapper);
        if(update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}

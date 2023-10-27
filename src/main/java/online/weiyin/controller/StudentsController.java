package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
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
     * 按照班级查找学生列表
     * @return
     */
    @ApiOperation("按照班级查找学生列表")
    @GetMapping("/getStudentsList/{grade}")
    @SaCheckLogin
    public Result getStudentsList(@PathVariable String grade) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("grade",grade);
        List<Students> list = studentsService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 获取某个id的学生信息
     * @param id 业务角度唯一性id
     * @return
     */
    @ApiOperation("获取某个id的学生信息")
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
    @ApiOperation("更新特定学生的个人信息（生日、邮箱、手机号、性别）")
    @PostMapping("/updateStudent")
    @SaCheckLogin
    public Result updateStudent(@RequestBody StudentInfo info) {
//        构造查询条件
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("student_unique_id", StpUtil.getLoginId());
//        构造更新对象
        Students students = new Students();
        students.setGender(info.getGender());
        students.setContactPhone(info.getContactPhone());
        students.setContactEmail(info.getContactEmail());
        students.setBirthdate(info.getBirthdate());
//        执行更新
        boolean update = studentsService.update(students, wrapper);
        if(update) {
            return Result.success("更新信息成功");
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }

    /**
     * 为学生分配班级
     * @param id
     * @param grade
     * @return
     */
    @ApiOperation("为学生分配班级")
    @GetMapping("/setGrade/{id}/{grade}")
    @SaCheckLogin
    public Result setGrade(@PathVariable String id, @PathVariable String grade) {
        UpdateWrapper<Students> wrapper = new UpdateWrapper<Students>()
                .set("grade", grade)
                .eq("student_unique_id", id);
        boolean update = studentsService.update(wrapper);
        if(update) {
            return Result.success("更新班级成功");
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}

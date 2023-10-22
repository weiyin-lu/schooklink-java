package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.TeacherInfo;
import online.weiyin.entity.Teachers;
import online.weiyin.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  教师管理
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/teachers")
public class TeachersController {

    @Autowired
    TeachersService teachersService;

    /**
     * 管理功能-教师列表(分页)
     * @return
     */
    @GetMapping("/getTeachersList")
    @SaCheckLogin
    public Result getTeachersList() {
        List<Teachers> list = teachersService.list();
        return Result.success(list);
    }

    /**
     * 管理功能-获取某个id的教师信息
     * @param id 业务角度唯一性id
     * @return
     */
    @GetMapping("/getTeachersByUnique/{id}")
    @SaCheckLogin
    public Result getTeachersByUnique(@PathVariable String id) {
        QueryWrapper<Teachers> wrapper = new QueryWrapper<Teachers>()
                .eq("teacher_unique_id", id);
        Teachers one = teachersService.getOne(wrapper);
        return Result.success(one);
    }

    /**
     * 更新教师的个人信息（性别、联系邮箱、联系电话）
     * @param info
     * @return
     */
    @PostMapping("/updateTeacher")
    @SaCheckLogin
    public Result updateTeacher(@RequestBody TeacherInfo info) {
//        构造查询条件
        QueryWrapper<Teachers> wrapper = new QueryWrapper<Teachers>()
                .eq("teacher_unique_id", info.getTeacherUniqueId());
//        构造更新对象
        Teachers teachers = new Teachers();
        teachers.setGender(info.getGender());
        teachers.setContactPhone(info.getContactPhone());
        teachers.setContactEmail(info.getContactEmail());
//        执行更新
        boolean update = teachersService.update(teachers, wrapper);
        if(update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}

package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.entity.Teachers;
import online.weiyin.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getTeachersList/{page}")
    @SaCheckLogin
    public Result getTeachersList(@PathVariable Integer page) {
        Page<Teachers> pageIns = new Page<>(page, 10);
        Page<Teachers> pageResult = teachersService.page(pageIns);
        return Result.success(pageResult);
    }

    /**
     * 管理功能-获取某个id的教师信息
     * @param id
     * @return
     */
    @GetMapping("/getTeachersByUnique/{id}")
    @SaCheckLogin
    public Result getTeachersByUnique(@PathVariable String id) {
        QueryWrapper<Teachers> wrapper = new QueryWrapper<Teachers>()
                .eq("teacher_unique_id", id);
        Teachers one = teachersService.getOne(wrapper);
        return Result.success(wrapper);
    }
}

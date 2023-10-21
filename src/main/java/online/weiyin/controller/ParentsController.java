package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.entity.Parents;
import online.weiyin.entity.Students;
import online.weiyin.service.ParentsService;
import online.weiyin.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  家长管理
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/parents")
public class ParentsController {
    @Autowired
    ParentsService parentsService;
    @Autowired
    StudentsService studentsService;

    /**
     * 管理功能-查找家长列表(分页)
     * @return
     */
    @GetMapping("/getParentsList/{page}")
    @SaCheckLogin
    public Result getParentsList(@PathVariable Integer page) {
        Page<Parents> pageIns = new Page<>(page, 10);
        Page<Parents> pageResult = parentsService.page(pageIns);
        return Result.success(pageResult);
    }

    /**
     * 根据id获取家长信息
     * @param id 业务角度唯一性标识
     * @return
     */
    @GetMapping("/getParentByUnique/{id}")
    @SaCheckLogin
    public Result getParentByUnique(@PathVariable String id) {
        QueryWrapper<Parents> wrapper = new QueryWrapper<Parents>()
                .eq("parent_unique_id",id);
        Parents parents = parentsService.getOne(wrapper);
        return Result.success(parents);
    }

    /**
     * 管理功能-查看家长对应的学生信息
     * @return
     */
    @GetMapping("/getStudentList/{id}")
    @SaCheckLogin
    public Result getStudentsByParent(@PathVariable String id) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("parents", id);
        List<Students> list = studentsService.list(wrapper);
        return Result.success(list);
    }

}
